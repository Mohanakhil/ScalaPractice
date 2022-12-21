package Basics

object Factorial1
{
  def factorial(n:Int,fact:Int):Int={
    if(n<=1) fact
    else factorial(n-1,fact*n)
  }
  def main(Args:Array[String]):Unit={
    val n:Int=5
    println(factorial(n,1))
  }
}
