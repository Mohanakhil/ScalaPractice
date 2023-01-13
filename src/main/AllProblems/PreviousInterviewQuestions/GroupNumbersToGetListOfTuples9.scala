import scala.annotation.tailrec

object GroupNumbersToGetListOfTuples9
{
  val groupNumbers:List[Int]=>List[(Int,Int)]=(list:List[Int])=>{
   @tailrec
   def prepare(list:List[Int], acc:List[(Int,Int)]):List[(Int,Int)]={
     if(list.isEmpty)acc
     else {
       prepare(list.tail.tail,acc:+(list.head,list(1)))
     }
   }
    prepare(list,List())
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(1,2,3,4,5,6)

    println(groupNumbers(list))
  }
}
