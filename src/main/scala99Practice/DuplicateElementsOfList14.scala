import scala.annotation.tailrec

object DuplicateElementsOfList14
{
  val duplicate: List[Int]=>List[Int] = (list:List[Int])=>{
    @tailrec
    def duplicateList(list:List[Int], acc:List[Int]):List[Int]={
      list match {
        case Nil=>acc
        case h::_=> duplicateList(list.tail,acc:::List.fill(2)(h))
      }
    }
    duplicateList(list,List())
  }
def main(Args:Array[String]):Unit={
  val list:List[Int]=List(3,4,5,6,7,8)


  val requiredList:List[Int]=List()
  println(list.foldLeft(requiredList)((acc,ele)=>{
    acc:::List.fill(2)(ele)
  }))

  println(duplicate(list))
}
}
