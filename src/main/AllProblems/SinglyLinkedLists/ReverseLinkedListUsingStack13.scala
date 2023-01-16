import scala.annotation.tailrec
import scala.collection.mutable

object ReverseLinkedListUsingStack13
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

  val reverseListUsingStack: () =>Unit= ()=>{
    @tailrec
    def createStack(temp:Node, s:mutable.Stack[Int]):mutable.Stack[Int]={
      if(temp==null) return s
      else{
        createStack(temp.next,s.push(temp.data))
      }
    }
    val s:mutable.Stack[Int]=createStack(head,mutable.Stack())
    head.data=s.top
    head.next=null
    tail=head
    @tailrec
    def reverse(s:mutable.Stack[Int]):Unit={
      if(s.isEmpty) return
      else{
     val newNode:Node=new Node(s.top,null)
     tail.next=newNode
        tail=newNode
        reverse(s.tail)
      }
    }
    reverse(s.tail)

  }

  val countLengthOfList:()=>Int=()=>{
    @tailrec
    def count(temp:Node, c:Int):Int={
      if(temp==null) c
      else count(temp.next,c+1)
    }
    count(head,0)
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

    //count the length of list
   val count:Int= countLengthOfList()

    //using stack to reverse linkedlist
    println("after reversing using stack")
    reverseListUsingStack()

    printLinkedList()
  }
}
