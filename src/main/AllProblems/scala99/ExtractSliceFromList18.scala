import scala.annotation.tailrec

object ExtractSliceFromList18
{
  val sliceList:(List[Int],Int,Int)=> List[Int] = (list:List[Int], i:Int, k:Int)=>{
    val length:Int=list.length
    @tailrec
    def slice(list:List[Int], acc:List[Int], counter:Int):List[Int]={
      (counter>=i,counter>=k,counter<length) match {
        case (false,false,true)=>slice(list.tail,acc,counter+1)
        case (true,false,true)=>slice(list.tail,acc:+list.head,counter+1)
        case (true,true,true)=>acc
        case (_,_,false)=>acc
      }
    }
    slice(list,List(),0)
  }
    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(1,2,3,4,5,6,7,8)

      val i:Int=2
      val k:Int=7

      println(sliceList(list,i,k))


      println(list.slice(i,k))
    }
}
