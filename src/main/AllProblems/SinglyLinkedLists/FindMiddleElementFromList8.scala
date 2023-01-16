import scala.annotation.tailrec

object FindMiddleElementFromList8
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

  val findMiddleElementInList:()=>Int=()=>{
    @tailrec
    def findMiddle(slow:Node, fast:Node):Int={
      if(fast==null||fast.next==null){
         slow.next.data
      }
      else findMiddle(slow.next,fast.next.next)
    }
    findMiddle(head,head.next.next)
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
      println("middle ele is ")
      print(findMiddleElementInList())
  }
}
