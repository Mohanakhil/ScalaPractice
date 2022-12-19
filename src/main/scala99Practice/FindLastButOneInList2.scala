import scala.annotation.tailrec

object FindLastButOneInList2
{
  //using tailrec and pattern matching
  val lastButOneCaseMatch:List[Int]=>Option[Int]=(list:List[Int])=> {
    @tailrec
    def findLastButOne(list: List[Int]): Option[Int] = {list match {
      case Nil=>None
      case h :: _ :: Nil => Some(h)
      case _ => findLastButOne(list.tail)
    }
    }
    findLastButOne(list)
  }
  //using tailrec and if else
  val lastButOne: List[Int]=>Option[Int] = (list:List[Int])=>{
    @tailrec
    def findLastButOne(list:List[Int], acc:Option[Int]):Option[Int]={
      if(list.size<=1) acc
      else findLastButOne(list.tail,list.headOption)
    }
    findLastButOne(list,None)
  }
def main(Args:Array[String]):Unit={
  val list:List[Int]=List(1,2,3,4,5)
  println(lastButOne(list))
  println(lastButOneCaseMatch(list))

  //find lastButOne using inbuilt function
//  println(Some(list(list.length-2)))

  //using foldLeft if else
  println(list.foldLeft((list,None:Option[Int]))((acc,ele)=>{
    if(acc._1.size==2) {
      val x:Int=ele
      (list,Some(x))}
    else (acc._1.tail,acc._2)
  }))

  //using fold left case matching
  println(list.foldLeft((list,0))((acc, _)=>{
    acc._1 match {
      case Nil=>(List(),acc._2)
      case h::_::Nil=> (list,h)
      case _=> (acc._1.tail,acc._2)
    }
  }))


  println(list.foldLeft(None:Option[Int],2,list.size)((acc,ele)=>{
    acc._3-acc._2 match {
      case 0=> (Some(ele),acc._2+1,acc._3)
      case _=> (acc._1,acc._2+1,acc._3)
    }
  })._1)
}
}
