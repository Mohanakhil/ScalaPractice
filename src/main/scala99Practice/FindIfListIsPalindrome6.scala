import scala.annotation.tailrec

object FindIfListIsPalindrome6
{
//using tail rec and pattern matching
  val isPalindromePattern:List[Int]=>Boolean=(list:List[Int])=>{

    @tailrec
    def findPalindromeUsingMatch(list:List[Int], acc:List[Int]):List[Int]={
      list match {
        case Nil=>acc
        case _=>findPalindromeUsingMatch(list.tail,list.head+:acc)
      }
    }
    val acc:List[Int]=findPalindromeUsingMatch(list,List())
    acc==list
  }


  //using tail rec and if else
  val isPalindrome:List[Int]=>Boolean=(list:List[Int])=>{
      @tailrec
      def findPalindromeIf(list:List[Int],acc:List[Int]):List[Int]={
       if(list.isEmpty) acc
       else findPalindromeIf(list.tail,list.head+:acc)
   }
     val acc:List[Int]=findPalindromeIf(list,List())
    list==acc
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,4,3)
    println(isPalindrome(list))

    println(isPalindromePattern(list))
    val result:List[Int]=List()
    //using foldRight
    val reversedList:List[Int]=list.foldRight(result)((ele,acc)=>{
      list match {
        case Nil=>acc
        case _=>acc:+ele
      }
    })
    println(reversedList==list)


    //using foldLeft
    val reversedList2:List[Int]=list.foldLeft(result)((acc,ele)=>{
      list match {
        case Nil=>acc
        case _=>ele+:acc
      }
    })
    println(reversedList2==list)
  }
}
