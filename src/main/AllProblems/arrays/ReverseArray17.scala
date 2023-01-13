import scala.annotation.tailrec

object ReverseArray17
{
  val reverseArray:Array[Int]=>Array[Int]= (a:Array[Int])=>{
    val counter:Int=a.length-1
    @tailrec
    def reverse(a:Array[Int], acc:Array[Int],counter:Int): Array[Int] =
    {
      counter match {
        case 0=> acc:+a(counter)
        case _=>reverse(a,acc:+a(counter),counter-1)
      }
    }
    reverse(a,Array(),counter)
  }

  val reverseUsingSwap:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def reverse(a:Array[Int], start:Int, end:Int):Array[Int]={
      if(start<=end){
        val temp=a(start)
        a(start)=a(end)
        a(end)=temp
        reverse(a,start+1,end-1)
      }
      else a
    }
    reverse(a,0,a.length-1)
  }
def main(Args:Array[String]):Unit={
  val a:Array[Int]=Array(2,3,4,5,6)

  //using extra space
  println(reverseArray(a).mkString("Array(",",",")"))


  //using foldRight
  val acc:Array[Int]=Array()
  println(a.foldRight(acc)((ele, acc) => {
    acc :+ ele
  }).mkString("Array(", ", ", ")"))

  //using swap of elements
  println(reverseUsingSwap(a).mkString("Array(",",",")"))
}
}
