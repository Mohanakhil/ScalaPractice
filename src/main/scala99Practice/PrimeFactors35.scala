import scala.annotation.tailrec

object PrimeFactors35
{
  @tailrec
  def last(n:Int, count:Int, acc:List[Int]):(List[Int],Int)={
    if(n%count==0)last(n/count,count,acc:+count)
    else (acc,n)
  }
  val primeFactors: Int=> List[Int] = (n:Int)=>{
    @tailrec
    def primeFactorization(n:Int, count:Int, acc:List[Int]): List[Int] ={
      if(count<=n) {
       val (a:List[Int],b:Int)= last(n,count,List())
        primeFactorization(b,count+1,acc:::a)
      } else acc
    }
    primeFactorization(n,2,List())
  }
  def main(Args:Array[String]):Unit={
    val n:Int=35
    println(primeFactors(n))

  }
}
