package starstart.cgame.flows.utils;

import java.util.List;

import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.mysqlgens.trade.entity.LandDxIdDesc;
import starstart.cgame.flows.mysqlgens.trade.entity.LandProdInfo;
import starstart.cgame.flows.mysqlgens.trade.entity.MchInf;
import starstart.cgame.flows.mysqlgens.trade.entity.MchProdInf;
import starstart.cgame.flows.mysqlgens.trade.entity.TradeParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import cn.msec.bao.outils.serialize.SerializerUtil;
import cn.msec.ojpa.api.CacheKey;
import cn.msec.ojpa.api.OJpaDAO;

@Data
@AllArgsConstructor
public class CacheHelper {
	protected OJpaDAO cache;

	public MchInf getMerchantInf(String merchantId) {
		return (MchInf) SerializerUtil.deserialize(cache.selectByPrimaryKey(new CacheKey("tmchinf", merchantId)), MchInf.class);
	}

	public String getTradeParamByKey(String key) {
		TradeParam TradeParamo = SerializerUtil.deserialize(cache.selectByPrimaryKey(new CacheKey("ttradeparam", key)), TradeParam.class);
		if (TradeParamo != null) {
			return TradeParamo.getParamValue();
		}
		return null;
	}

	public LandProdInfo getLandProdInf(String prodid) {
		return (LandProdInfo) SerializerUtil.deserialize(cache.selectByPrimaryKey(new CacheKey("tlandprodinfo", prodid)), LandProdInfo.class);
	}

	public LandChannelInf getLandChannelInf(String channelDxId) {
		LandDxIdDesc dx = SerializerUtil.deserialize(cache.selectByPrimaryKey(new CacheKey("tlanddxiddesc", channelDxId)), LandDxIdDesc.class);
		if (dx != null) {
			return (LandChannelInf) SerializerUtil.deserialize(cache.selectByPrimaryKey(new CacheKey("tlandchannelinf", dx.getChannelId())),
					LandChannelInf.class);
		}
		return null;
	}
	public LandChannelInf getTLandChannelInf(String prodMchId) {
		
		List<LandChannelInf> rets= SerializerUtil.deserializeArray(cache.selectByExample(new CacheKey("tlandchannelinf", "prodMchId", prodMchId)),LandChannelInf.class);
		if (rets != null&&rets.size()>0) {
			return (LandChannelInf) rets.get(0);
		}
		return null;
	}
	
	public List<MchProdInf> getMchProdInf(String prodid, String merchantId) {
		List<Object> rets = cache.selectByExample(new CacheKey("tmchprodinf", "mchntId,prodId", merchantId + "," + prodid));
		return (List<MchProdInf>) SerializerUtil.deserializeArray(rets, MchProdInf.class);
	}

}
