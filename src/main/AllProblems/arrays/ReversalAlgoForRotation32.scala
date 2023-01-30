import scala.annotation.tailrec

object ReversalAlgoForRotation32
{

  val rotateUsingReversal:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
    @tailrec
    def reverse(left:Int, right:Int):Array[Int]={
      if(left>right) a
      else{
        val temp=a(left)
        a(left)=a(right)
        a(right)=temp
        reverse(left+1, right-1)
      }
    }
    reverse(0,n-1)
    reverse(n,a.length-1)
    reverse(0,a.length-1)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(3,4,5,6,7,8)
    val n:Int=scala.io.StdIn.readInt()
    println(rotateUsingReversal(a, n).mkString("Array(", ", ", ")"))
  }
}
