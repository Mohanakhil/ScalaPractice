package arrays

import scala.annotation.tailrec

object SelectionSort8 {

  @tailrec
  def minElementAndIndex(a:Array[Int], counter:Int, min:Int, index:Int):(Int,Int)={
    if(counter==a.length) (min,index)
    else if(a(counter)<min) minElementAndIndex(a,counter+1,a(counter),counter)
    else minElementAndIndex(a,counter+1,min,index)
  }

  @tailrec
  def selectionSort(a:Array[Int], acc:Array[Int], counter:Int):Array[Int]={
    if(a.isEmpty) return acc
      val (min:Int,index:Int)=minElementAndIndex(a,0,100,0)
      selectionSort(a.slice(0,index)++a.slice(index+1,a.length),acc:+min,counter+1)
      }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(10,3,9,4,8,5)
    println(selectionSort(a,Array(),0).mkString("Array(",",",")"))
  }
}
