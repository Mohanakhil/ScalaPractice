import scala.annotation.tailrec

object PushAllNegativeElementsToEnd42
{
  val moveToEnd:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def moveNegativeToEnd(a:Array[Int], counter:Int,c:Int):Array[Int]={
      if(counter>=a.length-c)  a
      else if(a(counter)<0) moveNegativeToEnd(a.slice(0,counter)++a.slice(counter+1,a.length)++Array(a(counter)),counter,c+1)
      else moveNegativeToEnd(a,counter+1,c)
    }
    moveNegativeToEnd(a,0,0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(-5, 7, -3, -4, 9, 10, -1, 11)
    println(moveToEnd(a).mkString("Array(", ", ", ")"))
  }
}
