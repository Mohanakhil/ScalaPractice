import scala.annotation.tailrec

object RotationCount19
{
  val countUsingMinIndex: Array[Int]=>Int = (a:Array[Int])=>{
    @tailrec
    def count(a:Array[Int], min:Int, index:Int,requiredIndex:Int):Int={
      if(index>=a.length) requiredIndex
      else if(a(index)<min) count(a,a(index),index+1,index)
      else count(a,min, index+1,requiredIndex)
    }
    count(a,a.head,0,0)
  }

  val rotationCount:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def count(a:Array[Int], c:Int, index:Int):Int={
      if(index>=a.length-1||a(index)>a(index+1)) c
      else count(a,c+1,index+1)
    }
    count(a,1,0)
  }

  val countUsingBinarySearch:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def count(a:Array[Int], low:Int, high:Int, mid:Int):Int={
      if(low>high) 0
      else if(high==low) low
      else if(mid<high&&a(mid)>a(mid+1)) mid+1
      else if(low<mid&&a(mid-1)>a(mid)) mid
      else if(a(high)>a(mid)) count(a,low,mid-1,(low+mid-1)/2)
      else count(a,mid+1,high,(mid+1+high)/2)
    }
    count(a,0,a.length-1, 0+(a.length-1)/2)
  }


  val countUsingBSearch: Array[Int]=>Int = (a:Array[Int])=>{
    @tailrec
    def count(a:Array[Int], left:Int, right:Int, mid:Int):Int={
      if(left>right) 0
      else if(left==right) left
      else if(a(mid)<a(right)) count(a,left,mid,(left+mid)/2)
      else count(a,mid+1,right,(mid+1+right)/2)
    }
    count(a,0,a.length-1,(a.length-1)/2)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(12,15, 18, 2, 3, 6)


    //using point of decrease
    println(rotationCount(a))

    //using index of minimum element is the count of rotations
    println(countUsingMinIndex(a))


    //using binary search
    println(countUsingBinarySearch(a))

    println(countUsingBSearch(a))
  }
}
