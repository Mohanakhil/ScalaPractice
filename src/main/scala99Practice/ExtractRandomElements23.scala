import scala.annotation.tailrec
import scala.util.Random

object ExtractRandomElements23
{
  val extract: (List[Int],Int)=>List[Int] = (list:List[Int], n:Int)=>{
    @tailrec
    def extractList(list:List[Int], acc:List[Int], counter:Int):List[Int]={
      if(list.isEmpty||counter>=n) return acc
      val index:Int=new Random().nextInt(list.size)
      extractList(list.splitAt(index)._1:::list.splitAt(index+1)._2,acc:+list(index),counter+1)
    }
    extractList(list,List(),0)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6,7,8,9,10,11)
    val n:Int=3
    println(extract(list,n))
  }
}
