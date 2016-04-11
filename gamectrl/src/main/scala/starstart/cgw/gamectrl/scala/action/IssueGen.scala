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
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueGen
import starstart.cgw.gamectrl.scala.service.IssueGenerator_CQSSC
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfw.ojpa.api.exception.JPADuplicateIDException
import org.apache.commons.lang3.StringUtils
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample
import onight.tfw.ojpa.api.TransactionExecutor
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBRetIssueGen
import onight.tfg.ordbgens.tlt.entity.TLTIssueKey

@NActorProvider
object IssueGen extends SessionModules[PBIssueGen] {
  override def service = IssueGensService
}

// http://localhost:8081/cgc/pbisg.do?fh=VISGCGC000000J00&bd={"ltype":"CQSSC","days":["20160401","20160402"],"limit":1}
object IssueGensService extends OLog with PBUtils with LService[PBIssueGen] {

  override def cmd: String = PBCommand.ISG.name();

  def onPBPacket(pack: FramePacket, pbo: PBIssueGen, handler: CompleteHandler) = {
    //    log.debug("guava==" + VMDaos.guCache.getIfPresent(pbo.getLogid()));      val ret = PBActRet.newBuilder();
    val ret = PBRetIssueGen.newBuilder();
    ret.setRetcode("0000").setRetmsg("ok").setRequest(pbo);

    var records: List[TLTIssue] = null;
    try {
      val pbrecords: List[PBIssue] = pbo.getLtype match {
        case "CQSSC" => {
          log.debug("生成时时彩奖期：")
          IssueGenerator_CQSSC.gen(pbo);
        }
        case ltype @ _ => {
          log.debug("unknow ltype:" + ltype)
          List[PBIssue]();
        }
      }
      records = pbrecords.map { x =>
        ret.addIssues(x);
        pbBeanUtil.copyFromPB(x, new TLTIssue());
      }
      Mysqls.issuesDAO.batchInsert(records);
    } catch {
      case e1: JPADuplicateIDException =>
        {
          try {
            Mysqls.issuesDAO.doInTransaction(new TransactionExecutor {
              def doInTransaction: Object = {
                records.map { x =>
                  Mysqls.issuesDAO.deleteByPrimaryKey(new TLTIssueKey(x.getIssueId))
                }
                Mysqls.issuesDAO.batchInsert(records);
                return "";
              }
            })
          } catch {
            case e: Throwable => log.warn("inser error:", e); ret.setRetcode("0002").setRetmsg("期号重复:" + e1)
          }

        }
      case e: Throwable =>
        log.warn("insert Issue ERRO:", e);
        ret.setRetcode("0001").setRetmsg(e.getMessage.replaceAll("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry ", "").replaceAll("for key 'DDD'", ""))
    }
    handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));

  }
}