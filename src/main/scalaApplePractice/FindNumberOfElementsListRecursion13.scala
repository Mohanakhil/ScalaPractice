import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object FindNumberOfElementsListRecursion13
{
  val ele_count: List[Int] => Int = (list:List[Int])=>{
    @tailrec
    def findLengthOfList(list: List[Int],count:Int):Int={
      if(list.isEmpty) count
      else {
        findLengthOfList(list.tail,count+1)}
    }
    findLengthOfList(list,0)
  }


  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(1,2,3,4,5,6,7)
//    val emptyList = List.empty[Int]
//    println(emptyList.map(ele => 1).reduce((acc, ele) => acc + ele))

    println(list.map(ele => 1).reduce((acc, ele) => acc + ele))
    println(list.reduce((acc, ele) => acc + 1))
    println(ele_count(list))
    println(list.fold(0) { (acc, _) => acc + 1 })
    val list2:ListBuffer[Int]=ListBuffer()
    list.map((x)=>list2.addOne(x))

//    println(list.reduce((a,b)=>{count=count+2}))
  }
}
