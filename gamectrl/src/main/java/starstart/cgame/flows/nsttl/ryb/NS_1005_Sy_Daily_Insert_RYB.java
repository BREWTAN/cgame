package starstart.cgame.flows.nsttl.ryb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.Constants;
import starstart.cgame.flows.land.util.ParamsDatasUtil;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.mysqlgens.sett.entity.SettSyDaily;
import starstart.cgame.flows.mysqlgens.trade.entity.LandChannelInf;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import cn.msec.bao.outils.serialize.SerializerUtil;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.ojpa.api.annotations.StoreDAO;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
/* *
 * 每天更新T_SETT_SY_DAILY产品损益表
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_1005_Sy_Daily_Insert_RYB extends NSettle_BaseActor<CalcMutex>{
	

	@StoreDAO(domain = SettSyDaily.class)
	protected OJpaDAO<SettSyDaily> syDao;
	@StoreDAO(domain = LandChannelInf.class)
	protected OJpaDAO<LandChannelInf> landChannelInfDao;
	
	public void processMessage(CalcMutex pack) {
		try {
			ParamsDatasUtil paramsUtil=new ParamsDatasUtil(landChannelInfDao);
			String settleDate = paramsUtil.getSettDate(pack);
			//查询商户手续费
			List<Object> dailyList = new ArrayList<Object>();
			StringBuffer hql = new StringBuffer();
			hql.append("select MCHNT_ID,PROD_ID ,sum(MCH_FEE_AMT) MCH_TOT_FEE_AMT from T_SETT_MCHNT_DETAILS "
					+ " WHERE PRODUCT_TYPE='"+Constants.OFAG+"' and SETT_DATE='"+settleDate+"' group by MCHNT_ID,PROD_ID");
			List<HashMap> syList = SerializerUtil.deserializeArray(
					syDao.doBySQL(hql.toString()), HashMap.class);
			for(HashMap obj:syList){
				SettSyDaily daily = new SettSyDaily();
				daily.setId(StringUtil.getUUID());
				daily.setMchntId((String)obj.get("MCHNT_ID"));
				daily.setProdId((String)obj.get("PROD_ID"));
				daily.setSettleDate(settleDate);
				daily.setMchTotFeeAmt((BigDecimal)obj.get("MCH_TOT_FEE_AMT"));
				daily.setStatus("0001");
				dailyList.add(daily);
			}
			if(dailyList!=null&&dailyList.size()>0){
				syDao.batchInsert(dailyList);
			}
			//查询产品手续费
			List<Object> dailyList2 = new ArrayList<Object>();
			StringBuffer hql2 = new StringBuffer();
			hql2.append("select PROD_ID ,sum(PROD_FEE_AMT) PRO_TOT_FEE_AMT from T_SETT_PROD_DETAILS "
					+ "WHERE PRODUCT_TYPE='"+Constants.OFAG+"' and SETT_DATE='"+settleDate+"' group by PROD_ID");
			List<HashMap> syList2 = SerializerUtil.deserializeArray(
					syDao.doBySQL(hql2.toString()), HashMap.class);
			for(HashMap obj:syList2){
				SettSyDaily daily = new SettSyDaily();
				daily.setId(StringUtil.getUUID());
				daily.setProdId((String)obj.get("PROD_ID"));
				daily.setSettleDate(settleDate);
				daily.setProTotFeeAmt((BigDecimal)obj.get("PRO_TOT_FEE_AMT"));
				daily.setStatus("0001");
				dailyList2.add(daily);
			}
			if(dailyList2!=null&&dailyList2.size()>0){
				syDao.batchInsert(dailyList2);
			}
			
		} catch (Exception e) {
			throw new SettleException(e);
		}
	}
	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Sy_Daily_Insert;
	}
}
