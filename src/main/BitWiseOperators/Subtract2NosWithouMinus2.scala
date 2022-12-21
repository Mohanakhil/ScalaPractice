object Subtract2NosWithouMinus2
{
  def sub(a:Int,b:Int):Int={
    if(b==0) a
    else sub(a^b,((~a)&b)<<1)
  }
  def main(Args:Array[String]):Unit={
    val a:Int=23
    val b:Int=9
    println(sub(a,b))
  }
}
