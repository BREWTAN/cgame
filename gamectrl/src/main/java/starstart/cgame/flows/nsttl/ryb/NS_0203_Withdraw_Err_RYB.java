package starstart.cgame.flows.nsttl.ryb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URLEncoder;
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
import starstart.cgame.flows.land.util.SoapClient;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.mysqlgens.sett.entity.SettErr;
import starstart.cgame.flows.mysqlgens.sett.entity.SettErrExample;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontUserProdAcct;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontUserProdAcctExample;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs101;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs101Example;
import starstart.cgame.flows.mysqlgens.trade.entity.TradeMscs101;
import starstart.cgame.flows.mysqlgens.trade.entity.TradeMscs101Example;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
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
 * @ClassName: NS_0203_Withdraw_Err_RYB
 * @Description: 差错文件处理
 * @date 2015年4月14日 下午5:40:56
 *
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_0203_Withdraw_Err_RYB extends NSettle_BaseActor<CalcMutex> {


	@StoreDAO(domain = LandMscs101.class)
	protected OJpaDAO<LandMscs101> land101Dao;
	@StoreDAO(domain = TradeMscs101.class)
	protected OJpaDAO<TradeMscs101> trade101Dao;
	@StoreDAO(domain = SettErr.class)
	protected OJpaDAO<SettErr> settErrDao;
	@StoreDAO(domain = FrontUserProdAcct.class)
	protected OJpaDAO<FrontUserProdAcct> acctDao;
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;


	@Override
	public void processMessage(CalcMutex pack) {
		log.info("STTL:差错处理:" + pack);
		try {
			ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
			String settleDate = paramsUtil.getSettDate(pack);
			String dayOfEndFilePath=cacheHelper.getTradeParamByKey("dayOfEndFilePath");
			String diffFilePath=ParamsDatasUtil.getDownLoadPath(dayOfEndFilePath, settleDate, "LT06");
			File diffFile=new File(diffFilePath);
			//获取目录下所有ryb差错文件 逐个处理
			File[] fileList=diffFile.listFiles();
			if(null!=fileList&&fileList.length>0){
				for (int i = 0; i < fileList.length; i++) {
					File file=fileList[i];
					String proMchId=pack.getDatas().get(TaskDataDefs.PROD_MchID);
					if(file.getName().endsWith(proMchId+"result100.txt")){
						log.info("对账文件："+file.getName());
						List<String> diffList = new ArrayList<String>();
						InputStreamReader read = new InputStreamReader(
								new FileInputStream(file));
						BufferedReader bufferedReader = new BufferedReader(read);
						String lineTxt = null;
						//文件中的数据读入list中用于数据处理
						while ((lineTxt = bufferedReader.readLine()) != null) {
							diffList.add(lineTxt);
						}
						List<String> errStatusList1 = new ArrayList<String>();
						List<String> errStatusList2 = new ArrayList<String>();
						//判断list中数据 差错类型   <:产品有,我方无     >：我方有,产品无
						if(diffList.size()>0){
							for (int j = 0; j < diffList.size(); j++) {
								
								String diffStr = diffList.get(j);
								if (diffStr.length() > 4) {
									if (diffStr.indexOf("<") == 0) {// 01 产品有,我方无 
										errStatusList1.add(diffStr);
									} else if (diffStr.indexOf(">") == 0) {// 02 我方有,产品无 
										errStatusList2.add(diffStr);
									} else{
										log.info("跳过内容："+diffStr);
									}
								}
							}
							//产品方有我方无得差错数据（对账时都只有正常状态数据 查询本地是否有状态不为正常的本条数据）
							if (errStatusList1.size() > 0) {
								updateAndInsertErr1(errStatusList1);
							}
							//产品方无我方有的差错数据
							if (errStatusList2.size() > 0) {
								updateAndInsertErr2(errStatusList2);
							}
						}else{
							log.info(file.getName()+"无差错记录.");
						}
					}
				}
				log.info("差错处理完成。");
			}else{
				log.info("无差错对账文件。");
			}
			
		}  catch (Exception e) {
			throw new SettleException(e);
		}
	}

	/**
	 * 产品方有我方无得差错数据
	 * 1：产品有我方无  查询本地有状态不为正常的本条数据
	 * 2：产品有我方无  查询本地不存在任何状态的本条数据
	 * @param errStatusList
	 * @throws Exception
	 */
	
	public void updateAndInsertErr1(List<String> errStatusList)
			throws Exception {

		try {
			List<String> errStatusList2 = new ArrayList<String>();
			List<Object> land1List2 = new ArrayList<Object>();
			List<String> mailList = new ArrayList<String>();
			for (int i = 0; i < errStatusList.size(); i++) {
				String diffStr = errStatusList.get(i);
				Object[] objs = diffStr.split("\\|");// < 交易日期|金额|状态|订单号
				if (objs.length >= 4) {
					String prodOrderNo = (String) objs[3];
					BigDecimal transAmt =  new BigDecimal(objs[1].toString());
					String settleDate = objs[0].toString().replace("<", "").trim();
					LandMscs101Example example = new LandMscs101Example();
					example.createCriteria().andProdOrderIdEqualTo(prodOrderNo);
					List<Object> land1List = land101Dao.selectByExample(example);
					
					//首先判断是否已经做过差错对账，已经做过的话就更新差错表，否则插入
					SettErrExample errExample = new SettErrExample();
					errExample.createCriteria().andFldReservedEqualTo(prodOrderNo).andTransTypeEqualTo(Constants.TRANS101);
					int flag = settErrDao.countByExample(errExample);
					
					/**
					 * 2：产品有我方无  查询本地不存在任何状态的本条数据   发端短信提示 邮件
					 */
					if (null == land1List || land1List.size() == 0) {
						SoapClient client = new SoapClient();
						String content = URLEncoder.encode("RYB赎回差错对账通知prodOrderNo="+prodOrderNo, "utf8");
						String sn = cacheHelper.getTradeParamByKey("sn");
						String pwd = cacheHelper.getTradeParamByKey("password");
						String serviceURL = cacheHelper.getTradeParamByKey("soapUrl");
						String phone = cacheHelper.getTradeParamByKey("phoneno");
						String result_mt = client.mdSmsSend_u(phone, content,
								"", "", String.valueOf(new Date().getTime()),sn, client.getMD5(sn+pwd),serviceURL);
						
						String info = "RYB赎回差错对账通知prodOrderNo="+prodOrderNo;
						mailList.add(info);
	
						// 插入数据到差错表
						SettErr settErr = new SettErr();
						settErr.setVireFlag("1");
						settErr.setCurrntFlag("1");
						settErr.setDateSettlmt(settleDate);
						settErr.setChannelNum("00");
						settErr.setAmtTrans(transAmt.divide(new BigDecimal(100)));
						settErr.setMchntRecordId("");
						settErr.setMchntId("");
						settErr.setProdId("");
						settErr.setStatus("00");//待处理
						settErr.setTransType(Constants.TRANS101);
						settErr.setErrState(Constants.BLEND_STATE0);
						settErr.setErrMsg("");
						Timestamp timeStamp = new Timestamp(new Date().getTime());
						settErr.setFldReserved(prodOrderNo);
						log.info("prodOrderNo="+prodOrderNo+",count="+flag);

						// 输出返回标识，为小于19位的正数，String类型的。记录您发送的批次。发送短信，如果是以负号开头就是发送失败。
						if (StringUtil.isEmpty(result_mt)
								|| result_mt.startsWith("-")) {
							log.error("短信发送失败！返回信息为：" + result_mt);
							settErr.setErrMsg("短信发送失败！");
						} else {
							log.info("发送成功，返回值为：" + result_mt);
							settErr.setErrMsg("短信发送成功!");
						}
						
						if(flag>0){
							settErr.setUpdTime(timeStamp);
							settErrDao.updateByExampleSelective(settErr, errExample);
						}else{
							settErr.setCrtTime(timeStamp);
							settErr.setId(StringUtil.getUUID());
							settErrDao.insert(settErr);
						}
					} else {
						 /**
						  *  1：产品有我方无  查询本地有状态不为正常的本条数据
						  */
						errStatusList2.add(diffStr);
						land1List2.add(land1List.get(0));
					}
					
				}
			}
			// 如果查询到本地有当前流水信息 抹平修改流水状态为正常并插入差错信息
			if (errStatusList2.size() > 0) {
				updateStreamAndErrTable(errStatusList2, land1List2,
						Constants.BLEND_STATE0);
			}
			//发送邮件信息
			if (mailList.size() > 0) {
				String mailto = cacheHelper.getTradeParamByKey("EmailAddress");
				String subject = StringUtil.getCurrDate()+"RYB赎回差错对账通知";
				String text ="";
				String url =cacheHelper.getTradeParamByKey("mailUrl");;
				for(String info:mailList){
					text+=info+"\n";
				}
				SoapClient client = new SoapClient();
				String rs = client.sendMail(mailto, subject, text, url);
				log.info(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// 如果查询到本地有当前流水信息 抹平修改流水状态为正常并插入差错信息
	public void updateStreamAndErrTable(List<String> errStatusList,
			List<Object> landList, String BlendStat) {

		List<Object> land101Records = new ArrayList<Object>();
		List<Object> trade101Records = new ArrayList<Object>();
		List<Object> acctRecords = new ArrayList<Object>();

		try {
			// 本地查询流水信息放入mchntMap中 value="商户上送订单号"+"商户号"+"产品号"
			Map<String, String> mchntMap = new HashMap<String, String>();
			for (int i = 0; i < landList.size(); i++) {
				LandMscs101 landMscs101 = (LandMscs101)landList.get(i);
				String key = landMscs101.getProdOrderId();
				mchntMap.put(key,
						landMscs101.getOrderId() + "," + landMscs101.getSndMchId() + ","
						+ landMscs101.getProductId()+","+landMscs101.getActNo());
			}

			for (int i = 0; i < errStatusList.size(); i++) {
				String diffStr = errStatusList.get(i);
				Object[] objs = diffStr.split("\\|");
				String prodOrderNo = (String) objs[3];
				BigDecimal transAmt = new BigDecimal(objs[1].toString());
				String settleDate = objs[0].toString().replace("<", "").trim();
				String status = (String) objs[2];
				if (null != mchntMap.get(prodOrderNo)) {
					
					//首先判断是否已经做过差错对账，已经做过的话就更新差错表，否则插入
					SettErrExample errExample = new SettErrExample();
					errExample.createCriteria().andFldReservedEqualTo(prodOrderNo).andTransTypeEqualTo(Constants.TRANS101);
					int flag = settErrDao.countByExample(errExample);
					log.info("flag="+flag);
					
					String[] mchnts = mchntMap.get(prodOrderNo).split(",");
					// 插入数据到差错表
					SettErr settErr = new SettErr();
					settErr.setVireFlag("1");
					settErr.setCurrntFlag("1");
					settErr.setStatus("01");//处理成功
					settErr.setDateSettlmt(settleDate);
					settErr.setChannelNum("00");
					settErr.setAmtTrans(transAmt.divide(new BigDecimal(100)));
					settErr.setMchntRecordId(mchnts[0]);
					settErr.setMchntId(mchnts[1]);
					settErr.setProdId(mchnts[2]);
					settErr.setTransType(Constants.TRANS101);
					Timestamp timeStamp = new Timestamp(new Date().getTime());
					settErr.setErrState(BlendStat);
					settErr.setErrMsg("");
					settErr.setFldReserved(prodOrderNo);
					
					// 产品方流水表处理
					LandMscs101 land101 = new LandMscs101();
					land101.setOrderId(mchnts[0]);
					land101.setSttlDate(settleDate);
					land101.setInvAmt(transAmt.divide(new BigDecimal(100)));
					land101.setResultCode(Constants.STATUS_00);
					land101.setProdResultCode(Constants.STATUS_00);
					land101Records.add(land101);
					log.info("更新land101 id="+land101.getOrderId());

					// 商户端流水表处理
					List<HashMap> tlist = SerializerUtil.deserializeArray(
							trade101Dao.doBySQL("select 1 from T_TRADE_MSCS101 where ORDER_ID='"+land101.getOrderId()+"'"), HashMap.class);
					if(tlist!=null&&tlist.size()>0){
						TradeMscs101 trade101 = new TradeMscs101();
						trade101.setOrderId(mchnts[0]);
						trade101.setSttlDate(settleDate);
						trade101.setInvAmt(transAmt.divide(new BigDecimal(100)));
						trade101.setResultCode(Constants.STATUS_00);
						trade101.setProdResultCode(Constants.STATUS_00);
						trade101Records.add(trade101);
						log.info("更新trade101 MchntOrderId="+mchnts[0]);
					}else{
						settErr.setStatus("00");//待处理
						settErr.setErrState(Constants.ERR_STATE1);
						settErr.setErrMsg("T_TRADE_MSCS101表中找不到对应的记录！");
						log.error("T_TRADE_MSCS101表中找不到对应的记录！ORDER_ID:"+mchnts[0]);
					}
					//更新 T_FRONT_USER_PROD_ACCT 余额值=原值+赎回金额
					FrontUserProdAcctExample example=new FrontUserProdAcctExample();
					example.createCriteria().andLandAcctNoEqualTo(mchnts[3]).andMchntIdEqualTo(mchnts[1]);
					List acctList = acctDao.selectByExample(example);
					if(acctList!=null&&acctList.size()>0){
						FrontUserProdAcct acct = (FrontUserProdAcct)acctList.get(0);
						acct.setTotalDepositAmt(acct.getTotalDepositAmt().subtract(transAmt.divide(new BigDecimal(100))));
						acctRecords.add(acct);
						log.info("更新T_FRONT_USER_PROD_ACCT ACT_NO="+mchnts[3]);
					}else{
						settErr.setStatus("00");//待处理
						settErr.setErrState(Constants.ERR_STATE1);
						settErr.setErrMsg("ACCT表中找不到对应的记录！");
						log.error("T_FRONT_USER_PROD_ACCT表中找不到对应的记录！ACT_NO:"+mchnts[3]+",SND_MCH_ID:"+mchnts[1]);
					}

					if(flag>0){
						settErr.setUpdTime(timeStamp);
						settErrDao.updateByExampleSelective(settErr, errExample);
					}else{
						settErr.setCrtTime(timeStamp);
						settErr.setId(StringUtil.getUUID());
						settErrDao.insert(settErr);
					}
				}

			}

			
			
			// 更新产品方流水表
			if (land101Records.size() > 0) {
				land101Dao.batchUpdate(land101Records);
			}
			// 更新商户端流水表
			for (int i = 0; i < trade101Records.size(); i++) {
				TradeMscs101 trans101 = (TradeMscs101) trade101Records.get(i);
				TradeMscs101Example example = new TradeMscs101Example();
				example.createCriteria().andOrderIdEqualTo(
						trans101.getOrderId());
				
				trade101Dao.updateByExampleSelective(trans101, example);
			}
			// 更新用户账户信息表
			if (acctRecords.size() > 0) {
				acctDao.batchUpdate(acctRecords);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 产品方无我方有的差错数据
	 * @param errStatusList
	 * @throws Exception
	 */
	public void updateAndInsertErr2(List<String> errStatusList)throws Exception {

		try {
			StringBuffer sb = null;
			for (int i = 0; i < errStatusList.size(); i++) {

				String diffStr = errStatusList.get(i);
				Object[] objs = diffStr.split("\\|");// < 交易日期|金额|状态|订单号
				if (objs.length >= 4) {
					String prodOrderNo = (String) objs[3];
					if (null == sb) {
						sb = new StringBuffer();
						sb.append("'" + prodOrderNo + "'");
					} else {
						sb.append(",'" + prodOrderNo + "'");
					}
				}
			}
			String sql = "select * from T_LAND_MSCS101 where PROD_ORDER_ID in("
					+ sb.toString() + ")";
			List<HashMap> listMchnt = SerializerUtil.deserializeArray(
					land101Dao.doBySQL(sql), HashMap.class);
			if (null != listMchnt&&listMchnt.size()>0) {
				updateErrTable(errStatusList, listMchnt,
						Constants.BLEND_STATE1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//产品方无我方有的差错数据  更新我方数据库中流水数据状态
	public void updateErrTable(List<String> errStatusList,
			List<HashMap> landList, String BlendStat) {

		List<Object> errRecords = new ArrayList<Object>();
		List<Object> acctRecords = new ArrayList<Object>();
		List<Object> land101Records = new ArrayList<Object>();
		List<Object> trade101Records = new ArrayList<Object>();

		try {
			// 本地查询流水信息放入mchntMap中 value="商户上送订单号"+"商户号"+"产品号"
			Map<String, String> mchntMap = new HashMap<String, String>();
			for (int i = 0; i < landList.size(); i++) {
				Map map = landList.get(i);
				String key = (String) map.get("PROD_ORDER_ID");
				mchntMap.put(key,
						map.get("ORDER_ID") + "," + map.get("SND_MCH_ID") + ","
								+ map.get("PRODUCT_ID") + "," + map.get("ACT_NO"));
			}

			for (int i = 0; i < errStatusList.size(); i++) {
				String diffStr = errStatusList.get(i);
				log.info(diffStr);
				Object[] objs = diffStr.split("\\|");
				String prodOrderNo = (String) objs[3];
				BigDecimal transAmt = new BigDecimal(objs[1].toString());
				String settleDate = objs[0].toString().replace(">", "").trim();
				String status = (String) objs[2];
				if (null != mchntMap.get(prodOrderNo)) {
					String[] mchnts = mchntMap.get(prodOrderNo).split(",");

					//首先判断是否已经做过差错对账，已经做过的话就更新差错，否则插入
					SettErrExample errExample = new SettErrExample();
					errExample.createCriteria().andFldReservedEqualTo(prodOrderNo).andTransTypeEqualTo(Constants.TRANS101);
					int flag = settErrDao.countByExample(errExample);
					
					// 产品方流水表
					LandMscs101 land101 = new LandMscs101();
					land101.setOrderId(mchnts[0]);// "ID"
					land101.setSttlDate(settleDate);
					land101.setResultCode(Constants.STATUS_FAILED);
					land101.setProdResultCode(Constants.STATUS_FAILED);
					land101Records.add(land101);
					log.info("更新land101 ORDER_ID="+land101.getOrderId());

					
					
					// 插入数据到差错表
					SettErr settErr = new SettErr();
//					settErr.setId(StringUtil.getUUID());
					settErr.setProdId(mchnts[2]);
					settErr.setVireFlag("1");
					settErr.setCurrntFlag("1");
					settErr.setStatus("01");//已处理
					settErr.setDateSettlmt(settleDate);
					settErr.setChannelNum("00");
					settErr.setAmtTrans(transAmt.divide(new BigDecimal(100)));
					settErr.setMchntRecordId(mchnts[0]);
					settErr.setMchntId(mchnts[1]);
					settErr.setProdId(mchnts[2]);
					Timestamp timeStamp = new Timestamp(new Date().getTime());
					settErr.setErrState(BlendStat);
					settErr.setFldReserved(prodOrderNo);
					settErr.setTransType(Constants.TRANS101);

					List<HashMap> tlist = SerializerUtil.deserializeArray(
							trade101Dao.doBySQL("select 1 from T_TRADE_MSCS101 where ORDER_ID='"+mchnts[0]+"'"), HashMap.class);
					if(tlist!=null&&tlist.size()>0){
						// 商户端流水表
						TradeMscs101 trade101 = new TradeMscs101();
						trade101.setOrderId(mchnts[0]);
						trade101.setSttlDate(settleDate);
						trade101.setResultCode(Constants.STATUS_FAILED);
						trade101.setProdResultCode(Constants.STATUS_FAILED);
						trade101Records.add(trade101);
						log.info("更新trade101 ORDER_ID="+mchnts[0]);
					}else{
						settErr.setStatus("00");//待处理
						settErr.setErrState(Constants.ERR_STATE1);
						settErr.setErrMsg("T_TRADE_MSCS101表中找不到对应的记录！");
						log.error("T_TRADE_MSCS101表中找不到对应的记录！ORDER_ID:"+mchnts[0]);
					}
					
					//更新 T_FRONT_USER_PROD_ACCT 余额值 =原值-赎回金额
					FrontUserProdAcctExample example=new FrontUserProdAcctExample();
					example.createCriteria().andLandAcctNoEqualTo(mchnts[3]).andMchntIdEqualTo(mchnts[1]);
					List acctList = acctDao.selectByExample(example);
					if(acctList!=null&&acctList.size()>0){
						FrontUserProdAcct acct = (FrontUserProdAcct)acctList.get(0);
						acct.setTotalDepositAmt(acct.getTotalDepositAmt().add(transAmt.divide(new BigDecimal(100))));
						acctRecords.add(acct);
						log.info("更新T_FRONT_USER_PROD_ACCT DIG_ACCT_NO="+mchnts[3]);
					}else{
						settErr.setStatus("00");//待处理
						settErr.setErrState(Constants.ERR_STATE1);
						settErr.setErrMsg("T_FRONT_USER_PROD_ACCT表中找不到对应的记录！");
						log.error("T_FRONT_USER_PROD_ACCT表中找不到对应的记录！DIG_ACCT_NO:"+mchnts[3]+",SND_MCH_ID:"+mchnts[1]);
					}

					if(flag>0){
						settErr.setUpdTime(timeStamp);
						settErrDao.updateByExampleSelective(settErr, errExample);
					}else{
						settErr.setCrtTime(timeStamp);
						settErr.setId(StringUtil.getUUID());
						settErrDao.insert(settErr);
						log.info("插入settErr表 id="+settErr.getId());
					}
					
				}
			}

			
			// 更新产品方流水表
			if (land101Records.size() > 0) {
				land101Dao.batchUpdate(land101Records);
			}
			// 更新商户端流水表
			for (int i = 0; i < trade101Records.size(); i++) {
				TradeMscs101 trans101 = (TradeMscs101) trade101Records.get(i);
				TradeMscs101Example example = new TradeMscs101Example();
				example.createCriteria().andOrderIdEqualTo(
						trans101.getOrderId());
				
				trade101Dao.updateByExampleSelective(trans101, example);
			}
			// 更新用户账户信息表
			if (acctRecords.size() > 0) {
				acctDao.batchUpdate(acctRecords);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Withdraw_Err_RYB;
	}

}
