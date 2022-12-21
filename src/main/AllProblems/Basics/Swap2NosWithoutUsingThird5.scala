package Basics

object Swap2NosWithoutUsingThird5
{
  def swap(a:Int,b:Int):(Int,Int)={
    (b,a)
  }
  def main(Args:Array[String]):Unit={
    val a:Int=10
    val b:Int=20
    println(swap(a,b))
  }
}
