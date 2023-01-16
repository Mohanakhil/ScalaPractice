import scala.annotation.tailrec

object InsertNodeAfterParticularNode2
{
  class Node(var data:Int,var next:Node)

  var head:Node=_
  var last:Node=_

  val insertNodeAtEnd:Int=>Unit=(ele:Int)=>{
    val newNode:Node=new Node(ele,null)
    if(head==null){
      head=newNode
      last=newNode
    }
    else{
     last.next=newNode
      last=newNode
    }
  }

  val insertNodeAfterParticularNode:(Int,Int)=>Unit=(ele:Int,n:Int)=>{
    @tailrec
    def insertAfterNthNode(n:Int, temp:Node):Unit={
      if(temp==null) println("linked list length over")
      if(n==0)
      {
        val newNode:Node=new Node(ele,temp.next)
        temp.next=newNode
      }
      else insertAfterNthNode(n-1,temp.next)
    }
    insertAfterNthNode(n,head)
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
  def main(Args:Array[String]):Unit={
    var n: Int = scala.io.StdIn.readInt()
    while(n>0)
      {
        val ele:Int=scala.io.StdIn.readInt()
        insertNodeAtEnd(ele)
        n=n-1
      }
      printLinkedList()
    println()
      val ele:Int=scala.io.StdIn.readInt()
    val afterWhichNode:Int=2
    insertNodeAfterParticularNode(ele,afterWhichNode)
    printLinkedList()
  }
}
