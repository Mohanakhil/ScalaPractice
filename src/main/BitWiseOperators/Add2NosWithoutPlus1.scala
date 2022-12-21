import scala.annotation.tailrec
//2 means  10
//3 means  11

object Add2NosWithoutPlus1
{
  //a should be my addition so using a xor b
  //b should be muy carry so using a&b and apply carry left 1 as always

  @tailrec
  def add(a:Int, b:Int):Int={
    if(b==0) a
    else add(a^b,(a&b)<<1)
  }
    def main(Args:Array[String]):Unit={
      val a:Int=3
      val b:Int=5
      println(add(a,b))
    }
}
