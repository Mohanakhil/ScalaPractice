object SplitListInto2Parts
{
  def split(list:List[Int],n:Int):(List[Int],List[Int])={
   list.splitAt(n)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(1,2,3,4,5,6,7,8)
    println(split(list,3))
  }
}
