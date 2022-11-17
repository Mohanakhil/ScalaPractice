object PrimeOrNot
{
def isPrime(n:Int): Unit ={
  var x=n
  var count:Int=0
  for(i<- 1 to n){
    if(n%i==0){
    count=count+1
    }
  }
  if(count==2){
    println("prime")
  }
  else{
    println("composite")
  }

}
  def main(args:Array[String]): Unit ={
   val x=scala.io.StdIn.readInt()
    isPrime(x)
  }
}
