package starstart.cgame.flows.nsttl.ryb;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.BlendAccountCheckingFiles;
import starstart.cgame.flows.land.util.CommonSql;
import starstart.cgame.flows.land.util.Constants;
import starstart.cgame.flows.land.util.ParamsDatasUtil;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs101;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs101Example;
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
* @ClassName: NS_0102_Deposit_Check_RYB 
* @Description: 生成本地申购文件并对账
* @date 2015年4月14日 下午5:40:32 
*
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_0102_Deposit_Check_RYB extends NSettle_BaseActor<CalcMutex>{

	
	
	@StoreDAO(domain = LandMscs101.class)
	protected OJpaDAO<LandMscs101> land101Dao;
	
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;
	
	@Override
	public void processMessage(CalcMutex pack) {
		
			log.info("STTL:进行申购记录的匹配:"+pack);
			FileOutputStream out=null;
			try {
				ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
				String settleDate = paramsUtil.getSettDate(pack);
				String status=Constants.STATUS_00;
				String dayOfEndFilePath=cacheHelper.getTradeParamByKey("dayOfEndFilePath");
				String rybDownLoadPath=cacheHelper.getTradeParamByKey("rybDownLoadPath");
				String filePath=ParamsDatasUtil.getDownLoadPath(dayOfEndFilePath, settleDate, "LT04");
				String shellPath=cacheHelper.getTradeParamByKey("shellPath");
				
				File file=new File(filePath);
				if(!file.exists()){
					file.mkdirs();
				}
				log.debug("进行记录的匹配:"+pack);
				String sql=CommonSql.getProMchIdSql(Constants.OFAG,pack.getDatas().get(TaskDataDefs.PROD_MchID));
				List<HashMap> channellist = SerializerUtil.deserializeArray(
						landChannelInfDao.doBySQL(sql), HashMap.class);
				//根据产品方提供的商户号生成本地申购文件  对账生成差错文件
				if(null!=channellist&&channellist.size()>0){
					for (int i = 0; i < channellist.size(); i++) {
						Map channelMap=channellist.get(i);
						String prodMchId=(String) channelMap.get("PROD_MCH_ID");
						LandMscs101Example example=new LandMscs101Example();
						example.createCriteria().andRcvChnIdEqualTo(prodMchId).andSttlDateEqualTo(settleDate)
						.andResultCodeEqualTo(status);
						log.info("查询条件："+prodMchId+settleDate+status);
						List<Object> list=land101Dao.selectByExample(example);
						StringBuffer purchaseStr = new StringBuffer();
						//日终本地数据库申购流水文件生成文件
						String purchaseFilePath=filePath+prodMchId+"100.txt";
						File filepath =new File(purchaseFilePath);
						if(filepath.exists()){
							filepath.delete();
						}
						log.info("本地数据库申购流水文件:"+purchaseFilePath);
						out=new FileOutputStream(filepath); 
						out.write( "清算日期|金额|状态|订单号".getBytes("UTF-8"));
						out.write( "\n".getBytes());
						//查询出本地数据写入文件中
						if(null!=list&&list.size()>0){
							for (int j = 0; j <list.size(); j++) {
								purchaseStr.delete(0, purchaseStr.toString().length());//清空字符串
								LandMscs101 land101=(LandMscs101) list.get(j);
								purchaseStr.append(land101.getSttlDate()+"|");
								BigDecimal transAmt = StringUtil.StringToBigDecimal(land101.getInvAmt().toString());
								purchaseStr.append(transAmt.multiply(new BigDecimal("100")).intValue()+"|");
								purchaseStr.append("00|");
								purchaseStr.append(land101.getProdOrderId());
								out.write(purchaseStr.toString().getBytes());
								out.write( "\n".getBytes());
							}
							
						}
						Map<String,Object> paramMap=new HashMap<String,Object>();
						String purdownFilePath=ParamsDatasUtil.getDownLoadPath(rybDownLoadPath, settleDate,"LT04")+File.separator+prodMchId+"LT04_"+settleDate.replace("-", "")+".txt";//获取的申购文件路径
						String diffPurchaseFile=ParamsDatasUtil.getDownLoadPath(dayOfEndFilePath, settleDate,"LT04")+File.separator+prodMchId+"result100.txt";//对账结果文件路径
						String purshell=shellPath+" "+purdownFilePath+" "+ purchaseFilePath+" "+diffPurchaseFile;
						paramMap.put("shell", purshell);
						log.info("勾兑Map:"+paramMap);
						//根据diff脚本对比文件 生成差错文件  diffPurchaseFile
						BlendAccountCheckingFiles.execute(paramMap);
					}
				}
			} catch (Exception e) {
				throw new SettleException("",e);
			}finally{
				try {
					if(null!=out){
						out.close();
					}
				} catch (Exception e) {
					throw new SettleException(e);
				}
			}
	}
	
	

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Deposit_Check_RYB;
	}


}
