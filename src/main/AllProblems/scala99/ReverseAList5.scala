import scala.annotation.tailrec

object ReverseAList5
{

  val reverseList: List[Int]=>Option[List[Int]] = (list:List[Int])=>{
    @tailrec
    def reverse(list:List[Int], acc:List[Int]):Option[List[Int]]={
      list match {
        case Nil=>Some(acc)
        case h::tail=>reverse(tail,h::acc)
      }
    }
    reverse(list,List())
  }
    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(3,4,5,6,7)


      //using tail recursion
      println(reverseList(list))

      //using fold right
      val acc:List[Int]=List()
      println(list.foldRight(acc)((ele,acc)=>acc:+ele))

      //using inbuilt
      println(list.reverse)

    }
}
