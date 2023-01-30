import scala.annotation.tailrec

object FindPeakElementWhichIsNotSmallerThanNeighbours53
{
  val findPeakGreaterThanNeighbours:Array[Int]=> Array[Int] = (a:Array[Int])=>{
    @tailrec
    def find(counter:Int,acc:Array[Int]):Array[Int]={
      if(counter==0){
        if(a(0)>a(1)) find(counter+1,acc:+a(0))
        else find(counter+1,acc)
      }
      else if(counter==a.length-1){
        if(a(counter)>a(counter-1)) acc:+a(counter)
        else acc
      }
      else if(a(counter)>a(counter-1)&&a(counter)>a(counter+1)) find(counter+1,acc:+a(counter))
      else find(counter+1,acc)
    }
    find(0,Array())
  }

  val findPeakUsingBinarySearch:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def find(left:Int, right:Int, mid:Int):Int={
      if(left>=right) -1
      else if(a(mid)>a(mid-1)&&a(mid)>a(mid+1)) a(mid)
      else if(a(mid+1)>a(mid)) find(mid+1,right,(mid+1+right)/2)
      else find(left,mid-1,(left+mid-1)/2)
    }
    find(0,a.length-1,(a.length-1)/2)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(10, 20, 15, 2, 23, 90, 67)
    //using brute force approach
    println(findPeakGreaterThanNeighbours(a).mkString("Array(", ", ", ")"))

    //using binary search approach
    println(findPeakUsingBinarySearch(a))
  }
}
