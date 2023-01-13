import scala.annotation.tailrec

object ListFactorialGivenRange3
{
  val factorial:Int=>Int=(x:Int)=>{
    @tailrec
    def findFactorial(x:Int, fact:Int):Int={
      if(x==0) fact
      else findFactorial(x-1,fact*x)
    }
    findFactorial(x,1)
  }
  def main(Args:Array[String]):Unit={
    val a:Int=1
    val b:Int=10
    val acc:List[Int]=List()
    println(List.range(a,b).foldLeft(acc)((acc,ele)=>{
      acc:+factorial(ele)
    }))
  }
}
