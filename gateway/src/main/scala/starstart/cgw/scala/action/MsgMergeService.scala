package starstart.cgw.scala.action

import scala.collection.JavaConversions.asScalaBuffer
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.LService
import onight.scala.commons.PBUtils
import onight.scala.commons.SessionModules
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.pbgens.Cgw.PBFramePacket
import starstart.cgw.pbgens.Cgw.PWMergeProxy
import starstart.cgw.pbgens.Cgw.PWRetWager
import starstart.cgw.scala.service.Sender
import onight.tfw.async.CallBack
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Promise

@NActorProvider
object CGWMsgMergeActor extends SessionModules[PWMergeProxy] {
  override def service = CGWMsgMergeService
}

object CGWMsgMergeService extends OLog with PBUtils with LService[PWMergeProxy] {

  override def cmd: String = "MER";

  def proxyPacket(pack: FramePacket, proxypack: PBFramePacket, future: Future[FramePacket]) = {
    //only support json now
    val forwordpack = PacketHelper.genASyncPack(proxypack.getGcmd.substring(0, 3), proxypack.getGcmd.substring(3, 6), proxypack.getJsondatas);
    forwordpack.getExtHead.appendFrom(proxypack.getExts.getBytes);
    val cb = new CallBack[FramePacket]() {
      def onSuccess(v: FramePacket) {
        
      }
      def onFailed(e: Exception, v: FramePacket) {
        
      }

    };
    Sender.ps.asyncSend(forwordpack).whenDone(cb);
  }

  def onPBPacket(pack: FramePacket, pbo: PWMergeProxy, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PWRetWager.newBuilder();
    val f = Future {  
      100
    }
    val p = Promise[FramePacket] ();
    
    pbo.getPacketsList().map { pack =>
      
    }

    handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
  }
}