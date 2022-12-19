import scala.annotation.tailrec

object DecodeRunLength12
{
  val decodeList: List[(Int,Int)]=>List[Int] = (list:List[(Int,Int)])=>{
    @tailrec
    def decodeListUsingFill(list:List[(Int,Int)], acc:List[Int]):List[Int]={
      list match {
        case Nil=>acc
        case first::_=>decodeListUsingFill(list.tail,acc:::List.fill(first._1)(first._2))
      }
    }
    decodeListUsingFill(list,List())
  }
def main(Args:Array[String]):Unit={
  val list:List[(Int,Int)]=List((4,1),(1,2),(2,3))
  val requiredList:List[Int]=List()
  println(list.foldLeft(requiredList)((acc,ele)=>{
    ele match {
      case (a,b)=> acc:::List.fill(a)(b)
    }
  }))
  println(decodeList(list))

}
}
