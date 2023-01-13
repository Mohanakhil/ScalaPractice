import scala.annotation.tailrec

object LastElementInList1
{
  @tailrec
  def lastElementUsingRecursion(list:List[Int]):Option[Int]={
    list match {
      case h::Nil=>Some(h)
      case _::tail=>lastElementUsingRecursion(tail)
    }
  }

    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(1,2,3,4,5,6)
      println(list.foldLeft(-1)((_,ele)=>ele))
      println(list.lastOption)

      //using pattern matching
      println(lastElementUsingRecursion(list))


    }
}
