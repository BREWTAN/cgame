package starstart.cgame.flows.nsttl.flows;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.annotations.StoreDAO;
import onight.tfw.ojpa.api.exception.JPADuplicateIDException;
import onight.tfw.orouter.api.IRecievier;
import onight.tfw.outils.serialize.SerializerUtil;
import onight.tfw.proxy.ActorProxy;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import starstart.cgame.flows.enums.SettleStatus;
import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.nsttl.exception.SettleSleep;
import starstart.cgame.flows.utils.CacheHelper;
import starstart.cgame.flows.utils.TradeLocal;

@Slf4j
@Data
public abstract class NSettle_BaseActor<T extends CalcMutex> extends ActorProxy {

	@StoreDAO(domain = String.class, key = "key", target = "cache")
	protected OJpaDAO cacheDao;

	/**
	 * 取cache的内容
	 */
	protected CacheHelper cacheHelper;

	FlowCtrl flowCtrl = new FlowCtrl();

	public abstract SettleSteps getSettleStep();

	public Class<?> getBeanClass() {
		return CalcMutex.class;
	}

	/**
	 * 更新任务
	 */
	@StoreDAO(domain = SettTaskRun.class)
	protected OJpaDAO<SettTaskRun> sttlTaskRunDao;

	public abstract void processMessage(T pack);

	private HttpRequestor http = null;
	
	@Override
	public void onQServiceReady() {
		log.debug("QServiceReady");
		http = new HttpRequestor();
		http.reload();
		http.changeMaxTotal(100);
		final SettleSteps step = getSettleStep();
		flowCtrl.build();
		createMessageListener(step.getCode(), new IRecievier() {
			@Override
			public boolean onMessage(String ex, Serializable wmsg) {
				TradeLocal.clean();
				String errorCode = "0000";
				boolean dropMsg = true;
				T pack = null;
				try {
					pack = (T) SerializerUtil.deserialize(wmsg, getBeanClass());

					long starttime = System.currentTimeMillis();
					log.info("PROCESSING::@" + step.getCode() + ":body=" + pack);
					TradeLocal.setTaskID(pack.getId());
					processMessage(pack);
					pack.setLastProcessor(step.getCode());
					TradeLocal.logCostTime(1, System.currentTimeMillis() - starttime);
					
					FlowNode[] nexts = flowCtrl.getNextSteps(step.getCode(),step);
					genNewTaskStep(nexts, pack);
					TradeLocal.logCostTime(0, System.currentTimeMillis() - starttime);
				} catch (SettleSleep ss) {
					dropMsg = false;
					log.trace("Sleep :" + ss.getSleepMS());
					try {
						synchronized (this) {
							this.wait(ss.getSleepMS());
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (SettleException ce) {
					log.error("消息处理失败:" + ce.getMessage() + "@" + wmsg, ce);
					reportError(pack, ce.getMessage()+ "@" + wmsg);
				} catch (Throwable e) {
					errorCode = "9999";
					log.error("proc message error:" + "@" + wmsg, e);
					dropMsg = true;
					reportError(pack, e.getMessage());
				} finally {
					log.info(TradeLocal.zbxLogs(step.getCode(), errorCode));
					TradeLocal.clean();
				}
				return dropMsg;
			}
		});
	}

	public void reportError(T pack, String msg) {
		if (pack != null)
			try {
				final SettTaskRun uptask = new SettTaskRun();
				uptask.setTaskId(pack.getId());
				uptask.setDsc(msg.substring(0, 80));
				uptask.setStatus(SettleStatus.Error.getCode());
				sttlTaskRunDao.updateByPrimaryKeySelective(uptask);
			} catch (Throwable e) {
				// e.printStackTrace();
				log.error("store message error:", e);
			}

	}

	public void genNewTaskStep(final FlowNode[] nexts, T pack) {
		final SettTaskRun uptask = new SettTaskRun();
		uptask.setTaskId(pack.getId());
		uptask.setStatus(SettleStatus.Finished.getCode());//修改任务为status=‘2’

		final List<Object> newTasks = new ArrayList<>();
		final List<Pair<String, Serializable>> newMsgs = new ArrayList<>();
		boolean hasMergeNode = false;
		String nextIds = "";
		if (nexts != null && nexts.length > 0) {

			String parentID = pack.getDatas().get(TaskDataDefs.DT_ParentID);
			String settleDt = pack.getDatas().get(TaskDataDefs.DT_SettleDT);

			for (FlowNode next : nexts) {
				SettTaskRun task = new SettTaskRun();
				task.setTaskId(parentID+"|"+next.getCurrent().getCode());
				task.setCrtTime(new Date());
				if (next.mergeCount > 1) {
					hasMergeNode = true;
				}
				if (nextIds.length() > 0) {
					nextIds += ",";
				}
				nextIds += task.getTaskId();

				task.setStatus(SettleStatus.Processing.getCode());//修改任务为status=‘1’
				task.setTaskType(next.getCurrent().getCode());
				task.setSettleDt(settleDt);
				task.setRootRunid(task.getTaskId());
				pack.setId(task.getTaskId());
				byte[] msg = SerializerUtil.toBytes(SerializerUtil.serialize(pack));
				newTasks.add(task);
				newMsgs.add(new MutablePair<String, Serializable>(next.current.getCode(), msg));
			}
		}
		final boolean mergeNode = hasMergeNode;
		uptask.setNextRunid(nextIds);
		sttlTaskRunDao.updateByPrimaryKeySelective(uptask);
		if (newTasks.size() > 0) {
			log.info("mergeNode=:"+mergeNode);
			if (mergeNode) {
				if (!increMergeNode((SettTaskRun) newTasks.get(0), nexts[0].getMergeCount())) {
					// 没完成合并，不发送消息
					return;
				}
			} else {
				for (Object task : newTasks) {
					insertOrUpdateNode((SettTaskRun) task);
				}
			}

			for (Pair<String, Serializable> pair : newMsgs) {
				sendMessage(pair.getLeft(), pair.getRight());
			}
		}
	}

	public void insertOrUpdateNode(SettTaskRun newtask) {
		try {
			sttlTaskRunDao.insert(newtask);
		} catch (JPADuplicateIDException e) {
			newtask.setDsc("REDO:" + TradeLocal.getNow());
			sttlTaskRunDao.updateByPrimaryKey(newtask);
			log.info("任务异常："+e);
			e.printStackTrace();
		}
	}

	public boolean increMergeNode(SettTaskRun newtask, int mergeCount) {
		try {
			sttlTaskRunDao.insert(newtask);
		} catch (JPADuplicateIDException e) {
			// e.printStackTrace();
			int tryi = 0;
			SettTaskRunExample example = new SettTaskRunExample();
			example.createCriteria().andNextRunidEqualTo(newtask.getTaskId()).andStatusEqualTo("2").andSettleDtEqualTo(newtask.getSettleDt());
			int cc = sttlTaskRunDao.countByExample(example);
			if (cc == mergeCount) {
				log.info("STTL:MergeNode::OutputOK:" + mergeCount + "," + newtask.getTaskId() + ",type=" + newtask.getTaskType());
				return true;
			} else {
				log.info("STTL:MergeNode::Wait:current=" + cc + ", mergeCount=" + mergeCount + "," + newtask.getTaskId() + ",type=" + newtask.getTaskType());
				return false;
			}
		}
		return false;
	}

	/**
	 * 注入cache帮助类！ 注意！千万不要在子类里面覆盖这个函数
	 */
	@Override
	public void onDaoServiceReady(OJpaDAO dao) {
		if (dao == cacheDao) {
			cacheHelper = new CacheHelper(dao);
			log.debug("set CacheHelper:" + cacheHelper);
		}
		super.onDaoServiceReady(dao);
	}

}
