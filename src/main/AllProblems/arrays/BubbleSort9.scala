package arrays

import scala.annotation.tailrec

object BubbleSort9
{
  val bubbleSort: Array[Int]=>Array[Int] = (a:Array[Int])=>{
    @tailrec
    def bubbleSorting(i:Int, j:Int):Array[Int]={
     if(i>=a.length-1) a
     else if(j<a.length-i-1)
     {
       if(a(j)>a(j+1))
       {
         val temp:Int=a(j)
         a(j)=a(j+1)
         a(j+1)=temp
         bubbleSorting(i,j+1)
       }
       else bubbleSorting(i,j+1)
     }
     else  bubbleSorting(i+1,0)
    }
    bubbleSorting(0,0)
  }

  @tailrec
  def bubbleSortOptimum(a: Array[Int], i:Int, j:Int,swapped:Boolean):Array[Int]= {
    if(i>a.length-1) a
    else if(j<a.length-i-1)
    {
      if(a(j)>a(j+1)){
        val temp: Int = a(j)
        a(j) = a(j + 1)
        a(j + 1) = temp
        bubbleSortOptimum(a,i,j+1,swapped = true)
      }
      else
      bubbleSortOptimum(a,i,j+1,swapped = true)
    }
    else if(!swapped) a
    else bubbleSortOptimum(a,i+1,0,swapped = false)
  }


  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(4,10,5,9,6,5,11,4,3,12)
//    println(bubbleSort(a).mkString("Array(",",",")"))

    //optimized way of bubbleSorting
    val b:Array[Int]=Array(5,19,6,20,3,18,2,6,5,20)
    println(bubbleSortOptimum(b, 0, 0,swapped = true).mkString("Array(", ", ", ")"))
  }
}
