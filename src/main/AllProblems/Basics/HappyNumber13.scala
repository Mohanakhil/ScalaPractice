package Basics

import scala.annotation.tailrec

object HappyNumber13
{
  @tailrec
  def digits(n:Int, acc:List[Int]):List[Int]={
    if(n==0) acc
    else digits(n/10,acc:+n%10)
  }
  @tailrec
  def sumSquare(list:List[Int], acc:Int):Int={
    if(list.isEmpty) acc
    else sumSquare(list.tail,acc+ list.head * list.head)
  }
  @tailrec
  def isHappyNumber(n:Int,acc:List[Int]):Boolean={
    val l:List[Int]=digits(n,List())
    val sumOfSquare:Int=sumSquare(l,0)
    if(sumOfSquare==1) true
    else if(acc.contains(sumOfSquare)) false
    else isHappyNumber(sumOfSquare,acc:+sumOfSquare)
  }
  def main(Args:Array[String]):Unit={
    val n:Int=19
    println(isHappyNumber(n,List()))

    val reqList:List[Int]=List()
    println(List.range(1,1000).foldLeft(reqList)((acc,ele)=>{
      if(isHappyNumber(ele,List())) acc:+ele
      else acc
    }))
  }
}
