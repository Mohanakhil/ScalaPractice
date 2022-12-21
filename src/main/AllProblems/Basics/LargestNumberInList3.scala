package Basics

import scala.annotation.tailrec

object LargestNumberInList3
{
  @tailrec
  def largestNumber(list:List[Int], max:Int):Int={
    list match {
      case Nil=>max
      case h::_=>if(h>max) largestNumber(list.tail,h)
      else largestNumber(list.tail,max)
    }
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(9,4,3,5,6,8,11)
    val max:Int=0
    val index:Int= -1
    val counter:Int=0
    //element and index where it is found are given below
    println(list.foldLeft(max,index,counter)((acc,ele)=>{
      if(ele > acc._1) (ele,acc._3,acc._3+1)
      else (acc._1,acc._2,acc._3+1)
    }))

    println(largestNumber(list,0))
  }
}
