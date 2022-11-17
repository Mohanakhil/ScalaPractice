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

  def main(args:Array[String]):Unit={
    evenOdd(100)
  }


}
