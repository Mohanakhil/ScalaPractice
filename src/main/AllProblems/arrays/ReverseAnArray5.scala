package arrays

import scala.annotation.tailrec

object ReverseAnArray5
{
  @tailrec
  def reverseArray(arr:Array[Int],acc:Array[Int],counter:Int):Array[Int]={
     counter match {
       case -1=>acc
       case _=>reverseArray(arr,acc:+arr(counter),counter-1)
     }
  }
    def main(Args:Array[String]):Unit={
      val arr:Array[Int]=Array(3,4,5,6,7,8)
      println(reverseArray(arr,Array(),arr.length-1).mkString("Array(",",",")"))


      //using foldRight
      val reqArray:Array[Int]=Array()
      println(arr.foldRight(reqArray)((ele,acc)=>{
          acc:+ele
      }).mkString("Array(",",",")"))
    }


}
