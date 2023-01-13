import scala.annotation.tailrec

object CheckIfListIsPalindrome6
{

val isPalindrome: List[Int]=>Boolean = (list:List[Int])=>{
  @tailrec
  def reverse(list:List[Int], acc:List[Int]):List[Int]={
    list match {
      case h::tail=>reverse(tail,h::acc)
      case Nil=>acc
    }
  }
  reverse(list,List())==list
}
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,4,3)


    //using tail recursion
    println(isPalindrome(list))


    //using in built function
    if(list.equals(list.reverse)) println("palindrome") else println("not a palindrome")
  }
}
