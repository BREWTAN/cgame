package starstart.cgw.gamectrl.scala.action

import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.SessionModules
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBCommand
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueFlowGen
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBRetIssueFlowGen
import scala.io.Codec
import onight.tfw.outils.bean.JsonPBUtil
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueFlowInit
import starstart.cgw.gamectrl.scala.persist.Mysqls
import org.osgi.framework.Bundle
import onight.tfw.mservice.NodeHelper
import onight.tfw.outils.conf.PropHelper
import scala.collection.JavaConversions._
import org.osgi.framework.BundleReference
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlowsKey
import onight.oapi.scala.commons.PBUtils
import onight.tfg.ordbgens.tlt.entity.TLTIssueFlows
import java.util.ArrayList
import scala.collection.mutable.ListBuffer
import onight.oapi.scala.commons.LService

@NActorProvider
object GCGenFlows extends SessionModules[PBIssueFlowGen] {
  override def service = GCGenFlowsService
}

class FFlow {

}
// http://localhost:8081/cgc/pbfls.do?fh=VFLSCGC000000J00&bd={"reload_type":null}
object GCGenFlowsService extends OLog with PBUtils with LService[PBIssueFlowGen] {

  override def cmd: String = PBCommand.FLS.name();

  def onPBPacket(pack: FramePacket, pbo: PBIssueFlowGen, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBRetIssueFlowGen.newBuilder();
    ret.setRetcode("0000").setRetmsg("ok");
    val flows: List[PBIssueFlowGen] = pbo.getReloadType match {
      case "1" =>
        {
          List(pbo);
        }
      case "" =>
        {
          val bytes = Array[Byte]();
          implicit val code = scala.io.Codec.UTF8
          val fileurl = classOf[BundleReference].cast(classOf[FFlow].getClassLoader()).getBundle().getResource("/initflows.json");

          val lines = scala.io.Source.fromURL(fileurl).mkString
          println("lines==" + lines);
          val builder = PBIssueFlowInit.newBuilder();
          JsonPBUtil.json2PB(lines, builder);
          val list = ListBuffer[PBIssueFlowGen]()
          builder.build().getFlowsList.map { x =>
            list.+=(x)
          }
          list.toList
        }
    }

    val flowrows = new ArrayList[Object];
    flows.map { x =>
      x.getStepsList.map { step =>
        val flowrow = pbBeanUtil.copyFromPB(step, new TLTIssueFlows())
        flowrow.setLtype(x.getLtype)
        flowrows.add(flowrow);
      }
    }
    
    val dbret = Mysqls.issueflowDAO.batchInsert(flowrows);
    
    println("steps==::" + flows + ":" + dbret);

    handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));

  }
}