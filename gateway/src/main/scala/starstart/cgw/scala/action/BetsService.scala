package starstart.cgw.scala.action

import scala.concurrent.ExecutionContext.Implicits.global
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.PBUtils
import onight.tfw.outils.serialize.UUIDGenerator
import onight.tfw.async.CompleteHandler
import onight.scala.commons.LService
import onight.oapi.scala.traits.OLog
import onight.scala.commons.SessionModules
import onight.tfw.otransio.api.beans.FramePacket
import onight.tfw.otransio.api.PacketHelper
import scala.collection.mutable.MutableList
import scala.collection.mutable.ListBuffer
import java.util.concurrent.ScheduledThreadPoolExecutor
import onight.tfw.mservice.NodeHelper
import java.util.concurrent.ConcurrentLinkedQueue
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.mutable.HashMap
import java.sql.Timestamp
import onight.tfw.async.CallBack
import org.apache.commons.lang3.StringUtils
import java.util.concurrent.TimeUnit
import starstart.cgw.pbgens.Cgw.PWBetResult
import starstart.cgw.pbgens.Cgw.PWWager
import starstart.cgw.pbgens.Cgw.PWRetWager

@NActorProvider
object CGWBetActor extends SessionModules[PWWager] {
  override def service = CGWBetService
}

object CGWBetService extends OLog with PBUtils with LService[PWWager] {

  override def cmd: String = "BET";

  def onPBPacket(pack: FramePacket, pbo: PWWager, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PWRetWager.newBuilder();
    
    ret.setRetcode("0000").setRetmsg("ok");
//    if (pbo == null) {
//      ret.setDesc("Packet_Error").setStatus("0001") setRetcode (RetCode.FAILED);
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
//    } else if (StringUtils.isBlank(pbo.getActNo)) {
//      ret.setDesc("账户号不能为空").setStatus("0002") setRetcode (RetCode.FAILED);
//      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
//    } else {
//      val vmap = pbo.getAllFields.map({ kv =>
//        (kv._1.getName.toUpperCase(), kv._2)
//      })
//      vmap.put("CREATE_TIME",  java.lang.Long.valueOf(System.currentTimeMillis()))
//      vmap.put("ACT_STAT", "0")
//      val v = TActInfoDAO.instanceFromMap(vmap.asInstanceOf[HashMap[String, Object]])
//
//      ret.setActNo(v.ACT_NO)
//      buckets.offer((v, handler, ret, pack));
//
//    }

  }
}