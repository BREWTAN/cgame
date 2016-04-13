package starstart.cgw.scala.ssc

import scala.collection.mutable.ListBuffer

trait Slicer {
  def splitArr(bcArr: List[List[String]]): List[String];
  val LINE_SEP = ","
  val BALL_SEP = "\\|"
  val Zt3 = for { i <- 0 to 999 } yield "%03d".format(i)
  val Zt2 = for { i <- 0 to 99 } yield "%02d".format(i)

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
      if (x.length() > 0 && str2.trim().contains(x)) return true;
    }
    return false;
  }
  def isNotDuplStr(str1: String, str2: String): Boolean = {
    if (isDuplStr(str1, str2)) return false;
    return true;
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

  def split五星组选120(bc: String): List[String] = {
    toLists(bc)(0).flatten.combinations(5).toList.map { x => x.mkString("") }
  }
  def split四星组选24(bc: String): List[String] = {
    toLists(bc)(0).flatten.combinations(4).toList.map { x => x.mkString("") }
  }

  def split四星组选6(bc: String): List[String] = {
    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
  }

  def split三星组3(bc: String): List[String] = {
    //    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
    val bcarr = toLists(bc)
    val com2 = bcarr(0).combinations(2)
    com2.map { x =>
      List(x(0) + x(0) + x(1), x(0) + x(1) + x(0), x(1) + x(0) + x(0), x(1) + x(1) + x(0), x(1) + x(0) + x(1), x(0) + x(1) + x(1))
    }.flatten.toList

  }
  def split二星组选复式(bc: String): List[String] = {
    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
  }

  def split三星一码不定位(bc: String): List[String] = {
    //    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
    val bcarr = toLists(bc)
    val com2 = bcarr(0).combinations(1)
    com2.map { x =>
      List("*" + x(0) + "*", "**" + x(0), x(0) + "**")
    }.flatten.toList

  }

  def split三星二码不定位(bc: String): List[String] = {
    //    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
    val bcarr = toLists(bc)
    val com2 = bcarr(0).combinations(2)
    com2.map { x =>
      List("*" + x(0) + x(1), "*" + x(1) + x(0),
        x(0) + x(1) + "*", x(1) + x(0) + "*",
        x(0) + "*" + x(1), x(1) + "*" + x(0))
    }.flatten.toList

  }
  def split三星组6(bc: String): List[String] = {
    //    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
    val bcarr = toLists(bc)
    bcarr(0).permutations.map { p => p.mkString("") }.toList
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
        //        println("x:" + x + ":" + isNotDuplStr(x(0), x(1)))
        isNotDuplStr(x(0), x(1))
      }).map(_.mkString(""));
  }

  def split(bc: String, line0Count: Int, line1Count: Int): List[String] = {
    val bcarr = toLists(bc)
    val v = for {
      c <- SL_zuxuan.splitZuxuan(bcarr, 0, line0Count)
      d <- SL_zuxuan.splitZuxuan(bcarr, 1, line1Count)
    } yield List(c, d)
    v.filter(x =>
      {
        //println("x:" + x + ":" + isNotDuplStr(x(0), x(1)))
        isNotDuplStr(x(0), x(1))
      }).map(_.mkString(""));
  }
  def split五星组选60(bc: String): List[String] = {
    split(bc, 1, 3);
  }
  def split五星组选30(bc: String): List[String] = {
    split(bc, 2, 1);
  }
  def split五星组选20(bc: String): List[String] = {
    split(bc, 1, 2);
  }
  def split五星组选10(bc: String): List[String] = {
    split(bc, 1, 1);
  }
  def split五星组选5(bc: String): List[String] = {
    split(bc, 1, 1);
  }

  def split四星组选12(bc: String): List[String] = {
    split(bc, 1, 2);
  }
  def split四星组选4(bc: String): List[String] = {
    split(bc, 1, 1);
  }
}

object SL_hezhi extends Slicer { //120组选，如：投注方案：02568，开奖号码的5个数字必须包含02568（例如：08526），顺序不限，即可中五星组选120。
  def split直选和值(bc: String, ncount: Int): List[String] = {
    val bcarr = toLists(bc)
    //    bcarr(0).map { h =>
    //      val p = for (i <- 0 to Math.min(9, Integer.parseInt(h))) yield i
    //
    //      val vp = p.combinations(3).map { v =>
    //        val vl = v.toList.permutations.toList.filter { x =>
    //
    //          val v = x.foldLeft(0)((B, A) => B + A)
    ////          println("permu:" + x + ":v=" + v+"::eq="+(bcarr(0).filter { _.equals(v + "") }.isEmpty))
    //          !(bcarr(0).filter { _.equals(v + "") }.isEmpty)
    //        }
    //        println("vl=" + vl.filter { _.length>0 }.map { _.mkString("")})
    //        vl.map {  _.mkString("") }
    //      }.filter { x => x.length>0 }.toList.flatten
    //
    //      println(vp.size + ":vp=" + vp)
    //    }

    Zt3.filter { x =>
      val v = x.toList.foldLeft(0)((B, A) => B + Integer.parseInt(A + ""))
      !bcarr(0).filter { _.equals(v + "") }.isEmpty
    }.toList

  }

  def split三星直选和值(bc: String): List[String] = {
    split直选和值(bc, 3)
  }

  def split二星直选和值(bc: String): List[String] = {
    Zt2.filter { x =>
      val v = x.toList.foldLeft(0)((B, A) => B + Integer.parseInt(A + ""))
      !toLists(bc)(0).filter { _.equals(v + "") }.isEmpty
    }.toList
  }

  def splitArr(bcarr: List[List[String]]): List[String] = {
    return List();
  }
}

object SL_定位胆 extends Slicer { //120组选，如：投注方案：02568，开奖号码的5个数字必须包含02568（例如：08526），顺序不限，即可中五星组选120。
  def splitArr(bcArr: List[List[String]]): List[String] = {
    List(bcArr(0).map(_ + "****"),
      bcArr(1).map("*" + _ + "***"),
      bcArr(2).map("**" + _ + "**"),
      bcArr(3).map("***" + _ + "*"),
      bcArr(4).map("****" + _)).flatten
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
        P(SL_zuhe.split("1,2,3,4,5|2"))
    //    P(SL_zuxuan.split("1|2|3|4|5|6|0"))
    //    P(SL_Doublezuxuan.split五星组选60("1|2,1|2|3|4,,,")); //
    //    P(SL_Doublezuxuan.split五星组选30("0|1|2|3,0|1|2|3,,,"));
    //    P(SL_Doublezuxuan.split五星组选20("0|1|2|3,0|1|2|3,,,"));
    //    P(SL_Doublezuxuan.split五星组选10("0|1|2|3,0|1|2|3,,,"));
    //    P(SL_Doublezuxuan.split五星组选5("0|1|2|3,0|1|2|3,,,"));

    //     P(SL_fushi.split("1|2,2,3,4")) //四星复式
    //      P(SL_zuhe.split("1,2,3,4|2,"))//四星组合
    //      P(SL_zuxuan.split四星组选24("1|2|3|4|5|6|0"))//四星组选
    //    P(SL_Doublezuxuan.split四星组选12("0|1|2|3,0|1|2|3,,,"));
    //    P(SL_zuxuan.split四星组选6("0|1|2|3,0|1|2|3,,,"));
    //    P(SL_Doublezuxuan.split四星组选4("0|1|2|3,0|1|2|3,,,"));

    //    P(SL_fushi.split("1|2,2,3,,")) //三码复式
    //    P(SL_zuhe.split("1,2,3|4,,")) //三星组合
    //    P(SL_hezhi.split3直选和值("12"))
    //    P(SL_zuxuan.split三星组3("0|1,,,,")) //三星组3
    //    P(SL_zuxuan.split三星组3("0|1|2,,,,")) //三星组3
    //    P(SL_zuxuan.split三星组6("0|1|2,,,,")) //三星组3
    //   P(SL_zuxuan.split三星一码不定位("0|1|2"))
    //   P(SL_zuxuan.split三星二码不定位("0|1|2"))

//    P(SL_fushi.split("1|2,2|4,,,")) //二星复式
//    P(SL_zuxuan.split二星组选复式("1|2|3|4|5|6|7|8|9|0,,,,")) //二星组选
//    P(SL_hezhi.split三星直选和值("12"))
//    P(SL_hezhi.split二星直选和值("12"))

//    P(SL_定位胆.split("0|1|2|3,,4,5,5"))
  }
}
