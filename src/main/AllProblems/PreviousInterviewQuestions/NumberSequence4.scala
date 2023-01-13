object NumberSequence4
{
    def main(Args:Array[String]):Unit={
      val n:Int=100
      val acc:String=""
      println(List.range(51,n).foldLeft(acc)((acc,ele)=>{
        acc+"X"+ele+", "
      }))
    }
}
