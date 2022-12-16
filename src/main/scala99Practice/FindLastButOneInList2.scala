import scala.annotation.tailrec

object FindLastButOneInList2
{
  //using tailrec and pattern matching
  val lastButOneCaseMatch:List[Int]=>Option[Int]=(list:List[Int])=> {
    @tailrec
    def findLastButOne(list: List[Int]): Option[Int] = {list match {
      case h :: _ :: Nil => Some(h)
      case _::_:: _ => findLastButOne(list.tail)
    }
    }
    findLastButOne(list)
  }
  //using tailrec and if else
  val lastButOne: List[Int]=>Option[Int] = (list:List[Int])=>{
    @tailrec
    def findLastButOne(list:List[Int], acc:Option[Int]):Option[Int]={
      if(list.size<=2) acc
      else findLastButOne(list.tail,list.headOption)
    }
    findLastButOne(list,None)
  }
def main(Args:Array[String]):Unit={
  val list:List[Int]=List(3,4,5,6,7,8)
  println(lastButOne(list))
  println(lastButOneCaseMatch(list))
  //find lastButOne using inbuilt function
  println(Some(list(list.length-2)))

  //using foldLeft if else
  println(list.foldLeft((list,0))((acc,ele)=>{
    if(acc._1.size==2) {
      val x:Int=ele
      (list,x)}
    else (acc._1.tail,acc._2)
  }))

  //using fold left case matching
  println(list.foldLeft((list,0))((acc,ele)=>{
    acc._1 match {
      case h::_::Nil=> (list,h)
      case _::_::_=> (acc._1.tail,acc._2)
    }
  }))


}
}
