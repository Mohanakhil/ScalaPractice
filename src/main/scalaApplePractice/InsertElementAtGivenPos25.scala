object InsertElementAtGivenPos25
{
def main(Args:Array[String]):Unit={
  val list:List[Int]=List(3,4,5,6)
  val addedList:List[Int]=List()
  val x:Int=100
  val pos:Int=4
  val counter:Int=0
  val t:(List[Int],Int)=list.foldLeft((addedList,counter))((acc,ele)=>{
  if(list.isEmpty||pos>=list.size) (list:+x,acc._2)
  else if(acc._2==pos) (acc._1:+x:+ele,acc._2+1)
  else (acc._1:+ele,acc._2+1)
  })
  println(t._1)
}
}
