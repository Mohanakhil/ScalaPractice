import scala.annotation.tailrec

object BubbleSorting56
{
  val bubbleSorting:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def swap(i:Int, j:Int,flag:Boolean):Array[Int]={
      if(i>=a.length) a
      else if(j>=a.length-i-1){
        if(!flag) a
        else swap(i+1,0,flag)
      }
      else if(a(j)>a(j+1)){
        val temp:Int=a(j)
        a(j)=a(j+1)
        a(j+1)=temp
        swap(i,j+1,flag = true)
      }
      else swap(i,j+1,flag)
    }
    swap(0,0,flag = false)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(4,5,6)
    println(bubbleSorting(a).mkString("Array(", ", ", ")"))
  }
}
