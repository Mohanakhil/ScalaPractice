import scala.annotation.tailrec

object RearrangeArrayEvenPositionGreaterThanOddPosition44
{
  val rearrangeArrayUsingSorting:Array[Int]=>Array[Int]=(sortedArray:Array[Int])=>{
    val acc:Array[Int]=new Array[Int](sortedArray.length)

    @tailrec
    def arrangeMax(counter:Int, a:Array[Int]):Array[Int]={
      if(counter>=sortedArray.length) a
      else{
        acc(counter)=a.head
        arrangeMax(counter+2,a.tail)
      }
    }

    @tailrec
    def arrangeMin(counter:Int, a:Array[Int]):Array[Int]={
      if(a.isEmpty) acc
      else{
        acc(counter)=a.head
        arrangeMin(counter+2,a.tail)
      }
    }
    arrangeMin(0,arrangeMax(1,sortedArray))
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1, 3, 2, 2, 5)
    println(rearrangeArrayUsingSorting(a.sorted.reverse).mkString("Array(", ", ", ")"))
  }
}
