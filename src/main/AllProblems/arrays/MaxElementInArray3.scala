package arrays

import scala.annotation.tailrec

object MaxElementInArray3
{
  @tailrec
  def maxElementOfArray(arr: Array[Int], counter:Int, max:Int):Int={
    counter match {
      case -1=>max
      case  h=>if(arr(h)>max) maxElementOfArray(arr,counter-1,arr(h))
      else maxElementOfArray(arr,counter-1,max)
    }
  }
  def main(Args:Array[String]):Unit={
    val arr:Array[Int]=Array(3,4,5,101,6,2)
    println(maxElementOfArray(arr,arr.length-1,0))

    //max using foldLeft
    println(arr.foldLeft(0)((acc,ele)=>{
      if(ele>acc) ele
      else acc
    }))

  }
}
