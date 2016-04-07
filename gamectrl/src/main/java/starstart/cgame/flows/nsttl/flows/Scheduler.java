package starstart.cgame.flows.nsttl.flows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleStatus;
import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.land.util.UUIDGenerator;
import starstart.cgame.flows.mysqlgens.sett.entity.SettTaskRun;
import starstart.cgame.flows.mysqlgens.sett.entity.SettTaskRunExample;
import starstart.cgame.flows.mysqlgens.trade.entity.TradeParam;
import starstart.cgame.flows.mysqlgens.trade.entity.TradeParamKey;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleSleep;
import cn.msec.bao.outils.serialize.SerializerUtil;
import cn.msec.ojpa.api.CounterCriteria;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.ojpa.api.annotations.StoreDAO;
import cn.msec.ojpa.api.exception.JPADuplicateIDException;
import cn.msec.orouter.api.IQClient;
import cn.msec.orouter.api.NoneQService;
import cn.msec.osgi.annotation.iPojoBean;

@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class Scheduler extends NSettle_BaseActor<CalcMutex> {

	@StoreDAO(domain = SettTaskRun.class)
	protected OJpaDAO<SettTaskRun> sttlTaskInfDao;

	@StoreDAO(domain = TradeParam.class)
	protected OJpaDAO<TradeParam> tradeParamDao;

	int daoReadyCount = 0;

	public final static String LOCKER_ID = "settle.lock";
	public final static String SLEEP_MS = "settle.sleepms";

	public void renewAllTask() {
		log.debug("更新所有处理中的节点为未处理状态");
		SettTaskRunExample example = new SettTaskRunExample();
		example.createCriteria().andStatusEqualTo("1");
		SettTaskRun str = new SettTaskRun();
		str.setStatus("0");
		sttlTaskInfDao.updateByExampleSelective(str, example);
	}

	@Override
	public void processMessage(CalcMutex pack) {
		log.debug("任务处理");
		
		SimpleDateFormat sf_yyMMddHHmm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		
		/*try {
			
			//查询日终任务异常状态 且未发送过短信及邮件的数据  发送提示短信和邮件
			SettTaskRunExample exampleError = new SettTaskRunExample();
			exampleError.createCriteria().andStatusEqualTo(SettleStatus.Error.getCode()).andSettleDtLessThanOrEqualTo(sf_yyMMddHHmm.format(new Date()))
			.andFieldIsNull();
			List<Object> todoErrorList = sttlTaskInfDao.selectByExample(exampleError);
			if(todoErrorList!=null&&todoErrorList.size()>0){
				SettTaskRun taskRun=(SettTaskRun) todoErrorList.get(0);
				SoapClient client = new SoapClient();
				String content = URLEncoder.encode("日终任务异常：="+taskRun.getTaskId(), "utf8");
				String sn = cacheHelper.getTradeParamByKey("sn");
				String pwd = cacheHelper.getTradeParamByKey("password");
				String serviceURL = cacheHelper.getTradeParamByKey("soapUrl");
				String phone = cacheHelper.getTradeParamByKey("phoneno");
				log.info("日终任务异常发送短信：serviceURL："+serviceURL+",content:"+content);

				String result_mt = client.mdSmsSend_u(phone, content,
						"", "", String.valueOf(new Date().getTime()),sn, client.getMD5(sn+pwd),serviceURL);
				// 输出返回标识，为小于19位的正数，String类型的。记录您发送的批次。发送短信，如果是以负号开头就是发送失败。
				if (StringUtil.isEmpty(result_mt)
						|| result_mt.startsWith("-")) {
					//Math.abs(Integer.valueOf(result_mt))
					log.error("短信发送失败！返回信息为：" + result_mt);
					//eturn ;
				} else {
					log.error("短信发送成功！返回信息为：" + result_mt);

				}
				String mailto = cacheHelper.getTradeParamByKey("EmailAddress");
				String subject = StringUtil.getCurrDate()+"日终任务异常通知";
				String url =cacheHelper.getTradeParamByKey("mailUrl");
				log.info("日终任务异常发送邮件：EmailAddress："+mailto+",mailUrl:"+url);
				String rs = client.sendMail(mailto, subject, content, url);
				if (StringUtil.isEmpty(rs)||rs.contains("false")) {
					log.error("邮件发送失败！返回信息为：" + rs);
					//return ;
				} else {
					log.info("邮件发送成功，返回值为：" + rs);
				}
				//发送提示成功后修改任务标志为已发送过提示信息
				taskRun.setField("0");//0:表示已发送过短信和邮件
				sttlTaskInfDao.updateByPrimaryKeySelective(taskRun);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		SettTaskRunExample example = new SettTaskRunExample();
		example.createCriteria().andStatusEqualTo(SettleStatus.Start.getCode()).andSettleDtLessThanOrEqualTo(sf_yyMMddHHmm.format(new Date()));
		List<Object> todoList = sttlTaskInfDao.selectByExample(example);

		if (todoList != null) {
			log.debug("找到对应的任务:size=" + todoList.size());
			for (Object todo : todoList) {
				SettTaskRun todotask = (SettTaskRun) todo;
				pack = new CalcMutex();
				//产品号prodId+日期settleDate+任务类型TaskType
				if (SettleSteps.Start_RYB.getCode().equals(todotask.getTaskType())
						||SettleSteps.Start_GF.getCode().equals(todotask.getTaskType())
						||SettleSteps.Start_P2P.getCode().equals(todotask.getTaskType())
						||SettleSteps.Start_Banlance.getCode().equals(todotask.getTaskType())
						||SettleSteps.Start_Upd_R.getCode().equals(todotask.getTaskType())
					||SettleSteps.Start_Banlance_FNLN.getCode().equals(todotask.getTaskType())){
					
					pack.getDatas().put(TaskDataDefs.DT_ParentID, todotask.getTaskId());
				} else{
					pack.getDatas().put(TaskDataDefs.DT_ParentID, todotask.getRootRunid());
				}
				pack.getDatas().put(TaskDataDefs.DT_SettleDT, todotask.getSettleDt());
				pack.getDatas().put(TaskDataDefs.PROD_MchID, todotask.getTaskId().split("\\|")[0]);
				pack.setId(todotask.getTaskId());
				SettTaskRun uptask = new SettTaskRun();
				uptask.setTaskId(todotask.getTaskId());
				uptask.setStatus(SettleStatus.Processing.getCode());
				byte bb[] = SerializerUtil.toBytes(SerializerUtil.serialize(pack));
				log.info("从数据库获取/生成新任务：datetime=" + todotask.getSettleDt() + ":type=" + todotask.getTaskType() + ",@id=" + todotask.getTaskId() + ",root="
						+ todotask.getRootRunid());
				sttlTaskInfDao.updateByPrimaryKeySelective(uptask);
				sendMessage(todotask.getTaskType(), bb);
			}
		} else {
			log.debug("任务检查:NoTasks:size=0");

		}
		throw new SettleSleep(getSleepMS());
	}

	public int getSleepMS() {
		String delay = cacheHelper.getTradeParamByKey(SLEEP_MS);
		if (delay == null) {
			return 10 * 1000;
		}
		try {
			return Integer.parseInt(delay);
		} catch (NumberFormatException e) {
			return 10 * 1000;
		}
	}

	public void onQServiceReady() {
		super.onQServiceReady();
		checkServiceOK(null);
	}

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.CTRL;
	}

	/**
	 * 注入cache帮助类！ 注意！千万不要在子类里面覆盖这个函数
	 */
	@Override
	final public void onDaoServiceReady(OJpaDAO dao) {
		super.onDaoServiceReady(dao);
		checkServiceOK(dao);
	}

	public void checkServiceOK(OJpaDAO dao) {
		if (sttlTaskInfDao != null && tradeParamDao != null && (!(getQService() instanceof NoneQService))) {
			TradeParam sys = tradeParamDao.selectByPrimaryKey(new TradeParamKey(LOCKER_ID));
			if (sys == null || "0".equals(sys.getParamValue())) {
				log.info("数据库中没有任务队列锁，即将创建一个：v=" + sys);
				try {
					if (sys == null) {
						sys = new TradeParam();
						sys.setParamId(LOCKER_ID);
						sys.setParamValue("0");
						sys.setDsc(UUIDGenerator.generate());
						tradeParamDao.insert(sys);
					}

					CounterCriteria<Integer> cc = new CounterCriteria<Integer>();
					cc.setWhereCause("PARAM_ID='" + LOCKER_ID + "' and PARAM_VALUE='0' ");
					cc.setIncrements(1);
					cc.setColumn("paramValue");
					cc.setTable("TradeParam");
					Object obj = tradeParamDao.increAnGetInt(cc);
					log.debug("incre obj==" + obj);					//UPDATE T_TRADE_PARAM SET PARAM_VALUE=PARAM_VALUE+1 WHERE PARAM_ID='settle.lock' and PARAM_VALUE='0' 
					if (obj != null && obj.equals(1)) {
						//
						renewAllTask();

						byte[] vv = SerializerUtil.toBytes(SerializerUtil.serialize(sys));
						int qcount = getQueueCount(SettleSteps.CTRL.getCode());
						log.info("往队列放入控制原子:" + sys + "@" + sys.getDsc() + ",qcount=" + qcount);
						if (qcount == 0) {
							sendMessage(getSettleStep().getCode(), vv);
						} else {
							log.warn("数据库不存在控制原子，但是队列Q中存在:" + sys + ",qcount=" + qcount);
						}
					} else {
						log.info("往队列放入控制原子:" + sys + "@" + sys.getDsc());
					}

				} catch (JPADuplicateIDException je) {
					log.info("放入控制原子失败，重复放入");
				}
			} else {
				int qcount = getQueueCount(SettleSteps.CTRL.getCode());
				log.warn("没放入控制原子，请检查队列状态是否正确:WARN_QCTRL:qcount=" + qcount);
			}
		}
	}

}
