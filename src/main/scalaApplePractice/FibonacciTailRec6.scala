import scala.annotation.tailrec

object FibonacciTailRec6 {

  /**
   *
   *
   *  int fib(int n)
   *  {
   *  int a = 0, b = 1, c, i;
   *  if (n == 0)
   *  return a;
   *  for (i = 2; i <= n; i++)
   *  {
   *  c = a + b;
   *  a = b;
   *  b = c;
   *  }
   *  return b;
   *  }
   */

  @tailrec  def fib(n:Int,acc1:Int,acc2:Int):Int={
  if(n<=2) acc1+acc2
  else fib(n-1,acc2,acc1+acc2)
}
  def main(Args:Array[String]):Unit={
    println(fib(10,0,1))
  }
}
