import scala.annotation.tailrec

object TwoPointersTechnique16
{
  @tailrec
  def findPair(a: Array[Int], i:Int, j:Int, sum:Int):(Int,Int)={
    if(a(i)+a(j)==sum){
      (a(i), a(j))
    }
    else if(a(i)+a(j)<sum){
      findPair(a,i+1,j,sum)
    }
    else findPair(a,i,j-1,sum)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(10, 20, 35, 50, 75, 80)
    val sum=70
    println(findPair(a,0,a.length-1,sum))
  }
}
