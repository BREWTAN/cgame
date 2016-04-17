package starstart.cgw.gamectrl.scala.np

import java.text.SimpleDateFormat
import java.util.Date
import scala.collection.JavaConversions._
import com.github.nscala_time.time.Imports._
import onight.act.ordbgens.act.pbo.Act.PBCommand
import onight.act.ordbgens.act.pbo.Act.PBIFundTrans
import onight.act.ordbgens.act.pbo.Act.PBModule
import onight.oapi.scala.traits.OLog
import onight.tfg.ordbgens.tlt.entity.TLTCoreWin
import onight.tfg.ordbgens.tlt.entity.TLTCoreWinExample
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import onight.tfw.otransio.api.beans.FixHeader
import onight.tfw.otransio.api.beans.FramePacket
import onight.tfw.outils.serialize.SerializerFactory
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfw.otransio.api.IPacketSender
import onight.tfw.otransio.api.PSenderService
import starstart.cgw.scala.service.Sender
import onight.tfw.async.CallBack

object P012_MoneyDispatch extends OProcessor with OLog {

  def sendActFund(win: TLTCoreWin) = {

    val fp = new FramePacket();
    val fh = new FixHeader();
    fh.setCmd(PBCommand.ADD.name());
    fh.setModule(PBModule.ACT.name());
    fh.setPrio(0);
    fh.setVer('V');
    fh.setSync(true);
    fh.setEnctype(SerializerFactory.SERIALIZER_PROTOBUF);
    fp.setFixHead(fh);

    val sdf = new SimpleDateFormat("yyyyMMdd");

    val pack = PBIFundTrans.newBuilder()
    pack.setAmt(win.getAwardMoney.doubleValue())
    pack.setTxSno(win.getWinNo)
    pack.setCnt(win.getWinNum.intValue())
    pack.setBizDtlType("WIN_AWARD")
    pack.setBizType("CGAME")
    pack.setConsDate(sdf.format(win.getCreateDate))
    pack.setCreateTime(System.currentTimeMillis())
    pack.setExtCommets(win.getWinPattern)
    pack.setFromFundNo("S0001")
    pack.setRelatedTransId(win.getBetNo)
    pack.setSettDate(sdf.format(win.getCreateDate))
    pack.setSubTransCode("AUTO")
    pack.setToFundNo("b" + win.getUserId)
    pack.setTransCode("AWARD")
    fp.setFbody(pack)

    val cb = new CallBack[FramePacket]() {
      def onSuccess(v: FramePacket) {
        log.debug("send OK:" + v); //update db
        val example = new TLTCoreWinExample
        example.createCriteria().andWinNoEqualTo(win.getWinNo).andStatusEqualTo("1")
        val up = new TLTCoreWin()
        up.setWinNo(win.getWinNo)
        up.setStatus("2")
        Mysqls.corewinDAO.updateByPrimaryKey(up);
      }
    }
    Sender.ps.send(fp, cb)

    //    forwordpack.setBody(proxypack.getJsbody.getBytes)

  }
  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)

    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)
    //算奖
    var finished = false;
    var offset = 0
    val limit = 1000;
    var wincount = 0;
    var betwincount = 0;
    do {
      val example = new TLTCoreWinExample
      example.createCriteria().andIssueNoEqualTo(issue.getIssueNo).andLtypeEqualTo(issue.getLtype)
      example.setOffset(offset)
      example.setLimit(limit)
      val res = Mysqls.corewinDAO.selectByExample(example);
      log.debug("proc--selectCount==" + res.size())
      res.map { v =>
        val win = v.asInstanceOf[TLTCoreWin]
        log.debug("recharge to users funds")
        sendActFund(win)
      }
      if (res.size() < limit) finished = true;
      offset += limit
    } while (!finished)
    log.info("派奖：" + "Ltype=" + issue.getLtype + ",期号:" + issue.getIssueNo
      + ",共有[" + betwincount + "]条中奖投注，产生[" + wincount + "]条中奖记录")

    return 1;
  }

}