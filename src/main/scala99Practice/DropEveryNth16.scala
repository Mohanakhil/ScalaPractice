import scala.annotation.tailrec

object DropEveryNth16
{
  val drop:(List[Int],Int)=>List[Int]=(list:List[Int],n:Int)=>{
    @tailrec
    def dropEveryNthElement(list:List[Int], acc:List[Int], counter:Int):List[Int]={
      (counter%n,list.headOption) match {
        case (_,None)=>acc
        case (0,_)=>dropEveryNthElement(list.tail,acc,counter+1)
        case (_,_)=>dropEveryNthElement(list.tail,acc:+list.head,counter+1)
      }
      }
    dropEveryNthElement(list,List(),1)
    }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6,7,8,9,10)
    val n:Int=2
    println(drop(list,n))
    val reqList:List[Int]=List()
    println(list.foldLeft((reqList,1))((acc,ele)=>{
      acc._2%n match {
        case 0=>(acc._1,acc._2+1)
        case _=>(acc._1:+ele,acc._2+1)
      }
    })._1)
  }
}
