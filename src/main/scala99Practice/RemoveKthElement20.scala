import scala.annotation.tailrec

object RemoveKthElement20
{
  val remove: (List[Int],Int)=>List[Int] = (list:List[Int], k:Int)=>{
    @tailrec
    def removeKthElement(list:List[Int], acc:List[Int], counter:Int):List[Int]={
      if(list.isEmpty) acc
      else if(counter==k) removeKthElement(list.tail,acc,counter+1)
      else removeKthElement(list.tail,acc:+list.head,counter+1)
    }
    removeKthElement(list,List(),0)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6,7,8)
    val k:Int=2
    println(remove(list,k))

    val reqList:List[Int]=List()
    val counter:Int=0
    println(list.foldLeft(reqList,counter)((acc,ele)=>{
      if(acc._2==k) (acc._1,acc._2+1)
      else (acc._1:+ele,acc._2+1)
    })._1)
  }
}
