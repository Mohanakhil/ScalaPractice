import scala.annotation.tailrec

object SplitAndAddFirstPartAtEnd24
{
  val splitAndAddAtEnd:(Array[Int],Int)=>Array[Int]=(a:Array[Int],k:Int)=>{
    @tailrec
    def addAtEnd(a:Array[Int], counter:Int):Array[Int]={
     if(counter==k) a
     else addAtEnd(a.tail:+a.head,counter+1)
    }
    addAtEnd(a,0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(2,3,4,5,6,7,9,10)
    val k:Int=4
    println(splitAndAddAtEnd(a,k).mkString("Array(",",",")"))


    println((a.slice(k, a.length) ++ a.slice(0, k)).mkString("Array(", ", ", ")"))
  }
}
