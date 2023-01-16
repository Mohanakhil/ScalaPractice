import scala.annotation.tailrec

object InsertNodeAtMiddle3
{
  class Node(var data:Int,var next:Node)

  var head:Node=_
  var last:Node=_

  val insertElementAtEnd: Int =>Unit= (ele:Int)=>{
    val newNode:Node=new Node(ele,null)
    if(head==null)
      {
        head=newNode
        last=newNode
      }
      else{
      last.next=newNode
      last=newNode
    }
  }

  val insertAtMiddle:Int=>Unit=(ele:Int)=>{
    @tailrec
    def insert(slow:Node, fast:Node):Unit={
       if(fast.next==null||fast==null||fast.next.next==null){
        val newNode:Node=new Node(ele,slow.next)
        slow.next=newNode
         return
      }
      else insert(slow.next,fast.next.next)
    }
    insert(head.next,head.next.next)
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
        val ele=scala.io.StdIn.readInt()
        insertElementAtEnd(ele)
        n=n-1
      }

    val ele:Int=scala.io.StdIn.readInt()
    insertAtMiddle(ele)

    printLinkedList()
  }
}
