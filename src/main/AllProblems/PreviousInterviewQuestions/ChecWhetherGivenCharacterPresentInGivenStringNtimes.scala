object ChecWhetherGivenCharacterPresentInGivenStringNtimes
{
 def main(Args:Array[String]):Unit={
   val s1:String="rama sai mohan akhil is working in techsophy since last 2 years"
   val c:Char=scala.io.StdIn.readChar()
   println(s1.count(x=>x.equals(c)))
   val count:Int=s1.count(x=>x.equals(c))
   if(count>=2&&count<=4)
     println("true")
   else println("false")
 }
}
