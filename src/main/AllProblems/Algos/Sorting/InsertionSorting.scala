package main.AllProblems.Algos.Sorting

import scala.annotation.tailrec

object InsertionSorting
{
  val insertionSort:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    val n:Int=a.length
    @tailrec
    def sort(a:Array[Int], i:Int, j:Int, key:Int):Array[Int]={
     if(j>=0&&a(j)>key){
      a(j+1)=a(j)
       sort(a,i,j-1,key)
     }
      else{
       a(j+1)=key
       if(i+1==n)a
       else
       sort(a,i+1,i,a(i+1))
     }
    }
    sort(a,1,0,a(1))
  }
   def main(Args:Array[String]):Unit={
   val a:Array[Int]=Array(5,4,10,1,6,2,101,99,3)
     println(insertionSort(a).mkString("Array(", ", ", ")"))
   }
}
