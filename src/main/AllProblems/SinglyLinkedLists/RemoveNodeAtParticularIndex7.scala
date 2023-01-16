import scala.annotation.tailrec

object RemoveNodeAtParticularIndex7
{
  class Node(var data:Int,var next:Node)

  var head:Node=_
  var tail:Node=_

  val insertElementAtEnd:Int=>Unit=(ele:Int)=>{
    val newNode:Node=new Node(ele,null)
    if(head==null){
      head=newNode
      tail=newNode
    }
    else{
      tail.next=newNode
      tail=newNode
    }
  }

  val removeAtParticularIndex: Int =>Unit= (index:Int)=>{
    @tailrec
    def remove(index:Int, temp:Node):Unit={
      if(temp==null) return
      else if(index<=1){
        temp.next=temp.next.next
      }
      else remove(index-1,temp.next)
    }
    remove(index,head)
  }

  val printLinkedList:()=>Unit=()=>{
    def printList(temp:Node):Unit={
      if(temp==null) return
      else{
        print(temp.data+" ")
        printList(temp.next)
      }
    }
    printList(head)
  }
  def main(Args:Array[String]):Unit={
    var n:Int=scala.io.StdIn.readInt()
    while(n>0)
      {
        val ele:Int=scala.io.StdIn.readInt()
        insertElementAtEnd(ele)
        n=n-1
      }
      printLinkedList()
    println()
      val index:Int=scala.io.StdIn.readInt()
     removeAtParticularIndex(index)
    printLinkedList()
  }
}
