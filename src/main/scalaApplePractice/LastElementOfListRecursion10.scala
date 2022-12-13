import scala.annotation.tailrec

object LastElementOfListRecursion10 {

  val last_ele: List[Int] => Option[Int] = (list: List[Int]) => {
    @tailrec
    def findLastElement(list: List[Int], x: Option[Int]): Option[Int] = {
      if (list.isEmpty) x
      else findLastElement(list.tail, list.headOption)
    }
    findLastElement(list, None)
  }

  val last_ele_higher_order:List[Int]=>Option[Int]=(list:List[Int])=>{
    Option(list.filter(x=>list.indexOf(x)==list.length).head)


   Option(list.reduce((a:Int,b:Int)=>b))

  }

  def main(Args:Array[String]): Unit ={
    val list:List[Int]=List(1,2,3,4,5,6)
    println(last_ele(list))
    val list2:List[Int]=List(1,2,3,4,5,6,7,9)
    println(last_ele_higher_order(list2))
    println(List(1,2,3).foldLeft(0){(acc,ele)=>ele})
  }
}
