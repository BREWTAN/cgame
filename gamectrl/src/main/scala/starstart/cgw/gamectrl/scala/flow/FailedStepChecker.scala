package starstart.cgw.gamectrl.scala.flow

import java.util.Date
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import com.github.nscala_time.time.Imports._
import onight.oapi.scala.commons.LService
import onight.oapi.scala.commons.PBUtils
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import onight.tfw.async.CompleteHandler
import onight.tfw.ojpa.api.TransactionExecutor
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueFlowGen
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.scala.commons.SessionModules
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsKey
@NActorProvider
object FailedStepChecker extends SessionModules[PBIssueFlowGen] {
  override def service = FailedStepCheckerService
}

object FailedStepCheckerService extends OLog with PBUtils with LService[PBIssueFlowGen] {

  override def cmd: String = "SRF";

  val scheduler = new ScheduledThreadPoolExecutor(10);

  var runningCheck = new AtomicBoolean(false);
  scheduler.scheduleWithFixedDelay(new Runnable() {
    def run() = {
      if (runningCheck.compareAndSet(false, true)) {
        val nodeNeedProc = ListBuffer[TLTIssueSteps]();
        do {
          try {
            nodeNeedProc.clear()
            log.info("CRONT.FAILED::CHECKING::")
            val issueexample = new TLTIssueExample();
            val now = new Date();
            issueexample.createCriteria().andIssueStatusLessThan("8").andSaleEtimeLessThanOrEqualTo(now).andRetryTimesGreaterThan(1);
            issueexample.setForUpdate(true);

            Mysqls.issuesDAO.doInTransaction(new TransactionExecutor {
              def doInTransaction: Object = {
                val recs = Mysqls.issuesDAO.selectByExample(issueexample);
                if (recs == null) {
                  log.info("CRONT::未发现需要处理的异常奖期.");
                  return ""
                }
                log.info("发现异常期号个数为：" + recs.size());
                recs.map { _.asInstanceOf[TLTIssue] }.filter { _.getIssueStatus.equals("1") }.map { issue =>
                  dealOnSaleErrorIssue(issue)
                  
                }
                recs.map { _.asInstanceOf[TLTIssue] }.filter { _.getIssueStatus.equals("7") }.map { issue =>
                  dealOnRedoErrorIssue(issue)
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
        } while (nodeNeedProc.filter { _.getStepStatus.equals("1") }.size > 0)
      } else {
        log.debug("Cannot Check:WAIT_FOR_LAST_FINISHED::")
      }
    }
  }, 10, 10, TimeUnit.SECONDS)

  def onPBPacket(pack: FramePacket, pbo: PBIssueFlowGen, handler: CompleteHandler) = {
  }

  //处理状态为“1”-当期的奖期
  def dealOnSaleErrorIssue(issue: TLTIssue) {
    try {
      //处理异常期，
      log.info("处理异常期：" + issue.getIssueId + ",status=" + issue.getIssueStatus)
      val up = new TLTIssue();
      up.setIssueId(issue.getIssueId);
      up.setModifyTime(new Date());
      up.setIssueStatus("7") //设置为追期处理销售
      Mysqls.issuesDAO.updateByPrimaryKeySelective(up);
    } catch {
      case e: Throwable =>
        log.warn("异常处理期失败:" + issue.getIssueId, e)
    }
  }

  def dealOnRedoErrorIssue(issue: TLTIssue) {
    val issueStep = Mysqls.issuestepsDAO.selectByPrimaryKey(new TLTIssueStepsKey(issue.getLtype + "_" + issue.getIssueNo + "_999"))
    if (issueStep == null) return ;
    log.info("dealOnRedoErrorIssue::" + issue.getIssueNo + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)

    val lst = issueStep.getWaitOrders.split(",").toList;
    val ex = new TLTIssueStepsExample()
    ex.createCriteria().andIssueNoEqualTo(issue.getIssueNo).andLtypeEqualTo(issue.getLtype) //
      .andStepStatusEqualTo("8").andGsOrderIn(lst)
    val dbcount = Mysqls.issuestepsDAO.countByExample(ex)
    if (dbcount == lst.length) {
      val up = new TLTIssue();
      val curDT = new Date();
      up.setIssueStatus("8")
      up.setIssueId(issue.getIssueId);
      up.setModifyTime(new Date());
      Mysqls.issuesDAO.updateByPrimaryKeySelective(up);
      NodeProcessor.postProcess(issueStep)(issue);

      val upstep = new TLTIssueSteps();
      upstep.setIssueStepId(issueStep.getIssueStepId);
      upstep.setStepStatus("8")
      upstep.setModifyTime(new Date())
      Mysqls.issuestepsDAO.updateByPrimaryKeySelective(upstep);

      log.info("奖期结束:" + issue.getIssueId + ",status=" + up.getIssueStatus)
    } else {

      log.info("奖期未结束:" + issue.getIssueId + ",dbcount=" + dbcount + ",,需要节点数：" + lst.length + ",lst=" + lst)
    }
  }
}