import scala.annotation.tailrec

object FindKthLargestContiguousSubArray45
{
  val findKthLargestSumContiguousSubArrayUsingArraySort:(Array[Int],Int)=>Int=(a:Array[Int],k:Int)=>{
    @tailrec
    def accumilateSums(acc:Array[Int], i:Int, j:Int,sum:Int):Array[Int]={
      if(i>=a.length-1) acc:+sum
      else if(j>=a.length){
        accumilateSums(acc:+sum,i+1,i+2,a(i+1))
      }
      else accumilateSums(acc:+sum,i,j+1,sum+a(j))
    }
    val b=accumilateSums(Array(),0,1,a(0))
    val sortedArray=b.sorted.reverse
    sortedArray(k-1)
  }



  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(20, -5, -1)

    val k:Int=scala.io.StdIn.readInt()
    //using bruteforce
    println(findKthLargestSumContiguousSubArrayUsingArraySort(a,k))
  }
}
