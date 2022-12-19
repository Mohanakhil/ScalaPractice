import scala.annotation.tailrec

object PackConsecutiveDuplicatesIntoSublists9
{
  //using tailrec and patternMatching
  val packing: List[Int]=>List[List[Int]] = (list:List[Int])=>{
    @tailrec
    def packDuplicatesIntoListMatching(list:List[Int], packList:List[List[Int]], helpList:List[Int]):List[List[Int]]={
      list match {
        case Nil=>packList
        case first::Nil=> if(helpList.nonEmpty){
          if(first==helpList.head) packList:::List(helpList:+first)
          else packList ::: List(List(first))
        }
        else packList:::List(List(first))
        case first::second::_=> if(first==second){
          packDuplicatesIntoListMatching(list.tail,packList,helpList:+first)}
          else packDuplicatesIntoListMatching(list.tail,packList:::List(helpList:+first),List())
        }
      }
    packDuplicatesIntoListMatching(list,List(),List())
  }

  //using tailrec and if else
  val pack: List[Int]=>List[List[Int]] = (list:List[Int])=>{
    @tailrec
    def packDuplicatesIntoList(list:List[Int], packList:List[List[Int]], helpList:List[Int]):List[List[Int]]={
      if(list.isEmpty) return packList
        if(list.size==1)
        {
          if(helpList.nonEmpty)
          {
            if(helpList.head==list.head) packList:::List(helpList:+list.head)
            else
            {
              val li: List[Int] = List(list.head)
              packList ::: List(li)
            }
          }
          else
          {
            val li: List[Int] = List(list.head)
            packList ::: List(li)
          }
        }
      else if(list.head==list(1)){
        packDuplicatesIntoList(list.tail,packList,helpList:+list.head)
      }
      else{
        packDuplicatesIntoList(list.tail,packList:::List(helpList:+list.head),List())
      }
    }
    packDuplicatesIntoList(list,List(),List())
  }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(1,1,1,2,2,2,3,4,5,6,6)
    println(pack(list))
    println(packing(list))

    val modifiedList:List[List[Int]]=List()
    val helpList:List[Int]=List()
//    list.foldLeft((list,modifiedList,helpList))((acc,ele)=>{
//      acc._1 match {
//        case Nil=>(list,acc._2,acc._3)
//        case first::second::_=> if(first==second){
//          (acc._1.tail,acc._2,acc._3:+first)
//        }
//        else{
//          ()
//        }
//      }
//    })

  }
}
