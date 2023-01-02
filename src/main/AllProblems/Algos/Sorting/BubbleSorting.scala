package main.AllProblems.Algos.Sorting

import scala.annotation.tailrec

object BubbleSorting {
  //compare 2 adjacent elements swap these 2 elements


  val bubbleSorting: Array[Int]=>Array[Int] = (a:Array[Int])=>{
    val n:Int=a.length
    @tailrec
    def sort(a:Array[Int], i:Int, j:Int):Array[Int]={
      if(i>=n-1) a
      else if(j>=(n-i-1)) sort(a,i+1,0)
      else if(a(j)>a(j+1)){
        val temp:Int=a(j)
        a(j)=a(j+1)
        a(j+1)=temp
        sort(a,i,j+1)
      }
      else sort(a,i,j+1)
    }
    sort(a,0,0)
  }

  val optimizedBubbleSort: Array[Int]=>Array[Int] = (b:Array[Int])=>{
    val n:Int=b.length
    @tailrec
    def sort(b:Array[Int], i:Int, j:Int, flag:Boolean):Array[Int]={
      if(i>=n-1) b
      else if(j>=(n-i-1)){
        sort(b,i+1,0,flag = false)
      }
      else if(b(j)>b(j+1)){
      val temp:Int=b(j)
      b(j)=b(j+1)
      b(j+1)=temp
      sort(b,i,j+1,flag = true)
      }
      else if(!flag) b
      else {
      sort(b,i,j+1,flag)
      }
    }
    sort(b,0,0,flag = true)
  }

  def main(Args:Array[String]):Unit={

    val a:Array[Int]=Array(5,10,6,9,7,6,0,101,1)

    println(bubbleSorting(a).mkString("Array(",",",")"))


    //optimized bubble Sorting
    val b:Array[Int]=Array(12,16,14,5,6,8)

    println(optimizedBubbleSort(b).mkString("Array(", ", ", ")"))
  }
}
