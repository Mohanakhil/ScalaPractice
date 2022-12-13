import scala.annotation.tailrec

object DropEveryNthEle21
{
  @tailrec
  def dropEveryNth(list: List[Int], n:Int,count:Int, list2:List[Int]):List[Int]={
    if(list.isEmpty) return list2
     if((count%n)==0){
       dropEveryNth(list.tail,n,count+1,list2)
     }
    else dropEveryNth(list.tail,n,count+1,list2:::List(list.head))

  }
def main(Args:Array[String]):Unit={
  val list:List[Int]=List(1,2,3,4,5,6,7,8,9)
  println(dropEveryNth(list,3,1,List()))
}
}
