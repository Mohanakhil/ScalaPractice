import scala.annotation.tailrec

object RearrangePositiveAndNegativeNumbers42
{
  val rearrangeUsingBringToFront:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def rearrange(a:Array[Int], counter:Int,c:Int):Array[Int]={
      if(c>=counter) a
      else if(a(counter)<0&&counter>c) rearrange(Array(a(counter))++a.slice(0,counter)++a.slice(counter+1,a.length),counter,c+1)
      else rearrange(a,counter-1,c)
    }
    rearrange(a,a.length-1,0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1,-1,2,-2,3,-3,4,-4)
    println(rearrangeUsingBringToFront(a).mkString("Array(", ", ", ")"))
  }
}
