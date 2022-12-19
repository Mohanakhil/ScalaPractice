import scala.annotation.tailrec

object FindLastElementOfList1
{

  //using tailrec and patternmatching
  val last:List[Int]=>Option[Int]=(list:List[Int])=>{
    @tailrec
    def findLastElementUsingPattern(list:List[Int], acc:Option[Int]):Option[Int]={
      list.headOption match {
        case None=> acc
        case Some(_)=> findLastElementUsingPattern(list.tail,list.headOption)

//         case h :: Nil  => Some(list,Some(h))
//         case _ :: tail => findLastElementUsingPattern(tail,list.headOption)
      }
    }
    findLastElementUsingPattern(list,None)
  }

  //using tailrec and if else
  val lastElement:List[Int]=>Option[Int]=(list:List[Int])=>{
    @tailrec
    def findLastElementOfList(list: List[Int], acc: Option[Int]): Option[Int] = {
      if (list.isEmpty) acc
      else findLastElementOfList(list.tail,list.headOption)
    }
    findLastElementOfList(list,None)
  }


  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6,7,8,9)
    println(lastElement(list))
    println(last(list))


    //using foldLeft it gives -1 for empty list
    println(list.foldLeft(-1)((_, ele)=> ele))

    //using builtin functions
    println(list.lastOption)
  }
}
