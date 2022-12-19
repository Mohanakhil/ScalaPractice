import scala.annotation.tailrec

object createListGivenRange22
{
  val createList:(List[Int],Int,Int)=>List[Int]=(list:List[Int],low:Int,high:Int)=>{
    @tailrec
    def createListGivenRange(list:List[Int], counter:Int):List[Int]={
      if(counter>=low&&counter<=high) createListGivenRange(list:+counter,counter+1)
      else list
    }
    createListGivenRange(list,low)
  }
def main(Args:Array[String]):Unit={
  val list:List[Int]=List()
  val low:Int=4
  val high:Int=9
  println(createList(list,low,high))

  println(List.range(low,high))
}
}
