

object PrimeNumbersRecursion7 {

  //loop
//  def prime_number(n:Int):Boolean={
//  for(i<- 2 until n){
//    if(n%i==0){
//      false
//    }
//  }
//    true
//  }

  def prime_number(n:Int,i:Int):Boolean={
    if(i>=n) return true
    if(n==1) return false
    if(n==2) return true
    if(n%i==0) return false
    prime_number(n,i+1)
  }
  def main(Args:Array[String]):Unit={
    println(prime_number(13,2))
  }
}
