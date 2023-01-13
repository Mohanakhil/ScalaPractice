import scala.annotation.tailrec

object RotateListNTimes19
{
  val leftRotate:(List[Int],Int)=>List[Int]=(list:List[Int],n:Int)=>{
    val length:Int=list.length
    @tailrec
    def rotate(list:List[Int], counter:Int):List[Int]={
      if(counter>=n||counter>length) list
      else rotate(list.tail:+list.head,counter+1)
    }
    rotate(list,0)
  }

  val rightRotate:(List[Int],Int)=>List[Int]=(list:List[Int],n:Int)=>{
    val length:Int=list.length
    @tailrec
    def rotate(list:List[Int], counter:Int):List[Int]={
      if(counter>n||counter>length) list
      else rotate(list.last::list.slice(0,length-1),counter+1)
    }
    rotate(list,0)
  }
    def main(Args:Array[String]):Unit={
      val list:List[Int]=List(3,4,5,6,7,8)
      println(list)
      val n:Int=3

      //left rotate
      println(leftRotate(list,n))

      //right rotate
      println(rightRotate(list,n))

    }
}
