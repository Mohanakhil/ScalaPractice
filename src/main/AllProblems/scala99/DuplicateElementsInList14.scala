object DuplicateElementsInList14
{
  val duplicateElements: List[Int]=>List[Int] = (list:List[Int])=>{
    def duplicate(list:List[Int],acc:List[Int]):List[Int]={
      list match {
        case Nil=>acc
        case h::_=>duplicate(list.tail,acc:::List(h,h))
      }
    }
    duplicate(list,List())
  }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(1,2,3,4)

    println(duplicateElements(list))
    val reqList:List[Int]=List()
    println(list.foldLeft(reqList)((acc,ele)=>{
      acc:::List.fill(2)(ele)
    }))
  }
}
