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
import starstart.cgame.flows.land.util.Constants;
import starstart.cgame.flows.land.util.IDHelper;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.msg.entity.NotifyReqPackage;
import starstart.cgame.flows.msg.entity.Notify_805Req;
import starstart.cgame.flows.msg.entity.RB_NSettle_805;
import starstart.cgame.flows.mysqlgens.sett.entity.SettProdBalance;
import starstart.cgame.flows.mysqlgens.trade.entity.MchInf;
import starstart.cgame.flows.mysqlgens.trade.entity.MchInfExample;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import starstart.cgame.flows.nsttl.flows.TaskDataDefs;
import cn.msec.bao.outils.serialize.SerializerUtil;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.ojpa.api.annotations.StoreDAO;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
/**
 * 
 * 805报文结算通知信息
 *
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_805_Banlance_Notice_RYB extends  NSettle_BaseActor<CalcMutex>  {

	@StoreDAO(domain = SettProdBalance.class)
	protected OJpaDAO<SettProdBalance> settProdBalanceDao;
	@StoreDAO(domain = MchInf.class)
	protected OJpaDAO<MchInf> MchInfDao;

	
	@Override
	public void processMessage(CalcMutex pack) {
		String settleDate = pack.getDatas().get(TaskDataDefs.DT_SettleDT);// StringUtil.getCurrDate();
		if (!StringUtil.isEmpty(settleDate) && settleDate.length() >= 10) {
			settleDate = settleDate.substring(0, 10);
		}
		MchInfExample mchInfExample=new MchInfExample();
		mchInfExample.createCriteria().andStatusEqualTo("00");
		List<Object> mchList =MchInfDao.selectByExample(mchInfExample);
		//循环给商户发送通知
		if(null!=mchList&&mchList.size()>0){
			for (int i = 0; i < mchList.size(); i++) {
				List<RB_NSettle_805> sttl805List=new ArrayList<RB_NSettle_805>();
				NotifyReqPackage<RB_NSettle_805, Notify_805Req> packVal =new NotifyReqPackage<RB_NSettle_805, Notify_805Req>();
				MchInf mchMap=(MchInf) mchList.get(i);
				List<RB_NSettle_805.SettDetailsBean> detailList=new ArrayList<RB_NSettle_805.SettDetailsBean>();
				RB_NSettle_805 nsettle805=new RB_NSettle_805();
				//通知报文 报头
				packVal.setMsgtype("MSCS.805");
				packVal.setMsgsentid(IDHelper.getTMessageId(mchMap.getMchntId()+"805"));
				packVal.setSender(mchMap.getMchntId());//ntrade处理发送通知时  Receiver取pack中的sender值
				packVal.setReceiver(mchMap.getMchntId()+"805");//ntrade处理发送通知时  Msgsentid取packVal中的Receiver
				nsettle805.setCurrency("CNY");
				nsettle805.setSttldate(settleDate);
				nsettle805.setProductType(Constants.OFAG);
				nsettle805.setPayAmount("0");
				nsettle805.setLoaningAmount("0");
				nsettle805.setLoaningTotalAmount("0");
				nsettle805.setLoaningFee("0" );
				nsettle805.setLoaningPayDate(" ");
				//只通知申购、赎回信息
				String prodBanSql="SELECT MCHNT_ID,ACCT_TYPE ,SUM(TOTAL_AMT) TOTAL_AMT FROM T_SETT_PROD_BALANCE  "
						+ " WHERE SETT_DATE='"+settleDate+"'  AND PRODUCT_TYPE='"+Constants.OFAG+"'"
						+ " AND MCHNT_ID='"+mchMap.getMchntId()+"' AND ACCT_TYPE IN ('1','2') GROUP BY MCHNT_ID,ACCT_TYPE ";
				List<HashMap> prodBanList = SerializerUtil.deserializeArray(
						settProdBalanceDao.doBySQL(prodBanSql), HashMap.class);
				BigDecimal sgAmt=new BigDecimal(0);
				BigDecimal shAmt=new BigDecimal(0);
				BigDecimal feeAmt=new BigDecimal(0);
				if(null!=prodBanList&&prodBanList.size()>0){
					for (int j = 0; j < prodBanList.size(); j++) {
						Map prodMap=prodBanList.get(j);
						RB_NSettle_805.SettDetailsBean detail=new RB_NSettle_805.SettDetailsBean();
						detail.setBookType(prodMap.get("ACCT_TYPE").toString());
						if(prodMap.get("ACCT_TYPE").equals(Constants.ACCT_TYPE_01)){
							sgAmt=StringUtil.StringToBigDecimal(prodMap.get("TOTAL_AMT").toString());
							detail.setReDeCrType("D");//借方
						}else if(prodMap.get("ACCT_TYPE").equals(Constants.ACCT_TYPE_02)){
							shAmt=StringUtil.StringToBigDecimal(prodMap.get("TOTAL_AMT").toString());
							detail.setReDeCrType("C");//贷方
						}
						detail.setBookAmount(prodMap.get("TOTAL_AMT").toString());
						detailList.add(detail);
					}
				}else{//商户当日没有结算信息 也发送通知
					RB_NSettle_805.SettDetailsBean detail=new RB_NSettle_805.SettDetailsBean();
					detail.setBookType("");
					detail.setReDeCrType("");//贷方
					detail.setBookAmount("0");
					detailList.add(detail);
				}
				//结算金额=申购-赎回
				nsettle805.setSttlamt(sgAmt.subtract(shAmt).toPlainString());
				BigDecimal sttamt=new BigDecimal(nsettle805.getSttlamt());
				if(sttamt.compareTo(new BigDecimal(0))>0){
					nsettle805.setDeCrType("D");
				}else if(sttamt.compareTo(new BigDecimal(0))<0){
					nsettle805.setDeCrType("C");
				}else if(sttamt.compareTo(new BigDecimal(0))==0){
					nsettle805.setDeCrType("");
				}
				nsettle805.setSettlementDetailList(detailList);
				sttl805List.add(nsettle805);
				packVal.setReqbeans(sttl805List);
				//发送结算通知
				log.debug("往NTRADE发送结算通知："+packVal.toString());
				sendMessage("NOTI_MSCS.805", SerializerUtil.toBytes(SerializerUtil.serialize(packVal)));
			}
			
		}
	}
	
	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Banlance_Notice_OFAG;
	}
}
