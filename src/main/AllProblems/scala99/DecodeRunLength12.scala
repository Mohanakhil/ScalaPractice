import scala.annotation.tailrec

object DecodeRunLength12
{
  val decodeList: List[(Int,Int)]=>List[Int] = (list:List[(Int,Int)])=>{
    @tailrec
    def decode(list:List[(Int,Int)], acc:List[Int]):List[Int]={
      list match {
        case Nil=>acc
        case a::tail=>if(a._1!=0)
        {
          val counter:Int=list.head._1-1
          val element=list.head._2
          decode(List((counter,element)):::tail, acc:+element)
        }
        else
        {
          decode(tail,acc)
        }
      }
    }
    decode(list,List())
  }
    def main(Args:Array[String]):Unit={
      val list:List[(Int,Int)]=List((3,1),(5,2),(1,3))
      println(decodeList(list))

      var reqList:List[Any]=List()
      list.foreach(x=>{
        reqList=reqList:::List.fill(x._1)(x._2)
      })
      println(reqList)

      val rList:List[Any]=List()
      println(list.foldLeft(rList)((acc,ele)=>{
        acc:::List.fill(ele._1)(ele._2)
      }))
    }
}
