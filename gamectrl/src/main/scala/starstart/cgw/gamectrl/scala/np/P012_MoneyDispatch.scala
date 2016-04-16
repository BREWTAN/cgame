package starstart.cgw.gamectrl.scala.np

import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.oapi.scala.traits.OLog
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueStepsExample
import starstart.cgw.gamectrl.scala.flow.NodeProcessor
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import com.github.nscala_time.time.Imports._
import java.util.Date
import onight.tfg.ordbgens.tlt.entity.TLTCoreBetExample
import starstart.cgw.scala.ssc.BetsCalc
import onight.tfg.ordbgens.tlt.entity.TLTCoreWin
import onight.tfg.ordbgens.tlt.entity.TLTCoreBet
import scala.collection.mutable.ListBuffer
import org.springframework.beans.BeanUtils
import scala.collection.JavaConversions._
import onight.tfg.ordbgens.tlt.entity.TLTCoreWinExample
import onight.tfw.otransio.api.beans.FixHeader
import onight.tfw.otransio.api.beans.FramePacket

object P012_MoneyDispatch extends OProcessor with OLog {

  
  def sendActFund() = {

    val forwordpack = new FramePacket();
    val fh = new FixHeader();
//    fh.setCmd(onight.act.ordbgens.act.pbo.);
    fh.setModule(proxypack.getGcmd.substring(3, 6));
    fh.setPrio(0);
    fh.setVer('V');
    fh.setSync(true);
    fh.setEnctype(SerializerFactory.SERIALIZER_JSON);
    forwordpack.setFixHead(fh);
    forwordpack.getExtHead.appendFrom(proxypack.getExts.getBytes)
    forwordpack.getExtHead().getHiddenkvs.putAll(pack.getExtHead.getHiddenkvs);
    forwordpack.getExtHead().getIgnorekvs.putAll(pack.getExtHead.getIgnorekvs);

    forwordpack.setBody(proxypack.getJsbody.getBytes)

    
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
       
      }
      if (res.size() < limit) finished = true;
      offset += limit
    } while (!finished)
    log.info("派奖：" + "Ltype=" + issue.getLtype + ",期号:" + issue.getIssueNo
      + ",共有[" + betwincount + "]条中奖投注，产生[" + wincount + "]条中奖记录")

      
    return 1;
  }

}