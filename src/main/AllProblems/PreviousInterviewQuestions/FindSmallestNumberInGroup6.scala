object FindSmallestNumberInGroup6
{
    def main(Args:Array[String]):Unit={
      val a:List[Int]=List(5,4,3,6)
      val min:Int=a.head
      println(a.foldLeft(min)((acc,ele)=>{
        ele<acc match {
          case true=>ele
          case false=>acc
        }
      }))

    }
}
