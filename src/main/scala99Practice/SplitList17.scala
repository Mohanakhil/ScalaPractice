import scala.annotation.tailrec

object SplitList17
{
  val split: (List[Int],Int)=>(List[Int],List[Int]) = (list:List[Int],n:Int)=>{
    @tailrec
    def splitList(list:List[Int], acc:(List[Int],List[Int]), counter:Int):(List[Int],List[Int])={
      if (counter >= n||list.isEmpty) {
        acc
      } else {
        splitList(list.tail, (acc._1 :+ list.head, list.tail), counter + 1)
      }
    }
    splitList(list,(List(),List()),0)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6,7,8,9,10,11,12,13,14)
      val n:Int=2
    println(split(list,n))

    val firstList:List[Int]=List()
    val secondList:List[Int]=List()
    println(list.foldLeft((firstList,secondList,0))((acc,ele)=>{
      if (acc._3 >= n) {
        (acc._1,acc._2:+ele, acc._3 + 1)
      }
      else {
        (acc._1:+ele,acc._2, acc._3 + 1)
      }
    }))

  }
}
