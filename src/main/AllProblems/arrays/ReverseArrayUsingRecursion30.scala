import scala.annotation.tailrec

object ReverseArrayUsingRecursion30
{
  val reverseArray:Array[Int]=>Unit=(a:Array[Int])=>{
    @tailrec
    def reverse(left:Int, right:Int):Unit={
      if(left>right) return
      else{
        val temp:Int=a(left)
        a(left)=a(right)
        a(right)=temp
        reverse(left+1,right-1)
      }
    }
    reverse(0,a.length-1)
  }
    def main(Args:Array[String]):Unit={
      val a:Array[Int]=Array(3,4,5,6,7,8)

      println(a.mkString("Array(", ", ", ")"))
      //reverse array using recursion
      reverseArray(a)
      println(a.mkString("Array(",",",")"))
    }
}
