object RemoveKthElementFromList24
{
def main(Args:Array[String]):Unit={
  val list:List[Int]=List(3,4,5,6,7)
  val outList:List[Int]=List()
  val k:Int=3
  val outElement:Int=0
  val counter:Int=0
  val t1:(List[Int], Int, Int)= list.foldLeft(outList,outElement,counter)((acc, ele)=>{
    if(list.isEmpty) (acc._1,acc._2,acc._3)
    else if(acc._3==k){
      val x:Int=ele
      (acc._1,x,acc._3+1)
    }
    else (acc._1:+ele,acc._2,acc._3+1)
  })
  println((t1._1,t1._2))
}
}
