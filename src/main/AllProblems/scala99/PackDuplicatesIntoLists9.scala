import scala.annotation.tailrec

object PackDuplicatesIntoLists9
{
  val packDuplicatesIntoList: List[Int]=>List[List[Int]] = (list:List[Int])=>{
    @tailrec
    def pack(list:List[Int], acc:List[List[Int]], l:List[Int]):List[List[Int]]={
      list match {
        case Nil=>acc
        case first::Nil=>if(l.isEmpty){
          pack(list.tail,acc:+List(first),List())
        }
        else{
          val k:List[Int]=l:+first
          pack(list.tail,acc:+k,List())
        }
        case first::second::_=>if(first==second){
          pack(list.tail,acc,l:+first)
        }
        else{
          val k:List[Int]=l:+first
          pack(list.tail,acc:+k,List())
        }
      }
    }
    pack(list,List(),List())
  }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,3,4,4,4,4,5,6,7,7,7,8,8,8,8)
    println(packDuplicatesIntoList(list))


  }
}
