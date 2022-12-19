import scala.annotation.tailrec

object FindNoOfElementsInList4
{
  val count: List[Int] =>Int= (list:List[Int])=>{
    @tailrec
    def findCountUsingMatching(list:List[Int],counter:Int):Int={
      list match {
        case Nil => 0
        case _ ::Nil =>counter+1
        case _ =>findCountUsingMatching(list.tail,counter+1)
      }
    }
    findCountUsingMatching(list,0)
  }
  val countOfList: List[Int] =>Int= (list:List[Int])=>{
    @tailrec
    def findCountUsingIf(list:List[Int], acc:Int):Int={
      if(list.isEmpty) acc
      else findCountUsingIf(list.tail,acc+1)
    }
    findCountUsingIf(list,0)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6,7,8,9,10,11)
    //using tail rec and if else
    println(countOfList(list))

    //using tail rec and patternMatching
    println(count(list))

    //using foldLeft
    println(list.foldLeft(0)((acc, _)=>acc+1))

    //using builtin function
    println(list.size)
  }
}
