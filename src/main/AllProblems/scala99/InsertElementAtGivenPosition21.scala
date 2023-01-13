object InsertElementAtGivenPosition21
{
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6)

    val n:Int=101
    val pos:Int=3

    val outputList:List[Int]=List()
    val counter:Int=0
    println(list.foldLeft(outputList,counter)((acc,ele)=>{
      if(acc._2==pos) (acc._1:::List(n,ele),acc._2+1)
      else (acc._1:+ele,acc._2+1)
    }))
  }
}
