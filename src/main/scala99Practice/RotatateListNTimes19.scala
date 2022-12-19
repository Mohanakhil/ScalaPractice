import scala.annotation.tailrec

object RotatateListNTimes19
{
  val rotate: (List[Int],Int)=>List[Int] = (list:List[Int], n:Int)=>{
    @tailrec
    def rotateNTimes(list:List[Int],counter:Int):List[Int]={
      if (counter >= n || list.isEmpty) {
        list
      } else {
        rotateNTimes(list.tail:+list.head, counter + 1)
      }
    }
    rotateNTimes(list,0)
  }
    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(3,4,5,6,7,8)
      val n:Int=4
      println(rotate(list,n))

    }
}
