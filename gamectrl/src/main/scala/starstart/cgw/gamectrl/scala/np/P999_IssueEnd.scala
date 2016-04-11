package starstart.cgw.gamectrl.scala.np

import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.oapi.scala.traits.OLog
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import starstart.cgw.gamectrl.scala.flow.NodeProcessor
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import com.github.nscala_time.time.Imports._
import java.util.Date

object P999_IssueEnd extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)

    val up = new TLTIssue();
    val curDT = new Date();
    if (curDT.after(issue.getSaleEtime)) {
      //实际已经结束了
      up.setIssueStatus("8")
    } else if (curDT.before(issue.getPreEtime)) {
      up.setIssueStatus("1")
    }
    up.setIssueId(issue.getIssueId);
    up.setModifyTime(new Date());
    Mysqls.issuesDAO.updateByPrimaryKeySelective(up);
    NodeProcessor.postProcess(issueStep)(issue);
    log.info("奖期结束:" + issue.getIssueId + ",status=" + up.getIssueStatus)
    return 0;
  }

}