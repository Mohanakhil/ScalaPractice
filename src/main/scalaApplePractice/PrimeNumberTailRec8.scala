import scala.annotation.tailrec

object PrimeNumberTailRec8 {

  @tailrec
  def prime_number(n:Int,i:Int):Boolean={
    if(n==2)
      return true
    if(n<2)
      return false
    if(n%i==0)
      return false
    if(i*i>=n)
      return true
    prime_number(n,i+1)
  }


//  @tailrec
//  def prime_number(n: Int, i: Int): Boolean = {
//    if (n < 2)
//      return false
//    if (i>= n)
//      return false
//    if (n % i == 0)
//      return false
//    prime_number(n, i + 1)
//  }
//

//  def prime(n:Int,divisor:Int) : Boolean ={
//    if(n<2) false
//    else if(n==2) true
//    else if(n%divisor==0) false
//    else if(n>=divisor) true
//    else prime(n, divisor+1)
//  }





  def main(Args:Array[String]):Unit={
println(prime_number(26,2))
//    println(prime(23,2))
  }
}
