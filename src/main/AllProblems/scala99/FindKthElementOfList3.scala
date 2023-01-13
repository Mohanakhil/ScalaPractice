object FindKthElementOfList3
{
  val findKth:(List[Int],Int)=>Int=(list:List[Int],k:Int)=>{
    def findKthElementOfList(list:List[Int],k:Int):Int={
      (list,k) match {
        case (h::_,0)=>h
        case (_,_)=>findKthElementOfList(list.tail,k-1)
      }
    }
  findKthElementOfList(list,k)
  }
  def main(Args:Array[String]):Unit={
    val k:Int=1
    val list:List[Int]=List(3,4,5,6)
    println(findKth(list,k))
  }
}
