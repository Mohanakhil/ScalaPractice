import scala.annotation.tailrec

object FindNumberOfElementsOfList4
{
  val countElements: List[Int]=>Int = (list:List[Int])=>{
    @tailrec
    def count(list:List[Int], c:Int):Int={
      list match {
        case Nil=>c
        case _=>count(list.tail,c+1)

      }
    }
    count(list,0)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6)


    //using tail rec
    println(countElements(list))


   println(list.length)


    println(list.foldLeft(0)((acc,_)=>{
      acc+1
    }))

    println(list.foldRight(0)((_,acc)=>{
      acc+1
    }))
  }
}
