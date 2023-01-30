import scala.annotation.tailrec

object MoveAllZeroesToEnd39
{
  val moveZeroesToEnd:Array[Int]=>Unit=(a:Array[Int])=>{
    @tailrec
    def removeZeroes(a:Array[Int], counter:Int, countOfZeroes:Int):(Int,Array[Int])={
      if(counter>=a.length) (countOfZeroes,a)
      else if(a(counter)==0) removeZeroes(a.slice(0,counter)++a.slice(counter+1,a.length),counter,countOfZeroes+1)
      else removeZeroes(a,counter+1,countOfZeroes)
    }
   val (count:Int,b:Array[Int])= removeZeroes(a, 0, 0)
   println((b ++ List.fill(count)(0)).mkString("Array(", ", ", ")"))
  }

  val moveZeroesToEndUsingSwap:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    for(i<- 0 until a.length-1){
      if(a(i)==0){
        var j=i+1
        while(a(j)==0&&j<a.length-1){
           j=j+1
        }
        a(i)=a(j)
        a(j)=0
      }
    }
    a
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1, 2, 0, 0, 0, 3, 6)
   moveZeroesToEnd(a)

    //using swap of elements
    println(moveZeroesToEndUsingSwap(a).mkString("Array(", ", ", ")"))
  }
}
