import scala.annotation.tailrec

object LastButOneElementRecursion11
{
  val last_but_one_ele: List[Int] => Option[Int] = (list: List[Int]) => {
    @tailrec
    def findLastButOne(list: List[Int],x:Option[Int]): Option[Int] = {
//      if (list.size < 2) return x
//      findLastButOne(list.tail, list.headOption)
      list.size match {
        case 0 =>x
        case 1 => x
        case _ =>findLastButOne(list.tail,list.headOption)
//        case h::_::Nil => Some(h)
//        case _ => findLastButOne(list.tail)
      }
    }

    findLastButOne(list,None)
  }
def main(Args:Array[String]): Unit ={
  val list:List[Int]=List(1,2,3,4)
  println(last_but_one_ele(list))
  println(list.find(x => list.indexOf(x) == list.length - 2))
  val k = 9
  println(list.foldLeft(None:Option[Int],k){(acc,ele)=>{
    if(list.indexOf(ele) == acc._2 ) (Some(ele),acc._2)
    else acc
  }}._1)
}
}
