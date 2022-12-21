package Basics

import scala.annotation.tailrec

object AutomorphicNumber11
{
  @tailrec
  def count(n:Int, acc:Int):Int={
    if(n==0) acc
    else count(n/10,acc+1)
  }
  @tailrec
  def last(n:Int, count:Int, acc:Int):Int={
    if(count==0)acc
    else last(n/10,count-1,(n%10)+acc*10)
  }
  @tailrec
  def reverseNumber(n:Int, acc:Int):Int={
    if(n==0) acc
    else reverseNumber(n/10,acc*10+(n%10))
  }
  def isAutomorphic(n: Int):Boolean={
    val sq:Int=n*n
    val countOfDigits:Int=count(n,0)
    val lastNDigits=last(sq,countOfDigits,0)
    reverseNumber(lastNDigits,0)==n
  }

  def main(Args:Array[String]):Unit={
    val n:Int=76
    println(isAutomorphic(n))

    val reqList:List[Int]=List()
    println(List.range(0,100000).foldLeft(reqList)((acc,ele)=>{
      if(isAutomorphic(ele)) acc:+ele
      else acc
    }))
  }
}
