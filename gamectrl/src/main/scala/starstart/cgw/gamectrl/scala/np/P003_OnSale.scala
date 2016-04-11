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

object P003_OnSaleProcessor extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)

    val up = new TLTIssue();
    val curDT = new Date();

    if (curDT.after(issue.getSaleEtime)) { //不是追期的话，设置为期后处理
      val up = new TLTIssue();
      up.setIssueId(issue.getIssueId);
      up.setModifyTime(new Date());
      up.setRealEtime(curDT);
      if (!StringUtils.equalsIgnoreCase("4", issue.getIssueStatus)) { //不是追期的话，设置为期后处理
        up.setIssueStatus("2") //封闭期  
      }
      issue.setIssueStatus(up.getIssueStatus)
      Mysqls.issuesDAO.updateByPrimaryKeySelective(up);
      log.info("奖期销售关闭中..." + issue.getIssueId + ",status=" + issue.getIssueStatus)
      return 1;
    } else {
      log.info("奖期未到关闭时间，继续销售中..." + issue.getIssueId + ",status=" + issue.getIssueStatus)
      return 0;
    }

  }

}