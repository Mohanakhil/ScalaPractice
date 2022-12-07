import scala.annotation.tailrec

object SumOfNTailRec5 {

  @tailrec def sum(n:Int,acc:Int):Int={
  if(n<=1) acc
  else sum(n-1,n+acc)
}
  def main(Args:Array[String]):Unit={
  println(sum(10,1))
  }
}
