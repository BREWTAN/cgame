package starstart.cgw.gamectrl.scala.np

import java.text.SimpleDateFormat
import java.util.Date
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.map.SerializationConfig
import com.github.nscala_time.time.Imports._
import onight.oapi.scala.traits.OLog
import onight.tfg.ordbgens.tlt.entity.TLTIssue
import onight.tfg.ordbgens.tlt.entity.TLTIssueSteps
import scalaj.http.Http
import scalaj.http.HttpResponse
import org.codehaus.jackson.map.DeserializationConfig.Feature
import org.codehaus.jackson.node.ObjectNode
import org.codehaus.jackson.node.ArrayNode
import org.codehaus.jackson.JsonNode
import starstart.cgw.gamectrl.pbgens.winno.Winnoctrl.Award163SSC
import onight.oapi.scala.commons.PBUtils
import onight.tfw.outils.bean.JsonPBUtil
import scala.collection.JavaConversions._
import org.apache.commons.lang3.StringUtils
import starstart.cgw.gamectrl.scala.persist.Mysqls
import onight.tfg.ordbgens.tlt.entity.TLTIssueExample
import onight.tfw.outils.serialize.UUIDGenerator

object P007_WinNumFetch extends OProcessor with OLog with PBUtils {

  val jsonmapper = new ObjectMapper();
  jsonmapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  jsonmapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
  jsonmapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);

  def getNode(parent: JsonNode, path: String, currentPath: String): JsonNode = {
    // Now, recursively invoke this method on all properties
    val it = parent.getFields
    if (path.indexOf(currentPath) < 0) {
      return null;
    }
    if (path.equals(currentPath)) {
      return parent;
    }
    while (it.hasNext()) {
      val child = it.next();
      val vpath = path.length() match {
        case 0 => child.getKey()
        case _ => path + "." + child.getKey()
      }
      //      println("path:" + vpath + ",idex=" + pathkey._1.indexOf(vpath))
      if (path.indexOf(vpath) >= 0) {
        if (child.getValue.isArray()) {
          val cit = child.getValue.asInstanceOf[ArrayNode].iterator()
          while (cit.hasNext()) {
            val cch = cit.next();
            if (cch.isInstanceOf[ObjectNode]) {
              return getNode(cch, path, vpath);
            }
          }
        } else {
          if (child.getValue.isInstanceOf[ObjectNode])
            return getNode(child.getValue, path, vpath);
        }

      }
    }

    return null;

  }

  def getpathkey(fullpath: String): (String, String) = {
    val idx = fullpath.lastIndexOf(".")
    if (idx < 0) return ("", fullpath);
    return (fullpath.substring(0, idx).trim(), fullpath.substring(idx + 1).trim());

  }

  def fetchFrom163His(issue: TLTIssue): String = {

    var winno = ""
    var times: Int = 0;
    val peroid163 = issue.getIssueNo.substring(2).replaceAll("-", "")
    val date163 = issue.getIssueNo.split("-")(0)

    do {
      val req = Http("http://caipiao.163.com/award/cqssc/" + date163 + ".html")
      val response: HttpResponse[String] = req.asString
      if (times > 0) {
        Thread.sleep(500);
      }
      val lines = response.body.split("\n");
      lines.map { line =>
        if (line.contains(peroid163)) {
          log.debug("163:Found PeroidLine:" + line)
          val array = line.split("'")
          if (array.length > 2) {
            winno = array(1);
            winno = winno.replaceAll(" ", "")
            log.debug("找到相同期号[163]:" + peroid163 + ",winno=" + winno)
          }
        }
      }
      times = times + 1;
    } while (winno.length() == 0 && times < 120)
    return winno;
  }

  def fetchFrom163(issue: TLTIssue): String = {
    var winno = ""
    var times: Int = 0;
    val peroid163 = issue.getIssueNo.substring(2).replaceAll("-", "")
    do {
      val req = Http("http://caipiao.163.com/award/getAwardNumberInfo.html?gameEn=ssc&cache=1460394588810&periodNum=" + times)
      val response: HttpResponse[String] = req.asString
      if (times > 0) {
        Thread.sleep(500);
      }
      val awards = Award163SSC.newBuilder();
      JsonPBUtil.json2PB(response.body, awards);
      awards.getAwardNumberInfoListList.map { award =>
        if (StringUtils.equalsIgnoreCase(peroid163, award.getPeriod)) {
          winno = award.getWinningNumber + ""
          winno = winno.replaceAll(" ", "")
          log.debug("找到相同期号[163]:" + award.getPeriod + ",winno=" + winno)
        }
      }
      times = times + 1;
    } while (winno.length() == 0 && times < 120)
    return winno;
  }
  def proc(issue: TLTIssue, issueStep: TLTIssueSteps, operator: String): Int = {
    val sdf = new SimpleDateFormat("yyyyMMdd");
    //    log.info("PS::" + issueStep.getGsChcode + ":" + issue.getIssueId + ",status=" + issue.getIssueStatus)
    val curDay = sdf.format(new Date());
    if (!StringUtils.isBlank(issue.getLotteryNo)&& StringUtils.isNumeric(issue.getLotteryNo)) {
      return 1;
    }

    val winno = if (issue.getIssueNo.contains(curDay)) fetchFrom163(issue) else fetchFrom163His(issue)

    if (winno.length() > 0 && StringUtils.isNumeric(winno)) {
      val up = new TLTIssue();
      up.setModifyTime(new Date());
      up.setLotteryNo(winno);
      val upex = new TLTIssueExample();
      upex.createCriteria().andIssueIdEqualTo(issue.getIssueId).andLotteryNoEqualTo(issue.getLotteryNo);
      Mysqls.issuesDAO.updateByExampleSelective(up, upex);
      log.info("找到期号开奖号码[163]:" + issue.getIssueNo + ",winno=" + winno)
      return 1;
    }
    log.info("开奖号码获取不正确[163]:" + issue.getIssueNo + ",winno=" + winno)
    return -1;
  }

  def main(args: Array[String]): Unit = {
    val issue = new TLTIssue();
    issue.setIssueNo("20160411-023")
    issue.setIssueId(UUIDGenerator.generate())
    issue.setPreStime(new Date());
    proc(issue, null, null);
  }

}