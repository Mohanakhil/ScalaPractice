object PalindromeNumber
{
  def isPalindrome(n:Int)={
    var rev=0
    var x=n
    while(x>0){
      rev=rev*10+x%10
      x=x/10
    }
    println("rev= "+rev)
    if(rev.compare(n)==0){
      println("palindrome")
    }
    else{
      println("not a palindrome")
    }
  }
  def main(args:Array[String]):Unit={
    val n:Int=scala.io.StdIn.readInt()
    isPalindrome(n)
  }
}
