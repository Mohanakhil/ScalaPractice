import scala.annotation.tailrec

object DeterminePrimeFactors36 {
@tailrec
def divideTillLast(n:Int, counter:Int, acc:List[Int], ct:Int):(List[Int],Int,Int,Int)={
  if(n%counter==0) divideTillLast(n/counter,counter,acc:+counter,ct+1)
  else (acc,ct,n,counter)
}

  val primeFactors: Int=> List[(Int,Int)] = (n:Int)=>{
   @tailrec
   def primeFactorization(n:Int, counter:Int, acc:List[(Int,Int)]): List[(Int,Int)] ={
     if(counter<=n){
    val   (a:List[Int],b:Int,c:Int,d:Int) = divideTillLast(n,counter,List(),0)
       if(a.nonEmpty)
       primeFactorization(c,d+1,acc:::List((a.head,b)))
       else primeFactorization(c,d+1,acc)
     }
     else{
       acc
     }
  }
    primeFactorization(n,2,List())
  }


def main(Args:Array[String]):Unit={
  val n:Int=81
  println(primeFactors(n))
}

}
