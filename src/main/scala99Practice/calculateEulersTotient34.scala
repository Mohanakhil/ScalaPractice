import scala.annotation.tailrec

object calculateEulersTotient34
{
  @tailrec
  def hcf(a:Int, b:Int):Int={
    if(b==0)a
    else hcf(b,a%b)
  }
  def main(Args:Array[String]):Unit={
    val m:Int=10
    val count:Int=0
    println(List.range(1,m).foldLeft(count)((acc,ele)=>{
      if(hcf(m,ele)==1) acc+1
      else acc
    }))
  }
}
