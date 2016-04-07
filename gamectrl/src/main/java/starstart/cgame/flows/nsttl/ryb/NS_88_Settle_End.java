package starstart.cgame.flows.nsttl.ryb;

import java.util.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleStatus;
import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.StringUtil;
import starstart.cgame.flows.mysqlgens.sett.entity.SettTaskRun;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import starstart.cgame.flows.nsttl.flows.TaskDataDefs;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
/**
 * 
 * 流程结束 插入下一日任务初始化数据 STTL_00_OFAG
 *
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class NS_88_Settle_End extends NSettle_BaseActor<CalcMutex>{

	@Override
	public void processMessage(CalcMutex pack) {
		try {
			log.info("STTL:流程结束:"+pack);
			String settleDate = pack.getDatas().get(TaskDataDefs.DT_SettleDT);//StringUtil.getCurrDate();
			String nextDay=StringUtil.getNextDay(settleDate.substring(0, 10));
			SettTaskRun task = new SettTaskRun();
			task.setTaskId(pack.getDatas().get(TaskDataDefs.PROD_MchID)+"|"+nextDay+"|STTL_00_RYB");
			task.setCrtTime(new Date());
			task.setStatus(SettleStatus.Start.getCode());
			task.setTaskType("STTL_00_RYB");
			task.setSettleDt(nextDay+settleDate.substring(10, settleDate.length()));
			sttlTaskRunDao.insert(task);
			log.info("插入新任务"+task.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException(e);
		}

	
	}

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.End_RYB;
	}


}
