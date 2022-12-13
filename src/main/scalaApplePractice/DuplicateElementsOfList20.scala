import scala.annotation.tailrec

object DuplicateElementsOfList20
{
  @tailrec
  def duplicateElements(list:List[Int],list2:List[Int],n:Int):List[Int]={
    if(list.isEmpty) list2
    else
    duplicateElements(list.tail,list2:::List.fill(n)(list.head),n)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(1,2,3,4)
    val list2:List[Int]=List()
    println(duplicateElements(list,list2,3))
  }
}
