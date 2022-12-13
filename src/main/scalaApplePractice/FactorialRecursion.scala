object FactorialRecursion
{
  def factorial(n:Int):Int={
    if(n==0)
      1
    else
      n*factorial(n-1)
  }

  def main(args:Array[String]):Unit={
    val n:Int=scala.io.StdIn.readInt()
    println(factorial(n))
  }
}
