package starstart.cgw.scala.ssc

import scala.collection.mutable.ListBuffer

trait Calc {
  def calcArr(bcArr: List[List[String]])(implicit winno: String): List[String] = { List() }
  val LINE_SEP = ","
  val BALL_SEP = "\\|"
  val Zt3 = for { i <- 0 to 999 } yield "%03d".format(i)
  val Zt2 = for { i <- 0 to 99 } yield "%02d".format(i)

  def calc(bc: String)(implicit winno: String): List[String] = {
    calcArr(toLists(bc))
  }

  def toLists(bc: String): List[List[String]] = {
    val lines = bc.split(LINE_SEP);
    val line5s = for { i <- 0 to 5 } yield if (i < lines.length) lines(i) else "-";
    line5s.map { x =>
      //      println("line:"+x+"::"+x.calc("\\|").toList.size)
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
  def calc_直选复式(bc: String)(implicit winno: String): List[(String, Int)] = {
    val bcarr = toLists(bc)
    val r = for {
      i0 <- bcarr(0)
      i1 <- bcarr(1)
      i2 <- bcarr(2)
      i3 <- bcarr(3)
      i4 <- bcarr(4)
    } yield (i0 + i1 + i2 + i3 + i4, 0)
        println("r=" + r)
    r.filter { x => x._1.equals(winno) }
  }
  def calc_五星直选复式(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_直选复式(bc)(winno);
  }
  def calc_四星直选复式(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_直选复式(bc)(winno.substring(1) + "-").map(x => ("-" + x._1.substring(0, 4), x._2));
  }

  def calc_前三码复式(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_直选复式(bc)(winno.substring(0, 3) + "-" * 2).map(x => (x._1.substring(0, 3) + "-" * 2, x._2));
  }

  def calc_中三码复式(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_直选复式(bc)(winno.substring(1, 4) + "-" * 2).map(x => ("-" * 1 + x._1.substring(0, 3) + "-" * 1, x._2));
  }
  def calc_后三码复式(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_直选复式(bc)(winno.substring(2, 5) + "-" * 2).map(x => ("-" * 2 + x._1.substring(0, 3), x._2));
  }

  def calc_二码前二直选复式(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_直选复式(bc)(winno.substring(0, 2) + "-" * 3).map(x => (x._1.substring(0, 2) + "-" * 3, x._2));
  }
  def calc_二码后二直选复式(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_直选复式(bc)("-" * 3 + winno.substring(3, 5)).map(x => ("-" * 3 + x._1.substring(0, 2), x._2));
  }

  def calc_三码直选和值(bc: String)(implicit winno: String): List[(String, Int)] = {
    //    calc_直选复式(bc)(winno.substring(2, 5)+"-"*2).map(x => ("-" * 2 + x._1.substring(0, 3), x._2));
    val bcarr = toLists(bc)
    val totalnum = winno.toList.foldLeft(0)((B, A) => B + Integer.parseInt(A + "")) + ""
    //    println("totalnum=" + totalnum)
    bcarr(0).filter { x =>
      x.equals(totalnum)
    }.map { x => (x, 0) }
  }

  def calc_三码组选和值(bc: String)(implicit winno: String): List[(String, Int)] = {
    //    calc_直选复式(bc)(winno.substring(2, 5)+"-"*2).map(x => ("-" * 2 + x._1.substring(0, 3), x._2));
    val c0 = existCount(winno, winno.charAt(0))
    val c1 = existCount(winno, winno.charAt(1))
    val c2 = existCount(winno, winno.charAt(2))
    val winlevel = if (c0 == c1 && c1 == c2 && c0 == 1) 1 else if (c0 == 2 || c1 == 2 || c2 == 2) 3 else -1
    if (winlevel == -1) {
      return List();
    }
    val bcarr = toLists(bc)
    val totalnum = winno.toList.foldLeft(0)((B, A) => B + Integer.parseInt(A + "")) + ""
    //    println("totalnum=" + totalnum)
    bcarr(0).filter { x =>
      x.equals(totalnum)
    }.map { x => (x, 0) }
  }
  def calc_前三码直选和值(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码直选和值(bc)(winno.substring(0, 3))
  }
  def calc_中三码直选和值(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码直选和值(bc)(winno.substring(1, 4))
  }
  def calc_后三码直选和值(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码直选和值(bc)(winno.substring(2, 5))
  }

  def calc_前三码组选和值(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码组选和值(bc)(winno.substring(0, 3))
  }
  def calc_中三码组选和值(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码组选和值(bc)(winno.substring(1, 4))
  }
  def calc_后三码组选和值(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码组选和值(bc)(winno.substring(2, 5))
  }

  def calc_组合(bc: String)(implicit winno: String): List[(String, Int)] = {
    val bcarr = toLists(bc)
    val r = for {
      i0 <- bcarr(0)
      i1 <- bcarr(1)
      i2 <- bcarr(2)
      i3 <- bcarr(3)
      i4 <- bcarr(4)
    } yield List((i0 + i1 + i2 + i3 + i4, 0), (i1 + i2 + i3 + i4, 1), (i2 + i3 + i4, 2), (i3 + i4, 3), (i4, 3))
    r.flatten.filter { x => winno.endsWith(x._1) }.map(x =>
      ("-" * (5 - x._1.length()) + x._1, x._2))
  }

  def calc_五星组合(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_组合(bc)(winno)
  }
  def calc_四星组合(bc: String)(implicit winno: String): List[(String, Int)] = {
    val bcarr = toLists(bc)
    val r = for {
      i0 <- bcarr(0)
      i1 <- bcarr(1)
      i2 <- bcarr(2)
      i3 <- bcarr(3)
    } yield List((i0 + i1 + i2 + i3, 0), (i1 + i2 + i3, 1), (i2 + i3, 2), (i3, 3))
    r.flatten.filter { x => winno.endsWith(x._1) }.map(x =>
      ("-" * (5 - x._1.length()) + x._1, x._2))

    //    calc_组合(bc)(winno.substring(1) + "-").map(x => ("-" + x._1.substring(0, 4), x._2));
  }
  def calc_五星组选120(bc: String)(implicit winno: String): List[(String, Int)] = {
    val sortedwinno = winno.sorted;
    toLists(bc)(0).flatten.combinations(5).toList.map { x => (x.mkString(""), 0) }.filter { x =>
      sortedwinno.equals(x._1);
    }
  }

  def calc_四星组选24(bc: String)(implicit winno: String): List[(String, Int)] = {
    val sortedwinno = winno.substring(1).sorted;
    toLists(bc)(0).flatten.combinations(4).toList.map { x => (x.mkString(""), 0) }.filter { x =>
      //      println("xx="+x)
      sortedwinno.equals(x._1);
    }.map(x => ("-" + x._1, x._2))
  }

  def calc_三码组六(bc: String, l: Int)(implicit winno: String): List[(String, Int)] = {
    val sortedwinno = winno.substring(l, l + 3).sorted;
    toLists(bc)(0).flatten.combinations(3).toList.map { x => (x.mkString("").sorted, 0) }.filter { x =>
      //      println("xx="+x)
      sortedwinno.equals(x._1);
    }.map(x => ("-" * l + x._1 + "-" * (5 - l - 3), x._2))
  }

  def calc_组三(bc: String, l: Int)(implicit winno: String): List[(String, Int)] = {
    val subwinno = winno.substring(l, l + 3);
    toLists(bc)(0).flatten.combinations(2).toList.map { x => (x.mkString(""), 0) }.filter { x =>
      val c0 = existCount(subwinno, x._1.charAt(0))
      val c1 = existCount(subwinno, x._1.charAt(1))
      //      println("x=="+x+",c0="+c0+",c1="+c1)
      c0 > 0 && c1 > 0 && c0 + c1 == 3
    }.map(x => ("-" * l + x._1 + "*" + "-" * (5 - l - 3), x._2))
  }

  def calc_前三码组六(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码组六(bc, 0)(winno)
  }
  def calc_中三码组六(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码组六(bc, 1)(winno)
  }
  def calc_后三码组六(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_三码组六(bc, 2)(winno)
  }

  def calc_前三码组三(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_组三(bc, 0)(winno)
  }
  def calc_中三码组三(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_组三(bc, 1)(winno)
  }
  def calc_后三码组三(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_组三(bc, 2)(winno)
  }

  def existCount(winno: String, com: Char): Int = {
    var cc = 0
    for (i <- 0 to winno.length() - 1) if (winno(i).equals(com)) cc = cc + 1
    return cc;
  }

  def existCount(winno: String, com: String, compareV: Int): Boolean = {
    val v = com.toList.map { x =>
      existCount(winno, x)
    }.filter { x => x == compareV }

    v.length == com.length()
  }

  def calc_重号组选(bc: String, picnum0: Int, picnum1: Int, comnum0: Int, comnum1: Int)(implicit winno: String): List[(String, Int)] = {
    val bcarr = toLists(bc)
    val v = for {
      c <- SC_zuxuan.calcZuxuan(bcarr, 0, picnum0)
      d <- SC_zuxuan.calcZuxuan(bcarr, 1, picnum1)
    } yield List(c, d)
    v.filter(x =>
      {
        isNotDuplStr(x(0), x(1)) && existCount(winno, x(0), comnum0) && existCount(winno, x(1), comnum1)
      }).map(x => (x(0) + "*" + comnum0 + "/" + x(1) + "*" + comnum1, 0));
  }

  def calc_五星组选60(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_重号组选(bc, 1, 3, 2, 1)(winno)
  }

  def calc_五星组选30(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_重号组选(bc, 2, 1, 2, 1)(winno)
  }
  def calc_五星组选20(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_重号组选(bc, 1, 2, 3, 1)(winno)
  }

  def calc_五星组选10(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_重号组选(bc, 1, 1, 3, 2)(winno)
  }
  def calc_五星组选5(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_重号组选(bc, 1, 1, 4, 1)(winno)
  }

  def calc_四星组选12(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_重号组选(bc, 1, 2, 2, 1)(winno.substring(1))
  }
  def calc_四星组选6(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_重号组选(bc, 2, 0, 2, 0)(winno.substring(1))
  }
  def calc_四星组选4(bc: String)(implicit winno: String): List[(String, Int)] = {
    calc_重号组选(bc, 1, 1, 3, 1)(winno.substring(1))
  }
}

object SC_zuxuan extends Calc { //120组选，如：投注方案：02568，开奖号码的5个数字必须包含02568（例如：08526），顺序不限，即可中五星组选120。
  def calcZuxuan(bcarr: List[List[String]], lineNO: Int = 0, num: Int = 5): List[String] = {
    bcarr(lineNO).flatten.combinations(num).toList.map { x => x.mkString("") }
  }

  def calc五星组选120(bc: String): List[String] = {
    toLists(bc)(0).flatten.combinations(5).toList.map { x => x.mkString("") }
  }
  def calc四星组选24(bc: String): List[String] = {
    toLists(bc)(0).flatten.combinations(4).toList.map { x => x.mkString("") }
  }

  def calc四星组选6(bc: String): List[String] = {
    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
  }

  def calc三星组3(bc: String): List[String] = {
    //    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
    val bcarr = toLists(bc)
    val com2 = bcarr(0).combinations(2)
    com2.map { x =>
      List(x(0) + x(0) + x(1), x(0) + x(1) + x(0), x(1) + x(0) + x(0), x(1) + x(1) + x(0), x(1) + x(0) + x(1), x(0) + x(1) + x(1))
    }.flatten.toList

  }
  def calc二星组选复式(bc: String): List[String] = {
    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
  }

  def calc三星一码不定位(bc: String): List[String] = {
    //    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
    val bcarr = toLists(bc)
    val com2 = bcarr(0).combinations(1)
    com2.map { x =>
      List("*" + x(0) + "*", "**" + x(0), x(0) + "**")
    }.flatten.toList

  }

  def calc三星二码不定位(bc: String): List[String] = {
    //    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
    val bcarr = toLists(bc)
    val com2 = bcarr(0).combinations(2)
    com2.map { x =>
      List("*" + x(0) + x(1), "*" + x(1) + x(0),
        x(0) + x(1) + "*", x(1) + x(0) + "*",
        x(0) + "*" + x(1), x(1) + "*" + x(0))
    }.flatten.toList

  }
  def calc三星组6(bc: String): List[String] = {
    //    toLists(bc)(0).flatten.combinations(2).toList.map { x => x.mkString("") }
    val bcarr = toLists(bc)
    bcarr(0).permutations.map { p => p.mkString("") }.toList
  }

  def calcArr(bcarr: List[List[String]]): List[String] = {
    calcZuxuan(bcarr)
  }
}

object SC_Doublezuxuan extends Calc { //120组选，如：投注方案：02568，开奖号码的5个数字必须包含02568（例如：08526），顺序不限，即可中五星组选120。
  def calcArr(bcarr: List[List[String]]): List[String] = {
    val v = for {
      c <- bcarr(0)
      d <- SC_zuxuan.calcZuxuan(bcarr, 1, 3)
    } yield List(c, d)
    v.filter(x =>
      {
        //        println("x:" + x + ":" + isNotDuplStr(x(0), x(1)))
        isNotDuplStr(x(0), x(1))
      }).map(_.mkString(""));
  }

  def calc(bc: String, line0Count: Int, line1Count: Int): List[String] = {
    val bcarr = toLists(bc)
    val v = for {
      c <- SC_zuxuan.calcZuxuan(bcarr, 0, line0Count)
      d <- SC_zuxuan.calcZuxuan(bcarr, 1, line1Count)
    } yield List(c, d)
    v.filter(x =>
      {
        //println("x:" + x + ":" + isNotDuplStr(x(0), x(1)))
        isNotDuplStr(x(0), x(1))
      }).map(_.mkString(""));
  }
  def calc五星组选60(bc: String): List[String] = {
    calc(bc, 1, 3);
  }
  def calc五星组选30(bc: String): List[String] = {
    calc(bc, 2, 1);
  }
  def calc五星组选20(bc: String): List[String] = {
    calc(bc, 1, 2);
  }
  def calc五星组选10(bc: String): List[String] = {
    calc(bc, 1, 1);
  }
  def calc五星组选5(bc: String): List[String] = {
    calc(bc, 1, 1);
  }

  def calc四星组选12(bc: String): List[String] = {
    calc(bc, 1, 2);
  }
  def calc四星组选4(bc: String): List[String] = {
    calc(bc, 1, 1);
  }
}

object SC_hezhi extends Calc { //120组选，如：投注方案：02568，开奖号码的5个数字必须包含02568（例如：08526），顺序不限，即可中五星组选120。
  def calc直选和值(bc: String, ncount: Int): List[String] = {
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

  def calc三星直选和值(bc: String): List[String] = {
    calc直选和值(bc, 3)
  }

  def calc二星直选和值(bc: String): List[String] = {
    Zt2.filter { x =>
      val v = x.toList.foldLeft(0)((B, A) => B + Integer.parseInt(A + ""))
      !toLists(bc)(0).filter { _.equals(v + "") }.isEmpty
    }.toList
  }

  def calcArr(bcarr: List[List[String]]): List[String] = {
    return List();
  }
}

object SC_定位胆 extends Calc { //120组选，如：投注方案：02568，开奖号码的5个数字必须包含02568（例如：08526），顺序不限，即可中五星组选120。
  def calcArr(bcArr: List[List[String]]): List[String] = {
    List(bcArr(0).map(_ + "****"),
      bcArr(1).map("*" + _ + "***"),
      bcArr(2).map("**" + _ + "**"),
      bcArr(3).map("***" + _ + "*"),
      bcArr(4).map("****" + _)).flatten
  }
}
object BetsCalc extends Calc {

  def calc(bc: String) = {

  }

  def P(lst: List[(String, Int)]) {
    println("::size=" + lst.size + ":" + lst)
  }

  def main(args: Array[String]): Unit = {
    val buff = ListBuffer[String]();
    implicit val winno = "01234"
    //    P(BetsCalc.calc_直选复式("0|1,1,2,3,4"))
    //        P(BetsCalc.calc_组合("0|1,1,2,3,4"))
    //        P(BetsCalc.calc_五星组选120("0|1|2|3|4|6"))
    //        P(BetsCalc.calc_五星组选60("0,1|2|3,")("03102"))
    //        P(BetsCalc.calc_五星组选30("0|1,4|2|3,")("03101"))
    //        P(BetsCalc.calc_五星组选20("8|1,4|2|0,")("80828"))
    //        P(BetsCalc.calc_五星组选10("0|8,4|2|3,")("82828"))
    //        P(BetsCalc.calc_五星组选5("8|1,4|2|3,")("88828"))
    //
    //    P(BetsCalc.calc_四星直选复式("0|1,2,3,4,")) //四星
    //    P(BetsCalc.calc_四星组合("1,2,3,4,"))
    //    P(BetsCalc.calc_四星组选24("0|1|2|3|4|6"))
    //    P(BetsCalc.calc_四星组选12("0,1|2|3,")("00102"))
    //    P(BetsCalc.calc_四星组选6("0|1|2|3,")("00202"))
    //    P(BetsCalc.calc_四星组选4("0,1|2|3,")("00100"))

    P(BetsCalc.calc_前三码复式("0|1,2,3,")("02345")) //
    P(BetsCalc.calc_中三码复式("0|1,2,3,")("40234")) //
    P(BetsCalc.calc_后三码复式("0|1,2,3,")("63023")) //
    P(BetsCalc.calc_前三码直选和值("9|18")("63023")) //
    P(BetsCalc.calc_中三码直选和值("9|18|5")("63023")) //
    P(BetsCalc.calc_后三码直选和值("9|18|5")("63023")) //

    println("==================")
    P(BetsCalc.calc_前三码组三("6|3|0")("63323")) //
    P(BetsCalc.calc_前三码组六("6|3|0|4")("63023")) //

    P(BetsCalc.calc_中三码组三("6|3|0")("63003")) //
    P(BetsCalc.calc_中三码组六("6|3|0|4")("63063")) //

    P(BetsCalc.calc_后三码组三("3|3|0")("63033")) //
    P(BetsCalc.calc_后三码组六("2|3|0|4")("63023")) //
    println("==================")

    P(BetsCalc.calc_前三码组选和值("9|18")("63023")) //
    P(BetsCalc.calc_中三码组选和值("9|18|5")("63113")) //
    P(BetsCalc.calc_后三码组选和值("9|18|5")("63023")) //
    P(BetsCalc.calc_后三码组选和值("9|18|9")("63333")) //
    println("==================")

    P(BetsCalc.calc_二码前二直选复式("0|1,2,")("02345")) //
    P(BetsCalc.calc_二码后二直选复式("0|3,2,")("63032")) //

    //    P(SC_fushi.calc("1|2,2,3,4,5"))
    //    P(SC_zuhe.calc("1,2,3,4,5|2"))
    //    P(SC_zuxuan.calc("1|2|3|4|5|6|0"))
    //    P(SC_Doublezuxuan.calc五星组选60("1|2,1|2|3|4,,,")); //
    //    P(SC_Doublezuxuan.calc五星组选30("0|1|2|3,0|1|2|3,,,"));
    //    P(SC_Doublezuxuan.calc五星组选20("0|1|2|3,0|1|2|3,,,"));
    //    P(SC_Doublezuxuan.calc五星组选10("0|1|2|3,0|1|2|3,,,"));
    //    P(SC_Doublezuxuan.calc五星组选5("0|1|2|3,0|1|2|3,,,"));

    //     P(SC_fushi.calc("1|2,2,3,4")) //四星复式
    //      P(SC_zuhe.calc("1,2,3,4|2,"))//四星组合
    //      P(SC_zuxuan.calc四星组选24("1|2|3|4|5|6|0"))//四星组选
    //    P(SC_Doublezuxuan.calc四星组选12("0|1|2|3,0|1|2|3,,,"));
    //    P(SC_zuxuan.calc四星组选6("0|1|2|3,0|1|2|3,,,"));
    //    P(SC_Doublezuxuan.calc四星组选4("0|1|2|3,0|1|2|3,,,"));

    //    P(SC_fushi.calc("1|2,2,3,,")) //三码复式
    //    P(SC_zuhe.calc("1,2,3|4,,")) //三星组合
    //    P(SC_hezhi.calc3直选和值("12"))
    //    P(SC_zuxuan.calc三星组3("0|1,,,,")) //三星组3
    //    P(SC_zuxuan.calc三星组3("0|1|2,,,,")) //三星组3
    //    P(SC_zuxuan.calc三星组6("0|1|2,,,,")) //三星组3
    //   P(SC_zuxuan.calc三星一码不定位("0|1|2"))
    //   P(SC_zuxuan.calc三星二码不定位("0|1|2"))

    //    P(SC_fushi.calc("1|2,2|4,,,")) //二星复式
    //    P(SC_zuxuan.calc二星组选复式("1|2|3|4|5|6|7|8|9|0,,,,")) //二星组选
    //    P(SC_hezhi.calc三星直选和值("12"))
    //    P(SC_hezhi.calc二星直选和值("12"))
    //
    //    P(SC_定位胆.calc("0|1|2|3,,4,5,5"))
  }
}
