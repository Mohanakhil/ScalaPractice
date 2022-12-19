import scala.annotation.tailrec

object EliminateConsecutiveDuplicatesInList8
{
  //using tail rec and patternMatching
  val remove:List[Int]=>List[Int]=(list:List[Int])=>{
    @tailrec
    def removeDuplicateUsingMatch(list:List[Int], acc:List[Int]):List[Int]={
      list match {
        case Nil=> acc
        case h ::Nil=>acc:+h
        case first::second::_=> if(first==second) removeDuplicateUsingMatch(list.tail,acc)
        else removeDuplicateUsingMatch(list.tail,acc:+list.head)
      }
    }
    removeDuplicateUsingMatch(list,List())
  }

  //using tail rec and if else
  val removeDuplicates:List[Int]=>List[Int]=(list:List[Int])=>{
    @tailrec
    def removeDuplicateUsingIf(list:List[Int], acc:List[Int]):List[Int]={
      if(list.isEmpty) acc
      else if(list.size==1) acc:+list.head
      else if(list.head==list(1)) removeDuplicateUsingIf(list.tail,acc)
      else removeDuplicateUsingIf(list.tail,acc:+list.head)
    }
    removeDuplicateUsingIf(list,List())
  }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,3,4,4,4,4,5,5,5,5,6,7,7,7,8,9,9,10)
    println(removeDuplicates(list))
    println(remove(list))

    val removeDuplicateList:List[Int]=List()

    //using foldLeft and patternMatching
    println(list.foldLeft(list,removeDuplicateList)((acc,ele)=>{
      acc._1 match {
        case Nil=>(acc._1,acc._2)
        case h::Nil=>(acc._1,acc._2:+h)
        case first::second::_=> if(first==second){
          (acc._1.tail,acc._2)
        }
        else{
          (acc._1.tail,acc._2:+ele)
        }
      }
    })._2)
  }
}
