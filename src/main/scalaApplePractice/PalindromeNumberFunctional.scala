object PalindromeNumberFunctional {
  def isPalindrome(n:Int):Boolean={
   if(n.compare(n.toString.reverse.toInt)==0)
     true
   else
    false
  }

  def main(args:Array[String]):Unit={
    val n=scala.io.StdIn.readInt()
    println(isPalindrome(n))
  }
}
