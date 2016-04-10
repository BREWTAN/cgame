package starstart.cgw.gamectrl.scala.service

import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssueGen
import java.text.SimpleDateFormat
import onight.oapi.scala.traits.OLog
import starstart.cgw.gamectrl.pbgens.Gamectrl.PBIssue
import java.util.Formatter.DateTime
import com.github.nscala_time.time.Imports._

import scala.collection.JavaConversions._

object IssueGenerator_CQSSC extends OLog {
  val DT_FORMAT = "yyyy-MM-dd HH:mm:ss"
  def gen(pbo: PBIssueGen): List[PBIssue] = {
    pbo.getDaysList.map { day => gen(pbo, day) }.toList.flatten
  }
  def gen(pbo: PBIssueGen, day: String): List[PBIssue] = {
    val dt_base = try {
      DateTimeFormat.forPattern("yyyyMMdd").parseDateTime(day);
    } catch {
      case _ => log.warn("生成奖期失败，日期有误:{}", day); return null;
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
        bd.setPreStime((dt_start - 10.seconds).toString(DT_FORMAT));
        bd.setPreEtime((dt_end - 30.seconds).toString(DT_FORMAT));
        bd.setSaleStime(dt_start.toString(DT_FORMAT));
        bd.setSaleEtime(dt_end.toString(DT_FORMAT));
        bd.setCancelLtime((dt_end - 30.seconds).toString(DT_FORMAT));
        bd.setIssueStatus("0");
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