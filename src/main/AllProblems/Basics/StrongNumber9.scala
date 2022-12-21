package Basics

import scala.annotation.tailrec

object StrongNumber9
{
  @tailrec
  def factorial(n:Int, fact:Int):Int={
    if(n==0) fact
    else factorial(n-1,fact*n)
  }
  @tailrec
  def sumOfFactorial(n:Int, acc:Int):Int={
    if(n==0) acc
    else sumOfFactorial(n/10,acc+factorial(n%10,1))
  }
  def main(Args:Array[String]):Unit={
    val n:Int=145
    val sum:Int=sumOfFactorial(n,0)
    if(sum==n) println(true)
    else println(false)

    //print strong numbers from 1 to 10000
    val reqList:List[Int]=List()
    println(List.range(1,10000).foldLeft(reqList)((acc,ele)=>{
      if(sumOfFactorial(ele,0)==ele) acc:+ele
      else acc
    }))
  }
}
