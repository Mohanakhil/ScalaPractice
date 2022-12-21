package arrays

import scala.annotation.tailrec

object DeleteElementFromArray2
{
  @tailrec
  def deleteElementFromArray(arr: Array[Int], pos: Int, acc:Array[Int]):Array[Int]={
//    arr.slice(0,pos)++arr.slice(pos+1,arr.length)
      if(arr.isEmpty) acc
      else if(pos==0) deleteElementFromArray(arr.tail,pos-1,acc)
      else deleteElementFromArray(arr.tail,pos-1,acc:+arr.head)
  }

  @tailrec
  def deleteElementFromArrayUsingValue(arr: Array[Int], element: Int, acc: Array[Int]):Array[Int]={
    if(arr.isEmpty) acc
    else if(element==arr.head) deleteElementFromArrayUsingValue(arr.tail,element,acc)
    else deleteElementFromArrayUsingValue(arr.tail,element,acc:+arr.head)
  }

  def main(Args:Array[String]):Unit={
    val arr:Array[Int]=Array(3,4,5,6,7)
    val pos:Int=3
    val element:Int=6
    //delete element from array using position
    println(deleteElementFromArray(arr,pos,Array()).mkString("Array(",",",")"))

    //delete element from array using value
    println(deleteElementFromArrayUsingValue(arr,element,Array()).mkString("Array(",",",")"))


    //using foldLeft
    val outputArray:Array[Int]=Array()
    val counter:Int=0
    println(arr.foldLeft(outputArray,counter)((acc,ele)=>{
      if(acc._2==pos) (acc._1,acc._2+1)
      else (acc._1:+ele,acc._2+1)
    })._1.mkString("Array(",",",")"))

  }
}
