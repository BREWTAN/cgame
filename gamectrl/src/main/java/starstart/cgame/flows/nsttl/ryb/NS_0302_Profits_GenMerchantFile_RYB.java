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
import starstart.cgame.flows.land.util.Constants;
import starstart.cgame.flows.land.util.ParamsDatasUtil;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.mysqlgens.sett.entity.SettUserProdDetails;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontDigacctInf;
import starstart.cgame.flows.mysqlgens.trade.entity.FrontUserProdAcct;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.MchInf;
import starstart.cgame.flows.mysqlgens.trade.entity.MchInfExample;
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
 * 
 * @ClassName: NS_0302_Profits_GenMerchantFile_RYB
 * @Description: 生成给商户收益文件
 * @author kyn
 * @date 2015年4月29日 下午4:21:17
 *
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_0302_Profits_GenMerchantFile_RYB extends NSettle_BaseActor<CalcMutex> {

	@StoreDAO(domain = FrontUserProdAcct.class)
	protected OJpaDAO<FrontUserProdAcct> frontUserProdAcctDao;
	@StoreDAO(domain = MchInf.class)
	protected OJpaDAO<MchInf> mchInfDao;
	@StoreDAO(domain = FrontDigacctInf.class)
	protected OJpaDAO<FrontDigacctInf> frontDigacctInfDao;
	@StoreDAO(domain = SettUserProdDetails.class)
	protected OJpaDAO<SettUserProdDetails> userProdDetailsDao;
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;

	@Override
	public void processMessage(CalcMutex pack) {
		log.info("STTL:生成商户收益文件:" + pack);
		FileOutputStream out = null;
		try {
			ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
			String settleDate = paramsUtil.getSettDate(pack);
			MchInfExample mchInfExample=new MchInfExample();
			mchInfExample.createCriteria().andStatusEqualTo("00")
			.andMchntFlagEqualTo("Y");
			List<Object> mchList =mchInfDao.selectByExample(mchInfExample);
			String filePath=cacheHelper.getTradeParamByKey("mntFilePath");
			String mntftpFilePath =ParamsDatasUtil.getDownLoadPath(filePath, settleDate,"S01");
			File file =new File(mntftpFilePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			//循环生成给商户的申购对账文件
			if (null != mchList && mchList.size() > 0) {
				for (int i = 0; i < mchList.size(); i++) {
					MchInf mchInf = (MchInf) mchList.get(i);
					String mchntId = mchInf.getMchntId();
					String sql = "SELECT DETAILS.MCHNT_ID,DIG_ACCT_NO,SUM(YESTD_TOTAMT_SY) YESTD_TOTAMT_SY,SUM(TODAY_TOTAMT_SY) TODAY_TOTAMT_SY,SUM(TODAY_TOTAMT_FE) TODAY_TOTAMT_FE,"
							+ " SUM(TODAY_TOTAMT_SG) TODAY_TOTAMT_SG,sum(TODAY_TOTAMT_SH) TODAY_TOTAMT_SH,DETAILS.PROD_ID  from  T_SETT_USER_PROD_DETAILS DETAILS, T_LAND_PROD_INFO PROD"
							+ " WHERE DETAILS.SETTLE_DATE='"+ settleDate + "'" + " AND DETAILS.MCHNT_ID='" + mchntId+"'"
							+ " AND PROD.PROD_ID=DETAILS.PROD_ID AND PROD.PRODUCT_TYPE='"+Constants.OFAG+"' "
							+ " GROUP BY DETAILS.MCHNT_ID,SUBSTRING_INDEX(DIG_ACCT_NO,'-',-1)";
					List<HashMap> list = SerializerUtil.deserializeArray(userProdDetailsDao.doBySQL(sql), HashMap.class);
					StringBuffer redemptionStr = new StringBuffer();
					String mntWithdrawFile = mntftpFilePath + mchntId +Constants.OFAG+ settleDate.replace("-", "") + "S01.txt";
					File filepath = new File(mntWithdrawFile);
					if (filepath.exists()) {
						filepath.delete();
					}
					out = new FileOutputStream(mntWithdrawFile);
					out.write("账务日期|商户号|渠道号|账号|昨日总收益|账务日收益|总份额|日申购份额|日赎回份额|产品编码|子产品编码|".getBytes());
					out.write("\n".getBytes());
					if (null != list && list.size() > 0) {
						//数据写入指定文件内
						for (int j = 0; j < list.size(); j++) {
							redemptionStr.delete(0, redemptionStr.toString().length());// 清空字符串
							Map map = list.get(j);
							redemptionStr.append(settleDate + "|");// 日期
							redemptionStr.append(map.get("MCHNT_ID").toString() + "|");
							redemptionStr.append("|");
							redemptionStr.append(map.get("DIG_ACCT_NO").toString() + "|");
							redemptionStr.append(StringUtil.StringToBigDecimal(map.get("YESTD_TOTAMT_SY").toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|");// 昨日总收益
							redemptionStr.append(StringUtil.StringToBigDecimal(map.get("TODAY_TOTAMT_SY").toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|");// 账务日期收益
							redemptionStr.append(StringUtil.StringToBigDecimal(map.get("TODAY_TOTAMT_FE").toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|");// 总份额
							redemptionStr.append(StringUtil.StringToBigDecimal(map.get("TODAY_TOTAMT_SG").toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|");// 日申购份额
							redemptionStr.append(StringUtil.StringToBigDecimal(map.get("TODAY_TOTAMT_SH").toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|");// 日赎回份额
							redemptionStr.append(map.get("PROD_ID").toString() + "|");// 产品编码
							redemptionStr.append("|");// 子产品编码
							out.write(redemptionStr.toString().getBytes());
							out.write("\n".getBytes());
						}
						out.close();
					} 
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException(e);
		} finally {
			try {
				if (null != out) {
					out.close();
				}
			} catch (Exception e) {
				throw new SettleException(e);
			}
		}
	}

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Profits_GenMerchantFile;
	}

}
