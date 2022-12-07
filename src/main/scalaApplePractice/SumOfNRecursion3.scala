object SumOfNRecursion3 {

  def sum_of_n(n:Int):Int={
    if(n<=1) 1
    else n+sum_of_n(n-1)
  }

  def main(Args:Array[String]):Unit={
    println(sum_of_n(10))
  }
}
