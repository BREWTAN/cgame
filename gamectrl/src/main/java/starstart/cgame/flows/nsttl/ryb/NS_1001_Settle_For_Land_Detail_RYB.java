package starstart.cgame.flows.nsttl.ryb;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.CommonSql;
import starstart.cgame.flows.land.util.Constants;
import starstart.cgame.flows.land.util.ParamsDatasUtil;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.mysqlgens.sett.entity.SettProdDetails;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandFeeInfo;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs101;
import starstart.cgame.flows.mysqlgens.trade.entity.MchFeeDesc;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import cn.msec.bao.outils.serialize.SerializerUtil;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.ojpa.api.annotations.StoreDAO;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
/**
 * 
 * 结算明细信息处理
 *
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_1001_Settle_For_Land_Detail_RYB extends NSettle_BaseActor<CalcMutex>{

	@StoreDAO(domain = LandMscs101.class)
	protected OJpaDAO<LandMscs101> landMscs101Dao;
	@StoreDAO(domain = LandFeeInfo.class)
	protected OJpaDAO<LandFeeInfo> landFeeInfoDao;
	@StoreDAO(domain = MchFeeDesc.class)
	protected OJpaDAO<MchFeeDesc> mchFeeDescDao;
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;
	
	@StoreDAO(domain = SettProdDetails.class)
	protected OJpaDAO<SettProdDetails> settProdDetailsDao;
	public void processMessage(CalcMutex pack) {
		log.info("STTL:处理落地结算:"+pack);
		
		try {
			ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
			String settleDate = paramsUtil.getSettDate(pack);
			Map<String,List<Object>>  proFeeMap=null;
			Map<String,List<Object>>  mchFeeMap=null;
			//根据结算日期查询出申购、赎回流水正常状态数据
			String sql=CommonSql.getProdBanDetailSql(settleDate, Constants.OFAG);
			List<HashMap> landlist = SerializerUtil.deserializeArray(
					landMscs101Dao.doBySQL(sql), HashMap.class);
			//对流水明细进行处理
			if(null!=landlist&&landlist.size()>0){
				List<Object> proDetailList=proDetailProcess(landlist,proFeeMap,mchFeeMap);
				if(null!=proDetailList&&proDetailList.size()>0){
					settProdDetailsDao.batchInsert(proDetailList);
				}
			}
		} catch (Exception e) {
			throw new SettleException(e);
		}
		
	}

	//产品明细处理
	public List<Object> proDetailProcess(List<HashMap> list,Map<String,List<Object>>  proFeeMap,Map<String,List<Object>>  mchFeeMap) {
		
		List<Object> prodDetaillist=new ArrayList();
		try {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map=list.get(i);
				SettProdDetails settProdDetails=new SettProdDetails();
				settProdDetails.setId(getId(map).get("ID").toString());//ID
				settProdDetails.setField1(getId(map).get("FIELD1").toString());
				settProdDetails.setPrdId(map.get("RCV_MCH_ID").toString());//接收方商户号
				settProdDetails.setChannleId((String)map.get("RCV_CHN_ID"));//渠道号 
				settProdDetails.setProductType(Constants.OFAG);
				settProdDetails.setProdId((String)map.get("PRODUCT_ID"));//产品号
				settProdDetails.setSettDate((String)map.get("STTL_DATE"));
				settProdDetails.setCustId(StringUtil.isEmpty(map.get("CUST_ID"))?" ":map.get("CUST_ID").toString());//用户号
				settProdDetails.setMchntRecordId((String)map.get("ORDER_ID"));//商户交易流水号
				settProdDetails.setProdRecordId((String)map.get("PROD_ORDER_ID"));//转给产品方的订单号
				settProdDetails.setTransType((String)map.get("TRANS_TYPE"));//交易类型
				settProdDetails.setTransAmt((BigDecimal)map.get("INV_AMT"));//交易金额
				settProdDetails.setFeeAmt((BigDecimal)map.get("MCH_SERVICE_FEE"));//手续费
				settProdDetails.setTransReqDate((Date)map.get("RECV_TIME"));
				settProdDetails.setTransRspDate((Date)map.get("RSP_RECV_TIME"));
				settProdDetails.setCertNo(StringUtil.isEmpty(map.get("CERT_NO"))?"":map.get("CERT_NO").toString());
				settProdDetails.setCertType(StringUtil.isEmpty(map.get("CERT_TYPE"))?"":map.get("CERT_TYPE").toString());
				settProdDetails.setStatus(StringUtil.isEmpty(map.get("RESULT_CODE"))?"":map.get("RESULT_CODE").toString());//流水表中当前流水状态
				ParamsDatasUtil paramsDatas=new ParamsDatasUtil(null,landFeeInfoDao);
				BigDecimal amt=settProdDetails.getTransAmt();
				//产品手续费计算结果 根据产品号把费率信息存入map中
				proFeeMap=paramsDatas.initProdFeeRule(proFeeMap, settProdDetails.getProdId());
				log.info("产品手续费proFeeMap："+proFeeMap);
				if(null!=proFeeMap && proFeeMap.size()>0){
					BigDecimal proFee=paramsDatas.getFeeValueByrule(proFeeMap,amt,settProdDetails.getProdId(),"PROD");
					settProdDetails.setProdFeeAmt(proFee);
				}else {
					settProdDetails.setProdFeeAmt(new BigDecimal(0));
				}
				Date date = new Date();
				Timestamp timeStamp = new Timestamp(date.getTime());
				settProdDetails.setCrtTime(timeStamp);
				settProdDetails.setUpdTime(timeStamp);
				settProdDetails.setRecStatus("03");//明细表 结算状态  待结算
				prodDetaillist.add(settProdDetails);
				log.info(settProdDetails.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException("落地明细处理失败：",e);
		}
		return prodDetaillist;
}
	
	public Map getId(Map map){
		Map param=new HashMap();
		String secnum="1";
		//id=订单号+交易类型+序号
	    String id=map.get("ORDER_ID")+map.get("TRANS_TYPE").toString().split("\\.")[1];
		String sql="select  max(ID) MAXID  ,max(FIELD1) MAXSEC from T_SETT_PROD_DETAILS where ID like '"+id+"%'";
		List<HashMap> deteillist = SerializerUtil.deserializeArray(
				settProdDetailsDao.doBySQL(sql), HashMap.class);
		if(null!=deteillist&&deteillist.size()>0){
			Map parammap=deteillist.get(0);
			if(!StringUtil.isEmpty(parammap.get("MAXSEC"))){
				String maxsec=(String) parammap.get("MAXSEC");
				secnum=String.valueOf(Integer.valueOf(maxsec)+1);
			}
		}
		param.put("ID", id+secnum);
		param.put("FIELD1", secnum);
		return  param;
		
	}
		
		@Override
		public SettleSteps getSettleStep() {
			return SettleSteps.Settle_For_Land_Detail;
		}


}
