package starstart.cgame.flows.nsttl.ryb;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.CommonSql;
import starstart.cgame.flows.land.util.Constants;
import starstart.cgame.flows.land.util.ParamsDatasUtil;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandMscs103;
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
 *@ClassName: NS_0104_Deposit_GenMerchantFile_RYB
 * @Description: 生成给商户申购对账文件
 * @date 2015年4月14日 下午5:39:57
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_0204_Withdraw_GenMerchantFile_RYB extends NSettle_BaseActor<CalcMutex> {

	@StoreDAO(domain = LandMscs103.class)
	protected OJpaDAO<LandMscs103> LandMscs103Dao;
	@StoreDAO(domain = MchInf.class)
	protected OJpaDAO<MchInf> MchInfDao;
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;

	@Override
	public void processMessage(CalcMutex pack) {
		log.info("STTL:生成商户赎回文件:" + pack);
		FileOutputStream out = null;
		try {
			ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
			String settleDate = paramsUtil.getSettDate(pack);

			MchInfExample mchInfExample = new MchInfExample();
			mchInfExample.createCriteria().andStatusEqualTo("00")
			.andMchntFlagEqualTo("Y");
			List<Object> mchList = MchInfDao.selectByExample(mchInfExample);
			String filePath = cacheHelper.getTradeParamByKey("mntFilePath");
			String mntftpFilePath = ParamsDatasUtil.getDownLoadPath(filePath, settleDate, "103");
			File file = new File(mntftpFilePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			//循环生成给商户的申购对账文件
			if (null != mchList && mchList.size() > 0) {
				for (int i = 0; i < mchList.size(); i++) {
					MchInf mchInf = (MchInf) mchList.get(i);
					String mchntId = mchInf.getMchntId();
					String sql=CommonSql.getMSCS103FileSql(mchntId,settleDate,Constants.OFAG);
					List<HashMap> landMscsList = SerializerUtil.deserializeArray(LandMscs103Dao.doBySQL(sql), HashMap.class);
					String mntDeppsitFile = mntftpFilePath + mchntId + Constants.OFAG + settleDate.replace("-", "") + "103.txt";
					//数据写入指定文件内
					ParamsDatasUtil.getRYBMntFile(landMscsList, "交易日期|金额|状态|订单号", mntDeppsitFile);
				}
			}

		} catch (Exception e) {
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
		return SettleSteps.Withdraw_GenMerchantFile;
	}

}
