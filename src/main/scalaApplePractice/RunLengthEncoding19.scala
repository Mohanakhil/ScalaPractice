import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object RunLengthEncoding19
{
  @tailrec
  def encode(list: List[Int], count:Int, listOfTuple: ListBuffer[(Int, Int)]):ListBuffer[(Int, Int)]={
    if(list.isEmpty||list.size==1) {
      if(list.size==1)
        {
          val c:Int=if(count>0) {count+1} else{1}
          listOfTuple.addOne((c,list.head))
        }
      return listOfTuple
    }
    if(list.head.compare(list(1))==0){
      encode(list.tail,count+1,listOfTuple)
    }
    else{
      encode(list.tail,0,listOfTuple.addOne((count+1,list.head)))
    }
  }

    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(1,1,1,1,2,2,2,3,5,5,6,6,6,6,6,7,7,8,9,10,10,10,11)
      val listOfTuple:ListBuffer[(Int,Int)]=ListBuffer()
      println(encode(list,0,listOfTuple))
    }
}
