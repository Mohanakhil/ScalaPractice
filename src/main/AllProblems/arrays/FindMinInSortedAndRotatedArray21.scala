import scala.annotation.tailrec

object FindMinInSortedAndRotatedArray21
{
  val findMinimumUsingBinarySearch: Array[Int]=>Int = (a:Array[Int])=>{
    @tailrec
    def findMin(a:Array[Int], low:Int, high:Int, mid:Int):Int={
      if(low>high) a(0)
      else if(low==high) a(low)
      else if(a(mid)<a(high)) findMin(a,low,mid,(low+mid)/2)
      else findMin(a,mid+1,high,(mid+1+high)/2)
    }
    findMin(a,0,a.length-1,(a.length-1)/2)
  }

  val findMinUsingLinearSearch:Array[Int]=>Int=(a:Array[Int])=>{
    def findMin(a:Array[Int],min:Int,counter:Int):Int={
      if(counter>=a.length) min
      else if(a(counter)<min) findMin(a,a(counter),counter+1)
      else findMin(a,min,counter+1)
    }
    findMin(a,a.head,1)
  }

    def main(Args:Array[String]):Unit={
      val a:Array[Int]=Array(15, 18, 2, 3, 6, 12)

      //using binary search
      println(findMinimumUsingBinarySearch(a))

      //using linear search
      println(findMinUsingLinearSearch(a))
    }

}
