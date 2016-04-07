package starstart.cgame.flows.nsttl.ryb;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
/**
 * 
 * 流程开始
 *
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_00_Settle_Ban_Start extends NSettle_BaseActor<CalcMutex> {

	@Override
	public void processMessage(CalcMutex pack) {
		log.info("STTL:RYB流程开始:" + pack);
		
	}

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.Start_Banlance;
	}

}
