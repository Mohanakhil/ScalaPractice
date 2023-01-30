import scala.annotation.tailrec

object RotationCountInRotatedSortedArray34
{
  val binarySearch:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def search(left:Int, right:Int, mid:Int):Int={
      if(left==right) left
      else if(a(mid)<a(right)) search(left,mid,(left+mid)/2)
      else search(mid+1,right,(mid+1+right)/2)
    }
    search(0,a.length-1,(a.length-1)/2)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(12,15,18, 2, 3, 6)

    //using linear search find the min element and its index is min element

    //using binary search find the min element and its index is answer
    println(binarySearch(a))

  }
}
