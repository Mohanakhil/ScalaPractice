import scala.annotation.tailrec

object CeilingAndFloorInSortedArray52
{
  val findCeiling:(Array[Int],Int)=> Int = (a:Array[Int], x:Int)=>{
    @tailrec
    def search(counter:Int):Int={
      if(counter>=a.length) -1
      else if(x<a(0)) a(0)
      else if(x>a(a.length-1)) -1
      else if(x>a(counter)) search(counter+1)
      else a(counter)
    }
    search(0)
  }

  val findFloor:(Array[Int],Int)=>Int=(a:Array[Int],x:Int)=>{
    @tailrec
    def searchFloor(counter:Int):Int={
      if(x>a(a.length-1))  a(a.length-1)
      else if(counter>=a.length) -1
      else if(x<a(0)) -1
      else if(a(counter)<x) searchFloor(counter+1)
      else a(counter-1)
    }
    searchFloor(0)
  }

  val findCeilingUsingBinarySearch:(Array[Int],Int)=>Int=(a:Array[Int],x:Int)=>{
    @tailrec
    def find(left:Int, right:Int, mid:Int):Int={
      if(x<=a(left)) a(left)
      else if(x>a(a.length-1)) -1
      else if(a(mid)==x) a(mid)
      else if(x>a(mid)){
        if(x<=a(mid+1)) a(mid+1)
        else find(mid+1,right,(mid+1+right)/2)
      }
      else{
        if(x<a(mid)) find(left,mid-1,(left+mid-1)/2)
        else a(mid)
      }
    }
    find(0,a.length-1,(a.length-1)/2)
  }

  val findFloorUsingBinarySearch:(Array[Int],Int)=>Int=(a:Array[Int],x:Int)=>{
    def find(left:Int,right:Int,mid:Int):Int={
      if(x>a(a.length-1)) a(a.length-1)
      else if(x<a(left)) -1
      else if(x<a(mid)){
        if(a(mid-1)<=x) a(mid-1)
        else find(left,mid-1,(left+mid-1)/2)
      }
      else{
        if(a(mid+1)>=x) a(mid)
        else find(mid+1,right,(mid+1+right)/2)
      }
    }
    find(0,a.length-1,(a.length-1)/2)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1, 2, 8, 10, 10, 12, 19)
    val x:Int=scala.io.StdIn.readInt()
    //using linear search
    println(findCeiling(a,x))

    println(findFloor(a,x))



    //using binary search
    println(findCeilingUsingBinarySearch(a,x))

    println(findFloorUsingBinarySearch(a,x))
  }
}
