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

object P002_PreSale extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)

    val up = new TLTIssue();
    val curDT = new Date(System.currentTimeMillis());
    log.debug("curDT=" + curDT + ",salesttime=" + issue.getSaleStime)
    if (curDT.after(issue.getSaleStime)) { //不是追期的话，设置为期后处理
      val up = new TLTIssue();
      up.setIssueId(issue.getIssueId);
      up.setModifyTime(new Date());
      up.setRealStime(curDT);
      if (!StringUtils.equalsIgnoreCase("7", issue.getIssueStatus)) { //不是追期的话，设置为期后处理
        up.setIssueStatus("1") //开始销售
      }
      issue.setIssueStatus(up.getIssueStatus)
      Mysqls.issuesDAO.updateByPrimaryKeySelective(up);
      log.info("奖期销售开始..." + issue.getIssueId + ",status=" + issue.getIssueStatus)
      return 1;
    } else {
      val up = new TLTIssue();
      up.setIssueId(issue.getIssueId);
      up.setModifyTime(new Date());
      if (!StringUtils.equalsIgnoreCase("7", issue.getIssueStatus)) { //不是追期的话，设置为期后处理
        up.setIssueStatus("3") //开始销售
      } else {
        up.setIssueStatus("3") //开始销售
      }
      issue.setIssueStatus(up.getIssueStatus)
      Mysqls.issuesDAO.updateByPrimaryKeySelective(up);

      val seconds = new Duration(new DateTime(curDT), new DateTime(issue.getSaleEtime));
      log.info("奖期未到开始时间，继续等待中..." + issue.getIssueId + ",status=" + issue.getIssueStatus + ",相差：" + seconds.getMillis)
      Thread.sleep(Math.max(100, seconds.getMillis - 60 * 1000))
      
      return -1;
    }

  }

}