import scala.annotation.tailrec

object KthElementRecursion12
{
    val kth_ele: (List[Int], Int) => Option[Int] = (list:List[Int], k:Int)=>{
    val size=list.size
      @tailrec
    def findKthElement(list:List[Int],x:Option[Int]):Option[Int]={
      if(list.size<=0) x
     if(list.size<=(size-k)) x
     else findKthElement(list.tail,list.headOption)
    }
    findKthElement(list,None)
  }

def main(Args:Array[String]):Unit={
  val list:List[Int]=List(1,2,3,4,5)
  val k=1
  println(kth_ele(list,k))
  //using higher order functions
  println(list.filter(x=>{list.indexOf(x)==k-1}).headOption)
}
}
