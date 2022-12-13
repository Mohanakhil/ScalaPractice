import scala.annotation.tailrec

object ListIsPalindrome15
{
  val list_is_palindrome:List[Int]=>Boolean=list=>{
    @tailrec
    def isPalindrome(list:List[Int], start:Int, end:Int):Boolean={
      if(start>=end) return true
      if(list(start).compare(list(end))!=0) return false
      isPalindrome(list, start+1, end-1)
    }
    isPalindrome(list,0,list.length-1)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(1,2,3,4,3,2,1)
    println(list_is_palindrome(list))
  }

}
