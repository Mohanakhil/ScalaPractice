import scala.annotation.tailrec

object MaxSumOfArrayAndIndex33
{
  val maxSum:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def sumOfMultiples(counter:Int, sum:Int,a:Array[Int]):Int={
      if(counter==a.length) sum
      else sumOfMultiples(counter+1,sum+(a(counter)*counter),a)
    }
    @tailrec
    def rotate(a:Array[Int], counter:Int):Array[Int]={
      if(counter==1) a
      else rotate(a.tail:+a.head,counter+1)
    }
    @tailrec
    def maximum(max:Int, counter:Int, a:Array[Int]):Int={
      val m:Int=sumOfMultiples(0,0,a)
      if(counter==a.length) max
      else if(m>max) maximum(m,counter+1,rotate(a,0))
      else maximum(max,counter+1,rotate(a,0))
    }
    maximum(0,0,a)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(8, 3, 1, 2)
    println(maxSum(a))
  }
}
