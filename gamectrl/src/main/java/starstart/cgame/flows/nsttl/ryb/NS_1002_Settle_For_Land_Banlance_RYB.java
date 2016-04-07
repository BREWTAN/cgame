package starstart.cgame.flows.nsttl.ryb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.Constants;
import starstart.cgame.flows.land.util.ParamsDatasUtil;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.mysqlgens.sett.entity.SettProdBalance;
import starstart.cgame.flows.mysqlgens.sett.entity.SettProdBalanceExample;
import starstart.cgame.flows.mysqlgens.sett.entity.SettProdChnBalance;
import starstart.cgame.flows.mysqlgens.sett.entity.SettProdChnBalanceExample;
import starstart.cgame.flows.mysqlgens.sett.entity.SettProdDetails;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontUserProdAcct;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandProdInfo;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import cn.msec.bao.outils.serialize.SerializerUtil;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.ojpa.api.annotations.StoreDAO;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * 结算信息处理
 * 产品渠道结算表：维度 MCHNT_ID,PRD_ID,CHANNLE_ID,OUT_PROD_CHN_ID,PROD_ID,OUT_PRODID,OUT_SUB_PROD_ID,TRANS_TYPE
 * 产品结算表：ACCT_TYPE,MCHNT_ID,PRD_ID,PROD_ID,OUT_PRODID,OUT_PROD_SUBID
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_1002_Settle_For_Land_Banlance_RYB extends NSettle_BaseActor<CalcMutex> {
	
	
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;
	@StoreDAO(domain = SettProdChnBalance.class)
	protected OJpaDAO<SettProdChnBalance> settProdChnBalanceDao;
	@StoreDAO(domain = SettProdBalance.class)
	protected OJpaDAO<SettProdBalance> settProdBalanceDao;
	@StoreDAO(domain = LandProdInfo.class)
	protected OJpaDAO<LandProdInfo> LandProdInfDao;
	@StoreDAO(domain = FrontUserProdAcct.class)
	protected OJpaDAO<FrontUserProdAcct> frontUserProdAcctDao ;
	@StoreDAO(domain = SettProdDetails.class)
	protected OJpaDAO<SettProdDetails> settProdDetailsDao ;
	
	public void processMessage(CalcMutex pack) {
		
			try {
				ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
				String settleDate = paramsUtil.getSettDate(pack);
				/**
				 * 产品渠道结算
				 */
				List<Object> proChnBanList=new ArrayList<Object>();
				//产品渠道结算：申购、赎回数据
				String prodChnDetailSql="SELECT  count(1) count,PRD_ID,TRANS_TYPE,CHANNLE_ID,PROD_ID,SETT_DATE,SUM(TRANS_AMT) TOTAL_AMT "
						+ " FROM T_SETT_PROD_DETAILS  WHERE SETT_DATE='"+settleDate+"' and PRODUCT_TYPE='"+Constants.OFAG+"'"
						+ " GROUP BY PRD_ID,CHANNLE_ID,PROD_ID,TRANS_TYPE";
				List<HashMap> prodChnBanlanceList = SerializerUtil.deserializeArray(
						settProdDetailsDao.doBySQL(prodChnDetailSql), HashMap.class);
				if(null!=prodChnBanlanceList){
					for (int i = 0; i < prodChnBanlanceList.size(); i++) {
						Map prodChnDetailMap=prodChnBanlanceList.get(i);
						SettProdChnBalance proChnBalance=getProdChnBanlance(prodChnDetailMap);
						proChnBanList.add(proChnBalance);
					}
				}
				//产品渠道结算：产品手续费金额
				String prodChnFee="SELECT count(1) count,PRD_ID,'6' TRANS_TYPE,CHANNLE_ID,PROD_ID,SETT_DATE,SUM(PROD_FEE_AMT) TOTAL_AMT "
						+ ",'MSCS.FEE' TRANS_TYPE FROM T_SETT_PROD_DETAILS WHERE SETT_DATE='"+settleDate+"' and PRODUCT_TYPE='"+Constants.OFAG+"'"
						+ " GROUP BY PRD_ID,CHANNLE_ID,PROD_ID";
				List<HashMap> prodChnFeeList = SerializerUtil.deserializeArray(
						settProdDetailsDao.doBySQL(prodChnFee), HashMap.class);
				if(null!=prodChnFeeList&&prodChnFeeList.size()>0){
					for (int i = 0; i < prodChnFeeList.size(); i++) {
						Map prodChnDetailMap=prodChnFeeList.get(i);
						SettProdChnBalance proChnBalance=getProdChnBanlance(prodChnDetailMap);
						proChnBanList.add(proChnBalance);
						//建账信息统计
						SettProdChnBalance proChnBalanceAcct=getProdChnBanlanceForAcct(prodChnDetailMap);
						proChnBanList.add(proChnBalanceAcct);
					}
					
				}
				//产品渠道结算插入数据库
				if(proChnBanList.size()>0){
					settProdChnBalanceDao.batchInsert(proChnBanList);
				}
				/**
				 * 产品结算
				 */
				//产品结算：申购、赎回、手续费金额
				String prodDetailSql="SELECT  count(1) count ,ACCT_TYPE,PRD_ID,PROD_ID,SETT_DATE,"
						+ " SUM(TOTAL_CNT),SUM(TOTAL_AMT) ,SUM(ACC_TOTAL_CNT),SUM(ACC_TOTAL_AMT) FROM T_SETT_PROD_CHN_BALANCE WHERE "
						+ " SETT_DATE='"+settleDate+"'  and PRODUCT_TYPE='"+Constants.OFAG+"'"
						+ " AND SETT_DATE='"+settleDate+"' GROUP BY ACCT_TYPE,PRD_ID,PROD_ID";
				List<HashMap> prodChnlList = SerializerUtil.deserializeArray(
						settProdChnBalanceDao.doBySQL(prodDetailSql), HashMap.class);
				if(null!=prodChnlList&&prodChnlList.size()>0){
					List<Object> proBanlanceList=new ArrayList<Object>();
					for (int i = 0; i < prodChnlList.size(); i++) {
						Map banlanceMap=prodChnlList.get(i);
						SettProdBalance  settProdBalance=new SettProdBalance();
						settProdBalance.setId(getId(banlanceMap).get("ID").toString());//ID
						settProdBalance.setField1(getId(banlanceMap).get("FIELD1").toString());
						settProdBalance.setProductType(Constants.OFAG);
						settProdBalance.setPrdId(StringUtil.isEmpty(banlanceMap.get("PRD_ID"))?" ":banlanceMap.get("PRD_ID").toString());
						settProdBalance.setProdId(StringUtil.isEmpty(banlanceMap.get("PROD_ID"))?" ":banlanceMap.get("PROD_ID").toString());
						settProdBalance.setSettDate((String)banlanceMap.get("SETT_DATE"));
						settProdBalance.setAcctType((String)banlanceMap.get("ACCT_TYPE"));
						settProdBalance.setTotalCnt(StringUtil.isEmpty(banlanceMap.get("SUM(TOTAL_CNT)"))?new BigDecimal(0):StringUtil.StringToBigDecimal(banlanceMap.get("SUM(TOTAL_CNT)").toString()));//当日记录总数
						settProdBalance.setTotalAmt(StringUtil.isEmpty(banlanceMap.get("SUM(TOTAL_AMT)"))?new BigDecimal(0):StringUtil.StringToBigDecimal(banlanceMap.get("SUM(TOTAL_AMT)").toString()));//当日申购总笔数
						settProdBalance.setAccTotalCnt(StringUtil.isEmpty(banlanceMap.get("SUM(ACC_TOTAL_CNT)"))?new BigDecimal(0):StringUtil.StringToBigDecimal(banlanceMap.get("SUM(ACC_TOTAL_CNT)").toString()));//当日申购总金额
						settProdBalance.setAccTotalAmt(StringUtil.isEmpty(banlanceMap.get("SUM(ACC_TOTAL_AMT)"))?new BigDecimal(0):StringUtil.StringToBigDecimal(banlanceMap.get("SUM(ACC_TOTAL_AMT)").toString()));//当日赎回总笔数
						settProdBalance.setStatus(Constants.BAN_STATUS);//状态:待结算
						proBanlanceList.add(settProdBalance);
					}
					if(proBanlanceList.size()>0){
						settProdBalanceDao.batchInsert(proBanlanceList);
					}
				}
			}  catch (Exception e) {
				throw new SettleException(e);
			}
			
			
			
	}
	
	//处理 产品渠道结算信息  按交易类和手续费类
	public SettProdChnBalance getProdChnBanlance(Map map){
		SettProdChnBalance  proChnBalance=new SettProdChnBalance();
		try {
			proChnBalance.setId(getId(map).get("ID").toString());//ID
			proChnBalance.setField1(getId(map).get("FIELD1").toString());
			proChnBalance.setProductType(Constants.OFAG);
			proChnBalance.setPrdId(StringUtil.isEmpty(map.get("PRD_ID"))?"-":map.get("PRD_ID").toString());
			proChnBalance.setChannelId(StringUtil.isEmpty(map.get("CHANNLE_ID"))?"-":map.get("CHANNLE_ID").toString());
			proChnBalance.setProdId(StringUtil.isEmpty(map.get("PROD_ID"))?"-":map.get("PROD_ID").toString());
			proChnBalance.setSettDate(StringUtil.isEmpty(map.get("SETT_DATE"))?" ":map.get("SETT_DATE").toString());
			proChnBalance.setStatus(Constants.BAN_STATUS);//状态：待结算 0000
			proChnBalance.setTotalCnt(new BigDecimal(map.get("count").toString()));//当日记录总笔数
			proChnBalance.setTotalAmt(new BigDecimal(map.get("TOTAL_AMT").toString()));//当日记录总笔数
			//处理总记录数  获取昨日记录数
			SettProdChnBalanceExample  proChnBalanceexample=new SettProdChnBalanceExample();
			String yesterDay=StringUtil.getLastDay(proChnBalance.getSettDate());
			proChnBalanceexample.createCriteria().andPrdIdEqualTo(proChnBalance.getPrdId())
			.andChannelIdEqualTo(proChnBalance.getChannelId()).andProdIdEqualTo(proChnBalance.getProdId())
			.andSettDateEqualTo(yesterDay);
			List<Object> banlancelist=settProdChnBalanceDao.selectByExample(proChnBalanceexample);
			//如果昨日总记录数不为空 则总记录数=昨日总记录数+今日记录数  否则总记录数=今日记录数
			if(banlancelist!=null&&banlancelist.size()>0){
				SettProdChnBalance banlance=(SettProdChnBalance) banlancelist.get(0);
				proChnBalance.setAccTotalCnt(proChnBalance.getTotalCnt().add(banlance.getAccTotalCnt()));
				proChnBalance.setAccTotalAmt(proChnBalance.getTotalAmt().add(banlance.getAccTotalAmt()));
			}else{
				proChnBalance.setAccTotalCnt(proChnBalance.getTotalCnt());
				proChnBalance.setAccTotalAmt(proChnBalance.getTotalAmt());
			}
			//申购、赎回、手续费类型根据detail表里交易类型翻译  
			String acctType=(String) map.get("TRANS_TYPE");
			if(acctType.equals(Constants.TRANS101)){
				proChnBalance.setAcctType(Constants.ACCT_TYPE_01);//申购
			}else if(acctType.equals(Constants.TRANS103)){
				proChnBalance.setAcctType(Constants.ACCT_TYPE_02);//赎回
			}else if(acctType.equals(Constants.TRANSFEE)){
				proChnBalance.setAcctType(Constants.ACCT_TYPE_06);//商户手续费、产品手续费 类型sql中已处理
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new SettleException();
		}
		return proChnBalance;
	}
		
	//处理  开户记录数 新建账户统计
	public SettProdChnBalance getProdChnBanlanceForAcct(Map map){
			map.put("TRANS_TYPE", "MSCS.ACCT");
			SettProdChnBalance proChnBalance=new SettProdChnBalance();
			try {
				proChnBalance.setId(getId(map).get("ID").toString());//ID
				proChnBalance.setField1(getId(map).get("FIELD1").toString());
				proChnBalance.setProductType(Constants.OFAG);
				proChnBalance.setPrdId(StringUtil.isEmpty(map.get("PRD_ID"))?"-":map.get("PRD_ID").toString());
				proChnBalance.setChannelId(StringUtil.isEmpty(map.get("CHANNLE_ID"))?"-":map.get("CHANNLE_ID").toString());
				proChnBalance.setProdId(StringUtil.isEmpty(map.get("PROD_ID"))?"-":map.get("PROD_ID").toString());
				proChnBalance.setSettDate(StringUtil.isEmpty(map.get("SETT_DATE"))?" ":map.get("SETT_DATE").toString());
				proChnBalance.setStatus(Constants.BAN_STATUS);//状态：待结算 0000
				proChnBalance.setAcctType(Constants.ACCT_TYPE_00);
				BigDecimal newAcctCnt=getAcctNewCnt(proChnBalance.getPrdId(),proChnBalance.getProdId(),proChnBalance.getSettDate());
				if(newAcctCnt.compareTo(new BigDecimal(0))>0){
					proChnBalance.setTotalCnt(newAcctCnt);//当日记录总数
					SettProdBalanceExample  proBalanceexample=new SettProdBalanceExample();
					String yesterDay=StringUtil.getLastDay(proChnBalance.getSettDate());
					proBalanceexample.createCriteria()
					.andPrdIdEqualTo(proChnBalance.getPrdId())
					.andProdIdEqualTo(proChnBalance.getProdId())
					.andSettDateEqualTo(yesterDay);
					List<Object> banlancelist=settProdBalanceDao.selectByExample(proBalanceexample);
					if(banlancelist!=null&&banlancelist.size()>0){
						SettProdBalance banlance=(SettProdBalance) banlancelist.get(0);
						proChnBalance.setAccTotalCnt(newAcctCnt.add(banlance.getTotalCnt()));//累计记录总数
					}else{
						proChnBalance.setAccTotalCnt(newAcctCnt);//累计记录总数
					}
					
				}else{
					
					proChnBalance.setTotalCnt(new BigDecimal(0));//当日记录总数
					SettProdBalanceExample  proBalanceexample=new SettProdBalanceExample();
					String yesterDay=StringUtil.getLastDay(proChnBalance.getSettDate());
					proBalanceexample.createCriteria()
					.andPrdIdEqualTo(proChnBalance.getPrdId())
					.andProdIdEqualTo(proChnBalance.getProdId())
					.andSettDateEqualTo(yesterDay);
					List<Object> banlancelist=settProdBalanceDao.selectByExample(proBalanceexample);
					if(banlancelist!=null&&banlancelist.size()>0){
						SettProdBalance banlance=(SettProdBalance) banlancelist.get(0);
						proChnBalance.setAccTotalCnt(banlance.getTotalCnt());//累计记录总数
					}else{
						proChnBalance.setAccTotalCnt(newAcctCnt);//累计记录总数
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new SettleException();
			}
			return proChnBalance;
		}
        	
	public Map getId(Map map){
		Map param=new HashMap();
		String secnum="1";
		String id="";
		if(StringUtil.isEmpty(map.get("ACCT_TYPE"))){
			//id=结算日期+交易类型+PRD_ID+CHANNEL_ID+PROD_ID
			id=map.get("SETT_DATE").toString().replace("-", "")+map.get("TRANS_TYPE").toString().split("\\.")[1]
					+map.get("PRD_ID")+map.get("CHANNEL_ID")+map.get("PROD_ID");
			String sql="select  max(ID) MAXID  ,max(FIELD1) MAXSEC from T_SETT_PROD_CHN_BALANCE where ID like '"+id+"%'";
			
			List<HashMap> proChnlist = SerializerUtil.deserializeArray(
					settProdChnBalanceDao.doBySQL(sql), HashMap.class);
			if(null!=proChnlist&&proChnlist.size()>0){
				Map parammap=proChnlist.get(0);
				if(!StringUtil.isEmpty(parammap.get("MAXSEC"))){
					String maxsec=(String) parammap.get("MAXSEC");
					secnum=String.valueOf(Integer.valueOf(maxsec)+1);
				}
			};
		}else{
			//id=结算日期+交易类型+PRD_ID+CHANNEL_ID+PROD_ID
			id=map.get("SETT_DATE").toString().replace("-", "")+map.get("ACCT_TYPE")
					+map.get("PRD_ID")+map.get("PROD_ID");
			String sql="select  max(ID) MAXID  ,max(FIELD1) MAXSEC from T_SETT_PROD_BALANCE where ID like '"+id+"%'";
			
			List<HashMap> proChnlist = SerializerUtil.deserializeArray(
					settProdBalanceDao.doBySQL(sql), HashMap.class);
			if(null!=proChnlist&&proChnlist.size()>0){
				Map parammap=proChnlist.get(0);
				if(!StringUtil.isEmpty(parammap.get("MAXSEC"))){
					String maxsec=(String) parammap.get("MAXSEC");
					secnum=String.valueOf(Integer.valueOf(maxsec)+1);
				}
				
			}
		}
		param.put("ID", id+secnum);
		param.put("FIELD1", secnum);
		
		return  param;
		
	}
	/**
	 * 查询新建账户
	 */
	public BigDecimal getAcctNewCnt(String mchntId,String prodId, String settleDate) {

		String sql = "select count(*) count from T_FRONT_USER_PROD_ACCT where left(ID,6)='"+ prodId
				+ "' and mchnt_id='"+mchntId+"' and left(create_time,10)='"
				+ settleDate+ "' and status='0000'";
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
			return SettleSteps.Settle_For_Land_Banlance;
		}
		
}
