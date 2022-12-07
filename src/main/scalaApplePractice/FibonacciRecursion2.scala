object FibonacciRecursion2 {

  def fibonacci(n:Int):Int={
    if(n<=1) 1
    else fibonacci(n-1)+fibonacci(n-2)
  }
  def main(Args:Array[String]):Unit={
    println(fibonacci(2))
  }
}
