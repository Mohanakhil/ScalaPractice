object RemoveKthElementFromList20
{
    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(3,4,5,6,7,8)
      val k:Int=2

      val outputList:List[Int]=List()
      val counter:Int=0

      //remove kth element from list
      println(list.foldLeft(outputList,counter)((acc,ele)=>{
        if(acc._2==k) (acc._1,acc._2+1)
        else (acc._1:+ele,acc._2+1)
      }))
    }
}
