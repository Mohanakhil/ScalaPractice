package Basics

import scala.annotation.tailrec

object FibonacciSeries6
{
  @tailrec
  def fibonacciSeries(n: Int, acc:List[Int], first:Int, second:Int):List[Int]={
    if(n<=0) acc
    else fibonacciSeries(n-1,acc:::List(first+second),second,first+second)
  }
  def main(Args:Array[String]):Unit={
    val n:Int=20
    println(fibonacciSeries(n,List(0,1),0,1))
  }
}
