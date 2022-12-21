package Basics

import scala.annotation.tailrec

object SpyNumber12
{
  @tailrec
  def sumOfDigits(n: Int, acc:Int):Int={
    if(n==0) acc
    else sumOfDigits(n/10,acc+n%10)
  }
  @tailrec
  def productOfDigits(n: Int, acc: Int):Int={
    if(n==0) acc
    else productOfDigits(n/10,acc*(n%10))
  }
  def isSpyNumber(n: Int):Boolean={
    sumOfDigits(n,0)==productOfDigits(n,1)
  }
  def main(Args:Array[String]):Unit={
    val n:Int=1124
    println(isSpyNumber(n))

    //print all spyNumbers from 1 to 10000
    val reqList:List[Int]=List()
    println(List.range(0,10000).foldLeft(reqList)((acc,ele)=>{
      if(isSpyNumber(ele)) acc:+ele
      else acc
    }))
  }
}
