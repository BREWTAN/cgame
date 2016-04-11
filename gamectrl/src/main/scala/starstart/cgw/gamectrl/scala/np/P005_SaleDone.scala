package starstart.cgw.gamectrl.scala.np

import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.oapi.scala.traits.OLog
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import starstart.cgw.gamectrl.scala.flow.NodeProcessor
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import com.github.nscala_time.time.Imports._
import java.util.Date
import org.apache.commons.lang3.StringUtils

object P005_SaleEndProcessor extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    if (!StringUtils.equalsIgnoreCase("4", issue.getIssueStatus)) { //不是追期的话，设置为期后处理
      val up = new TLTIssue();
      up.setIssueStatus("3")
      up.setIssueId(issue.getIssueId);
      up.setModifyTime(new Date());
      issue.setIssueStatus(up.getIssueStatus)
      Mysqls.issuesDAO.updateByPrimaryKeySelective(up);
    }
    NodeProcessor.postProcess(issueStep)(issue);
    log.info("销售截止:" + issue.getIssueId + ",status=" + issue.getIssueStatus)
    return 1;
  }

}