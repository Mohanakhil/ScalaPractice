package main.AllProblems.Algos.Sorting

object QuickSorting
{
//partition exchange sort

  def partition(a: Array[Int], lb: Int, ub: Int):Int={
   val pivot:Int=a(lb)
    var start:Int=lb
    var end:Int=ub
    while(start<end){
      while (a(start) <= pivot&&start<a.length-1) {
        start = start + 1
      }
      while (a(end) > pivot) {
        end = end - 1
      }
      if (start < end) {
        val temp = a(start)
        a(start) = a(end)
        a(end) = temp
      }
    }
    val temp:Int=a(lb)
    a(lb)=a(end)
    a(end)=temp
    end
  }

  val quickSort:Array[Int]=>Array[Int]=(a:Array[Int])=>
  {
    val n:Int=a.length
   def quickSorting(a:Array[Int],lb:Int,ub:Int):Array[Int]={
     if(lb<ub)
     {
       val loc:Int =partition(a,lb,ub)
       quickSorting(a,lb,loc-1)
       quickSorting(a,loc+1,ub)
     }
     else
       a
   }
    quickSorting(a,0,n-1)
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(7,6,10,5,9,2,1,15,7,101,8,23,102)
    println(quickSort(a).mkString("Array(",",",")"))
  }
}
