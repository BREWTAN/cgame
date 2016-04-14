package starstart.cgw.gamectrl.scala.flow

import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import onight.oapi.scala.commons.LService
import onight.oapi.scala.commons.PBUtils
import onight.oapi.scala.commons.SessionModules
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBCommand
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueFlowGen
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample
import java.util.Date
import onight.tfw.ojpa.api.TransactionExecutor
import com.github.nscala_time.time.Imports._
import scala.collection.JavaConversions._
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlows
import onight.tfw.ojpa.api.CASCriteria
import java.util.concurrent.atomic.AtomicBoolean
import onight.tfw.ojpa.api.exception.JPADuplicateIDException
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsExample
import scala.collection.mutable.ListBuffer
import org.apache.commons.lang3.StringUtils
@NActorProvider
object FlowStepChecker extends SessionModules[PBIssueFlowGen] {
  override def service = FlowStepCheckerService
}

object FlowStepCheckerService extends OLog with PBUtils with LService[PBIssueFlowGen] {

  override def cmd: String = PBCommand.SRA.name();

  val scheduler = new ScheduledThreadPoolExecutor(20);
  def increIssueError(issue: TLTIssue) = {
    val counter = new CASCriteria[Int]()
    counter.setTable("TLT_ISSUE");
    counter.setColumn("retryTimes"); //RETRY_TIMES");
    counter.setIncrements(-1);
    counter.setWhereCause("ISSUE_ID = '" + issue.getIssueId + "'");
    try {
      Mysqls.issuesDAO.increAnGetInt(counter)
    } catch {
      case e: Throwable => //如果尝试次数过多，则需要人工处理
        log.warn("修改issue尝试次数失败：" + issue + ",counter=" + counter, e)
    }
  }

  def increIssueStepError(step: TLTIssueSteps) = {
    val counter = new CASCriteria[Int]()
    counter.setTable("TLT_ISSUE_STEPS");
    counter.setColumn("retryTimes"); //RETRY_TIMES");
    counter.setIncrements(-1);
    counter.setWhereCause("ISSUE_STEP_ID = '" + step.getIssueStepId + "'");
    try {
      Mysqls.issuestepsDAO.increAnGetInt(counter)
    } catch {
      case e: Throwable => //如果尝试次数过多，则需要人工处理
        log.warn("修改issue尝试次数失败：" + step + ",counter=" + counter, e)
    }
  }
  var runningCheck = new AtomicBoolean(false);
  scheduler.scheduleWithFixedDelay(new Runnable() {
    def run() = {
      if (runningCheck.compareAndSet(false, true)) {
        val nodeNeedProc = ListBuffer[TLTIssueSteps]();
        do {
          try {
            nodeNeedProc.clear()
            log.info("CRONT::CHECKING::")
            val issueexample = new TLTIssueExample();
            val now = new Date();
            issueexample.createCriteria().andIssueStatusLessThan("8").andPreStimeLessThanOrEqualTo(now).andRetryTimesGreaterThan(1);
            issueexample.setForUpdate(true);

            Mysqls.issuesDAO.doInTransaction(new TransactionExecutor {
              def doInTransaction: Object = {
                val recs = Mysqls.issuesDAO.selectByExample(issueexample);
                if (recs == null) {
                  log.info("CRONT::未发现需要处理期号.");
                  return ""
                }
                log.info("发现未处理期号个数为：" + recs.size());
                recs.map { _.asInstanceOf[TLTIssue] }.map { issue =>
                  try {
                    //处理上次的任务，生成当期节点
                    dealWithStepDone(issue);
                    //处理本次任务
                    dealWithStepNotDone(issue, nodeNeedProc);

                  } catch {
                    case e: Throwable =>
                      log.warn("处理期失败:" + issue.getIssueId, e)
                      increIssueError(issue)
                  }
                }
                return ""
              }
            })
            nodeNeedProc.map { NodeProcessor.process(_) };

            if (nodeNeedProc.size > 0) {
              Thread.sleep(2000);
              log.debug("wait:for next:" + nodeNeedProc.size + ",rizesiz=" + nodeNeedProc.filter { _.getStepStatus.equals("1") }.size)
            }

          } catch {
            case e: Throwable => log.debug("running ChechError:", e);
          } finally {
            runningCheck.compareAndSet(true, false);
          }
        } while (nodeNeedProc.size > nodeNeedProc.filter { _.getStepStatus.equals("1") }.size)
      } else {
        log.debug("Cannot Check:WAIT_FOR_LAST_FINISHED::")
      }
    }
  }, 10, 10, TimeUnit.SECONDS)
  //处理已经做完的节点
  def dealWithStepDone(issue: TLTIssue) {
    val stepex = new TLTIssueStepsExample();
    stepex.createCriteria().andIssueNoEqualTo(issue.getIssueNo).andStepStatusLessThanOrEqualTo("8").andLtypeEqualTo(issue.getLtype);

    val steprecs = Mysqls.issuestepsDAO.selectByExample(stepex).map { _.asInstanceOf[TLTIssueSteps] };

    //生成下一个节点号
    val nextsteps = if (steprecs.size() == 0) {
      StepsGenerator.newStepForIssue(issue);
    } else {
      steprecs.filter { step => "5".equals(step.getStepStatus) && "1".equals(step.getAutoGonext) }.map { step =>
        StepsGenerator.nextStepForIssue(issue, step.asInstanceOf[TLTIssueSteps])
      }.flatten
    }
    log.debug("一共需要生成节点数：" + nextsteps.size());
    var success = 0;
    var failed = 0;
    //将节点插入数据库
    if (nextsteps.size > 0) {
      nextsteps.foreach { step =>

        try {
          val existexample = new TLTIssueStepsExample()
          existexample.createCriteria().andIssueStepIdEqualTo(step.getIssueStepId)
          if (Mysqls.issuestepsDAO.countByExample(existexample) == 0) { //不插入重复的
            Mysqls.issuestepsDAO.insertSelective(step)
          }
          success = success + 1;
        } catch {
          case e: JPADuplicateIDException => //如果尝试次数过多，则需要人工处理
            {
              log.warn("不能插入重复节点：" + step)
              failed = failed + 1
            }
          case e: Throwable => //如果尝试次数过多，则需要人工处理
            log.warn("新建节点失败：" + step, e)
            increIssueError(issue)
            increIssueStepError(step)
            failed = failed + 1
        }

      }

      log.info("完成生成节点数，成功数:" + success + ",失败数:" + failed + ",总数:" + nextsteps.size());

    }

    steprecs.filter { step => "5".equals(step.getStepStatus) }.map { step =>
      log.info("设置节点状态为结束：" + step.getIssueStepId);
      val up = new TLTIssueSteps();
      up.setStepStatus("8")
      val example = new TLTIssueStepsExample
      example.createCriteria().andIssueStepIdEqualTo(step.getIssueStepId).andStepStatusEqualTo("5").andOperatorIdEqualTo(step.getOperatorId)
      Mysqls.issuestepsDAO.updateByExampleSelective(up, example);
    }

  }

  //处理初始化的节点
  def dealWithStepNotDone(implicit issue: TLTIssue, nodeNeedProc: ListBuffer[TLTIssueSteps] = null) {
    val stepex = new TLTIssueStepsExample();
    stepex.createCriteria().andIssueNoEqualTo(issue.getIssueNo).andStepStatusIn(List("0", "7", "1", "3")).andLtypeEqualTo(issue.getLtype);
    stepex.setForUpdate(true);
    val steprecs = Mysqls.issuestepsDAO.selectByExample(stepex).map { _.asInstanceOf[TLTIssueSteps] }
    log.debug("一共有待处理节点数：" + steprecs.size());

    //将节点插入数据库
    if (steprecs.size > 0) {
      steprecs.map { step =>
        val p = NodeProcessor.preProcess(step)
        if (p > 0) {
          log.debug("可以处理该节点：" + step);
          if (nodeNeedProc != null) {
            nodeNeedProc.+=:(step);
          }
        }
      }
    }
  }

  def onPBPacket(pack: FramePacket, pbo: PBIssueFlowGen, handler: CompleteHandler) = {
  }
}