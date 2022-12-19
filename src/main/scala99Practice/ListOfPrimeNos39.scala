import scala.annotation.tailrec

object ListOfPrimeNos39
{
  @tailrec
  def isPrimeNumber(n:Int, counter:Int):Boolean={
    (n%counter,counter) match {
      case (0,_)=>false
      case (_,h)=>if(h>n/2) true
      else isPrimeNumber(n,counter+1)
    }
  }
  def main(Args:Array[String]):Unit={
    val low:Int=3
    val high:Int=100
    val reqList:List[Int]=List(2)
    val count:Int=1
    println(List.range(low,high+1).foldLeft(reqList,count)((acc,ele)=>{
      if(isPrimeNumber(ele,2)){
        (acc._1:+ele,acc._2+1)
      }
      else acc
    }))
  }
}
