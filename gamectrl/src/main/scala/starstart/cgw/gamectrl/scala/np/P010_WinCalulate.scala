package starstart.cgw.gamectrl.scala.np

import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.oapi.scala.traits.OLog
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import starstart.cgw.gamectrl.scala.flow.NodeProcessor
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import com.github.nscala_time.time.Imports._
import java.util.Date
import onight.tfg.ordbgens.tlt.entity.TLTCoreBetExample
import com.github.nscala_time.time.Imports._
import scala.collection.JavaConversions._
import starstart.cgw.scala.ssc.BetsCalc
import onight.tfg.ordbgens.tlt.entity.TLTCoreBet

object P010_WinCalculate extends OProcessor with OLog {

  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)
    //算奖

    val example = new TLTCoreBetExample
    example.createCriteria().andIssueNoEqualTo(issue.getIssueNo).andLtypeEqualTo(issue.getLtype)
    
    
    Mysqls.corebetDAO.selectByExample(example).map { _.asInstanceOf[TLTCoreBet] }.map { bet =>
      
      val winno = BetsCalc.calc(bet.getBetOrgContent,issue.getLotteryNo)
      
      log.debug("bet==" + bet+",winno="+winno)
    }

    return 1;
  }

}