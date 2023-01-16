import scala.annotation.tailrec

object InsertNodeAtBeginAndEndOfLinkedList1
{
  class Node(var data:Int,var next:Node)

  var head:Node=_
  var temp:Node=_

  val insertNodeAtEnd:Int=>Unit=(ele:Int)=>{
    val newNode: Node = new Node(ele,null)
    if(head==null)
      {
        head=newNode
        temp=newNode
      }
      else{
    temp.next=newNode
      temp=newNode
    }
  }

  val printLinkedList:()=>Unit=()=>{
    @tailrec
    def printList(temp:Node):Unit={
      if(temp==null) return
      else{
        print(temp.data+" ")
        printList(temp.next)
      }
    }
    printList(head)
  }


  val insertNodeAtBegin:Int=>Unit=(ele:Int)=>{
    val newNode:Node=new Node(ele,head)
    head=newNode
  }


  def main(Args:Array[String]):Unit={
    var n:Int=scala.io.StdIn.readInt()
    //insert node at end
    while(n>0)
      {
        val ele:Int=scala.io.StdIn.readInt()
        insertNodeAtEnd(ele)
        n=n-1
      }

    //printLinkedList
    printLinkedList()
    println()

    //insert node at begin
    n=scala.io.StdIn.readInt()
    while(n>0)
      {
        val ele:Int=scala.io.StdIn.readInt()
        insertNodeAtBegin(ele)
        n=n-1
      }
    printLinkedList()
  }
}
