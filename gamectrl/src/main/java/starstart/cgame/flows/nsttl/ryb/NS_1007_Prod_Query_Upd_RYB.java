package starstart.cgame.flows.nsttl.ryb;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.Constants;
import starstart.cgame.flows.land.util.HttpClient431Util;
import starstart.cgame.flows.land.util.IDHelper;
import starstart.cgame.flows.land.util.RybSign;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInfExample;
import starstart.cgame.flows.mysqlgens.trade.entity.LandProdAltInfo;
import starstart.cgame.flows.mysqlgens.trade.entity.LandProdInfo;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleSleep;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import starstart.cgame.flows.nsttl.flows.TaskDataDefs;
import starstart.cgame.flows.utils.XMLHelper;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.ojpa.api.annotations.StoreDAO;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
/* *
 * 产品信息变更流水新增记录  LandProdAltInfo
 * 更新产品信息   LandProdInfo
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_1007_Prod_Query_Upd_RYB extends NSettle_BaseActor<CalcMutex>{
	

	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;
	@StoreDAO(domain = LandProdAltInfo.class)
	protected OJpaDAO<LandProdAltInfo> landProdAltInfoDao;
	@StoreDAO(domain = LandProdInfo.class)
	protected OJpaDAO<LandProdInfo> landProdInfoDao;
	
	
	public void processMessage(CalcMutex pack) {
		
			
			String PROD_KEY=Constants.PROD_KEY;
			String [] prodKey=PROD_KEY.split("\\|");
			if(prodKey!=null&&prodKey.length>0){
				for (int i = 0; i < prodKey.length; i++) {
					String PROD_ID=prodKey[i];
					LandProdInfo prodInf = cacheHelper.getLandProdInf(PROD_ID);
					if(null!=prodInf){
						String OUT_PROD_ID=prodInf.getOutProdId();
						String OUT_SUB_PROD_ID=prodInf.getOutSubProdId();
						//获取产品对应的渠道编码
						String prodMch=pack.getDatas().get(TaskDataDefs.PROD_MchID);
						LandChannelInf channel=cacheHelper.getTLandChannelInf(prodMch);
						String PROD_MCH_ID=channel.getProdMchId();
						String ENT_TYPE=channel.getEntType();
						String CHANNEL_KEY=channel.getChannelKey();
						String CHANNEL_PRI_KEY=channel.getChannelPriKey();
						String CHANNEL_PUB_KEY=channel.getChannelPubKey();
						String CHANNEL_URL=channel.getChannelUrl();
						String toXml=toXml(PROD_MCH_ID,OUT_PROD_ID,OUT_SUB_PROD_ID);
						log.debug("查询产品最新信息，组织报文："+toXml);
						
						String plain="";
						try{
						    if("1".equals(ENT_TYPE)){
						    	//签名
								RybSign sign=new RybSign();
								String reqObj = sign.sign(toXml, CHANNEL_KEY, CHANNEL_PRI_KEY, CHANNEL_PUB_KEY);
								// 发送请求并获取执行结果
								byte[] resString = HttpClient431Util.doPostContent(reqObj,"application/xml","utf-8", "utf-8" ,CHANNEL_URL);
								plain = sign.verify(new String(resString,"utf-8"), CHANNEL_KEY, CHANNEL_PRI_KEY, CHANNEL_PUB_KEY);
						    }else{	    	
								// 发送请求并获取执行结果
								byte[] resString = HttpClient431Util.doPostContent(toXml,"application/xml","utf-8", "utf-8" ,CHANNEL_URL);
								plain = new String(resString,"utf-8");
						    }	
						}catch(Exception e){
							log.debug("返回报文解析出错"+e);
						}
					    log.debug("请求产品信息返回报文："+plain);
					   	if(!StringUtils.isBlank(plain)){
					   		Map<String, String> mm=XMLHelper.buildMsg(plain);
					   		log.debug("请求产品信息返回报文解析xml后MAP值为："+mm.toString());
					   		if("AAAAAAA".equals(mm.get("ReturnCode"))){
					   			LandProdAltInfo prodAltInf=new LandProdAltInfo();
					   			prodAltInf.setId(IDHelper.toRYBMessageId(PROD_ID));
					   			prodAltInf.setProdId(PROD_ID);
					   			prodAltInf.setMchntId(prodInf.getMchntId());
					   			prodAltInf.setOutProdId(prodInf.getOutProdId());
					   			prodAltInf.setOutSubProdId(prodInf.getOutSubProdId());
					   			prodAltInf.setNavDate(mm.get("NavDate"));// 净值日期
					   			prodAltInf.setDaysErn(new BigDecimal(mm.get("DayAmount")));// 日每万份净值收益
					   			prodAltInf.setAnnualizedRate(new BigDecimal(mm.get("DyAmount")));// 七日年化收益
					   			prodAltInf.setProductName("");
					   			prodAltInf.setProductType("");
					   			prodAltInf.setProductStatus("");
					   			prodAltInf.setProductTags("");
					   			prodAltInf.setProductTitle("");
					   			Date date = new Date();
								Timestamp timeStamp = new Timestamp(date.getTime());
								prodAltInf.setUpdTime(timeStamp);
								landProdAltInfoDao.insert(prodAltInf);
								
								prodInf.setNavDate(mm.get("NavDate"));// 净值日期
								prodInf.setDaysErn(new BigDecimal(mm.get("DayAmount")));// 日每万份净值收益
								prodInf.setAnnualizedRate(new BigDecimal(mm.get("DyAmount")));// 七日年化收益
								landProdInfoDao.updateByPrimaryKeySelective(prodInf);
					   		}
					   	}else{
					   		throw new SettleSleep(300000);
					   	}
					}
					
				}
			}
	}
	private String toXml(String innermchntid,String outprodId,String outSubProdId){
		StringBuilder sb=new StringBuilder();		
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<Root>");
		sb.append("<Version>1.0.0</Version>");  //版本号  
		sb.append("<ProdType>01</ProdType>");
		sb.append("<ProdId>"+outprodId+"</ProdId>");
		sb.append("<ProdSubId>"+outSubProdId+"</ProdSubId>");
		sb.append("<InstId>"+innermchntid+"</InstId>");  //机构标识      
		String MessageId = IDHelper.toRYBMessageId(innermchntid);// 流水号
		sb.append("<MessageId>"+MessageId+"</MessageId>");  ;//协议流水号    
		sb.append("<CertId>ADSReq</CertId>");  ;//交易类型标识   
		sb.append("</Root>");		
		return sb.toString();
		
	}
	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Prod_Query_Upd_R;
	}
}
