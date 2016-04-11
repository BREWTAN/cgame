package starstart.cgw.gamectrl.scala.np

import java.util.Date
import scala.collection.JavaConversions._
import org.apache.commons.lang3.StringUtils
import onight.oapi.scala.traits.OLog
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssueKey
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsKey
import starstart.cgw.gamectrl.scala.flow.NodeProcessor
import starstart.cgw.gamectrl.scala.persist.Mysqls
import org.apache.felix.ipojo.transaction.Transaction
import onight.tfw.ojpa.api.TransactionExecutor

trait OProcessor extends OLog {

  def checkAndProc(ltype: String, issueNo: String, issueStepId: String, operator: String): Int = {
    val issue = Mysqls.issuesDAO.selectByPrimaryKey(new TLTIssueKey(ltype + "_" + issueNo))
    val issueStep = Mysqls.issuestepsDAO.selectByPrimaryKey(new TLTIssueStepsKey(issueStepId));
    val up = new TLTIssueSteps();
    val orgstatus = issue.getIssueStatus;
    if (!issue.getIssueStatus.equals("7")) {
      up.setStepStatus("4")
    }
    up.setModifyTime(new Date());

    val upex = new TLTIssueStepsExample();
    upex.createCriteria().andIssueStepIdEqualTo(issueStepId).andStepStatusEqualTo("3").andOperatorIdEqualTo(operator);
    upex.setForUpdate(true);
    val ret = Mysqls.issuestepsDAO.doInTransaction(new TransactionExecutor {
      def doInTransaction: Object = {
        if (Mysqls.issuestepsDAO.updateByExampleSelective(up, upex) <= 0) {
          log.info("节点处理错误，Operator：" + operator + ",dboperator=" + issueStep.getOperatorId
            + " ,step.dbstatus=" + issueStep.getStepStatus + ":@stepid=" + issueStepId);
          return "-2";
        }
        val ret = proc(issue.asInstanceOf[TLTIssue], issueStep, operator)
        if (ret > 0) {
          return "" + NodeProcessor.postProcess(issueStep)(issue); //修改流程状态
        } else if (ret == -1) {
          val upex = new TLTIssueStepsExample();
          upex.createCriteria().andIssueStepIdEqualTo(issueStepId).andOperatorIdEqualTo(operator);
          up.setOperatorId("");
          up.setStepStatus(orgstatus);
          Mysqls.issuestepsDAO.updateByExampleSelective(up, upex);
          return "-1";
        } else {
          return "" + ret;
        }
      }
    })
    return Integer.parseInt(ret + "");

  }
  def proc(issue: TLTIssue, issueStepId: TLTIssueSteps, operator: String): Int

}

object NoneProcessor extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    Thread.sleep(5000);
    log.info("NoneProcessor::" + issueStep.getIssueStepId + ",name=" + issueStep.getGsChcode)
    return 1;
  }

}


