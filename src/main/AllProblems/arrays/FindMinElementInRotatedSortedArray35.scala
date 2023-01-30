import scala.annotation.tailrec

object FindMinElementInRotatedSortedArray35
{
  val findMinUsingBinarySearch:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def findMin(left:Int, right:Int, mid:Int):Int={
      if(left==right) a(mid)
      else if(a(mid)<a(right)) findMin(left,mid,(left+mid)/2)
      else findMin(mid+1,right,(mid+1+right)/2)
    }
    findMin(0,a.length-1,(a.length-1)/2)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(15, 18, 19, 3, 6, 12,13)
    println(findMinUsingBinarySearch(a))
  }
}
