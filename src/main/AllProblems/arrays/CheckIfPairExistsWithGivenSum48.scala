import scala.annotation.tailrec

object CheckIfPairExistsWithGivenSum48
{
  val checkUsingNestedLoop:(Array[Int],Int)=>(Int,Int)=(a:Array[Int],sum:Int)=>{
    @tailrec
    def checkSum(i:Int, j:Int):(Int,Int)={
      if(i>=a.length) (-1,-1)
      else if(j>=a.length) checkSum(i+1,i+2)
      else if(a(i)+a(j)==sum) (a(i),a(j))
      else checkSum(i,j+1)
    }
    checkSum(0,1)
  }

  val checkSumUsing2PointerTech:(Array[Int],Int)=>(Int,Int)=(a:Array[Int],sum:Int)=>{
    val b:Array[Int]=a.sorted
    @tailrec
    def checkSum(left:Int, right:Int):(Int,Int)={
      if(left>=right) (-1,-1)
      else if(b(left)+b(right)==sum) (b(left),b(right))
      else if(b(left)+b(right)<sum) checkSum(left+1,right)
      else checkSum(left,right-1)
    }
    checkSum(0,a.length-1)
  }

  val checkSumUsingBinarySearch:(Array[Int],Int)=>(Int,Int)=(a:Array[Int],sum:Int)=>{
    @tailrec
    def binarySearch(left:Int, right:Int, target:Int, mid:Int):(Boolean,Int)={
      if(left>=right) (false,-1)
      else if(a(mid)==target) (true,mid)
      else if(a(mid)<target) binarySearch(mid+1,right,target,(mid+1+right)/2)
      else binarySearch(left,mid-1,target,(left+mid-1)/2)
    }

    @tailrec
    def sumCheckBinarySearch(counter:Int):(Int,Int)={
      if(counter>=a.length) (-1,-1)
      else{
       val (flag:Boolean,index:Int)= binarySearch(0,a.length-1,sum-a(counter),(a.length-1)/2)
        if(flag) (a(counter),a(index))
        else sumCheckBinarySearch(counter+1)
      }
    }
    sumCheckBinarySearch(0)
  }

  val checkSumUsingSet:(Array[Int],Int)=>(Int,Int)=(a:Array[Int],sum:Int)=>{
    def checkSum(s:Set[Int],counter:Int):(Int,Int)={
      if(counter>=a.length) (-1,-1)
      else if(s.contains(sum-a(counter))) (a(counter),sum-a(counter))
      else  checkSum(s+a(counter),counter+1)
    }
    checkSum(Set(),0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1, 4, 45, 6, 10, -8)
    val sum=scala.io.StdIn.readInt()
    //brute force approach
    println(checkUsingNestedLoop(a,sum))

    //using sorting and 2 pointer technique
    println(checkSumUsing2PointerTech(a,sum))


    //2 sum using binary search
    println(checkSumUsingBinarySearch(a.sorted,sum))

    //2 sum using hashing
    println(checkSumUsingSet(a,sum))
  }
}
