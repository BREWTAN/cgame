package starstart.cgw.gamectrl.scala.np

import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import starstart.cgw.gamectrl.scala.flow.NodeProcessor
import onight.tfg.ordbgens.tlt.entity.TLTIssueKey
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsKey
import onight.oapi.scala.traits.OLog
import org.apache.commons.lang3.StringUtils
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsExample
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import java.util.Date
import scala.collection.JavaConversions._

trait OProcessor extends OLog {

  def checkAndProc(ltype: String, issueNo: String, issueStepId: String, operator: String): Int = {
    val issue = Mysqls.issuesDAO.selectByPrimaryKey(new TLTIssueKey(ltype + "_" + issueNo))
    val issueStep = Mysqls.issuestepsDAO.selectByPrimaryKey(new TLTIssueStepsKey(issueStepId));
    if (issue == null || issueStep == null) {
      return -1;
    } else {
      if (StringUtils.equalsIgnoreCase(issueStep.getOperatorId, operator)) {
        if (proc(issue.asInstanceOf[TLTIssue], issueStep, operator) > 0) {
          return NodeProcessor.postProcess(issueStep)(issue);//修改流程状态
        } else {
          return -1;
        }
      } else {
        log.info("节点处理错误，Operator不等：" + operator + ",db=" + issueStep.getOperatorId);
        return -2;
      }
    }
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

object FinalProcessor extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    //    Thread.sleep(5000);
    //    log.info("FinalProcessor::" + issueStep.getIssueStepId + ",name=" + issueStep.getGsChcode)

    val prefRSCodes = issueStep.getWaitOrders.split(",").toList;
    val stepex = new TLTIssueStepsExample();
    stepex.createCriteria().andIssueNoEqualTo(issue.getIssueNo).andStepStatusEqualTo("8") //
      .andLtypeEqualTo(issue.getLtype).andGsOrderIn(prefRSCodes);

    val stepDoneCount = Mysqls.issuestepsDAO.countByExample(stepex)

    if (stepDoneCount == prefRSCodes.length) {
      log.info("奖期结束:" + issue.getIssueId + ",stepCount:" + prefRSCodes)
      val up = new TLTIssue();
      up.setIssueStatus("8")
      up.setIssueId(issue.getIssueId);
      up.setModifyTime(new Date());
      Mysqls.issuesDAO.updateByPrimaryKeySelective(up);
      NodeProcessor.postProcess(issueStep)(issue, "8");
    } else {
      log.info("奖期未结束:" + issue.getIssueId + ",stepCount=" + stepDoneCount + "::flowCount=" + prefRSCodes)
    }

    return 0;
  }

}


