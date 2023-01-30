object CheckWhether2IntegersHaveSameLastDigit6
{
  def main(Args:Array[String]):Unit={
    val a:Int=scala.io.StdIn.readInt()
    val b:Int=scala.io.StdIn.readInt()
    if(a%10==b%10) println("true")
    else println("false")
  }
}
