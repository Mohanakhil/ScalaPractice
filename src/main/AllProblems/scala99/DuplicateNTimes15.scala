import scala.annotation.tailrec

object DuplicateNTimes15 {

  val duplicateNTimes:(List[Int],Int)=>List[Int]=(list:List[Int],n:Int)=>{
    @tailrec
    def duplicate(list:List[Int], acc:List[Int]):List[Int]={
      list match {
        case Nil=>acc
        case h::_=>duplicate(list.tail,acc:::List.fill(n)(h))
      }
    }
    duplicate(list,List())
  }
  def main(Args:Array[String]):Unit={
    val n:Int=4
    val list:List[Int]=List(1,2,3,4)
    println(duplicateNTimes(list,n))

    val duplicateList:List[Int]=List()
    println(list.foldLeft(duplicateList)((acc,ele)=>{
      acc:::List.fill(n)(ele)
    }))
  }
}
