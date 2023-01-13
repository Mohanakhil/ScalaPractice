import scala.annotation.tailrec

object DropEveryNthElementInList16
{
  val dropEveryNthElement:(List[Int],Int)=>List[Int]=(list:List[Int],n:Int)=>{
    val length:Int=list.length
    @tailrec
    def drop(list:List[Int], acc:List[Int], counter:Int):List[Int]={
      (counter%n,counter>length) match {
        case (0,false)=>drop(list.tail,acc,counter+1)
        case (_,false)=>drop(list.tail,acc:::List(list.head),counter+1)
        case (_,true)=>acc
      }
    }
    drop(list,List(),1)
  }

    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(3,4,5,6,7,8)
      val n:Int=2

      println(dropEveryNthElement(list,n))
      val droppedList:List[Int]=List()
      val counter:Int=1
      println(list.foldLeft(droppedList,counter)((acc,ele)=>{
        if(acc._2%n==0) (acc._1,acc._2+1)
        else (acc._1:::List(ele),acc._2+1)
      })._1)
    }
}
