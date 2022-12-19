import scala.annotation.tailrec

object IfPrime31
{
  val isPrime: Int=>Boolean = (n:Int)=>{
    @tailrec
    def checkPrime(n:Int, counter:Int):Boolean={
      (n%counter,counter) match {
        case (0,_)=>false
        case (_,h)=>
          if(h>=n/2) true
          else checkPrime(n,counter+1)
      }
    }
    checkPrime(n,2)
  }
  def main(Args:Array[String]):Unit={
    val n:Int=scala.io.StdIn.readInt()
    println(isPrime(n))
  }
}
