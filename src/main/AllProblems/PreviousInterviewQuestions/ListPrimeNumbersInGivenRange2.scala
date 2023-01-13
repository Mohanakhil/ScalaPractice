import scala.annotation.tailrec

object ListPrimeNumbersInGivenRange2
{
  val isPrime: Int=>Boolean = (x:Int)=>{
    @tailrec
    def check(x:Int, counter:Int):Boolean={
      if(counter>x/2) true
      else if(x%counter==0) false
      else check(x,counter+1)
    }
    check(x,2)
  }
  def main(Args:Array[String]):Unit={
    val a:Int=1
    val b:Int=100
    val acc:List[Int]=List()
    println(List.range(a,b+1).foldLeft(acc)((acc,ele)=>{
      if(ele==1) acc
      else if(isPrime(ele)) acc:+ele
      else acc
    }))
  }
}
