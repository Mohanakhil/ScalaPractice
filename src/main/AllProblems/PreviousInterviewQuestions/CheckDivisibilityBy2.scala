object CheckDivisibilityBy2
{
  def main(Args:Array[String]):Unit={
    val a:Int=1
    val b:Int=100
    println(List.range(a,b).filter(x=>x%2==0))
  }
}
