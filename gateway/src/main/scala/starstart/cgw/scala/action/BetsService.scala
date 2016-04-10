package starstart.cgw.scala.action

import scala.beans.BeanProperty
import scala.collection.JavaConversions._
import scala.collection.JavaConversions.mapAsScalaMap
import scala.concurrent.ExecutionContext.Implicits.global
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.LService
import onight.scala.commons.PBUtils
import onight.scala.commons.SessionModules
import onight.starstarts.utils.MD5
import onight.tfg.ordbgens.tlt.entity.TLTCoreBet
import onight.tfw.async.CompleteHandler
import onight.tfw.ojpa.api.OJpaDAO
import onight.tfw.otransio.api.PackHeader
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import onight.tfw.outils.serialize.DESCoder
import onight.tfw.outils.serialize.UUIDGenerator
import starstart.cgw.pbgens.Cgw.PWBetResult
import starstart.cgw.pbgens.Cgw.PWRetWager
import starstart.cgw.pbgens.Cgw.PWWager
import starstart.cgw.scala.service.MysqlDaos
import java.util.Date

@NActorProvider
object CGWBetActor extends SessionModules[PWWager] {
  override def service = CGWBetService
}

object CGWBetService extends OLog with PBUtils with LService[PWWager] {

  override def cmd: String = "BET";

  def onPBPacket(pack: FramePacket, pbo: PWWager, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PWRetWager.newBuilder();

    log.debug("getBug from IP:{},betscount={}", pack.getExtStrProp(PackHeader.PEER_IP), pbo.getBetsCount)
    ret.setRetcode("9999").setRetmsg("UNKNOW ERROR");

    val bets = pbo.getBetsList().map { bet =>
      val dbbet = pbBeanUtil.copyFromPB(bet, new TLTCoreBet)
      pbBeanUtil.copyFromPB(pbo, dbbet)

      dbbet.setBetDatetime(new Date());
      dbbet.setTickNo(UUIDGenerator.generate());
      val serialnum = MD5.getMD5(("starstart-ming:" + dbbet.getTickNo));
      dbbet.setBetIp(pack.getExtStrProp(PackHeader.PEER_IP));
      dbbet.setSerialNum(serialnum)
      dbbet
    }

    try {

      MysqlDaos.corebetDAO.batchInsert(bets);
      bets.map { dbbet =>
        val retbet = PWBetResult.newBuilder()
        retbet.setBetStatus("0000").setSerialNum(dbbet.getSerialNum).setVldcode(MD5.getMD5(DESCoder.desEncrypt(dbbet.getSerialNum, "zzzz-starstartsFFFF")))
        ret.addBetrets(retbet);
      }
      ret.setRetcode("0000").setRetmsg("ok");
    } catch {
      case e: Exception =>
        log.error( "投注异常",e)
        ret.setRetcode("0001").setRetmsg(e.getMessage)
    }
    handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
  }
}