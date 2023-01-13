import scala.annotation.tailrec

object MaximumSumOfRotation20
{



  val leftRotate:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
    @tailrec
    def rotate(a:Array[Int], counter:Int):Array[Int]={
      if(counter>=n) a
      else rotate(a.tail:+a.head,counter+1)
    }
    rotate(a,0)
  }

  val calculateSum: Array[Int] =>Int= (a:Array[Int])=>{
    @tailrec
    def sumOfArrayAndIndex(a:Array[Int], sumAcc:Int, counter:Int):Int={
      if(counter>=a.length) sumAcc
      else sumOfArrayAndIndex(a, sumAcc+(a(counter)*counter), counter+1)
    }
    sumOfArrayAndIndex(a,0,0)
  }

  //S = S'-sum+a(i-1)*n

  val maxSumUsingFormula:Array[Int]=>Int=(a:Array[Int])=>{
    val n:Int=a.length
    val s1=calculateSum(a)
    @tailrec
    def maxSum(a:Array[Int], i:Int, s1:Int, max:Int, s:Int):Int={
      if(i>=n-1) return max
      if(s>max) maxSum(a,i+1,s,s, (s-a.sum)+(a(i)*n))
      else maxSum(a,i+1,s,max, (s-a.sum)+(a(i)*n))
    }
    maxSum(a,1,s1,s1,s1-a.sum+(a(0)*n))
  }

  val maximumSum:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def maxSum(a:Array[Int], max:Int,counter:Int):Int={
      if(counter>=a.length) max
      else if(calculateSum(a)>max)
        maxSum(leftRotate(a,1),calculateSum(a),counter+1)
      else maxSum(leftRotate(a,1),max,counter+1)
    }
    maxSum(a,0,0)
  }
    def main(Args:Array[String]):Unit={
      val a:Array[Int]=Array(8,3,1,2)

      println(maximumSum(a))

      //using o(n) solution using formula
      //S = S'-sum+a(i-1)*n
      println(maxSumUsingFormula(a))
    }
}
