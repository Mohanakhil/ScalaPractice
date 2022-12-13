import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object EliminateDuplicatesInList17
{
  @tailrec
  def eliminateDuplicates(list: ListBuffer[Int],newList:ListBuffer[Int]):ListBuffer[Int]={
    if(list.size<=1) return newList.addOne(list.head)
    if(list.head.compare(list(1))==0){
    eliminateDuplicates(list.tail,newList)
    }
    else  eliminateDuplicates(list.tail,newList.addOne(list.head))
  }
  def main(Args:Array[String]):Unit={
    val list=ListBuffer(1,1,2,2,3,3,3,4,4)
    val newList: ListBuffer[Int] = ListBuffer()
    eliminateDuplicates(list,newList)
    println(newList)
  }
}
