

object ExtractSliceListTailRec22
{
//  @tailrec
//  def extractList(list: List[Int], sliceList: List[Int], diff:Int):List[Int]={
//    if(list.isEmpty||diff==0)return sliceList
//    if(list.head==list(l)) extractList(list.tail,sliceList:+list.head,diff)
//    else extractList(list.tail,sliceList,diff-1)
//  }
 def main(Args:Array[String]):Unit={
   val list:List[Int]=List(1,2,3,4,5,6,7)
   val sliceList:List[Int]=List()
   val l:Int=0
   val k:Int=4

  val slicedList:List[Int]=List()
   println(list.foldLeft((slicedList,0))((acc,ele)=>{
     if(acc._2==k) acc
     if(acc._2>=l && acc._2<=k-1) {
       (acc._1:+ele,acc._2+1)
     }
     else (acc._1,acc._2+1)
   })._1)
 }
}
