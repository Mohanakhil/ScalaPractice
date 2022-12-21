package Basics

import scala.annotation.tailrec

object FascinatingNumber14
{
  @tailrec
  def checkDigits(str: String):Boolean={
    if(str.isEmpty) true
    else if(List.range(1,9).contains(str.head)) checkDigits(str.tail)
    else false
  }

  @tailrec
  def isFascinating(n:Int, prod:Int, fasc:String):Boolean={
    if(n==0&&prod==0) {
      checkDigits(fasc)
    }
    else{
      isFascinating(n/10,prod/10,fasc+(n%10)+(prod%10))
    }
  }

  def main(Args:Array[String]):Unit={
    val n:Int=192
    val prod:Int=n*3*2
    isFascinating(n,prod,"")
  }
}
