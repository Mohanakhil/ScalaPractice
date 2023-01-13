import scala.annotation.tailrec

object SortList5
{
  val findMinimum:List[Int]=>(Int,Int)=(a:List[Int])=>{
    @tailrec
    def findMinAndIndex(a:List[Int], min:Int, index:Int,counter:Int):(Int,Int)={
      if(a.isEmpty) (min,index)
      else if(a.head<min) findMinAndIndex(a.tail,a.head,counter,counter+1)
      else findMinAndIndex(a.tail,min, index, counter+1)
    }
    findMinAndIndex(a,a.head,0,0)
  }
  val sortList:List[Int]=>List[Int]=(a:List[Int])=>{
    @tailrec
    def sort(a:List[Int], acc:List[Int]):List[Int]={
      if(a.isEmpty) return acc
      val (min:Int,index:Int)=findMinimum(a)
      sort(a.slice(0,index):::a.slice(index+1,a.length),acc:+min)
    }
    sort(a,List())
  }
  def main(Args:Array[String]):Unit={
    val a:List[Int]=List(3,10,4,9,8,5)
    println(sortList(a))
  }
}
