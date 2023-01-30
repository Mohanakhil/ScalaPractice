import scala.annotation.tailrec

object SelectionSorting56
{

  val selectionSort:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def findMinIndex(counter:Int,min:Int,minIndex:Int):Int={
      if(counter==a.length) minIndex
      else if(a(counter)<min) findMinIndex(counter+1,a(counter),counter)
      else findMinIndex(counter+1,min,minIndex)
    }

    @tailrec
    def sort(i:Int):Array[Int]={
      if(i==a.length-1) a
      else{
        val minIndex = findMinIndex(i, a(i), i)
        val temp = a(i)
        a(i) = a(minIndex)
        a(minIndex) = temp
        sort(i + 1)
      }
    }

    sort(0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(5,4,6,7,3,2,100,99,101)
    println(selectionSort(a).mkString("Array(", ", ", ")"))
  }
}
