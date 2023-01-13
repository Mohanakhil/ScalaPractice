import scala.annotation.tailrec

object LastButOneElementInList2
{
  val lastButOneElement:List[Int]=>Option[Int]=(list:List[Int])=>{
    @tailrec
    def lastButOneElementInList(list:List[Int]):Option[Int]={
      list match {
        case h::_::Nil=>Some(h)
        case _=>lastButOneElementInList(list.tail)
      }
    }
    lastButOneElementInList(list)
  }


    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(3,4,5,6,7,8)

      //using tail rec
      println(lastButOneElement(list))


      val counter:Int=0
      val value= -1 //returns -1 if list is empty
      println(list.foldLeft(counter,value)((acc,ele)=>{
        if(acc._1==list.length-2) (acc._1+1,ele)
        else (acc._1+1,acc._2)
      })._2)
    }
}
