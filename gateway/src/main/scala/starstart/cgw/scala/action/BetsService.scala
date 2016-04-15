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
import starstart.cgw.scala.service.MysqlDaos
import java.util.Date
import starstart.cgw.pbgens.Cgw.PWTicker
import starstart.cgw.pbgens.Cgw.PWRetTicker
import onight.tfw.ojpa.api.TransactionExecutor
import onight.tfg.ordbgens.tlt.entity.TLTCoreTicket
import onight.tfw.ojpa.api.exception.JPADuplicateIDException
import org.springframework.beans.BeanUtils

@NActorProvider
object CGWBetActor extends SessionModules[PWTicker] {
  override def service = CGWBetService
}

object CGWBetService extends OLog with PBUtils with LService[PWTicker] {

  override def cmd: String = "BET";

  def onPBPacket(pack: FramePacket, pbo: PWTicker, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PWRetTicker.newBuilder();

    log.debug("getBug from IP:{},betscount={}", pack.getExtStrProp(PackHeader.PEER_IP), pbo.getBetsCount)
    ret.setRetcode("9999").setRetmsg("UNKNOW ERROR");

    val tick = pbBeanUtil.copyFromPB(pbo, new TLTCoreTicket)
    tick.setTickNo(MD5.getMD5("cwd_" + pbo.getVldcode));
    tick.setBetIp(pack.getExtStrProp(PackHeader.PEER_IP));
    tick.setTickStatus("1")
    if (pbo.getIsAuto) {
      tick.setIsAuto("1")
    } else {
      tick.setIsAuto("0")
    }
    tick.setBetDatetime(new Date())
    log.info("bets:count="+pbo.getBetsCount+",tickno="+tick.getTickNo+":issue="+tick.getIssueNo+":ltype="+tick.getLtype)
    val bets = pbo.getBetsList().map { bet =>
      val dbbet = pbBeanUtil.copyFromPB(bet, new TLTCoreBet)
      pbBeanUtil.copyFromPB(pbo, dbbet)
      BeanUtils.copyProperties(tick, dbbet);
      dbbet.setBetDatetime(new Date());
      dbbet.setBetOrgCounts(bet.getBetCounts)
      dbbet.setBetIp(pack.getExtStrProp(PackHeader.PEER_IP));
      dbbet.setBetNo(MD5.getMD5("cwd_" + bet.getVldcode))
      dbbet.setBetStatus("1")
      dbbet.setIsAuto("0")
      dbbet.setBetDatetime(new Date());
      val serialnum = MD5.getMD5(("starstart-ming:" + dbbet.getBetNo));
      dbbet.setSerialNum(serialnum)
      log.debug("batchInsert.betno=::"+dbbet.getBetNo)
      dbbet
    }
    
    try {

      MysqlDaos.corebetDAO.doInTransaction(new TransactionExecutor {
        def doInTransaction: Object = {
          log.debug("batchInsert::"+bets)
          MysqlDaos.corebetDAO.batchInsert(bets);
          MysqlDaos.coreticketDAO.insert(tick)
          return ""
        }
      })

      bets.map { dbbet =>
        val retbet = PWBetResult.newBuilder()
        retbet.setBetStatus("0000").setSerialNum(dbbet.getSerialNum).setVldcode(MD5.getMD5(DESCoder.desEncrypt(dbbet.getSerialNum, "zzzz-starstartsFFFF")))
        ret.addBetrets(retbet);
      }
      ret.setTickNo(tick.getTickNo);
      ret.setRetcode("0000").setRetmsg("ok");
    } catch {
      case e: JPADuplicateIDException =>
        log.warn("投注异常重复")
        ret.setRetcode("0003").setRetmsg("重复提交相同的投注单")
      case e: Exception =>
        log.error("投注异常", e)
        ret.setRetcode("0009").setRetmsg(e.getMessage)
    }
    handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
  }
}