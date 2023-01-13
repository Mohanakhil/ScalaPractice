import scala.annotation.tailrec

object CountAndPackIntoLists
{
  val countAndPack: List[Int]=>List[(Int,Int)] = (list:List[Int])=>{
    @tailrec
    def count(list:List[Int], acc:List[(Int,Int)], c:Int,last:Int):List[(Int,Int)]={
      list match {
        case Nil=>acc
        case first::Nil=>{
          if(first==last){
            count(list.tail,acc:+(first,c+1),0,last)
          }else{
            count(list.tail,acc:+((first,1)),c,last)
          }
        }
        case first::second::_=>if(first==second){
          count(list.tail,acc,c+1,first)
        }
        else
          count(list.tail,acc:+(first,c+1),0,first)
      }
    }
    count(list,List(),0,0)
  }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,3,3,3,4,5,5,5,5,5,5,6,7,7)
    println(countAndPack(list))
  }
}
