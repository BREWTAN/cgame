package starstart.cgw.scala.ssc

import scala.collection.mutable.ListBuffer

trait Slicer {
  def splitArr(bcArr: List[List[String]], buff: ListBuffer[String]);
  val LINE_SEP = ","
  val BALL_SEP = "|"

  def split(bc: String, buff: ListBuffer[String]) = {
    splitArr(toLists(bc), buff);
  }

  def toLists(bc: String): List[List[String]] = {
    bc.split(LINE_SEP).map { _.split(BALL_SEP).toList }.toList
  }
}
object SL_fushi extends Slicer { //五星组合，四星组合
  def splitArr(bcArr: List[List[String]], buff: ListBuffer[String]) = {
    val cc = bcArr.combinations(5)

    println("cc:" + cc)
  }
}
object SL_zuhe extends Slicer { //五星组合，四星组合
  def splitArr(bcArr: List[List[String]], buff: ListBuffer[String]) = {

  }
}
object BetsSplitter {

  def split(bc: String) = {

  }

  def main(args: Array[String]): Unit = {
    val buff = ListBuffer[String]();
    SL_fushi.split("1,2,3,4,5", buff)
  }
}
