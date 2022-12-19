import scala.annotation.tailrec

object BinarySearchTailRecursion
{
  val binarySearch: (List[Int],Int)=>(Boolean,Int) = (list:List[Int], n:Int)=>{
    @tailrec
    def binarySearch(list:List[Int], left:Int, right:Int):(Boolean,Int)={
      left<=right match {
        case true=> if(n==list((left+right)/2)) (true,(left+right)/2)
        else if(n>list((left+right)/2)) {
          binarySearch(list,((left+right)/2)+1,right)}
          else binarySearch(list,left, (left+right)/2-1)
        case false=>(false,-1)
      }
    }
    binarySearch(list,0,list.size-1)
  }
 def main(Args:Array[String]):Unit={
   val list:List[Int]=List(3,4,5,6,7,8)
   val n:Int=1
   println(binarySearch(list,n))
 }
}
