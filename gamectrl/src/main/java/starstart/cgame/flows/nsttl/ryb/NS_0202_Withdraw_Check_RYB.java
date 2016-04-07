package starstart.cgame.flows.nsttl.ryb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs103;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs103Example;
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
* @ClassName: NS_0202_Withdraw_Check_RYB 
* @Description: 生成本地赎回文件并对账
* @date 2015年4月14日 下午5:41:38 
*
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_0202_Withdraw_Check_RYB extends NSettle_BaseActor<CalcMutex>{

	@StoreDAO(domain = LandMscs103.class)
	protected OJpaDAO<LandMscs103> land103Dao;
	
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;
	@Override
	public void processMessage(CalcMutex pack) {
		    log.info("STTL:进行赎回记录的匹配:"+pack);
			FileOutputStream out=null;
			ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
			String settleDate = paramsUtil.getSettDate(pack);

			String status=Constants.STATUS_00;
			String dayOfEndFilePath=cacheHelper.getTradeParamByKey("dayOfEndFilePath");
			String rybDownLoadPath=cacheHelper.getTradeParamByKey("rybDownLoadPath");
			String filePath=ParamsDatasUtil.getDownLoadPath(rybDownLoadPath, settleDate, "LT06");
			String shellPath=cacheHelper.getTradeParamByKey("shellPath");
			//创建文件目录
			File file=new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			try {
				
				String sql=CommonSql.getProMchIdSql(Constants.OFAG,pack.getDatas().get(TaskDataDefs.PROD_MchID));
				List<HashMap> channellist = SerializerUtil.deserializeArray(
						landChannelInfDao.doBySQL(sql), HashMap.class);
				//根据产品方提供的商户号生成本地赎回文件  对账生成差错文件
				if(null!=channellist&&channellist.size()>0){
					for (int i = 0; i < channellist.size(); i++) {
						Map channelMap=channellist.get(i);
						String prodMchId=(String) channelMap.get("PROD_MCH_ID");
						LandMscs103Example example=new LandMscs103Example();
						example.createCriteria().andRcvChnIdEqualTo(prodMchId).andSttlDateEqualTo(settleDate)
						.andResultCodeEqualTo(status);
						List<Object> list=land103Dao.selectByExample(example);
						StringBuffer redemptionStr = new StringBuffer();
						//日终本地数据库赎回流水文件生成文件
						String withdrawFilePath=filePath+prodMchId+"200.txt";
						File filepath =new File(withdrawFilePath);
						if(filepath.exists()){
							filepath.delete();
						}
						log.info("本地数据库赎回流水文件:"+withdrawFilePath);
						out=new FileOutputStream(filepath); 
						out.write( "清算日期|金额|状态|订单号".getBytes("UTF-8"));
						out.write( "\n".getBytes());
						//查询出本地数据写入文件中
						if(null!=list&&list.size()>0){
							for (int j = 0; j <list.size(); j++) {
								redemptionStr.delete(0, redemptionStr.toString().length());//清空字符串
								LandMscs103 land103=(LandMscs103) list.get(j);
								redemptionStr.append(land103.getSttlDate()+"|");
								BigDecimal transAmt = new BigDecimal(land103.getInvAmt().toString());
								redemptionStr.append(transAmt.multiply(new BigDecimal("100")).intValue()+"|");								
								redemptionStr.append("00|");
								redemptionStr.append(land103.getProdOrderId());
								out.write(redemptionStr.toString().getBytes());
								out.write( "\n".getBytes());
							}
						}
						Map<String,Object> paramMap=new HashMap<String,Object>();
						String purdownFilePath=ParamsDatasUtil.getDownLoadPath(rybDownLoadPath, settleDate, "LT06")+File.separator+prodMchId+"LT06_"+settleDate.replace("-", "")+".txt";//获取的申购文件路径
						String diffwithdrawFile=ParamsDatasUtil.getDownLoadPath(dayOfEndFilePath, settleDate, "LT06")+File.separator+prodMchId+"result200.txt";//对账结果文件路径
						String purshell=shellPath+" "+purdownFilePath+" "+ withdrawFilePath+" "+diffwithdrawFile;
						paramMap.put("shell", purshell);
						//根据diff脚本对比文件 生成差错文件  diffPurchaseFile
						BlendAccountCheckingFiles.execute(paramMap);
					}
				}
			}  catch (Exception e) {
				throw new SettleException(e);
			}finally{
				try {
					if(null!=out){
						out.close();
					}
				} catch (IOException e) {
					throw new SettleException(e);
				}
			}
	}

	

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Withdraw_Check_RYB;
	}


}
