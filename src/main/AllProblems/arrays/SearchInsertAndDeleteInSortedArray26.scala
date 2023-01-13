import scala.annotation.tailrec

object SearchInsertAndDeleteInSortedArray26
{
  val insertInSortedArray: (Array[Int],Int)=>Array[Int] = (a:Array[Int], ele:Int)=>{
    @tailrec
    def insert(a:Array[Int],acc:Array[Int],flag:Boolean):Array[Int]={
      if(a.isEmpty){
        if(flag) acc
        else acc:+ele
      }
      else{
        if(ele>a.head) insert(a.tail,acc:+a.head,flag)
        else{
          insert(Array.empty[Int],acc++Array(ele,a.head)++a.tail,flag = true)
        }
      }
    }
    insert(a,Array(),flag = false)
  }

  val deleteInSortedArray:(Array[Int],Int)=>Array[Int]=(a:Array[Int],ele:Int)=>{
   @tailrec
   def findIndex(a:Array[Int], low:Int, high:Int, mid:Int):Int={
     if(low>high) -1
     else if(low==high) low
     else if(a(mid)==ele) mid
     else if(ele>a(mid)) findIndex(a,mid+1,high,(mid+1+high)/2)
     else findIndex(a,low,mid-1,(low+mid-1)/2)
   }
    val index:Int=findIndex(a,0,a.length-1,(a.length-1)/2)
    a.slice(0,index)++a.slice(index+1,a.length)
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(3,5,8,9,10,11)
    println("original array")
    println(a.mkString("Array(", ", ", ")"))
    println("after inserting")
    val ele:Int=10
    println(insertInSortedArray(a, ele).mkString("Array(", ", ", ")"))


    println("after deleting")
    //using binary search
    println(deleteInSortedArray(a, ele).mkString("Array(", ", ", ")"))

  }
}
