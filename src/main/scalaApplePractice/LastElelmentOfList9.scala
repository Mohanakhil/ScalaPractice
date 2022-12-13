import scala.collection.mutable.ListBuffer

object LastElementOfList {
  def findLength(list: ListBuffer[Int]): Int = {
    var count: Int = 0
    list.foreach(
      _ => count = count + 1
    )
    count
  }

  def findLast(list: ListBuffer[Int]): Int = {
    val length: Int = findLength(list)
    list(length-1)
  }
  def main(Args:Array[String]): Unit ={
    val n:Int=scala.io.StdIn.readInt()
    val al:ListBuffer[Int]=ListBuffer[Int]()
    for(_ <- 0 until n) {
       al+=scala.io.StdIn.readInt()
    }
    println(al)
    println(findLast(al))
  }
}
