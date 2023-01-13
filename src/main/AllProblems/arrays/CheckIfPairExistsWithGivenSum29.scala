import scala.annotation.tailrec

object CheckIfPairExistsWithGivenSum29
{
  val checkPair:(Array[Int],Int)=>(Int,Int)=(a:Array[Int],sum:Int)=>{
    @tailrec
    def check(a:Array[Int], i:Int, j:Int):(Int,Int)={
      if(i>=a.length) (-1,-1)
      else if(a(i)+a(j)==sum) (a(i),a(j))
      else if(j<a.length-1) check(a,i,j+1)
      else check(a,i+1,i+2)
    }
    check(a,0,1)
  }

  val checkPairUsingSorting:((Array[Int],Int)=>(Int,Int))=(a:Array[Int],sum:Int)=>{
    @tailrec
    def check(left:Int, right:Int):(Int,Int)={
      if(a(left)+a(right)==sum) (a(left),a(right))
      else if(a(left)+a(right)<sum) check(left+1,right)
      else if(a(left)+a(right)>sum) check(left,right-1)
      else (-1,-1)
    }
    check(0,a.length-1)
  }

  val binarySearch:(Array[Int],Int)=>Boolean=(a:Array[Int],x:Int)=>{
    @tailrec
    def search(left:Int, right:Int, mid:Int):Boolean={
      if(left>right) return false
      if(a(mid)==x) true
      else if(x<a(mid)) search(left,mid-1,(left+mid-1)/2)
      else  search(mid+1,right,(mid+1+right)/2)
    }
    search(0,a.length-1,(a.length-1)/2)
  }
  val checkPairUsingBinarySearch:(Array[Int],Int)=>(Int,Int)=(a:Array[Int],sum:Int)=>{
    @tailrec
    def search(a:Array[Int], counter:Int):(Int,Int)={
      if(counter>a.length-1) (-1,-1)
      if(binarySearch(a,sum-a(counter))) (a(counter),sum-a(counter))
     else search(a,counter+1)
    }
    search(a,0)
  }
    def main(Args:Array[String]):Unit={
      val a:Array[Int]=Array(1,4,2,5,3)
      val sum:Int= 9
      //using o(n2)
      println(checkPair(a,sum))


      //using sorting
      println(checkPairUsingSorting(a.sorted,sum))


      //using binary search
      println(checkPairUsingBinarySearch(a.sorted,sum))
    }
}
