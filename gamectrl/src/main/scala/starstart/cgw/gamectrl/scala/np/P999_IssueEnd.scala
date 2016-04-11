package starstart.cgw.gamectrl.scala.np

import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.oapi.scala.traits.OLog
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import starstart.cgw.gamectrl.scala.flow.NodeProcessor
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import com.github.nscala_time.time.Imports._
import java.util.Date
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample
import scala.collection.JavaConversions._

object P999_IssueEnd extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)
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
      return 0;
    } else {
      
      log.info("奖期未结束:" + issue.getIssueId + ",dbcount=" + dbcount+",,需要节点数："+lst.length+",lst="+lst)
      return -1;
    }
    
  }

}