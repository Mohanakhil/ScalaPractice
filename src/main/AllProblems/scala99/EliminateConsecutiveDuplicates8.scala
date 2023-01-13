import scala.annotation.tailrec

object EliminateConsecutiveDuplicates8
{
  val eliminateDuplicates: List[Int]=>List[Int] = (list:List[Int])=>{
    @tailrec
    def eliminate(list:List[Int], acc:List[Int]):List[Int]={
      list match {
        case Nil=>acc
        case first::Nil=>acc:+first
        case first::second::_=> if(first==second){
          eliminate(list.tail,acc)
        }
        else eliminate(list.tail,acc:+first)
      }
    }
    eliminate(list,List())
  }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,3,5,6,6,7,8,8,8,8)

    println(eliminateDuplicates(list))
  }
}
