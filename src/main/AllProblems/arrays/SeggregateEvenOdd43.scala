import scala.annotation.tailrec

object SeggregateEvenOdd43
{
  val seggregateEvenOdd:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def seggregate(counter:Int, c:Int, a:Array[Int]):Array[Int]={
      if(counter<=c) a
      else if(a(counter)%2==0) seggregate(counter,c+1,Array(a(counter))++a.slice(0,counter)++a.slice(counter+1,a.length))
      else seggregate(counter-1,c,a)
    }
    seggregate(a.length-1,0,a)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array( 1, 3, 2, 4, 7, 6, 9, 10)
    println(seggregateEvenOdd(a).mkString("Array(", ", ", ")"))
  }
}
