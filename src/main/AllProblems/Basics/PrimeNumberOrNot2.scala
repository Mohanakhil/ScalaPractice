package Basics

import scala.annotation.tailrec

object PrimeNumberOrNot2
{
  @tailrec
  def isPrime(n: Int, counter:Int):Boolean={
    if(n%counter==0) false
    else if(counter>n/2) true
    else isPrime(n,counter+1)
  }
  def main(Args:Array[String]):Unit={
    val n:Int=28
    println(isPrime(n,2))
  }
}
