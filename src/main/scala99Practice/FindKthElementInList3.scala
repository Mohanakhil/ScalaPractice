import scala.annotation.tailrec

object FindKthElementInList3
{
  val kthElement:(List[Int],Int)=>Option[Int]=(list:List[Int],k:Int)=>{
    @tailrec
    def findKthElementUsingPattern(list:List[Int], k:Int):Option[Int]={
      (k,list) match {
        case (0,h::_)=>Some(h)
        case (k,_::tail)=> findKthElementUsingPattern(tail,k-1)
      }
    }
    findKthElementUsingPattern(list,k)
  }
  val kth:(List[Int],Int)=>Option[Int]=(list:List[Int],k:Int)=>{
    @tailrec
    def findKthElement(list:List[Int],k:Int, acc:Option[Int]):Option[Int]={
      if(list.isEmpty) return Some(-1)
      if(k<0)      acc
      else findKthElement(list.tail,k-1,list.headOption)
    }
    findKthElement(list,k,None)
  }
 def main(Args:Array[String]):Unit={
   val list:List[Int]=List(3,4,5,6,7,8)
   val k:Int=4
   //using tailrec and if else
   println(kth(list,k))
   //using tailrec and pattern matchingL
   println(kthElement(list,k))

   //using foldLeft and if else
   println(list.foldLeft((None:Option[Int],k))((acc,ele)=>{
     if(acc._2==0) (Some(ele),acc._2-1)
     else (acc._1,acc._2-1)
   })._1)

   //using foldLeft and  patternMatching
   println(list.foldLeft((None: Option[Int], k))((acc, ele) => {
     acc._2 match {
       case 0 =>(Some(ele),acc._2-1)
       case _ =>(acc._1,acc._2-1)
     }
   })._1)
 }
}
