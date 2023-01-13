import scala.annotation.tailrec

object SelectCommonFrom2DataLists11
{
  val commonInBoth:(List[Int],List[Int])=>List[Int]=(list1:List[Int],list2:List[Int])=>{
    val set:Set[Int]=list1.toSet
    @tailrec
    def common(list2:List[Int], acc:List[Int]):List[Int]={
      if(list2.isEmpty) acc
      else if(set.contains(list2.head)) common(list2.tail,acc:+list2.head)
      else common(list2.tail,acc)
    }
    common(list2,List())
  }
    def main(Args:Array[String]):Unit={
      val list1:List[Int]=List(3,4,5,6)
      val list2:List[Int]=List(5,6,7,8)
      println(commonInBoth(list1,list2))
    }
}
