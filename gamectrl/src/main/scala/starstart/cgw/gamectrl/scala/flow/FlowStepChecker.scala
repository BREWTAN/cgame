package starstart.cgw.gamectrl.scala.flow

import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

import onight.oapi.scala.commons.LService
import onight.oapi.scala.commons.PBUtils
import onight.oapi.scala.commons.SessionModules
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBCommand
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueFlowGen
import starstart.cgw.gamectrl.scala.persist.Mysqls

object FlowStepChecker extends SessionModules[PBIssueFlowGen] {
  override def service = FlowStepCheckerService
}
object FlowStepCheckerService extends OLog with PBUtils with LService[PBIssueFlowGen] {

  override def cmd: String = PBCommand.SRA.name();

  val scheduler = new ScheduledThreadPoolExecutor(2);

  scheduler.scheduleAtFixedRate(new Runnable() {
    def run() = {
      
      val example = new TLTIssueStepsExample()
      
      Mysqls.issuestepsDAO.selectByExample(example)

    }
  }, 10, 60, TimeUnit.SECONDS)
  def onPBPacket(pack: FramePacket, pbo: PBIssueFlowGen, handler: CompleteHandler) = {

  }
}