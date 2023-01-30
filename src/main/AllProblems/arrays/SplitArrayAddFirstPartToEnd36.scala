object SplitArrayAddFirstPartToEnd36
{
  val splitAndAdd:(Array[Int],Int)=>Array[Int]=(a:Array[Int],k:Int)=>{
   a.slice(k,a.length)++a.slice(0,k)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(12,10,5,6,52,36)
    val k:Int=2
    println(splitAndAdd(a, k).mkString("Array(", ", ", ")"))
  }
}
