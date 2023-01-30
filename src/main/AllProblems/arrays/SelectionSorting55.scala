import scala.annotation.tailrec

object SelectionSorting55
{
  val selectionSorting:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def findMinimum(a:Array[Int], counter:Int, min:Int,minIndex:Int):(Int,Int)={
      if(counter>=a.length) (min,minIndex)
      else if(a(counter)<min)  findMinimum(a,counter+1,a(counter),counter)
      else findMinimum(a,counter+1,min,minIndex)
    }
    @tailrec
    def find(i:Int, a:Array[Int]):Array[Int]={
      if(i>=a.length-1) a
      else{
        val (min:Int,index:Int)=findMinimum(a,i+1,a(i+1),i+1)
        val temp:Int=a(i)
        a(i)=a(index)
        a(index)=temp
        find(i+1,a)
      }
    }
    find(0,a)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(7,4,10,8,3,1)
    //find min element and prepare the array
    println(selectionSorting(a).mkString("Array(", ", ", ")"))
  }
}
