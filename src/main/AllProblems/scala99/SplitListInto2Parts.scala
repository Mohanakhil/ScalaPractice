import scala.annotation.tailrec

object SplitListInto2Parts
{
  val splitList:(List[Int],Int)=>(List[Int],List[Int])=(list:List[Int],splitAt:Int)=>{
    val length:Int=list.length
    @tailrec
    def split(list:List[Int], acc:(List[Int],List[Int]), counter:Int):(List[Int],List[Int])={
      if(counter==length) acc
      else if(counter<splitAt) split(list.tail,(acc._1:::List(list.head),acc._2),counter+1)
      else split(list.tail,(acc._1,acc._2:::List(list.head)),counter)
    }
    split(list,(List(),List()),0)
  }
  def main(Args:Array[String]):Unit={
    val a:List[Int]=List(3,4,5,6,7,8,9)
    val splitAt=4

    println(splitList(a,splitAt))
    val firstList:List[Int]=List()
    val secondList:List[Int]=List()
    val counter:Int=0
    println(a.foldLeft((firstList,secondList),counter)((acc,ele)=>{
      if(acc._2<splitAt)((acc._1._1:::List(ele),acc._1._2),acc._2+1)
      else ((acc._1._1,acc._1._2:::List(ele)),acc._2)
    })._1)
  }
}
