import scala.annotation.tailrec

object RemoveDuplicatesFromSortedArray10
{
  val removeDuplicates:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def remove(a:Array[Int], index:Int):Array[Int]={
      if(index>=a.length-1) a
      else if(a(index)!=a(index+1)) remove(a,index+1)
      else remove(a.slice(0,index)++a.slice(index+1,a.length),index)
    }
    remove(a,0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1,1,1,2,3,3,6,6,6,7,7,7,7)
    println(removeDuplicates(a).mkString("Array(",",",")"))
  }
}
