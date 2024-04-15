import scala.annotation.tailrec

object ReverseList5
{
  val reverse:List[Int]=>List[Int]=(list:List[Int])=>{
    @tailrec
    def reverseUsingPatternMatching(list:List[Int], acc:List[Int]):List[Int]={
      list match {
        case Nil=> acc
        case _=> reverseUsingPatternMatching(list.tail,list.head+:acc)
      }
    }
    reverseUsingPatternMatching(list,List())
  }
  private val reverseListInMemory:List[Int]=>List[Int]= (list1:List[Int])=>{
    @tailrec
    def reverseList(list:List[Int], first:Int, last:Int):List[Int]={
      if first >= last then
        list
      else
        reverseList(list.slice(0,first):::list.slice(last-1,last):::list.slice(first+1,last-1):::list.slice(first,first+1):::list.slice(last,list.length), first + 1, last - 1)
    }
    reverseList(list1,0,list1.length)
  }
  val  reverseList: List[Int] => List[Int] = (list:List[Int])=>{
    @tailrec
    def reverseListUsingIf(list:List[Int], acc:List[Int]):List[Int]={
      if(list.isEmpty) acc
      else reverseListUsingIf(list.tail,list.head+:acc)
    }
    reverseListUsingIf(list,List())
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6)
    //using tail rec and if else
    println(reverseList(list))

    //using tail rec and pattern matching
    println(reverse(list))


    //using foldRight and caseMatching
    val result:List[Int]=List()
    println("after reversal= "+list.foldRight(result)((ele,acc)=>{
      list match {
        case Nil=> acc
        case _=> acc:+ele
      }
    }))

    //using foldLeft and caseMatching
    println(list.foldLeft(result)((acc,ele)=>{
      list match {
        case Nil=>acc
        case _=> ele+:acc
      }
    }))
    println(reverseListInMemory(list1))

}}
