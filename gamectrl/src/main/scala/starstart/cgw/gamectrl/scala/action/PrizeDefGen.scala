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
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBPrizeInit
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBPrizeInit
import onight.tfg.ordbgens.tlt.entity.TLTCoreDefPrize
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBRetPrizeInit
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBPrizeInit.PBPrizeDef
import onight.tfw.outils.serialize.UUIDGenerator

@NActorProvider
object GCPrizeDef extends SessionModules[PBPrizeInit] {
  override def service = GCPrizeDefService
}

// http://localhost:8081/cgc/pbprz.do?fh=VPRZCGC000000J00&bd={"ltype":"CQSSC","catalog":"*"}
object GCPrizeDefService extends OLog with PBUtils with LService[PBPrizeInit] {

  override def cmd: String = PBCommand.PZG.name();

  def onPBPacket(pack: FramePacket, pbo: PBPrizeInit, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBRetPrizeInit.newBuilder();
    ret.setRetcode("0000").setRetmsg("ok");
    val defs: java.util.List[PBPrizeDef] = pbo.getReloadType match {
      case "1" =>
        {
          pbo.getDefsList;
        }
      case _ =>
        {
          val bytes = Array[Byte]();
          implicit val code = scala.io.Codec.UTF8
          val fileurl = classOf[BundleReference].cast(classOf[FFlow].getClassLoader()).getBundle().getResource("/initPrize_"+pbo.getLtype+".json");

          val lines = scala.io.Source.fromURL(fileurl).mkString
          println("lines==" + lines);
          val builder = PBPrizeInit.newBuilder();
          JsonPBUtil.json2PB(lines, builder);
          builder.build().getDefsList
        }
    }

    val defsrows = new ArrayList[Object];
    defs.map { x =>
        val defrow = pbBeanUtil.copyFromPB(x, new TLTCoreDefPrize())
        defrow.setLtype(pbo.getLtype)
        defrow.setCatalog(pbo.getCatalog)
        defrow.setUuid(UUIDGenerator.generate())
        defsrows.add(defrow);
    }
    
    val dbret = Mysqls.coredefprizeDAO.batchInsert(defsrows);
    
    println("defs==::" + defsrows + ":" + dbret);

    handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));

  }
}