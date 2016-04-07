package starstart.cgame.flows.nsttl.ryb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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
import starstart.cgame.flows.land.util.RybDownLoadFileByHttp;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.land.util.TradeDateUtil;
import starstart.cgame.flows.land.util.UUIDGenerator;
import starstart.cgame.flows.mysqlgens.sett.entity.SettLandAcctDetails;
import starstart.cgame.flows.mysqlgens.sett.entity.SettTradeDate;
import starstart.cgame.flows.mysqlgens.sett.entity.SettTradeDateExample;
import starstart.cgame.flows.mysqlgens.sett.entity.SettUserProdDetails;
import starstart.cgame.flows.mysqlgens.sett.entity.SettUserProdDetailsExample;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontMchUserInf;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontUserProdAcct;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontUserProdAcctExample;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs101;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs103;
import starstart.cgame.flows.mysqlgens.trade.entity.LandProdInfo;
import starstart.cgame.flows.mysqlgens.trade.entity.LandProdInfoExample;
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
 * 获取如意宝收益文件 分账处理
 *
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_0301_Profits_Get_RYB extends NSettle_BaseActor<CalcMutex>{

	
	@StoreDAO(domain = LandMscs101.class)
	protected OJpaDAO<LandMscs101> LandMscs101Dao;
	@StoreDAO(domain = LandMscs103.class)
	protected OJpaDAO<LandMscs103> LandMscs103Dao;
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;
	@StoreDAO(domain = SettTradeDate.class)
	protected OJpaDAO<SettTradeDate> settTradeDateDao;
	@StoreDAO(domain = LandProdInfo.class)
	protected OJpaDAO<LandProdInfo> LandProdInfoDao;
	
	@StoreDAO(domain = FrontMchUserInf.class)
	protected OJpaDAO<FrontMchUserInf> frontMchUserInfDao;
	
	@StoreDAO(domain = SettLandAcctDetails.class)
	protected OJpaDAO<SettLandAcctDetails> landAcctDetailsDao;
	@StoreDAO(domain = SettUserProdDetails.class)
	protected OJpaDAO<SettUserProdDetails> userProdDetailsDao;
	@StoreDAO(domain = FrontUserProdAcct.class)
	protected OJpaDAO<FrontUserProdAcct> frontUserProdAcctDao;
	@Override
	public void processMessage(CalcMutex pack) {
		log.info("STTL:处理获取收益文件");
		

		String rybDownLoadPath = cacheHelper.getTradeParamByKey("rybDownLoadPath");
		
		try {
			String filePath="";
			ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
			String settleDate = paramsUtil.getSettDate(pack);
			String sql=CommonSql.getProMchIdSql(Constants.OFAG,pack.getDatas().get(TaskDataDefs.PROD_MchID));
			List<HashMap> channellist = SerializerUtil.deserializeArray(landChannelInfDao.doBySQL(sql), HashMap.class);
			//根据产品方（如意宝）提供的商户号获取收益文件
			if(null!=channellist&&channellist.size()>0){
				for (int i = 0; i < channellist.size(); i++) {
					Map channelMap=channellist.get(i);
					filePath = ParamsDatasUtil.getDownLoadPath(rybDownLoadPath, settleDate, "LT22");
					String prodMchId =  (String) channelMap.get("PROD_MCH_ID");
					String url =(String) channelMap.get("CHANNEL_URL");
					String cerPath=(String) channelMap.get("CHANNEL_PUB_KEY");
					String pfxPath=(String) channelMap.get("CHANNEL_PRI_KEY");
					String pfxPwd=(String) channelMap.get("CHANNEL_KEY");
					String fileName = prodMchId + "_" + settleDate.replace("-", "");
					File file = new File(filePath);
					if (!file.exists()) {
						file.mkdirs();
					}
					filePath = filePath + File.separator + fileName;
					StringBuilder builder = new StringBuilder();
					String messageId = StringUtil.getCurrDate("yyMMddHHmmss") + prodMchId + StringUtil.getRandom(3);
					builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Root><Version>1.0.0</Version>");
					builder.append("<InstId>").append(prodMchId).append("</InstId>");
					builder.append("<MessageId>").append(messageId).append("</MessageId>");
					builder.append("<CertId>DLDReq</CertId><FileType>LT22</FileType>");
					builder.append("<ClearDate>").append(settleDate).append("</ClearDate></Root>");
					Map<String, Object> paramMap = new HashMap<String, Object>();
					int succLength = Integer.valueOf(cacheHelper.getTradeParamByKey("CMBC_DERECTBANK_SUCCESS_LENGTH"));
					paramMap.put("pfxPwd",pfxPwd);
					paramMap.put("pfxPath",pfxPath);
					paramMap.put("cerPath",cerPath);
					paramMap.put("url",url);
					paramMap.put("key",cacheHelper.getTradeParamByKey("3DESKey"));
					paramMap.put("succLength",succLength);
					paramMap.put("dataContent", builder.toString());
					paramMap.put("ent_type", StringUtil.isEmpty(channelMap.get("ENT_TYPE"))?" ":channelMap.get("ENT_TYPE"));
					paramMap.put("txtFilePath", filePath + ".txt");
					paramMap.put("zipFilePath", filePath + ".zip");
					int  count=3;
					int num=0;
					if(cacheHelper.getTradeParamByKey("runCount")!=null){
						count=Integer.valueOf(cacheHelper.getTradeParamByKey("runCount"));
					}
					//如果获取文件失败 尝试循环获取 （runCount次）
					for (int j = 0; j < count; j++) {
						Boolean flag=RybDownLoadFileByHttp.doPost(paramMap);
						if(flag){
							break;//如果获取文件成功 跳出当前循环
						}else if(!flag){
							num+=1;//如果获取文件失败 尝试再次获取
							continue;
						}else{
							log.error("获取申购文件失败："+builder.toString());
							throw new SettleException("获取申购文件失败："+builder.toString());//如果尝试count次后仍失败  则异常
						}
						
					}
				}
			}
			writeIncominfFile(filePath+ ".txt");
			//收益文件入库后 进行分账处理
			divideBanlanceProcess(settleDate );
			
		} catch (Exception e) {
			log.error("收益文件处理错误："+e);
			throw new SettleException(e);
		}
	}

	
		// 收益文件数据入库

		public void writeIncominfFile(String filepath) {
			
				try {
					File file = new File(filepath);
					Map<String, String> prodMap = new HashMap<String, String>();
					List<Object> landAcctDetailsList = new ArrayList();
					/**
					 * 获取收益文件 数据入库  T_SETT_LAND_ACCT_DETAILS
					 */
					List<String> strlist = new ArrayList<String>();
					if (file.exists()&&file.isFile()) {  //判断文件是否存在
						InputStreamReader read = new InputStreamReader(new FileInputStream(file)); 
						BufferedReader bufferedReader = new BufferedReader(read);
						String lineTxt = null;
						while ((lineTxt = bufferedReader.readLine()) != null) {
							strlist.add(lineTxt);
						}
						String channelId=file.getName().substring(0, 5);
						if(strlist.size()>0){
							for (int i = 1; i <strlist.size(); i++) {
								
								Object[] objs = strlist.get(i).split("\\|");
								String OutProdId=objs[6].toString();//净值日总份额
								String OutSubProdId=objs[7].toString();//净值日净赎回份额
								BigDecimal amtYSy = new BigDecimal(objs[2].toString());//昨日总收益
								BigDecimal amtTSy = new BigDecimal(objs[3].toString()); //净值日收益
								BigDecimal totFe=new BigDecimal(objs[4].toString());
								BigDecimal totSh=new BigDecimal(objs[5].toString());
								SettLandAcctDetails landAcctDetails = new SettLandAcctDetails();
								String id=objs[1].toString()+objs[0].toString().replaceAll("-","");
								landAcctDetails.setId(id);
								landAcctDetails.setSettleDate(objs[0].toString());
								landAcctDetails.setStatus(Constants.DIVIDE_STATUS0);
								landAcctDetails.setDigAcctNo(objs[1].toString()); //电子账号
								landAcctDetails.setMchntId(channelId);
								landAcctDetails.setChannelId("");
								landAcctDetails.setYestdTotSy(amtYSy.divide(new BigDecimal("100"))); //昨日总收益
								landAcctDetails.setTodayTotSy(amtTSy.divide(new BigDecimal("100")));//净值日收益
								landAcctDetails.setTodayTotFe(totFe.divide(new BigDecimal("100")));//净值日总份额
								landAcctDetails.setTodayTotSh(totSh.divide(new BigDecimal("100")));//净值日净赎回份额
								landAcctDetails.setOutProdId(OutProdId);
								landAcctDetails.setOutSubProdId(OutSubProdId);
								String key=landAcctDetails.getOutProdId()+"|"+landAcctDetails.getOutSubProdId();
								if(prodMap.get(key)==null){
									String sql1 = "select * from T_LAND_PROD_INFO WHERE OUT_PROD_ID='"
											+ OutProdId+ "' AND OUT_SUB_PROD_ID='"+ OutSubProdId + "'";
									List<HashMap> lanProdInf = SerializerUtil.deserializeArray(
											LandProdInfoDao.doBySQL(sql1), HashMap.class);
									if(null!=lanProdInf&&lanProdInf.size()>0){
										Map<String, String> map = lanProdInf.get(0);
										String prodId=map.get("PROD_ID");
										prodMap.put(map.get("OUT_PROD_ID")+"|"+map.get("OUT_SUB_PROD_ID"), prodId);
										landAcctDetails.setProdId(prodId);
									}else{
										landAcctDetails.setProdId("-");
									}
								}else{
									landAcctDetails.setProdId(prodMap.get(key));
								}
								landAcctDetailsList.add(landAcctDetails);
							}
							if(landAcctDetailsList.size()>0){
								log.info(landAcctDetailsList.toString());
								landAcctDetailsDao.batchInsert(landAcctDetailsList);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new SettleException(e);
				}
		}
		//分账处理
		public void divideBanlanceProcess(String settleDate ) {
			
			try {
				//计算各商户 电子账户 今日份额
				initUserProdDetail(settleDate);
				//统计各电子账号的总份额
				String sumSql="select sum(TODAY_FE) DIG_TOT_FE ,substring_index(DIG_ACCT_NO,'-',-1) DIG_ACCT from T_SETT_USER_PROD_DETAILS "
						+ "where SETTLE_DATE='"+settleDate+"' group by substring_index(DIG_ACCT_NO,'-',-1)";
				List<HashMap> sumList = SerializerUtil.deserializeArray(
						userProdDetailsDao.doBySQL(sumSql), HashMap.class);
				Map<Object, Object> sumMap = new HashMap<Object, Object>();
				if(null!=sumList&&sumList.size()>0){
					for (int i = 0; i < sumList.size(); i++) {
						Map feSumMap=sumList.get(i);
						String DIG_TOT_FE=(new BigDecimal(feSumMap.get("DIG_TOT_FE").toString())).toPlainString();
						sumMap.put(feSumMap.get("DIG_ACCT"), DIG_TOT_FE);
					}
				}
				//统计各账号的总份额
				List<Object> settUserProdDetailList=new ArrayList();
				for (int i = 0; i < sumList.size(); i++) {
					Map map=sumList.get(i);
					String digAcctNo=(String) map.get("DIG_ACCT");
					SettUserProdDetailsExample example =new SettUserProdDetailsExample();
					example.createCriteria().andSettleDateEqualTo(settleDate).andDigAcctNoLike("%"+digAcctNo);
					example.setOrderByClause("TODAY_FE ASC");
					List<Object> prodDetailsList=userProdDetailsDao.selectByExample(example);
					//循环处理 账户数据信息
					if(prodDetailsList!=null&&prodDetailsList.size()>0){
						for (int j = 0; j < prodDetailsList.size(); j++) {
							
								SettUserProdDetails settUserProdDetail=(SettUserProdDetails) prodDetailsList.get(j);
								log.info("循环处理 账户数据信息"+settUserProdDetail.toString());
								// 获取文件中 电子账户净值日收益
								BigDecimal landTodayTotSy=new BigDecimal(0);
								String PROD_ID=settUserProdDetail.getProdId();
								String DIG_ACCT_NO=settUserProdDetail.getDigAcctNo();
								String DIG_ACCT=DIG_ACCT_NO.substring(DIG_ACCT_NO.indexOf("-")+1, DIG_ACCT_NO.length());
								String landsysql="select * from  T_SETT_LAND_ACCT_DETAILS where PROD_ID='"+PROD_ID
										+"' and DIG_ACCT_NO='"+DIG_ACCT+"' and SETTLE_DATE='"+settleDate+"'";
								List<HashMap> landSyList = SerializerUtil.deserializeArray(
										landAcctDetailsDao.doBySQL(landsysql), HashMap.class);
								if(null!=landSyList&&landSyList.size()>0){
										Map landDetails=landSyList.get(0);
										String landTodayTotSyStr=(new BigDecimal(landDetails.get("TODAY_TOT_SY").toString())).toPlainString();
										landTodayTotSy=new BigDecimal(landTodayTotSyStr);
								}
								//今日份额（已起息金额）
								BigDecimal todayFe=settUserProdDetail.getTodayFe();
								//用于分账的总份额
								BigDecimal digTotFe=new BigDecimal(0);
								if(!StringUtil.isEmpty(sumMap.get(DIG_ACCT))){
									digTotFe=StringUtil.StringToBigDecimal(sumMap.get(DIG_ACCT).toString());
								}
								BigDecimal totSy=new BigDecimal(0);
								//落地电子账户净值日收益   如果今日份额小于等于0 净值日收益为0
								if(i==prodDetailsList.size()-1){
									settUserProdDetail.setTodayTotamtSy(landTodayTotSy.subtract(totSy));
								}else{
									if(todayFe.compareTo(new BigDecimal(0))>0&&digTotFe.compareTo(new BigDecimal(0))!=0){
										settUserProdDetail.setTodayTotamtSy(todayFe.divide(digTotFe,8,BigDecimal.ROUND_HALF_UP).multiply(landTodayTotSy).setScale(8,BigDecimal.ROUND_HALF_UP));
									}else{
										settUserProdDetail.setTodayTotamtSy(new BigDecimal(0));
									}
									totSy=totSy.add(settUserProdDetail.getTodayTotamtSy());//当前账户下净值日收益
								}
								/**
								 * 昨日总收益＝上一日昨日总收益＋当前净值日收益
								 */
								BigDecimal yestdTotamtSy=new BigDecimal(0);
								String MCHNT_ID=settUserProdDetail.getMchntId();
								String lastDay=StringUtil.getLastDay(settUserProdDetail.getRecordDate());
								BigDecimal totamtSy=new BigDecimal(0);
								BigDecimal yestdTodayTotamtFe=new BigDecimal(0);
								String sysql="select * from  T_SETT_USER_PROD_DETAILS where MCHNT_ID='"+MCHNT_ID
								+"' and DIG_ACCT_NO='"+DIG_ACCT_NO+"' and RECORD_DATE='"+lastDay+"'";
								List<HashMap> syList = SerializerUtil.deserializeArray(
										userProdDetailsDao.doBySQL(sysql), HashMap.class);
								if(null!=syList&&syList.size()>0){
										Map prodDetails=syList.get(0);
										yestdTotamtSy=StringUtil.StringToBigDecimal(prodDetails.get("YESTD_TOTAMT_SY").toString());//上一日昨日总收益
										totamtSy=StringUtil.StringToBigDecimal(prodDetails.get("TOTAMT_SY").toString());//累计收益
										yestdTodayTotamtFe=StringUtil.StringToBigDecimal(prodDetails.get("TODAY_TOTAMT_FE").toString());//上一日总份额
								}
								
								settUserProdDetail.setYestdTotamtSy(yestdTotamtSy.add(settUserProdDetail.getTodayTotamtSy()));//昨日总收益＝上一净值日收益＋当前净值日收益
								settUserProdDetail.setTodayTotamtFe(yestdTodayTotamtFe.add(settUserProdDetail.getTodayTotamtSy()).add(settUserProdDetail.getDayfe()));//净值日总份额＝上一日总份额+轧差＋净值日收益
								settUserProdDetail.setStatus(Constants.DIVIDE_STATUS0);
								settUserProdDetail.setTotamtSy(totamtSy.add(settUserProdDetail.getTodayTotamtSy()));//净值日收益累计收益
								log.info("处理完分账数据settUserProdDetail=："+settUserProdDetail.toString());
								settUserProdDetailList.add(settUserProdDetail);
							}
					}
				}
				if(settUserProdDetailList.size()>0){
					userProdDetailsDao.batchUpdate(settUserProdDetailList);
					updFrontProdAcct(settUserProdDetailList,settleDate);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new SettleException(e);
			}
			
			
			
		}
		
		
		public void updFrontProdAcct(List<Object> settUserProdDetailList,String  settleDate ) {
		
				try {
					//更新表T_FRONT_USER_PROD_ACCT  余额=原值+当日收益
					List<Object> frontUserProdAcctList= new ArrayList();
					if(settUserProdDetailList!=null&&settUserProdDetailList.size()>0){
						for (int i = 0; i < settUserProdDetailList.size(); i++) {
							SettUserProdDetails userProd=(SettUserProdDetails) settUserProdDetailList.get(i);
							String land_acct_no=userProd.getDigAcctNo();
							String mchnt_id=userProd.getMchntId();
							FrontUserProdAcctExample frontExample =new FrontUserProdAcctExample();
							frontExample.createCriteria().andMchntIdEqualTo(mchnt_id).andLandAcctNoEqualTo(land_acct_no);
							List<Object>  frontUserlist=frontUserProdAcctDao.selectByExample(frontExample);
							if(frontUserlist!=null&&frontUserlist.size()>0){
								FrontUserProdAcct frontUserProdAcct=(FrontUserProdAcct) frontUserlist.get(0);
								log.info("FrontUserProdAcct累加余额前数据为："+frontUserProdAcct.toString());
								BigDecimal TodayTotamtFe = new BigDecimal(0);
								if(frontUserProdAcct.getTotalDepositAmt()!=null){
									TodayTotamtFe =frontUserProdAcct.getTotalDepositAmt();
								}
								BigDecimal TodaySy= new BigDecimal(0);
								if(userProd.getTodayTotamtSy()!=null){
									TodaySy=userProd.getTodayTotamtSy();
								}
								frontUserProdAcct.setTotalDepositAmt(TodayTotamtFe.add(TodaySy));
								Date date = new Date();
								Timestamp timeStamp = new Timestamp(date.getTime());
								frontUserProdAcct.setUpdTime(timeStamp);
								log.info("FrontUserProdAcct累加余额后数据为："+frontUserProdAcct.toString());
								frontUserProdAcctList.add(frontUserProdAcct);
							}
							
						}
					}
					if(frontUserProdAcctList.size()>0){
						for (int j = 0; j < frontUserProdAcctList.size(); j++) {
							FrontUserProdAcct prodAcct = (FrontUserProdAcct) frontUserProdAcctList.get(j);
							FrontUserProdAcctExample example = new FrontUserProdAcctExample();
							example.createCriteria().andIdEqualTo(prodAcct.getId()).andUserIdEqualTo(prodAcct.getUserId());
							frontUserProdAcctDao.updateByExampleSelective(prodAcct, example);
						}
						
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new SettleException(e);
				}
		}
	
		/**
		 * 分账处理  插入数据用于计算当日总份额
		 */
		public void initUserProdDetail(String settleDate ) {
			
			List<Object> settUserProdDetailListTemp= new ArrayList();
			try {
				String Sql101=" select count(*) SG_COUNT, SND_MCH_ID,ACT_NO ,MSCS101.PRODUCT_ID ,MSCS101.OUT_PRODUCT_ID,MSCS101.OUT_PRODUCT_SUBID ,MSCS101.STTL_DATE ,sum(INV_AMT) AMT_SG "
						+ " from T_LAND_MSCS101 MSCS101,T_LAND_PROD_INFO PROD WHERE  PROD.PRODUCT_TYPE='"+Constants.OFAG+"' AND PROD.PROD_ID=MSCS101.PRODUCT_ID "
						+ "AND MSCS101.STTL_DATE='"+settleDate+"' and RESULT_CODE='0000'  group by SND_MCH_ID,ACT_NO";
				
				String Sql102=" select count(*) SH_COUNT, SND_MCH_ID,ACT_NO ,MSCS103.PRODUCT_ID ,MSCS103.OUT_PRODUCT_ID ,MSCS103.OUT_PRODUCT_SUBID ,MSCS103.STTL_DATE ,sum(INV_AMT) AMT_SH "
						+ " from T_LAND_MSCS103 MSCS103 ,T_LAND_PROD_INFO PROD WHERE  PROD.PRODUCT_TYPE='"+Constants.OFAG+"' AND PROD.PROD_ID=MSCS103.PRODUCT_ID " 
						+"AND MSCS103.STTL_DATE='"+settleDate+"' and RESULT_CODE='0000'  group by SND_MCH_ID,ACT_NO";
				//统计申购笔数
				List<HashMap> LandMscs101list = SerializerUtil.deserializeArray(
						LandMscs101Dao.doBySQL(Sql101), HashMap.class);
				Map<String, Object> LandMscs101Map = new HashMap<String, Object>();
				if(null!=LandMscs101list&&LandMscs101list.size()>0){
					for (int i = 0; i < LandMscs101list.size(); i++) { 
						Map landMap=LandMscs101list.get(i);
						String key=landMap.get("SND_MCH_ID")+","+landMap.get("ACT_NO");
						LandMscs101Map.put(key, landMap);
					}
				}
				//统计赎回笔数
				List<HashMap> LandMscs103list = SerializerUtil.deserializeArray(
						LandMscs103Dao.doBySQL(Sql102), HashMap.class);
				Map<String, Object> LandMscs103Map = new HashMap<String, Object>();
				if(null!=LandMscs103list&&LandMscs103list.size()>0){
					for (int i = 0; i < LandMscs103list.size(); i++) {
						Map landMap=LandMscs103list.get(i);
						String key=landMap.get("SND_MCH_ID")+","+landMap.get("ACT_NO");
						LandMscs103Map.put(key, landMap);
					}
				}
				FrontUserProdAcctExample example=new FrontUserProdAcctExample();
				example.createCriteria().andStatusEqualTo("0000");
				example.setGroupByClause(" MCHNT_ID,LAND_ACCT_NO");
				
				String sql="select ACCT.* ,PROD.PROD_ID  from T_FRONT_USER_PROD_ACCT ACCT,T_LAND_DX_ID_DESC DXID, T_LAND_PROD_INFO PROD where "
				+" PROD.PRODUCT_TYPE='"+Constants.OFAG+"' AND  PROD.PROD_ID=DXID.PROD_ID "
				+" AND substring_index(ACCT.LAND_ACCT_NO,'-',1) =DXID.ID";
				
				//插入每个电子账户信息
				List<HashMap> userList = SerializerUtil.deserializeArray(
						frontUserProdAcctDao.doBySQL(sql), HashMap.class);
				if(null!=userList&&userList.size()>0){
					Map<String, Object>  mchUserIdMap=getMchUserIdMap();
					for (int i = 0; i < userList.size(); i++) {
						SettUserProdDetails userProdDetails = new SettUserProdDetails();
						Map frontUserProdAcct= userList.get(i);
						BigDecimal amtSg=new BigDecimal(0);//申购份额
						BigDecimal amtSh=new BigDecimal(0);//赎回份额
						BigDecimal cntSg=new BigDecimal(0);//申购笔数
						BigDecimal cntSh=new BigDecimal(0);//赎回笔数
						BigDecimal dayfe=new BigDecimal(0);//扎差
						String mchntId=frontUserProdAcct.get("MCHNT_ID").toString();
						String userId=frontUserProdAcct.get("USER_ID").toString();
						String prodId=frontUserProdAcct.get("PROD_ID").toString();
						userProdDetails.setProdId(prodId);//产品号
						LandProdInfoExample landexample =new LandProdInfoExample();
						landexample.createCriteria().andProdIdEqualTo(prodId);
						List<Object> prodlist=LandProdInfoDao.selectByExample(landexample);
						if(prodlist!=null&&prodlist.size()>0){
							LandProdInfo prodInf=(LandProdInfo) prodlist.get(0);
							userProdDetails.setOutProdId(prodInf.getOutProdId());
							userProdDetails.setOutSubProdId(prodInf.getOutSubProdId());
						}else{
							userProdDetails.setOutProdId(" ");
							userProdDetails.setOutSubProdId(" ");
						}
						String landAcctNo=frontUserProdAcct.get("LAND_ACCT_NO").toString();
						userProdDetails.setId(UUIDGenerator.generate());
						userProdDetails.setMchntId(mchntId);
						userProdDetails.setSettleDate(settleDate);
						userProdDetails.setRecordDate(settleDate);//记录日期
						userProdDetails.setDigAcctNo(landAcctNo); //电子账号
						
						userProdDetails.setStatus(Constants.DIVIDE_STATUS0);
						String key=mchntId+","+landAcctNo;
						if(mchUserIdMap.get(key)!=null){
							Map userMap =(Map) mchUserIdMap.get(key);
							userProdDetails.setUserId(userMap.get("USER_ID").toString());
						}else{
							userProdDetails.setUserId(" ");
						}
						//净值日净申购份额
						if(LandMscs101Map.get(mchntId+","+landAcctNo)!=null){
							Map map101=(Map) LandMscs101Map.get(mchntId+","+landAcctNo);
							amtSg=new BigDecimal(map101.get("AMT_SG").toString());
							cntSg=new BigDecimal(map101.get("SG_COUNT").toString());
						}
						userProdDetails.setTodayTotamtSg(amtSg);
						userProdDetails.setTodayTotcntSg(cntSg);
						//净值日净赎回份额
						if(LandMscs103Map.get(mchntId+","+landAcctNo)!=null){
							Map map102=(Map) LandMscs103Map.get(mchntId+","+landAcctNo);
							amtSh=new BigDecimal(map102.get("AMT_SH").toString());
							cntSh=new BigDecimal(map102.get("SH_COUNT").toString());
						}
						userProdDetails.setTodayTotamtSh(amtSh);
						userProdDetails.setTodayTotcntSh(cntSh);
						//扎差
						dayfe=amtSg.subtract(amtSh);
						userProdDetails.setDayfe(dayfe);
						//抹除起息金额
						userProdDetails.setSubstractValueFe(new BigDecimal(0));
						//根据扎差 计算 已起息金额 、未起息金额、抹除起息金额 、
						log.info("获取分账初始化信息:"+userProdDetails.toString());
						userProdDetails=updateUserProdDetails(userProdDetails);
						settUserProdDetailListTemp.add(userProdDetails);
						
					}
				}
				if(settUserProdDetailListTemp.size()>0){
					log.info("分账处理完成信息："+settUserProdDetailListTemp);
					userProdDetailsDao.batchInsert(settUserProdDetailListTemp);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new SettleException(e);
			}
		}
		
		//根据扎差 计算 已起息金额 、未起息金额、抹除起息金额 、
		public SettUserProdDetails updateUserProdDetails(SettUserProdDetails userProdDetails){
			
			try {
				BigDecimal dayfe=userProdDetails.getDayfe();//扎差
				String prodId=userProdDetails.getProdId();
				LandProdInfo prodInf=cacheHelper.getLandProdInf(prodId);
				String product_type=prodInf.getProductType();
				String mchntId=userProdDetails.getMchntId();
				log.info("分账处理计算扎差及各金额:"+userProdDetails.toString());
				//起息日        扎差>0  起息日顺延到下一工作日，扎差<0 起息日=当前日期
				int dayFeDiff=dayfe.compareTo(new BigDecimal("0"));
				String currDate=userProdDetails.getRecordDate();
				if(dayFeDiff>0){
					List<Object> list = null;
					Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					SettTradeDateExample example = new SettTradeDateExample();
					String yearInfo=String.valueOf(year);
					example.createCriteria().andProductTypeEqualTo(product_type).andYearInfoEqualTo(yearInfo);
					list = settTradeDateDao.selectByExample(example);
					if(list!=null&&list.size()>0){
						SettTradeDate settTradeDate=(SettTradeDate) list.get(0);
						String allFestival = settTradeDate.getAllFestival();
						String valueDate=TradeDateUtil.getDateStr(userProdDetails.getRecordDate(), allFestival);
						userProdDetails.setValueDate(valueDate);
					}
				}else{
					userProdDetails.setValueDate(userProdDetails.getRecordDate());
				}
				//未起息金额   当扎差>0 ，未起息金额=扎差；当扎差<=0，未起息金额=0
				if(dayFeDiff>0){
					userProdDetails.setNoValueFe(dayfe);
				}else{
					userProdDetails.setNoValueFe(new BigDecimal(0));
				}
				//如果扎差金额为-X  计算抹除起息金额
				String digAcctNo=userProdDetails.getDigAcctNo();
				 List<Object> detailUpdList =new ArrayList();
				if(dayFeDiff<0){
					String sqlDate="select * from  T_SETT_USER_PROD_DETAILS where MCHNT_ID='"+mchntId
							+"' and DIG_ACCT_NO='"+digAcctNo+"' and VALUE_DATE>='"+currDate
							+"' and RECORD_DATE !='"+currDate+"' order by VALUE_DATE DESC";
					List<HashMap> userProdDetailList = SerializerUtil.deserializeArray(
							userProdDetailsDao.doBySQL(sqlDate), HashMap.class);
					
					if(userProdDetailList!=null&&userProdDetailList.size()>0){
							for (int i = 0; i < userProdDetailList.size(); i++) {
								Map detailsMap=userProdDetailList.get(i);
								BigDecimal noValueFe=StringUtil.StringToBigDecimal(detailsMap.get("NO_VALUE_FE").toString());
								BigDecimal stractValueFe=StringUtil.StringToBigDecimal(detailsMap.get("SUBSTRACT_VALUE_FE").toString());
								//未起息金额-抹除起息金额+（扎差 负值）
								BigDecimal diffVal=noValueFe.subtract(stractValueFe).add(dayfe);
								SettUserProdDetails detailUpd=new SettUserProdDetails();
								detailUpd.setId(detailsMap.get("ID").toString());
								if(diffVal.compareTo(new BigDecimal(0))>0){
									//抹除起息金额=抹除起息金额-扎差（扎差为负值）
									detailUpd.setSubstractValueFe(stractValueFe.subtract(dayfe));
									detailUpdList.add(detailUpd); 
									dayfe=new BigDecimal(0);
									continue;
								}else{
									//抹除起息金额=未起息金额
									detailUpd.setSubstractValueFe(noValueFe);
									detailUpdList.add(detailUpd); 
									dayfe=diffVal;
								}
							}
							if(detailUpdList.size()>0){
								userProdDetailsDao.batchUpdate(detailUpdList);
							}
					}
				}
				
				//计算已起息金额
				BigDecimal todayFe=getTodayFe(userProdDetails,dayfe);
				userProdDetails.setTodayFe(todayFe);
				log.info("处理分账获取已起息金额完成"+userProdDetails.toString());
				return userProdDetails;
			} catch (Exception e) {
				e.printStackTrace();
				throw new SettleException(e);
			}
		}
		
		/**
		 * 
		* @Title: getTodayFe 
		* @Description: 计算当前电子账号 已起息金额
		* @param @param userProdDetails
		* @param @return    
		* @return BigDecimal
		 */
		public BigDecimal getTodayFe(SettUserProdDetails userProdDetails,BigDecimal dayFeLeft){
			
				BigDecimal todayFe=new BigDecimal(0);//本次份额
				BigDecimal lastFe=new BigDecimal(0);//上一日份额
				BigDecimal dayFeSum=new BigDecimal(0);//当期日期为起息日的(未起息金额-起息金额抹除)之和
				
			try {
				/**
				 * 根据当前日期得到上一日的份数A
				 */
				String lastDay=StringUtil.getLastDay(userProdDetails.getRecordDate());
				String mchntId=userProdDetails.getMchntId();
				String digAcctNo=userProdDetails.getDigAcctNo();
				log.info("getTodayFe：%%%%%%% userProdDetails="+userProdDetails.toString()+"%%%%%%% dayFeLeft="+dayFeLeft);
				String sql="select * from  T_SETT_USER_PROD_DETAILS where MCHNT_ID='"+mchntId
						+"' and DIG_ACCT_NO ='"+digAcctNo+"' and RECORD_DATE='"+lastDay+"'";
				List<HashMap> feList = SerializerUtil.deserializeArray(
						userProdDetailsDao.doBySQL(sql), HashMap.class);
				if(null!=feList&&feList.size()>0){
						Map prodDetails=feList.get(0);
						lastFe=StringUtil.StringToBigDecimal(prodDetails.get("TODAY_FE").toString());
				}else{
					return lastFe;//如果上一日数据为空 为第一笔 当日份额为0
				}
				
				/**
				 * 以当前日期为起息日 sum(未起息金额-起息金额抹除) B
				 */
				String currDate=userProdDetails.getRecordDate();
				String sqlDate="select * from  T_SETT_USER_PROD_DETAILS where MCHNT_ID='"+mchntId
						+"' and DIG_ACCT_NO='"+digAcctNo+"' and VALUE_DATE='"+currDate
						+"' and RECORD_DATE !='"+currDate+"'";
				List<HashMap> dayFeList = SerializerUtil.deserializeArray(
						userProdDetailsDao.doBySQL(sqlDate), HashMap.class);
				if(null!=dayFeList&&dayFeList.size()>0){
					for (int j = 0; j < dayFeList.size(); j++) {
						Map prodDetails=dayFeList.get(0);
						BigDecimal noValueFe=StringUtil.StringToBigDecimal(prodDetails.get("NO_VALUE_FE").toString());
						BigDecimal subStractValueFe=StringUtil.StringToBigDecimal(prodDetails.get("SUBSTRACT_VALUE_FE").toString());
						dayFeSum=dayFeSum.add(noValueFe.subtract(subStractValueFe));
					}
				}
				if(dayFeLeft.compareTo(new BigDecimal(0))<0){
					todayFe=lastFe.add(dayFeSum).add(dayFeLeft);
				}else{
					todayFe=lastFe.add(dayFeSum);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new SettleException(e);
			}
			return todayFe;
		}
			
				
		//根据每个文件获取商户Id 用户Id集合
		public Map<String, Object> getMchUserIdMap(){
			
			Map<String, Object> mchntMap = new HashMap<String, Object>();
			try {
				String sql = "select  *  from T_FRONT_USER_PROD_ACCT where STATUS='0000'";
				List<HashMap> listUserInf = SerializerUtil.deserializeArray(
						frontMchUserInfDao.doBySQL(sql), HashMap.class);
				if(listUserInf!=null&&listUserInf.size()>0){
					for (int j = 0; j < listUserInf.size(); j++) {
						String mchntId=(String) listUserInf.get(j).get("MCHNT_ID");
						String landAcctNo = (String) listUserInf.get(j).get("LAND_ACCT_NO");
						String key = mchntId+","+landAcctNo;
						mchntMap.put(key, listUserInf.get(j));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new SettleException(e);
			}
			return mchntMap;
		}
	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Profits_Get_RYB;
	}


}
