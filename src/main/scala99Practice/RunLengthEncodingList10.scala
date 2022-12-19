import scala.annotation.tailrec

object RunLengthEncodingList10
{

  val compressList:List[Int]=>List[(Int,Int)]=(list:List[Int])=>{
      @tailrec
      def compressListUsingMatch(list:List[Int], acc:List[(Int,Int)], count:Int,last:Int):List[(Int,Int)]={
        list match {
          case Nil=> acc
          case first::Nil=> if(first==last){
            compressListUsingMatch(list.tail,acc:::List((count+1,list.head)),0,list.head)
          }
          else compressListUsingMatch(list.tail,acc:::List((1,list.head)),0,list.head)
          case first::second::_=> if(first==second){
            compressListUsingMatch(list.tail,acc,count+1,list.head)}
            else compressListUsingMatch(list.tail,acc:::List((count+1,list.head)),0,list.head)
          }
        }
    compressListUsingMatch(list,List(),0,0)
      }


  val compress: List[Int]=>List[(Int,Int)] = (list:List[Int])=>{
    @tailrec
    def countCompressUsingIf(list:List[Int], acc:List[(Int,Int)], count:Int,last:Int):List[(Int,Int)]={
      if(list.isEmpty) return acc
      if (list.size == 1)
      {
          if (last == list.head){
            countCompressUsingIf(list.tail, acc ::: List((count + 1, list.head)), 0, list.head)
          }
          else countCompressUsingIf(list.tail, acc ::: List((1, list.head)), 0, list.head)
      }
      else if(list.head==list(1)) countCompressUsingIf(list.tail,acc,count+1,list.head)
      else {
        countCompressUsingIf(list.tail,acc:::List((count+1,list.head)),0,list.head)
      }
    }
    countCompressUsingIf(list,List(),0,0)
  }
def main(Args:Array[String]):Unit={
val list:List[Int]=List(3,3,3,3,4,4,4,4,4,5,6,7,8,8,9)
  println(compress(list))
  println(compressList(list))
}
}
