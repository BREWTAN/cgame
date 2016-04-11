package starstart.cgw.gamectrl.scala.np

import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.oapi.scala.traits.OLog
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import starstart.cgw.gamectrl.scala.flow.NodeProcessor
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import com.github.nscala_time.time.Imports._
import java.util.Date

object P001_InitStart extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    //    Thread.sleep(5000);
    //    log.info("FinalProcessor::" + issueStep.getIssueStepId + ",name=" + issueStep.getGsChcode)
    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)

    val up = new TLTIssue();
    val curDT = new Date();
    if (curDT.after(issue.getSaleEtime)) {
      //实际已经结束了，属于追期
      up.setIssueStatus("7")
      log.info("追期奖期开始:" + issue.getIssueId + ",status=" + up.getIssueStatus)
    } else if (curDT.before(issue.getPreEtime)) {
      up.setIssueStatus("1")
    }
    up.setIssueId(issue.getIssueId);
    up.setModifyTime(new Date());
    Mysqls.issuesDAO.updateByPrimaryKeySelective(up);
    log.info("奖期开始:" + issue.getIssueId + ",status=" + up.getIssueStatus)
    return 1;
  }

}