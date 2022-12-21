package Basics

import scala.annotation.tailrec

object NeonNumber10
{
  @tailrec
  def sumOfDigits(n: Int, acc:Int):Int={
    if(n==0) acc
    else sumOfDigits(n/10,acc+n%10)
  }

  def isNeon(n: Int):Boolean={
    val sq:Int=n*n
    sumOfDigits(sq,0)==n
  }
  def main(Args:Array[String]):Unit={
    val n:Int=9
    println(isNeon(n))

    //print list of neon nos from 1 to 10000
    val reqList:List[Int]=List()
    println(List.range(0,10000).foldLeft(reqList)((acc,ele)=>{
      if(isNeon(ele)) acc:+ele
      else acc
    }))
  }
}
