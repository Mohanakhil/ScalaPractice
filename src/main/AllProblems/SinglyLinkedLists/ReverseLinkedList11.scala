import scala.annotation.tailrec

object ReverseLinkedList11
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


//  val reverseListUsingLoop:()=>Unit=()=>{
//    var curr:Node=head
//    var prev:Node=null
//    var next:Node=null
//     while(curr!=null)
//       {
//         next=curr.next
//         curr.next=prev
//         prev=curr
//         curr=next
//       }
//       head=prev
//  }

  val reverseListUsingRecursion:()=>Node=()=>{
    def reverse(head:Node):Node={
    if(head==null||head.next==null) return head
      val rest:Node=reverse(head.next)
      head.next.next=head
      head.next=null
      rest
    }
    reverse(head)
  }

  val reverseListUsingTailRec:(Node,Node)=>Node=(curr:Node,prev:Node)=>{
    @tailrec
    def reverse(curr:Node, prev:Node):Node={
      if(head==null) return head
      else if(curr.next==null)
    {
      head=curr
      curr.next=prev
      return head
    }
    val n:Node=curr.next
     curr.next=prev
     reverse(n,curr)
  }
    reverse(head,null)
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
    println("after reversing linkedlist is ")
//    reverseListUsingLoop()

    //using recursion
//  head=reverseListUsingRecursion()
//    printLinkedList()

    //using tail recursion
    println("after reversing using tail recursion")
    head=reverseListUsingTailRec(head,null)
    printLinkedList()


  }
}
