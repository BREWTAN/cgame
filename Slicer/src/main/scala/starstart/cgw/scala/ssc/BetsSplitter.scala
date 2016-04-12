package starstart.cgw.scala.ssc

import scala.collection.mutable.ListBuffer

trait Slicer {
  def splitArr(bcArr: List[List[String]]): List[String];
  val LINE_SEP = ","
  val BALL_SEP = "\\|"

  def split(bc: String): List[String] = {
    splitArr(toLists(bc))
  }

  def toLists(bc: String): List[List[String]] = {
    val lines = bc.split(LINE_SEP);
    val line5s = for { i <- 0 to 5 } yield if (i < lines.length) lines(i) else "-";
    line5s.map { x =>
      //      println("line:"+x+"::"+x.split("\\|").toList.size)
      x.split(BALL_SEP).toList
    }.toList
  }

  def isDuplStr(str1: String, str2: String): Boolean = {
    str1.split("").map { x =>
      if (str2.contains(x)) return false;
    }
    return true;
  }
  def isNotDuplStr(str1: String, str2: String): Boolean = {
    if (isDuplStr(str1, str2)) return true;
    return false;
  }
}
object SL_fushi extends Slicer { //五星复式，四星复式
  def splitArr(bcarr: List[List[String]]): List[String] = {
    for {
      i0 <- bcarr(0)
      i1 <- bcarr(1)
      i2 <- bcarr(2)
      i3 <- bcarr(3)
      i4 <- bcarr(4)
    } yield i0 + i1 + i2 + i3 + i4
  }
}
object SL_zuhe extends Slicer { //五星组合，四星组合
  def splitArr(bcarr: List[List[String]]): List[String] = {
    SL_fushi.splitArr(bcarr).map { x =>
      for {
        len <- 0 to x.length - 1
      } yield x.substring(len)
    }.flatten
  }
}

object SL_zuxuan extends Slicer { //120组选，如：投注方案：02568，开奖号码的5个数字必须包含02568（例如：08526），顺序不限，即可中五星组选120。
  def splitZuxuan(bcarr: List[List[String]], lineNO: Int = 0, num: Int = 5): List[String] = {
    bcarr(lineNO).flatten.combinations(num).toList.map { x => x.mkString("") }
  }

  def splitArr(bcarr: List[List[String]]): List[String] = {
    splitZuxuan(bcarr)
  }
}

object SL_Doublezuxuan extends Slicer { //120组选，如：投注方案：02568，开奖号码的5个数字必须包含02568（例如：08526），顺序不限，即可中五星组选120。
  def splitArr(bcarr: List[List[String]]): List[String] = {
    val v = for {
      c <- bcarr(0)
      d <- SL_zuxuan.splitZuxuan(bcarr, 1, 3)
    } yield List(c, d)
    v.filter(x =>
      {
        println("x:" + x + ":" + isNotDuplStr(x(0), x(1)))
        isNotDuplStr(x(0), x(1))
      }).map(_.mkString(""));
  }
}
object BetsSplitter {

  def split(bc: String) = {

  }

  def P(lst: List[String]) {
    println("::size=" + lst.size + ":" + lst)
  }

  def main(args: Array[String]): Unit = {
    val buff = ListBuffer[String]();
    //    P(SL_fushi.split("1|2,2,3,4,5"))
    //    P(SL_zuhe.split("1,2,3,4,5|2"))
    //    P(SL_zuxuan.split("1|2|3|4|5|6|0"))
    println(SL_Doublezuxuan.isNotDuplStr("0", "123"))
    P(SL_Doublezuxuan.split("0|1,1|2|3|4,,,"))
  }
}
