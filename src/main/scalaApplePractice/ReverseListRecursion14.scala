import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object ReverseListRecursion14 {




  val reverse_list:ListBuffer[Int]=>ListBuffer[Int]=(list:ListBuffer[Int])=>{
    @tailrec
    def reverseList(list:ListBuffer[Int],start:Int,end:Int):ListBuffer[Int]={
    if(start>=end) return list
      val temp = list(start)
      list(start) = list(end)
      list(end) = temp
    reverseList(list,start+1,end-1)
    }
    reverseList(list,0,list.size-1)
  }

 val revers_list2:ListBuffer[Int]=>ListBuffer[Int]=(list:ListBuffer[Int])=>{
   @tailrec
   def reverseList2(list:ListBuffer[Int],newList:ListBuffer[Int]):ListBuffer[Int]={
    if(list.isEmpty) return newList
    newList.addOne(list.last)
     list.remove(list.size-1)
    reverseList2(list,newList)
   }
   reverseList2(list,ListBuffer())
 }

  def main(Args:Array[String]):Unit={
    val list:ListBuffer[Int]=ListBuffer(1,2,3,4,5)
    println(reverse_list(list))
    val list2:ListBuffer[Int]=ListBuffer(1,2,3,4,5)
    println(revers_list2(list2))
    val list3:ListBuffer[Int] = ListBuffer()
    list.reverseIterator.foreach((x:Int)=>list3.addOne(x))

    println(list3)
  }
}
