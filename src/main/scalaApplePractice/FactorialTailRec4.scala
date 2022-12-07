import scala.annotation.tailrec
object FactorialTailRec4 {

// tail recursion using single stack trace

  /**
   *factorial(10,1)
   * factorial(9,10*1)
   * factorial(8,10*9*1)
   */
  @tailrec def factorial(num:Long,acc:Long):Long={
    if(num<=0) acc
    else factorial(num-1,acc*num)
  }
  def main(Args:Array[String]):Unit={
    println(factorial(4,1))
  }
}
