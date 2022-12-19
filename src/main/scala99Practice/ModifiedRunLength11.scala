import scala.annotation.tailrec

object ModifiedRunLength11
{
  val modify: List[Int]=>List[(Int,Int)] = (list:List[Int])=>{
    @tailrec
    def modifyList(list:List[Int], acc:List[(Int,Int)], count:Int,last:Int):List[(Int,Int)]={
      list match {
        case Nil=> acc
        case first::Nil=>if(first==last){
          modifyList(list.tail,acc:::List((count+1,list.head)),0,list.head)
        }
        else modifyList(list.tail,acc:::List((1,list.head)),0,list.head)
        case first::second::_=>if(first==second){
          modifyList(list.tail,acc,count+1,list.head)
        }
        else{
          modifyList(list.tail,acc:::List((count+1,list.head)),0,list.head)
        }
      }
    }
    modifyList(list,List(),0,0)
  }
def main(Args:Array[String]):Unit={
val list:List[Int]=List(3,4,5,6,7,8,8,8)
  val mList:List[(Int,Int)]=modify(list)
  println(mList)
  val requiredList:List[Any]=List()
    println(mList.foldLeft(requiredList)((acc,ele)=>{
      ele match {
        case (1,h)=>acc:+h
        case (a,b)=>acc:+ele
      }
    }))
}
}
