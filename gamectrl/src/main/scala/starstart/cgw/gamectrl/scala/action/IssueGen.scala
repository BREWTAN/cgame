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
        val rec = pbBeanUtil.copyFromPB(x, new TLTIssue());
        rec.setCreateTime(new Date());
        rec
      }
      Mysqls.issuesDAO.batchInsert(records);
    } catch {
      case e1: JPADuplicateIDException =>
        {
          try {
            if ("1".equals(pbo.getOverrideExists)) {
              Mysqls.issuesDAO.doInTransaction(new TransactionExecutor {
                def doInTransaction: Object = {
                  records.map { x =>
                    Mysqls.issuesDAO.deleteByPrimaryKey(new TLTIssueKey(x.getIssueId))
                  }
                  Mysqls.issuesDAO.batchInsert(records);
                  return "";
                }
              })
            } else { //不覆盖
              Mysqls.issuesDAO.doInTransaction(new TransactionExecutor {
                def doInTransaction: Object = {
                  records.map { x =>
                    if (Mysqls.issuesDAO.selectByPrimaryKey(new TLTIssueKey(x.getIssueId)) == null) {
                      Mysqls.issuesDAO.insertSelective(x);
                    }
                  }

                  return "";
                }
              })
            }
          } catch {
            case e: Throwable =>
              log.warn("inser error:", e); ret.setRetcode("0002").setRetmsg("期号重复:" + e1);ret.clearIssues()
              

          }

        }
      case e: Throwable =>
        log.warn("insert Issue ERRO:", e);
        ret.setRetcode("0001").setRetmsg(e.getMessage.replaceAll("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry ", "").replaceAll("for key 'DDD'", ""))
    }
    handler.onFinished(PacketHelper.toPBReturn(pack, ret.build()));

  }
}