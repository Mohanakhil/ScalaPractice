import scala.annotation.tailrec

object ExtractSliceFromList18
{
  val extract: (List[Int],Int,Int)=>List[Int] = (list:List[Int], i:Int, k:Int)=>{
    @tailrec
    def extractList(list:List[Int], acc:List[Int], counter:Int):List[Int]={
      if(list.isEmpty) acc
      else  if(counter>=i&&counter<=k) extractList(list.tail,acc:+list.head,counter+1)
      else extractList(list.tail,acc,counter+1)
    }
    extractList(list,List(),0)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6,7,8,9)
    val i:Int=2
    val k:Int=4
    println(extract(list,i,k))

    val reqList:List[Int]=List()
    val counter:Int=0
    println(list.foldLeft(reqList,counter)((acc,ele)=>{
      if(acc._2>=i&&acc._2<=k) (acc._1:+ele,acc._2+1)
      else (acc._1,acc._2+1)
    })._1)
  }
}
