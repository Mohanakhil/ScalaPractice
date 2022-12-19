import scala.annotation.tailrec

object PerfectNumber
{
  @tailrec
  def divisors(n:Int, counter:Int, acc:Set[Int]): Set[Int] ={
    if(counter>n/2) return acc
    if(n%counter==0) divisors(n,counter+1,acc++Set(counter))
    else divisors(n,counter+1,acc)
  }
  def isPerfectNumber(n:Int):Boolean={
    val setOfDivisors:Set[Int]=divisors(n,1,Set())
     val sum:Int=setOfDivisors.sum
    sum==n
  }
  def main(Args:Array[String]):Unit={
    val n:Int=6
    println(isPerfectNumber(n))
  }
}
