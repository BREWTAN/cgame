package starstart.cgame.flows.nsttl.ryb;

import java.io.File;
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
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
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
* @ClassName: NS_0201_Withdraw_Get_RYB 
* @Description: 从产品方（如意宝）获取赎回文件
* @date 2015年4月14日 下午5:41:16 
*
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_0201_Withdraw_Get_RYB extends NSettle_BaseActor<CalcMutex>{

	
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;
	@Override
	public void processMessage(CalcMutex pack) {
		
		ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
		String settleDate = paramsUtil.getSettDate(pack);
		String rybDownLoadPath = cacheHelper.getTradeParamByKey("rybDownLoadPath");
		
		try {
			String sql=CommonSql.getProMchIdSql(Constants.OFAG,pack.getDatas().get(TaskDataDefs.PROD_MchID));
			List<HashMap> channellist = SerializerUtil.deserializeArray(
					landChannelInfDao.doBySQL(sql), HashMap.class);
			//根据产品方（如意宝）提供的商户号获取赎回文件
				if(null!=channellist&&channellist.size()>0){
					for (int i = 0; i < channellist.size(); i++) {
						Map channelMap=channellist.get(i);
						String filePath=ParamsDatasUtil.getDownLoadPath(rybDownLoadPath, settleDate, "LT06");
						String prodMchId=(String) channelMap.get("PROD_MCH_ID");
						String url =(String) channelMap.get("CHANNEL_URL");
						String cerPath=(String) channelMap.get("CHANNEL_PUB_KEY");
						String pfxPath=(String) channelMap.get("CHANNEL_PRI_KEY");
						String pfxPwd=(String) channelMap.get("CHANNEL_KEY");
						String fileName = prodMchId + "LT06_" + settleDate.replace("-", "");
						File file = new File(filePath);
						if (!file.exists()) {
							file.mkdirs();
						}
						filePath = filePath + File.separator + fileName;
						log.info("获取赎回文件存储到本地路径为： " + filePath);
						StringBuilder builder = new StringBuilder();
						String messageId = StringUtil.getCurrDate("yyMMddHHmmss") + prodMchId + StringUtil.getRandom(3);
						builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Root><Version>1.0.0</Version>");
						builder.append("<InstId>").append(prodMchId).append("</InstId>");
						builder.append("<MessageId>").append(messageId).append("</MessageId>");
						builder.append("<CertId>DLDReq</CertId><FileType>LT06</FileType>");
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
						log.info(paramMap.toString());
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
								log.error("获取赎回文件失败："+builder.toString());
								throw new SettleException("获取赎回文件失败："+builder.toString());//如果尝试count次后仍失败  则异常
							}
							
						}
					}
				}
			}catch (Exception e) {
				throw new SettleException(e);
			}
	}

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Withdraw_Get_RYB;
	}


}
