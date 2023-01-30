import scala.annotation.tailrec

object SubArrayWithGivenSum54
{
  val findSubArrayWithSum:(Array[Int],Int)=> Array[(Int,Int)] = (a:Array[Int], sum:Int)=>{
  @tailrec
  def find(i:Int, j:Int, acc:Array[(Int,Int)], total:Int):Array[(Int,Int)]={
   if(i>=a.length-1){
     if(a(i)==sum) acc:+(i,i)
     else acc
   }
   else if(j>=a.length) find(i+1,i+2,acc,a(i+1))
   else if(total==sum) find(i+1,i+2,acc:+(i,j-1),a(i+1))
   else if(total>sum) find(i+1,i+2,acc,a(i+1))
   else find(i,j+1,acc,total+a(j))
  }
    find(0,1,Array(),a(0))
}

  val findSubArrayWithSumUsingSlidingWindow:(Array[Int],Int)=>Unit=(a:Array[Int],sum:Int)=>{
    @tailrec
    def find(i:Int, acc:Array[Int],k:Int):Unit={
      if(i>=a.length){

        println("all subarrays are printed")
      }
      else if(acc.sum<sum) find(i+1,acc:+a(i),k)
      else if(acc.sum==sum){
        println(acc.mkString("Array(", ", ", ")"))
        find(k+1,Array(),k+1)
      }
      else find(i+1,acc.tail,k)
    }
    find(0,Array(),0)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1,2,3,4,5,6,7,8,9,11,12,15)
    val sum:Int=scala.io.StdIn.readInt()
    //using brute force approach
    println(findSubArrayWithSum(a, sum).mkString("Array(", ", ", ")"))

    //using sliding window
    println("all sub arrays are")
    println(findSubArrayWithSumUsingSlidingWindow(a,sum))
  }

}
