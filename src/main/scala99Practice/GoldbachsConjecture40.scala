import scala.annotation.tailrec

object GoldbachsConjecture40
{
  @tailrec
  def isPrimeNumber(n:Int, counter:Int):Boolean={
    (n%counter,counter) match {
      case (0,_)=>false
      case (_,h)=>if(h>n/2) true
      else isPrimeNumber(n,counter+1)
    }
  }

  @tailrec
  def iterate(list:List[Int], n:Int):(Int,Int)={
    if(list.isEmpty)(0,0)
    else{
      (list.head, n - list.head) match {
        case (a, b) => if (list.contains(b)) (a, b)
        else iterate(list.tail, n)
      }
    }
  }

  val gold:Int=>(Int,Int) = (n:Int)=>{
    val reqList: List[Int] = List(2)
   val listOfPrimes:List[Int]= List.range(2,n).foldLeft(reqList)((acc,ele)=>{
     if(isPrimeNumber(ele,2)) acc:+ele
     else acc
   })
    iterate(listOfPrimes,n)
  }

  def main(Args:Array[String]):Unit={
    val n:Int=56
    println(gold(n))



    //41st problem list of goldbach compositions
    val low:Int=9
    val high:Int=20
    val reqList:List[(Int,Int)]=List()
    println(List.range(low,high+1).foldLeft(reqList)((acc,ele)=>{
      if(ele%2==0)
      acc:+gold(ele)
      else acc
    }))
  }
}
