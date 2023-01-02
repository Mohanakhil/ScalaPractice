import scala.annotation.tailrec

object SelectionSortList
{
    @tailrec
    def minimumElement(list: List[Int], min:Int): Int ={
      list match {
        case Nil=> min
        case first::_=>
          if(first<min) minimumElement(list.tail,first)
          else minimumElement(list.tail,min)
      }
    }

  val selectionSort: List[Int]=>List[Int] = (list:List[Int])=>{
    @tailrec
    def selectionSorting(list:List[Int], acc:List[Int]):List[Int]={
      if(list.isEmpty) return acc
       val currMin:Int =minimumElement(list,100)
      selectionSorting(list.splitAt(list.indexOf(currMin))._1:::list.splitAt(list.indexOf(currMin)+1)._2,acc:+currMin)
    }
    selectionSorting(list,List())
  }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(7,1,6,2,5,3,4)
    println(selectionSort(list))
  }
}
