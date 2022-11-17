object PrimeOrNotFunctional
{
  def isPrime(n:Int):Boolean={
    if(n<=1)
      false
    else if(n==2)
      true
    else {
      !(2 until n).exists(i=>n%i==0)
    }
  }
  def main(args:Array[String]):Unit={
    val n:Int=scala.io.StdIn.readInt()
    println(isPrime(n))
  }
}
