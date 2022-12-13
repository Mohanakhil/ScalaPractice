object EvenOdd
{
  def evenOdd(n:Int):Unit={
    if(n%2==0){
       println("Even")
    }
    else {
       println("odd")
    }
  }

  def even_or_odd(n:Int):Boolean={
    if(n%2==0) true
    else false
  }

  def main(args:Array[String]):Unit= {
    evenOdd(100)
    println(even_or_odd(101))
  }
}
