import scala.annotation.tailrec

object BinarySearchTailRecursion
{
  val binarySearch: (List[Int],Int)=>(Boolean,Int) = (list:List[Int], n:Int)=>{
    @tailrec
    def binarySearch(list:List[Int], left:Int, right:Int):(Boolean,Int)={
      val mid:Int=(left+right)/2
      if (left <= right)
      {
        if (n == list(mid)) (true, mid)
        else if (n > list((left + right) / 2))
        {
          binarySearch(list, mid + 1, right)
        }
        else binarySearch(list, left, mid - 1)
      }
      else
      {
        (false, -1)
      }
    }
    binarySearch(list,0,list.size-1)
  }

  val binary: (List[Int],Int)=> Boolean = (list:List[Int], n:Int)=>{
    @tailrec
    def binarySearch(list:List[Int]): Boolean ={
      list match {
        case Nil=> false
        case h::Nil=>if(h==n) true
        else false
        case _=>
          val mid=list(list.length/2)
          if(mid==n) true
          else if(n>mid){
            binarySearch(list.slice((list.length/2)+1,list.length))
          }
          else binarySearch(list.slice(0, list.length/2))
      }
    }
    binarySearch(list)
  }

 def main(Args:Array[String]):Unit={
   val list:List[Int]=List(3,4,5,6,7,8,9,10,11)
   val n:Int=10
   println(binarySearch(list,n))

   println(binary(list,n))
 }
}
