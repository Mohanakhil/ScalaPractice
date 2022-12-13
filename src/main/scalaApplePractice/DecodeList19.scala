import scala.annotation.tailrec

object DecodeList19
{
  @tailrec
  def decode(list:List[(Int,Int)],decodeList:List[Int]):List[Int]={
    if(list.isEmpty) return decodeList
    decode(list.tail, decodeList:::List.fill(list.head._1)(list.head._2))

  }
 def main(Args:Array[String]):Unit={
   val list:List[(Int,Int)]=List((4,1),(5,2),(3,3))
   val decodedList:List[Int]=List()
   println(decode(list,decodedList))
 }
}
