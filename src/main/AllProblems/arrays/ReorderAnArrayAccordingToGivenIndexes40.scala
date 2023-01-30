import scala.annotation.tailrec

object ReorderAnArrayAccordingToGivenIndexes40
{
  val reOrderArray:(Array[Int],Array[Int])=>Array[Int]=(a:Array[Int],indexArray:Array[Int])=>{
    val temp: Array[Int] = new Array[Int](a.length)
    @tailrec
    def rearrange(counter:Int):Array[Int]={
      if(counter==a.length) temp
      else{
        temp(indexArray(counter))=a(counter)
        rearrange(counter+1)
      }
    }
    rearrange(0)
    temp
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(50, 40, 70, 60, 90)
    val index:Array[Int]=Array(3,  0,  4,  1,  2)
    println(reOrderArray(a, index).mkString("Array(", ", ", ")"))
  }
}
