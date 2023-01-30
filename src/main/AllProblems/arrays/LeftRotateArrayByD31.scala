import scala.annotation.tailrec

object LeftRotateArrayByD31
{
  val leftRotate:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
    @tailrec
    def rotate(a:Array[Int], counter:Int):Array[Int]={
      if(counter==n) a
      else{
        rotate(a.tail:+a.head,counter+1)
      }
    }
    rotate(a,0)
  }

  val leftRotateUsingTemp:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
    @tailrec
    def storeInTempArray(a:Array[Int], temp:Array[Int], counter:Int):Array[Int]={
      if(counter==n) a++temp
      else storeInTempArray(a.tail,temp:+a.head,counter+1)
    }
    storeInTempArray(a,Array(),0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(3,4,5,6,7)
    println(a.mkString("Array(", ", ", ")"))
    val n:Int=scala.io.StdIn.readInt()
    //using one element by one element
    println(leftRotate(a, n).mkString("Array(", ", ", ")"))


    //using temp array
    println(leftRotateUsingTemp(a, n).mkString("Array(", ", ", ")"))
  }
}
