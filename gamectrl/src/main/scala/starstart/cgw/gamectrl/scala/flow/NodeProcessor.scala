package starstart.cgw.gamectrl.scala.flow

import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.oapi.scala.traits.OLog
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import onight.tfw.outils.serialize.UUIDGenerator
import starstart.cgw.gamectrl.scala.action.GS_NodeService
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBStepCtrl
import org.apache.commons.lang3.StringUtils

object NodeProcessor extends OLog {
  /**
   * 1.预处理的时候锁定这条记录，并且把operator改成本次的uuid，判断该节点的状态是否已处理，改成处理中，
   * 2、节点处理就是该节点应该做的事情，例如等待销售截止、算奖等
   * 3、后处理把节点状态改成已处理完成，
   *
   */

  def preProcess(step: TLTIssueSteps)(implicit issue: TLTIssue): Int = {
    //节点预处理
    log.debug("节点预处理：" + step.getGsChcode + ",stepid=" + step.getIssueStepId)
    if (!StringUtils.isBlank(step.getOperatorId) && !StringUtils.equalsIgnoreCase("AUTO", step.getOperatorId)) {
      log.debug("流程节点已被其他进程处理中：" + step.getOperatorId)
      return -1;
    }
    val up = new TLTIssueSteps();
    up.setStepStatus("3")// 提交处理中
    up.setOperatorId(UUIDGenerator.generate())
    step.setOperatorId(up.getOperatorId);
    val example = new TLTIssueStepsExample
    example.createCriteria().andIssueStepIdEqualTo(step.getIssueStepId).andStepStatusEqualTo(step.getStepStatus)
    return Mysqls.issuestepsDAO.updateByExampleSelective(up, example);
  }

  def process(step: TLTIssueSteps): Int = {
    //处理节点
    log.debug("节点处理中：" + step.getGsChcode + ",stepid=" + step.getIssueStepId + ",operator=" + step.getOperatorId)

    //call other to precsss
    val pbo = PBStepCtrl.newBuilder();
    pbo.setLtype(step.getLtype)
    pbo.setStepOperator(step.getOperatorId);
    pbo.setGsOrder(step.getGsOrder)
    pbo.setIssueNo(step.getIssueNo);
    pbo.setIssueStepId(step.getIssueStepId);
    FlowStepCheckerService.scheduler.execute(new Runnable() {
      def run() {
        try {
          GS_NodeService.onPBPacket(new FramePacket, pbo.build(), null)
        } catch {
          case e: Throwable =>
            log.warn("CALL_NODE_PROCESS_ERROR:" + step.getIssueStepId, e)
        }
      }
    })

    return 1;
  }

  def postProcess(step: TLTIssueSteps)(implicit issue: TLTIssue,newStatus:String = "5"): Int = {
    //节点后处理
    log.debug("节点后处理：" + step.getGsChcode + ",stepid=" + step.getIssueStepId)
    val up = new TLTIssueSteps();
    up.setStepStatus("5")
    val example = new TLTIssueStepsExample
    example.createCriteria().andIssueStepIdEqualTo(step.getIssueStepId).andOperatorIdEqualTo(step.getOperatorId)
    return Mysqls.issuestepsDAO.updateByExampleSelective(up, example);

  }
}