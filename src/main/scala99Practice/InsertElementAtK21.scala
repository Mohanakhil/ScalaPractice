import scala.annotation.tailrec

object InsertElementAtK21
{
  val insert:(List[Int],Int,Int)=> List[Int] = (list:List[Int], k:Int, ele:Int)=>{
    @tailrec
    def insertElementAtK(list:List[Int], acc:List[Int], counter:Int):List[Int]={
      if(list.isEmpty) return acc
      if(counter==k) insertElementAtK(list,acc:+ele,counter+1)
      else insertElementAtK(list.tail,acc:+list.head,counter+1)
    }
    insertElementAtK(list,List(),0)
  }
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(3,4,5,6)
    val k:Int=3
    val ele:Int=101
    println(insert(list,k,ele))

    val reqList:List[Int]=List()
    val counter:Int=0
    println(list.foldLeft(reqList,counter)((acc,element)=>{
      if(acc._2==k) {(acc._1:+ele:+element,acc._2+1)}
         else{ (acc._1:+element,acc._2+1)
      }
    }))
  }
}
