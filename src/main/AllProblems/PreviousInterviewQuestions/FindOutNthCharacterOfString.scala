import scala.annotation.tailrec

object FindOutNthCharacterOfString
{
  val findNthCharacter:(String,Int)=>Char=(s:String,n:Int)=>{
    @tailrec
    def find(s:String, n:Int):Char={
      if(n==0) s.head
      else find(s.tail,n-1)
    }
    find(s,n)
  }
  def main(Args:Array[String]):Unit={
    val s:String="denduluri rama sai mohan akhil"
    val n:Int=8
    println(findNthCharacter(s,n))
    println(s.charAt(n))
  }
}
