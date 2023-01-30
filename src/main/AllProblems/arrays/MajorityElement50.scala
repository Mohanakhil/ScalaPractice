import scala.annotation.tailrec

object MajorityElement50
{
  val findMajorityElement:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def findMajority(i:Int, j:Int, count:Int):Int={
      if(count>a.length/2) a(i)
      else if(i>=a.length) -1
      else if(j>=a.length) findMajority(i+1,i+2,1)
      else if(a(i)==a(j)) findMajority(i,j+1,count+1)
      else findMajority(i,j+1,count)
    }
    findMajority(0,1,1)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(3, 3, 4, 2, 4, 4, 2, 4, 4,5,5,5,5,5,5,5,5,5,5)
    println(findMajorityElement(a))
  }
}
