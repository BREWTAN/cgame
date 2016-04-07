package starstart.cgame.flows.nsttl.ryb;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import starstart.cgame.flows.mysqlgens.sett.entity.SettMchntBalance;
import starstart.cgame.flows.mysqlgens.sett.entity.SettMchntBalanceExample;
import starstart.cgame.flows.mysqlgens.sett.entity.SettMchntDetails;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontUserProdAcct;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.MchInf;
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
 * 商户结算信息处理
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_1004_Settle_For_Merchant_Banlance_RYB extends
		NSettle_BaseActor<CalcMutex> {

	@StoreDAO(domain = MchInf.class)
	protected OJpaDAO<MchInf> mchInfDao;
	@StoreDAO(domain = SettMchntDetails.class)
	protected OJpaDAO<SettMchntDetails> settMchDetailsDao;
	@StoreDAO(domain = SettMchntBalance.class)
	protected OJpaDAO<SettMchntBalance> settMchBalanceDao;
	@StoreDAO(domain = FrontUserProdAcct.class)
	protected OJpaDAO<FrontUserProdAcct> frontUserProdAcctDao;
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;

	public void processMessage(CalcMutex pack) {

			try {
				
				List<Object> mchBanlanceList=new ArrayList<Object>();
				ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
				String settleDate = paramsUtil.getSettDate(pack);
				//统计商户结算信息 交易金额、手续费金额总和
				String mchDetailSql=CommonSql.getMchBanlanceSql(settleDate, "OFAG");
				List<HashMap> mchDetailList = SerializerUtil.deserializeArray(
						settMchDetailsDao.doBySQL(mchDetailSql), HashMap.class);
				if(null!=mchDetailList){
						mchBanlanceList=mchBanlanceProcess(mchBanlanceList,mchDetailList);
				}
				//统计商户结算信息 手续费金额总和
				String mchDetailFeeSql="SELECT  count(1) count ,MCHNT_ID,PROD_ID,SUM(MCH_FEE_AMT) TOTAL_AMT,"
						+ "'MSCS.FEE' TRANS_TYPE,SETT_DATE FROM T_SETT_MCHNT_DETAILS"
						+ " WHERE SETT_DATE='"+settleDate+"' and PRODUCT_TYPE='OFAG' GROUP BY MCHNT_ID,PROD_ID";
				List<HashMap> mchDetailFeeList = SerializerUtil.deserializeArray(
						settMchDetailsDao.doBySQL(mchDetailFeeSql), HashMap.class);
				if(null!=mchDetailFeeList){
						mchBanlanceList=mchBanlanceProcess(mchBanlanceList,mchDetailFeeList);
				}
				if(mchBanlanceList.size()>0){
					settMchBalanceDao.batchInsert(mchBanlanceList);
				}
			} catch (Exception e) {
				throw new SettleException(e);
			}

	}
			
	//处理 产品渠道结算信息  按交易类和手续费类
	public List<Object> mchBanlanceProcess(List<Object> mchBanlanceList,List<HashMap> mchDetailList){
		
		
		for (int i = 0; i <mchDetailList.size(); i++) {
				Map<String, Object> map=mchDetailList.get(i);
				SettMchntBalance settMchntBalance = new SettMchntBalance();
				settMchntBalance.setId(getId(map).get("ID").toString());//ID
				settMchntBalance.setField1(getId(map).get("FIELD1").toString());
				settMchntBalance.setProductType(Constants.OFAG);//渠道号 与ChannleId存值一致
				settMchntBalance.setMchntId(StringUtil.isEmpty(map.get("MCHNT_ID"))?"-":map.get("MCHNT_ID").toString());
				settMchntBalance.setProdId(StringUtil.isEmpty(map.get("PROD_ID"))?"-":map.get("PROD_ID").toString());
				settMchntBalance.setSettDate(StringUtil.isEmpty(map.get("SETT_DATE"))?" ":map.get("SETT_DATE").toString());
				settMchntBalance.setStatus(Constants.BAN_STATUS);//状态：待结算 0000
				settMchntBalance.setTotalCnt(new BigDecimal(map.get("count").toString()));//当日记录总笔数
				settMchntBalance.setTotalAmt(new BigDecimal(map.get("TOTAL_AMT").toString()));//当日记录总笔数
				//处理总记录数  获取昨日记录数
				SettMchntBalanceExample  settMchntBalanceexample=new SettMchntBalanceExample();
				String yesterDay=StringUtil.getLastDay(settMchntBalance.getSettDate());
				settMchntBalanceexample.createCriteria().andMchntIdEqualTo(settMchntBalance.getMchntId())
				.andProdIdEqualTo(settMchntBalance.getProdId())
				.andSettDateEqualTo(yesterDay);
				List<Object> banlancelist=settMchBalanceDao.selectByExample(settMchntBalanceexample);
				if(banlancelist!=null&&banlancelist.size()>0){
					SettMchntBalance banlance=(SettMchntBalance) banlancelist.get(0);
					settMchntBalance.setAccTotalCnt(settMchntBalance.getTotalCnt().add(banlance.getAccTotalCnt()));
					settMchntBalance.setAccTotalAmt(settMchntBalance.getTotalAmt().add(banlance.getAccTotalAmt()));
				}else{
					settMchntBalance.setAccTotalCnt(settMchntBalance.getTotalCnt());
					settMchntBalance.setAccTotalAmt(settMchntBalance.getTotalAmt());
				}
				String acctType="";
				if(map.get("TRANS_TYPE")!=null){
					acctType=(String) map.get("TRANS_TYPE");
				}
				if(acctType.equals(Constants.TRANS101)){
					settMchntBalance.setAcctType(Constants.ACCT_TYPE_01);//申购
				}else if(acctType.equals(Constants.TRANS103)){
					settMchntBalance.setAcctType(Constants.ACCT_TYPE_02);//赎回
				}else{
					settMchntBalance.setAcctType(Constants.ACCT_TYPE_07);//手续费
				}
				mchBanlanceList.add(settMchntBalance);
			}
			return mchBanlanceList;
		}
			
	public Map getId(Map map){
		Map param=new HashMap();
		String secnum="1";
		String id="";
		//id=结算日期+交易类型+PRD_ID+CHANNEL_ID+PROD_ID
		id=map.get("SETT_DATE").toString().replace("-", "")+map.get("TRANS_TYPE").toString().split("\\.")[1]
				+map.get("MCHNT_ID")+map.get("PROD_ID");
		String sql="select  max(ID) MAXID  ,max(FIELD1) MAXSEC from T_SETT_MCHNT_BALANCE where ID like '"+id+"%'";
		
		List<HashMap> detaillist = SerializerUtil.deserializeArray(
				settMchBalanceDao.doBySQL(sql), HashMap.class);
		if(null!=detaillist&&detaillist.size()>0){
			Map parammap=detaillist.get(0);
			if(!StringUtil.isEmpty(parammap.get("MAXSEC"))){
				String maxsec=(String) parammap.get("MAXSEC");
				secnum=String.valueOf(Integer.valueOf(maxsec)+1);
			}
		};
		param.put("ID", id+secnum);
		param.put("FIELD1", secnum);
		
		return  param;
		
	}

	/**
	 * 查询当日新建账户
	 */
	public BigDecimal getAcctNewCnt(String mchntId, String settleDate) {
		
		String sql = "select count(*) count from T_FRONT_USER_PROD_ACCT where MCHNT_ID='"+ mchntId
				+"' and substring(create_time,0,10)='"+ settleDate+ "' and status='0000'";
		List<HashMap> frontUserProdAcct = SerializerUtil.deserializeArray(
				frontUserProdAcctDao.doBySQL(sql), HashMap.class);
		BigDecimal AcctNewCnt =new BigDecimal(0);
		if (null != frontUserProdAcct) {
			AcctNewCnt = new BigDecimal(frontUserProdAcct.get(0).get("count")
					.toString());
		}
		return AcctNewCnt;

	}

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Settle_For_Merchant_Banlance;
	}

}
