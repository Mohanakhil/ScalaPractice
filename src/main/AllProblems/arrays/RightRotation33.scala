import scala.annotation.tailrec

object RightRotation33
{
  val rightRotate:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
    @tailrec
    def rotate(a:Array[Int], counter:Int):Array[Int]={
      if(counter==n) a
      else{
        rotate(a.last+:a.slice(0,a.length-1),counter+1)
      }
    }
    rotate(a,0)
  }

  val rightRotateUsing2Pointer:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
    @tailrec
    def pointerRotate(left:Int, right:Int):Array[Int]={
      if(left==right) a
      else{
        val temp=a(left)
        a(left)=a(right)
        a(right)=temp
        pointerRotate(left+1,right)
      }
    }
    @tailrec
    def rotate(counter:Int):Array[Int]={
      if(counter==n) a
      else{
        pointerRotate(0,a.length-1)
        rotate(counter+1)
      }
    }
    rotate(0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(3,4,5,6,7,8)
    val n:Int=scala.io.StdIn.readInt()
    //using one by one
    println(rightRotate(a, n).mkString("Array(", ", ", ")"))

    //using 2 pointer approach i and j
    println(rightRotateUsing2Pointer(a, n).mkString("Array(", ", ", ")"))
  }
}
