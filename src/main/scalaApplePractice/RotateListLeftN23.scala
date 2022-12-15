object RotateListLeftN23
{
def main(Args:Array[String]):Unit={
  val list:List[Int]=List(3,4,5,6)
  val count:Int=3
  val rotatedList:List[Int]=List()
  println(list.foldLeft((list,count))((acc,ele)=>{
    if(acc._2<=0) (acc._1,acc._2)
    else (acc._1.tail:+acc._1.head,acc._2-1)
  }))
}
}
