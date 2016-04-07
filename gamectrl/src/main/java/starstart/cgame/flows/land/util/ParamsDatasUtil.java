package starstart.cgame.flows.land.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInfExample;
import starstart.cgame.flows.mysqlgens.trade.entity.LandFeeInfo;
import starstart.cgame.flows.mysqlgens.trade.entity.LandFeeInfoExample;
import starstart.cgame.flows.mysqlgens.trade.entity.MchFeeDesc;
import starstart.cgame.flows.mysqlgens.trade.entity.MchFeeDescExample;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.nsttl.flows.TaskDataDefs;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;


@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class ParamsDatasUtil {
	
    private   OJpaDAO<LandFeeInfo> landFeeInfoDao;
    private   OJpaDAO<MchFeeDesc> mchFeeDescDao;
    private   OJpaDAO<LandChannelInf> landChannelInfDao;

    public ParamsDatasUtil(OJpaDAO<MchFeeDesc> mchFeeDescDao,OJpaDAO<LandFeeInfo> landFeeInfoDao){
    	this.mchFeeDescDao=mchFeeDescDao;
    	this.landFeeInfoDao=landFeeInfoDao;
    }
    public ParamsDatasUtil(OJpaDAO<LandChannelInf> landChannelInfDao){
    	this.landChannelInfDao=landChannelInfDao;
    }

    
	public  String  getSettDate(CalcMutex pack){
		String settleDate="";
		String dtSettleDt = pack.getDatas().get(TaskDataDefs.DT_SettleDT);//StringUtil.getCurrDate();
		String taskId=pack.getDatas().get(TaskDataDefs.DT_ParentID);//taskId
		String prodMchId=taskId.split("\\|")[0];
		LandChannelInfExample channelexample = new LandChannelInfExample();
		channelexample.createCriteria().andProdMchIdEqualTo(prodMchId);
		channelexample.setDistinct(true);
		List<Object> chanelList = landChannelInfDao.selectByExample(channelexample);
		String T="";
		if(chanelList!=null&&chanelList.size()>0){
			LandChannelInf channelInf=(LandChannelInf) chanelList.get(0);
			T=channelInf.getField2();//结算日期计算规则  T：为当前任务日期  T-1为任务日期前一日
		}
		if(Constants.FNLN.equals(prodMchId)){//p2p执行结算日期为任务执行日期前一日
			settleDate=StringUtil.getLastDay(dtSettleDt.substring(0, 10));
		}else if(Constants.OFAG.equals(prodMchId)){//ryb执行结算日期为任务执行日期
			settleDate=dtSettleDt.substring(0, 10);
		}else{
			 if("T".equals(T)){
				 settleDate=dtSettleDt.substring(0, 10);
			 }else if("T-1".equals(T)){
				 settleDate=StringUtil.getLastDay(dtSettleDt.substring(0, 10));
			 }
		}
		return settleDate;
	}
	
	//获取对账文件存储路径
	public static String  getDownLoadPath(String path,String settleDate,String fileTp){
		String filePath = path + File.separator + settleDate.replace("-", "")+File.separator+fileTp+File.separator;
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return filePath;
		
	}
	/**
	 * 获取对账文件时需要的参数
	 * @param paramsMap   渠道map信息
	 * @param path   文件存储路径
	 * @param settleDate 结算日期
	 * @param mchTp  商户类型 P2P 如意宝
	 * @param fileTp  文件类型	：LT04：申购	 LT06：赎回  	LT09：转让	LT07：受让	LTPRF：收益
	 * @return  获取对账文件时需要的参数
	 */
	public static Map  getParamsForDownFile(Map paramsMap,String path,String settleDate,String fileTp){
		String proMchId=paramsMap.get("PROD_MCH_ID").toString();
		String filePath = path + File.separator + settleDate.replace("-", "")+File.separator+fileTp+File.separator;
		String fileName = proMchId + fileTp+"_" + settleDate.replace("-", "");
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		filePath = filePath + File.separator + fileName;
		if(fileTp.equals("LT04")){
			paramsMap.put("FILE_TYPE", Constants.SgCode);
		}else if(fileTp.equals("LT06")){
			paramsMap.put("FILE_TYPE", Constants.ShCode);
		}else if(fileTp.equals("LT22")){
			paramsMap.put("FILE_TYPE", Constants.SyCode);
		}else if(fileTp.equals("LT07")){
			paramsMap.put("FILE_TYPE", Constants.SrCode);
		} 
		
		paramsMap.put("SETTLE_DATE",settleDate);
		paramsMap.put("txtFilePath", filePath + ".txt");
		paramsMap.put("zipFilePath", filePath + ".zip");
		return paramsMap;
		
	}
	
	//生成给商户的文件
	public static void  getRYBMntFile (List<HashMap>  mscsList,String title,String mntFilePath){
		
		try {
			File filepath=new File(mntFilePath);
			if (filepath.exists()) {
				filepath.delete();
			}
			FileOutputStream out  = new FileOutputStream(mntFilePath);
			out.write(title.getBytes());
			out.write("\n".getBytes());
			if (null != mscsList && mscsList.size() > 0) {
				StringBuffer purchaseStr = new StringBuffer();
				for (int j = 0; j < mscsList.size(); j++) {
					purchaseStr.delete(0, purchaseStr.toString().length());// 清空字符串
					HashMap landMscsMap = mscsList.get(j);
					purchaseStr.append(landMscsMap.get("STTL_DATE") + "|");
					BigDecimal transAmt = new BigDecimal(landMscsMap.get("INV_AMT").toString());
					purchaseStr.append(transAmt.setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|");
					purchaseStr.append(Constants.STATUS_00+"|");
					purchaseStr.append(landMscsMap.get("ORDER_ID").toString()+"|");
					out.write(purchaseStr.toString().getBytes());
					out.write("\n".getBytes());
				}
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new SettleException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new SettleException(e);
		}
	}
	
	//生成给商户的文件
		public static void  getMntFile (List<HashMap>  mscsList,String title,String mntFilePath){
			
			try {
				File filepath=new File(mntFilePath);
				if (filepath.exists()) {
					filepath.delete();
				}
				FileOutputStream out  = new FileOutputStream(mntFilePath);
				out.write(title.getBytes());
				out.write("\n".getBytes());
				if (null != mscsList && mscsList.size() > 0) {
					StringBuffer purchaseStr = new StringBuffer();
					for (int j = 0; j < mscsList.size(); j++) {
						purchaseStr.delete(0, purchaseStr.toString().length());// 清空字符串
						HashMap landMscsMap = mscsList.get(j);
						purchaseStr.append(landMscsMap.get("STTL_DATE") + "|");
						BigDecimal transAmt = new BigDecimal(landMscsMap.get("INV_AMT").toString());
						purchaseStr.append(transAmt.setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|");
						purchaseStr.append("0000|");
						purchaseStr.append(landMscsMap.get("ORDER_ID").toString()+"|");
						out.write(purchaseStr.toString().getBytes());
						out.write("\n".getBytes());
					}
				}
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new SettleException(e);
			} catch (IOException e) {
				e.printStackTrace();
				throw new SettleException(e);
			}
		}
	
	
	/**
	 * 
	* @Title: initFeeRule 
	* @Description: 产品手续费规则  landFeeList
	* @param @param executionContext
	* @param @throws ItemStreamException    
	* @return void
	 */
	public Map<String,List<Object>>   initProdFeeRule(Map<String,List<Object>>  landFeeMap,String prodId) {
		
		    log.info("产品手续费规则");
		    
			try {
				if(landFeeMap==null){
				    landFeeMap=new HashMap<String, List<Object>>();
			    }
				LandFeeInfoExample exFeeInfoExample=new LandFeeInfoExample();
				exFeeInfoExample.setDistinct(true);
				exFeeInfoExample.createCriteria().andFeeStDateLessThanOrEqualTo(new Date()).andFeeEndDateGreaterThan(new Date())
				.andProdIdEqualTo(prodId);	
				List<Object> landFeeList=landFeeInfoDao.selectByExample(exFeeInfoExample);
				if(null!=landFeeList){
					List<Object> listFeeRules=new ArrayList<Object>();
					for(int i=0;i<landFeeList.size();i++){
						LandFeeInfo landFeeInfo=(LandFeeInfo) landFeeList.get(i);
						if(Constants.FEE_TYPE0.equals(landFeeInfo.getFeeType())){//0-按比率   1-分段计费    2-按月
							//按笔计算    费率类型_比例_最大值_收取或支付类型
							String landFeeStr=landFeeInfo.getFeeType()+"_"+landFeeInfo.getFeeValue()+"_"+landFeeInfo.getFeeMaxAmt()+"_"+landFeeInfo.getFeeFlag();
							listFeeRules.add(landFeeStr);
						}else if(Constants.FEE_TYPE1.equals(landFeeInfo.getFeeType())){
							//按阶梯段计费 费率类型_比例_开始阶段值_结束阶段值_收取或支付类型
							String landFeeStr=landFeeInfo.getFeeType()+"_"+landFeeInfo.getFeeValue()+"_"+landFeeInfo.getStAmt()+"_"+landFeeInfo.getEndAmt()+"_"+landFeeInfo.getFeeFlag();
							listFeeRules.add(landFeeStr);
						}
					}	
					landFeeMap.put(prodId,listFeeRules);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new SettleException(e);
			}
			
			return  landFeeMap ;
	}
	
	/**
	 * 
	* @Title: initMchFeeRule 
	* @Description: 商户手续费规则  landFeeList
	* @param @param executionContext
	* @param @throws ItemStreamException    
	* @return void
	 */
	public Map<String,List<Object>>   initMchFeeRule(Map<String,List<Object>>  mchFeeMap,String mchntId,String prodId) {
		
		    log.info("商户手续费规则");
		    
			try {
				if(mchFeeMap==null){
					mchFeeMap=new HashMap<String, List<Object>>();
			    }
				MchFeeDescExample example=new MchFeeDescExample();
				example.setDistinct(true);
				example.createCriteria().andFeeStDateLessThanOrEqualTo(new Date()).andFeeEndDateGreaterThan(new Date())
				.andMchntIdEqualTo(mchntId).andProdIdEqualTo(prodId);	
				List<Object> mchFeeList=mchFeeDescDao.selectByExample(example);
				if(null!=mchFeeList&&mchFeeList.size()>0){
					List<Object> listFeeRules=new ArrayList<Object>();
					for(int i=0;i<mchFeeList.size();i++){
						MchFeeDesc mchFeeInfo=(MchFeeDesc) mchFeeList.get(i);
						if(Constants.FEE_TYPE0.equals(mchFeeInfo.getFeeType())){//0-按比率   1-分段计费    2-按月
							//按笔计算    费率类型_比例_最大值_收取或支付类型
							String landFeeStr=mchFeeInfo.getFeeType()+"_"+mchFeeInfo.getFeeValue()+"_"+mchFeeInfo.getFeeMaxAmt()+"_"+mchFeeInfo.getFeeFlag();
							listFeeRules.add(landFeeStr);
						}else if(Constants.FEE_TYPE1.equals(mchFeeInfo.getFeeType())){
							//按阶梯段计费 费率类型_比例_开始阶段值_结束阶段值_收取或支付类型
							String landFeeStr=mchFeeInfo.getFeeType()+"_"+mchFeeInfo.getFeeValue()+"_"+mchFeeInfo.getStAmt()+"_"+mchFeeInfo.getEndAmt()+"_"+mchFeeInfo.getFeeFlag();
							listFeeRules.add(landFeeStr);
						}
					}	
					mchFeeMap.put(mchntId+"_"+prodId,listFeeRules);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new SettleException(e);
			}
			
			return  mchFeeMap ;
	}
	/**
	 * 根据feeTp ：MCHNT  PROD 判断是计算商户手续费还是产品手续费
	* @Title: getFeeValueByrule 
	* @Description: 根据手续费map中规则计算手续费
	* @param @param rules
	* @param @param amt
	* @param @return    
	* @return BigDecimal
	 */
	public  BigDecimal getFeeValueByrule(Map<String,List<Object>> feeMap,BigDecimal amt,String feeKey,String feeTp){
		BigDecimal fee=new BigDecimal(0);
		
		try {
			log.info("手续费计算："+feeMap+";"+feeTp+";"+feeKey);
			List<Object> feeRuleList=feeMap.get(feeKey);
			if(feeRuleList!=null&&feeRuleList.size()>0){
				for (int i = 0; i < feeRuleList.size(); i++) {
					//获取手续费计算类型
					String rule=(String) feeRuleList.get(i);
					Object[] objs = rule.split("_");
					if(Constants.FEE_TYPE0.equals(objs[0])){//按笔计费
						BigDecimal feeValue=new BigDecimal(objs[1].toString());
						BigDecimal maxFeeValue=new BigDecimal(objs[2].toString());
						fee=amt.multiply(feeValue).setScale(8,BigDecimal.ROUND_HALF_UP);
						if(maxFeeValue.compareTo(fee)<0){
							//超过上限值  取最大值
							fee=maxFeeValue;
						}
						if(objs[3].equals("1")){//0:收取商户费用  1：支付商户费用
							fee=fee.multiply(new BigDecimal(-1));
						}
					}else if(Constants.FEE_TYPE1.equals(objs[0])){//阶梯计费
						fee=getRegionFeeValue(rule,amt);
						if(fee==null){
							break;
						}
					}
				}
			}else if(feeTp.equals("MCHNT")){
				Object[] keyVal = feeKey.split("_");//MCHNT:商户号_产品号  PROD:产品号
				feeMap=initMchFeeRule(feeMap,keyVal[0].toString(),keyVal[1].toString()) ;
				if(feeMap.get(feeKey)==null){
					return new BigDecimal(0);
				}else{
					getFeeValueByrule(feeMap,amt,feeKey,"MCHNT");
				}
			}else if(feeTp.equals("PROD")){
				feeMap=initProdFeeRule(feeMap,feeKey) ;
				if(feeMap.get(feeKey)==null){
					return new BigDecimal(0);
				}else{
					getFeeValueByrule(feeMap,amt,feeKey,"PROD");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException(e);
		}
		return fee;
		
	}
	public  BigDecimal getRegionFeeValue(String rule,BigDecimal amt){
		//获取阶梯数组
		BigDecimal feeValue=new BigDecimal(0);
		BigDecimal minAmt=new BigDecimal(0);
		BigDecimal maxAmt=new BigDecimal(0);
		Object[] objs = rule.split("_");
		minAmt=new BigDecimal(objs[2].toString());
		maxAmt=new BigDecimal(objs[3].toString());
		if(amt.compareTo(minAmt)>=0 && amt.compareTo(maxAmt)<=0){
			feeValue= new BigDecimal(objs[1].toString());
			feeValue=amt.multiply(feeValue).setScale(8,BigDecimal.ROUND_HALF_UP);
		}else{
			return null;
		}
		if(objs[4].equals("1")){//0:收取商户费用  1：支付商户费用
			feeValue=feeValue.multiply(new BigDecimal(-1));
		}
		return feeValue;
	}
	
	public static void main(String[] args) {
		String str="2015-07-20";
		StringUtil.getLastDay(str);
		str.split("\\.");
	}
	
	
}