package starstart.cgw.gamectrl.scala.action

import scala.collection.JavaConversions._
import onight.oapi.scala.commons.LService
import onight.oapi.scala.commons.PBUtils
import onight.oapi.scala.traits.OLog
import onight.osgi.annotation.NActorProvider
import onight.scala.commons.SessionModules
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssueKey
import onight.tfw.async.CompleteHandler
import onight.tfw.ojpa.api.TransactionExecutor
import onight.tfw.ojpa.api.exception.JPADuplicateIDException
import onight.tfw.otransio.api.PacketHelper
import onight.tfw.otransio.api.beans.FramePacket
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBCommand
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssue
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueGen
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBRetIssueGen
import starstart.cgw.gamectrl.scala.persist.Mysqls
import starstart.cgw.gamectrl.scala.service.IssueGenerator_CQSSC
import java.util.Date
import starstart.cgame.flows.nsttl.exception.SettleException
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueFetch
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBRetIssueFetch
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample

@NActorProvider
object IssueFetch extends SessionModules[PBIssueFetch] {
  override def service = IssueFetchService
}

// http://localhost:8081/cgc/pblst.do?fh=VLSTCGC000000J00&bd={"ltype":"CQSSC","issue_day":"20160413","limit":10}
//  http://localhost:8081/cgc/pblst.do?fh=VLSTCGC000000J00&bd={"ltype":"CQSSC","issue_day":"20160413","limit":10,"showall":1}

object IssueFetchService extends OLog with PBUtils with LService[PBIssueFetch] {

  override def cmd: String = PBCommand.LST.name();

  def onPBPacket(pack: FramePacket, pbo: PBIssueFetch, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBRetIssueFetch.newBuilder();
    ret.setRetcode("0000").setRetmsg("ok");

    var records: List[TLTIssue] = null;
    try {

      val ex = new TLTIssueExample();

      val cri = ex.createCriteria().andIssueDateEqualTo(pbo.getIssueDay.replaceAll("-", "")).andLtypeEqualTo(pbo.getLtype);
      if (!pbo.getShowall) {
        cri.andSaleEtimeLessThan(new Date());
      }
      if (pbo.getLimit > 0) {
        ex.setLimit(pbo.getLimit)
      }
      ex.setOrderByClause("ISSUE_NO DESC")
      ex.setOffset(pbo.getOffset);

      Mysqls.issuesDAO.selectByExample(ex).map { _.asInstanceOf[TLTIssue] }.map { issue =>
        val builder = PBIssue.newBuilder();
        pbBeanUtil.toPB(builder, issue);
        ret.addIssues(builder.build())
      }
      
    } catch {
      case e: Throwable =>
        log.warn("get Issue ERRO:", e);
        ret.setRetcode("0001").setRetmsg(e.getMessage)
    }
    handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));

  }
}