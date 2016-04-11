package starstart.cgw.gamectrl.scala.action

import onight.oapi.scala.commons.LService
import onight.oapi.scala.commons.PBUtils
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.SessionModules
import onight.tfw.async.CompleteHandler
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBRetStepCtrl
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBStepCtrl
import starstart.cgw.gamectrl.scala.np.OProcessor
import starstart.cgw.gamectrl.scala.np.P001_InitStart
import starstart.cgw.gamectrl.scala.np.P002_PreSale
import starstart.cgw.gamectrl.scala.np.P003_OnSaleProcessor
import starstart.cgw.gamectrl.scala.np.P004_SalePause
import starstart.cgw.gamectrl.scala.np.P005_SaleEndProcessor
import starstart.cgw.gamectrl.scala.np.P006_WagerLock
import starstart.cgw.gamectrl.scala.np.P007_WinNumFetch
import starstart.cgw.gamectrl.scala.np.P008_WinOfficialBoardGet
import starstart.cgw.gamectrl.scala.np.P009_WinLocalBoardGet
import starstart.cgw.gamectrl.scala.np.P010_WinCalculate
import starstart.cgw.gamectrl.scala.np.P011_ReturnFailedMoney
import starstart.cgw.gamectrl.scala.np.P012_MoneyDispatch
import starstart.cgw.gamectrl.scala.np.P013_ProfitDispatch
import starstart.cgw.gamectrl.scala.np.P999_IssueEnd

@NActorProvider
object GS_Node extends SessionModules[PBStepCtrl] {
  override def service = GS_NodeService
}

// http://localhost:8081/cgc/pbisg.do?fh=VISGCGC000000J00&bd={"ltype":"CQSSC","days":["20160401","20160402"],"limit":1}
object GS_NodeService extends OLog with PBUtils with LService[PBStepCtrl] {

  override def cmd: String = "STP"; //重启时时彩
  val serviceByStep = Map[(String, String), OProcessor](
    ("CQSSC", "001") -> P001_InitStart,
    ("CQSSC", "002") -> P002_PreSale,
    ("CQSSC", "003") -> P003_OnSaleProcessor,
    ("CQSSC", "004") -> P004_SalePause,
    ("CQSSC", "005") -> P005_SaleEndProcessor,
    ("CQSSC", "006") -> P006_WagerLock,
    ("CQSSC", "007") -> P007_WinNumFetch,
    ("CQSSC", "008") -> P008_WinOfficialBoardGet,
    ("CQSSC", "009") -> P009_WinLocalBoardGet,
    ("CQSSC", "010") -> P010_WinCalculate,
    ("CQSSC", "011") -> P011_ReturnFailedMoney,
    ("CQSSC", "012") -> P012_MoneyDispatch,
    ("CQSSC", "013") -> P013_ProfitDispatch,
    ("CQSSC", "999") -> P999_IssueEnd //结束
    )

  def onPBPacket(pack: FramePacket, pbo: PBStepCtrl, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBRetStepCtrl.newBuilder();
    ret.setRetcode("0000").setRetmsg("ok")
    val op = serviceByStep.get((pbo.getLtype, pbo.getGsOrder)) match {
      case Some(op) =>
        val pret = op.checkAndProc(pbo.getLtype, pbo.getIssueNo, pbo.getIssueStepId, pbo.getStepOperator);
        log.debug("节点处理结果：", pret);
        ret.setBizcode("" + pret)
      case _ => log.warn("找不到对应的处理节点：" + pbo.getIssueStepId); ret.setRetcode("0001").setRetmsg("找不到对应的处理节点:" + pbo.getIssueStepId)
    }
    if (handler != null) {
      handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));
    }
  }
}