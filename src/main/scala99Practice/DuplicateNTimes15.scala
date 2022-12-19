import scala.annotation.tailrec

object DuplicateNTimes15
{
  val duplicateN:(List[Int],Int)=>List[Int]=(list:List[Int],n:Int)=>{
      @tailrec
      def duplicateNTimes(list:List[Int], acc:List[Int]):List[Int]={
        list match {
          case Nil=>acc
          case h::_=> duplicateNTimes(list.tail,acc:::List.fill(n)(h))
        }
      }
    duplicateNTimes(list,List())
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6)
    val n:Int=3
    println(duplicateN(list,n))

    val reqList:List[Int]=List()
    println(list.foldLeft(reqList)((acc,ele)=>{
      acc:::List.fill(n)(ele)
    }))

  }
}
