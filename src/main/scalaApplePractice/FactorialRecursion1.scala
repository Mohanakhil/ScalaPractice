object FactorialRecursion1
{
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n*factorial(n - 1)
  }
  def main(Args:Array[String]):Unit={
    println(factorial(4))
  }
}
