import scala.annotation.tailrec

object LongestConsecutiveSequence
{
  val longestSequence: List[Int]=>(Int,Int) = (list:List[Int])=>{
    @tailrec
    def longestConsecutiveSequence(list:List[Int], n:Int, count:Int, max:Int,last:Int):(Int,Int)={
      list match {
        case Nil=>(n,max)
        case first::Nil=> if(first==last) {
          if(count+1>max) longestConsecutiveSequence(list.tail,first,0,count+1,list.head)
          else longestConsecutiveSequence(list.tail,n,0,max,list.head)
        }
        else longestConsecutiveSequence(list.tail,n,0,max,list.head)
        case first::second::_=>if(first==second){
          longestConsecutiveSequence(list.tail,n,count+1,max,list.head)
        }
        else{
          if(count>max){
            longestConsecutiveSequence(list.tail,list.head,0,count+1,list.head)
          }
          else longestConsecutiveSequence(list.tail,n,0,max,list.head)
        }
      }
    }
    longestConsecutiveSequence(list,0,0,0,0)
  }


  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,4)
    println(longestSequence(list))
    val max:Int=0
    val req:Int=0
    val count:Int=0
    val last:Int=list.head
//    list.foldLeft((max,req,count))((acc,ele)=>{
//
//    })
  }
}
