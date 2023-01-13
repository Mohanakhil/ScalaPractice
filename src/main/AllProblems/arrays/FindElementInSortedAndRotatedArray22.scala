import scala.annotation.tailrec

object FindElementInSortedAndRotatedArray22
{
  val findInSortedAndRotatedBinarySearch:(Array[Int],Int)=>Int=(a:Array[Int],x:Int)=>{
    @tailrec
    def findIndex(a:Array[Int], low:Int, high:Int, mid:Int):Int={
      if(low>high) -1
      else if(low==high) low
      else if(a(mid)==x) mid
      else if(a(low)<a(mid)){
        if(x>=a(low)&&x<a(mid)) findIndex(a,low,mid-1,(low+mid-1)/2)
        else findIndex(a,mid+1,high,(mid+1+high)/2)
      }
      else{
        if(x>a(mid)&&x<=a(high)) findIndex(a,mid+1,high,(mid+1+high)/2)
        else findIndex(a,low,mid-1,(low+mid-1)/2)
      }
    }
    findIndex(a,0,a.length-1,(a.length-1)/2)
  }

  val modifiedBinarySearch:(Array[Int],Int)=>Int=(a:Array[Int],x:Int)=>{
    def binarySearchInSorted(a:Array[Int],low:Int,high:Int,mid:Int):Int={
      if(low>high) -1
      else if(low==high) low
      else if(a(mid)==x) mid
      else if(a(low)<a(mid)){
        if(x>=a(low)&&x<=a(mid)) binarySearchInSorted(a,low,mid-1,(low+mid-1)/2)
        else binarySearchInSorted(a,mid+1,high,(mid+1+high)/2)
      }
      else{
        if(x>a(mid)&&x<=a(high)) binarySearchInSorted(a,mid+1,high,(mid+1+high)/2)
        else binarySearchInSorted(a,low,mid-1,(low+mid-1)/2)
      }
    }
    binarySearchInSorted(a,0,a.length-1,(a.length-1)/2)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(120,130,40,50,90,100,110)
    val x:Int=100
    println(findInSortedAndRotatedBinarySearch(a,x))

    println(modifiedBinarySearch(a,x))
  }
}
