package starstart.cgw.gamectrl.scala.service

import java.util.Formatter.DateTime

import scala.collection.JavaConversions._

import org.apache.commons.lang3.StringUtils

import com.github.nscala_time.time.Imports._

import onight.oapi.scala.traits.OLog
import starstart.cgame.flows.nsttl.exception.SettleException
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssue
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueGen

object IssueGenerator_CQSSC extends OLog {
  val DT_FORMAT = "yyyy-MM-dd HH:mm:ss"
  def gen(pbo: PBIssueGen): List[PBIssue] = {
    pbo.getDaysList.map { day => gen(pbo, day) }.toList.flatten
  }
  def gen(pbo: PBIssueGen, day: String): List[PBIssue] = {
    val dt_base = try {
      DateTimeFormat.forPattern("yyyyMMdd").parseDateTime(day);
    } catch {
      case _: Throwable => log.warn("生成奖期失败，日期有误:{}", day); return null;
    }
    if (dt_base == null) {
      log.warn("生成奖期失败，日期有误:{}", day);
      throw new RuntimeException("生成奖期失败，日期有误:" + day);
    }

    val issues: List[PBIssue] = {
      val r = 1 to 120
      //      zipWithIndex.filter(_._2 > pbo.getOffset).filter(_._2 <= pbo.getLimit || pbo.getLimit == 0).map(_._1)
      r.filter { i => i > pbo.getOffset && (i <= pbo.getOffset + pbo.getLimit || pbo.getLimit == 0) }.map { step =>
        val issue_no = day + "-" + "%03d".format(step);
        val bd = PBIssue.newBuilder()
        bd.setIssueId(pbo.getLtype + "_" + issue_no)
        bd.setLtype(pbo.getLtype)
        bd.setIssueNo(issue_no)
        bd.setIssueDate(day);
        val dt_start_duration = (step - 1) match {
          case i if (i >= 0 && i <= 23) => (dt_base + (i * 5).minutes, 5)
          case i if (i > 23 && i <= 95) => (dt_base + ((i - 24) * 10).minutes + 10.hours, 10)
          case i if (i < 120) => (dt_base + ((i - 96) * 5).minutes + 22.hours, 5)
        }
        val dt_start = dt_start_duration._1
        val dt_end = dt_start_duration._1 + dt_start_duration._2.minutes;
        val preclose =
          if (StringUtils.isNoneBlank(pbo.getPrecOffsec) && StringUtils.isNumeric(pbo.getPrecOffsec.trim())) Integer.parseInt(pbo.getPrecOffsec) else 30
        val presale =
          if (StringUtils.isNoneBlank(pbo.getPresOffsec) && StringUtils.isNumeric(pbo.getPresOffsec.trim())) Integer.parseInt(pbo.getPresOffsec) else 20

        bd.setPreStime((dt_start - presale.seconds).toString(DT_FORMAT));
        bd.setPreEtime((dt_end - preclose.seconds).toString(DT_FORMAT));
        bd.setSaleStime(dt_start.toString(DT_FORMAT));
        bd.setSaleEtime(dt_end.toString(DT_FORMAT));
        bd.setCancelLtime((dt_end - preclose.seconds).toString(DT_FORMAT));
        bd.setIssueStatus("0");

        val prestime = pbo.getPreStimes.get(step+"");
        prestime match {
          case str: String =>
            val newtime = bd.getPreStime.split(" ")(0) + " " + str;
            val dt_base = try {
              DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime(newtime);
              bd.setPreStime(newtime);
            } catch {
              case _: Throwable =>
                log.warn("生成销售奖期["+bd.getIssueNo+"]失败，日期有误:" + newtime);
                throw new SettleException("生成销售奖期["+bd.getIssueNo+"]失败，时间有误:" + pbo.getPreStimes.get(step) + ",格式应为HH:mm:ss")
            }
          case a@_ => //log.debug("unknow pretime:" + a+": step= "+step)
        }

        bd.build()
      }.toList

    }

    return issues;
  }
  def main(args: Array[String]): Unit = {
    val b = PBIssueGen.newBuilder();
    b.addDays("20161224").addDays("20160302");
    b.setOffset(100).setLimit(5);
    val issues = gen(b.build());
    print(issues)
  }
}