import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object PackDuplicatesIntoList18
{
  @tailrec
  def packList(list:List[Int],newList:ListBuffer[ListBuffer[Int]],innerList:ListBuffer[Int]):ListBuffer[ListBuffer[Int]]={
    if(list.isEmpty||list.size==1){
      if(innerList.nonEmpty) newList.addOne(innerList)
      if(list.size==1) newList.addOne(ListBuffer(list.head))
      newList}
    else if(list.head.compare(list(1))==0){
      innerList.addOne(list.head)
      packList(list.tail,newList,innerList)
    }
    else{
      if(innerList.nonEmpty) newList.addOne(innerList)
      packList(list.tail,newList,ListBuffer())
    }
  }

  @tailrec
  def convertToTuples(list: ListBuffer[ListBuffer[Int]],x:ListBuffer[Any]):ListBuffer[Any]={
    if(list.isEmpty) return x
    if(list.head.size==1)
      x.addOne(list.head.head)
    if(list.head.size>1){
      val t:(Int, Int)=(list.head.size,list.head.head)
      x.addOne(t)
    }
    convertToTuples(list.tail,x)
  }
def main(Args:Array[String]):Unit={
  val list:List[Int]=List(1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,5)
  val newList:ListBuffer[ListBuffer[Int]]=ListBuffer()
  val innerList:ListBuffer[Int]=ListBuffer()
  val packagedList:ListBuffer[ListBuffer[Int]]= packList(list,newList,innerList)
  println(packagedList)
  val x:ListBuffer[Any]=ListBuffer()
  println("after converting to tuple"+convertToTuples(packagedList,x))
}
}
