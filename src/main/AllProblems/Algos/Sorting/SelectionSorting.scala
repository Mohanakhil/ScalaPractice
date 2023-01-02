package main.AllProblems.Algos.Sorting

import scala.annotation.tailrec

object SelectionSorting
{
  @tailrec
  def minimum(a:Array[Int], min:Int,index:Int,counter:Int):(Int,Int)={
    if(counter==a.length) (min,index)
    else if(a(counter)<min){
      minimum(a,a(counter),counter,counter+1)
    }
    else minimum(a,min,index,counter+1)
  }

  val selectionSort:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    val n:Int=a.length
    @tailrec
    def sort(a:Array[Int],acc:Array[Int]):Array[Int]={
      if(a.isEmpty) acc
      else{
        val (min:Int,index:Int)=minimum(a,100,0,0)
       sort(a.slice(0,index)++a.slice(index+1,n),acc:+min)
      }
    }
    sort(a,Array())
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(7,4,10,8,3,1)
    println(selectionSort(a).mkString("Array(", ", ", ")"))
  }
}
