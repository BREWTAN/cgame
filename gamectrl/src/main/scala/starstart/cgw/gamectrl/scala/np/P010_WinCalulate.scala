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
import com.github.nscala_time.time.Imports._
import scala.collection.JavaConversions._
import starstart.cgw.scala.ssc.BetsCalc
import onight.tfg.ordbgens.tlt.entity.TLTCoreBet
import onight.tfg.ordbgens.tlt.entity.TLTCoreWin
import org.springframework.beans.BeanUtils
import scala.collection.mutable.ListBuffer
import onight.tfw.ojpa.api.exception.JPADuplicateIDException
import onight.tfg.ordbgens.tlt.entity.TLTCoreDefPrize
import onight.tfg.ordbgens.tlt.entity.TLTCoreDefPrizeExample
import java.math.BigDecimal
import onight.tfg.ordbgens.tlt.entity.TLTCoreUseridPrize
import onight.tfg.ordbgens.tlt.entity.TLTCoreUseridPrizeExample
import java.util.HashMap

object P010_WinCalculate extends OProcessor with OLog {

  def insertOrUpdateBatch(buffer: List[TLTCoreWin]) {
    try {
      Mysqls.corewinDAO.batchInsert(buffer.toList)
    } catch {
      case e: JPADuplicateIDException =>
        log.warn("找到重复的算奖记录，先删除后覆盖")
        try {
          Mysqls.corewinDAO.batchDelete(buffer.toList)
          Mysqls.corewinDAO.batchInsert(buffer.toList);
        } catch {
          case e: Exception =>
            log.warn("重复算奖出现未知错误", e);
            throw e;
        }
      case e: Exception =>
        log.warn("算奖出现未知错误", e);
        throw e;
    }
  }

  val prizemap: HashMap[String, TLTCoreDefPrize] = new HashMap[String, TLTCoreDefPrize];

  val userPrizemap: HashMap[String, TLTCoreUseridPrize] = new HashMap[String, TLTCoreUseridPrize];

  def loadDefaultPrizeInfo(ltype: String) = {
    val example = new TLTCoreDefPrizeExample
    example.createCriteria().andLtypeEqualTo(ltype);
    val ret = Mysqls.coredefprizeDAO.selectByExample(example).map { x =>
      val defp = x.asInstanceOf[TLTCoreDefPrize];
      log.debug("获取奖等信息：" + defp.getCatalog + "_" + defp.getLtype + "_" + defp.getPlayType + "_" + defp.getWinLevel + "::" + prizemap.size())
      prizemap.put(defp.getCatalog + "_" + defp.getLtype + "_" + defp.getPlayType + "_" + defp.getWinLevel, defp);
      defp.getUuid
    }

    log.info("共找到奖等表:[" + prizemap.size + "]个:" + ret.size)

  }
  def loadUserPrizeInfo(ltype: String) = {
    val example = new TLTCoreUseridPrizeExample
    example.createCriteria().andLtypeEqualTo(ltype);
    val ret = Mysqls.coreuseridprizeDAO.selectByExample(example).map { x =>
      val defp = x.asInstanceOf[TLTCoreUseridPrize];
      userPrizemap.put(defp.getLtype + "_" + defp.getUserId, defp);
      defp.getUuid

    }
    log.info("共找到用户定义特殊奖等表:[" + prizemap.size + "]个:" + ret.size)

  }

  def getWinAmountAndBonus(win: TLTCoreWin): (Double, Double) = {
    userPrizemap.get(win.getLtype + "_" + win.getUserId) match {
      case defp if defp != null =>
        return getCatalogWinAmountAndBonus(defp.getCatalog, win)
      case null =>
        getCatalogWinAmountAndBonus("*", win)
    }
  }
  def getCatalogWinAmountAndBonus(cata: String, win: TLTCoreWin): (Double, Double) = {
    prizemap.get(cata + "_" + win.getLtype + "_" + win.getPlayType + "_" + win.getWinLevel) match {
      case defp if defp != null =>
        return (defp.getWinAmount().doubleValue() * win.getWinNum,
          (defp.getBonusAmount() match {
            case null => 0.0
            case b if b != null => b.doubleValue()
          }) * win.getWinNum)
      case null =>
        log.warn("未找到对应的奖等：" + win);
        (0.0, 0.0)
    }
  }

  def getMoneyFromUnit(unit: Int): Double = {
    if (unit == 2) return 0.1;
    if (unit == 3) return 0.01;
    if (unit == 4) return 0.001;
    return 1.0;

  }
  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)
    //算奖
    var finished = false;
    var offset = 0
    val limit = 1000;
    val buffer = ListBuffer[TLTCoreWin]()
    var wincount = 0;
    loadUserPrizeInfo(issue.getLtype)
    loadDefaultPrizeInfo(issue.getLtype)
    var betwincount = 0;
    do {
      val example = new TLTCoreBetExample
      example.createCriteria().andIssueNoEqualTo(issue.getIssueNo).andLtypeEqualTo(issue.getLtype)
      example.setOffset(offset)
      example.setLimit(limit)
      val res = Mysqls.corebetDAO.selectByExample(example);
      log.debug("proc--selectCount==" + res.size())
      res.foreach { v =>
        val bet = v.asInstanceOf[TLTCoreBet]

        val winno = BetsCalc.calc(bet.getBetOrgContent, bet.getPlayType, issue.getLotteryNo)
        var i = 0;
        if (winno.size > 0) {
          betwincount = betwincount + 1
        }
        winno.map { f =>
          val corewin = new TLTCoreWin;
          BeanUtils.copyProperties(bet, corewin);
          i = i + 1
          wincount = wincount + 1;
          corewin.setWinNo(bet.getBetNo + "-" + i)
          corewin.setWinLevel("" + f._2)
          corewin.setWinPattern(bet.getBetOrgContent + "::" + f._1)
          corewin.setWinType("1")
          corewin.setWinNum(bet.getBetMulti.toLong)
          corewin.setSumDivisionType(bet.getBetMulti)
          val winmoney = getWinAmountAndBonus(corewin);
          if (winmoney._1 > 0) {
            corewin.setAwardMoney(new BigDecimal(winmoney._1 * getMoneyFromUnit(bet.getBetMoneyUnit)))
            corewin.setStatus("1");
          } else { //未找到奖金的，返奖失败
            corewin.setStatus("0");
          }
          if (winmoney._1 > 0.0) {
            corewin.setBonusMoney(new BigDecimal(winmoney._2 * getMoneyFromUnit(bet.getBetMoneyUnit)));
          } else {
            corewin.setBonusMoney(new BigDecimal(0.0))
          }

          buffer.+=:(corewin)
          log.debug("bet==" + bet.getBetOrgContent + ",lotterno=" + issue.getLotteryNo + ",winno=" + winno + ",money=" + corewin.getAwardMoney)
        }
        if (buffer.size >= limit) {
          insertOrUpdateBatch(buffer.toList)
          buffer.clear();
        }
      }
      if (res.size() < limit) finished = true;
      offset += limit
    } while (!finished)
    if (buffer.size >= 0) {
      insertOrUpdateBatch(buffer.toList)
      buffer.clear();
    }
    log.info("算奖：" + "Ltype=" + issue.getLtype + ",期号:" + issue.getIssueNo
      + ",共有[" + betwincount + "]条中奖投注，产生[" + wincount + "]条中奖记录")

    return 1;
  }

}