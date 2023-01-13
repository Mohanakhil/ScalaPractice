import scala.annotation.tailrec

object InsertSearchDeleteInUnSortedArray25
{
  val insertAtBegin:(Array[Int],Int)=>Array[Int]=(a:Array[Int],ele:Int)=>{
    Array(ele)++a
  }
  val insertAtK:(Array[Int],Int,Int)=>Array[Int]=(a:Array[Int],ele:Int,k:Int)=>{
    val length:Int=a.length
    @tailrec
    def insert(a:Array[Int], ele:Int, k:Int, acc:Array[Int],counter:Int):Array[Int]={
      if(counter>=length) acc
      else if(counter==k) insert(a.tail,ele,k,acc++Array(ele)++Array(a.head),counter+1)
      else insert(a.tail,ele,k,acc++Array(a.head),counter+1)
    }
    insert(a,ele,k,Array(),0)
  }

  val insertAtEnd:(Array[Int],Int)=>Array[Int]=(a:Array[Int],ele:Int)=>{
    a++Array(ele)
  }

  val deleteAtBegin: Array[Int]=>Array[Int] = (a:Array[Int])=>{
    a.tail
  }

  val deleteAtK:(Array[Int],Int)=>Array[Int]=(a:Array[Int],k:Int)=>{
    @tailrec
    def delete(a:Array[Int], acc:Array[Int], counter:Int):Array[Int]={
      if(counter>=a.length) acc
      else if(counter==k-1) delete(a,acc,counter+1)
      else delete(a,acc:+a(counter),counter+1)
    }
    delete(a,Array(),0)
  }


  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(3,4,5,6,7)
    val ele:Int=101
    println(insertAtBegin(a, ele).mkString("Array(", ", ", ")"))

    val k:Int=3
    println(insertAtK(a, ele, k).mkString("Array(", ", ", ")"))


    println(insertAtEnd(a, ele).mkString("Array(", ", ", ")"))



    println(deleteAtBegin(a).mkString("Array(", ", ", ")"))

    println(deleteAtK(a, k).mkString("Array(", ", ", ")"))


    //search using linear search

  }
}
