package starstart.cgw.gamectrl.scala.flow

import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsExample
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlows
import onight.oapi.scala.traits.OLog
import org.springframework.beans.BeanUtils
import scala.collection.JavaConversions._

object StepsGenerator extends OLog {

  def stepByFlow(stepfl: TLTIssueFlows)(implicit issue: TLTIssue): TLTIssueSteps = {
    val step = new TLTIssueSteps();
    BeanUtils.copyProperties(stepfl, step);
    step.setIssueStepId(stepfl.getLtype + "_" + issue.getIssueNo + "_" + stepfl.getGsOrder)
    step.setIssueNo(issue.getIssueNo)
    step.setStepStatus("0");
    step.setRetryTimes(3);
    step.setRefParamGenId(stepfl.getGenId);

    return step;
  }
  //根据期号表，生成新的步骤
  def newStepForIssue(issue: TLTIssue): List[TLTIssueSteps] = {

    implicit val issueim = issue

    val issueflowsEx = new TLTIssueFlowsExample();
    issueflowsEx.createCriteria().andLtypeEqualTo(issue.getLtype).andStatusEqualTo("1");
    issueflowsEx.setOrderByClause("GS_ORDER ASC");
    issueflowsEx.setLimit(1);

    return Mysqls.issueflowDAO.selectOneByExample(issueflowsEx) match {
      case stepfl: TLTIssueFlows =>
        {
          List(stepByFlow(stepfl));
        }
      case null => {
        log.warn("未找到游戏的{}启动记录", issue.getLtype)
        List()
      }
    }
  }

  def getFlowDefsByGSOrder(gsorders: List[String])(implicit issue: TLTIssue): List[TLTIssueFlows] = {
    if (gsorders.size == 0) return List();
    val issueflowsEx = new TLTIssueFlowsExample();
    issueflowsEx.createCriteria().andLtypeEqualTo(issue.getLtype).andGsOrderIn(gsorders).andStatusEqualTo("1");
    Mysqls.issueflowDAO.selectByExample(issueflowsEx) match {
      case flows: java.util.List[Object] =>
        {
          return flows.map { _.asInstanceOf[TLTIssueFlows] }.toList
        }
      case _ =>
        return List();
    }

  }
  //根据期号表，当前步骤，生成下一个步骤
  def nextStepForIssue(issue: TLTIssue, currStep: TLTIssueSteps): List[TLTIssueSteps] = {

    implicit val issueim = issue

    val issueflowsEx = new TLTIssueFlowsExample();
    issueflowsEx.createCriteria().andLtypeEqualTo(issue.getLtype).andGsOrderEqualTo(currStep.getGsOrder).andStatusEqualTo("1");
    issueflowsEx.setLimit(1);

    return Mysqls.issueflowDAO.selectOneByExample(issueflowsEx) match {
      case stepfl: TLTIssueFlows =>
        {
          val stepsdeflist = stepfl.getNextOrders.split(",").filter { str =>
            str.trim().length() > 0
          }.toList
          getFlowDefsByGSOrder(stepsdeflist).map { stepfl => stepByFlow(stepfl) }
        }
      case null => {
        log.warn("未找到游戏的{}启动记录", issue.getLtype)
        List()
      }
    }
  }
}