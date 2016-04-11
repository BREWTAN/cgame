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
import com.github.nscala_time.time.Imports._

object P005_SaleEndProcessor extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {

    val curDT = new Date();

    if (curDT.after(issue.getSaleStime)) { //不是追期的话，设置为期后处理
      if (!StringUtils.equalsIgnoreCase("7", issue.getIssueStatus)) { //不是追期的话，设置为期后处理
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
    } else {
      val seconds = new Duration(new DateTime(curDT), new DateTime(issue.getSaleEtime));
      log.info("奖期未到封锁时间，继续等待期结束中..." + issue.getIssueId + ",status=" + issue.getIssueStatus + ",相差：" + seconds.getMillis)
      //      Thread.sleep(Math.max(100,seconds.getMillis-60*1000))
      return -1;
    }
  }

}