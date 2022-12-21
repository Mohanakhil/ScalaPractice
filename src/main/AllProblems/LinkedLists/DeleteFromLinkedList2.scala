package LinkedLists

import scala.annotation.tailrec

object DeleteFromLinkedList2
{
  case class Node(data:Int,var next:Node){

  }
  var head:Node=_

  @tailrec
  def printLinkedList(head: Node):Unit={
    head match {
      case null=>println()
      case _=>print(head.data+" ")
      printLinkedList(head.next)
    }
  }

  def deleteElementAtBegin(temp:Node):Unit={
    head=temp.next
  }

  @tailrec
  def deleteElementAtEnd(temp: Node):Unit={
    temp.next.next match {
      case null=>temp.next=null
      case _=>deleteElementAtEnd(temp.next)
    }
  }

  @tailrec
  def deleteAtPosition(temp:Node, counter:Int):Unit={
    (temp.next,counter) match {
      case (null,_)=>
      case (h,2)=>h.next=h.next.next
      case (_,_)=>deleteAtPosition(temp.next,counter-1)
    }
  }

  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(8,7,6,5,4,3,2,1)

    //insert elements from start of linked list
    list.foldLeft()((_, ele)=>{
      val newNode:Node=Node(ele,head)
      head=newNode
    })
    println("using foldleft")
    printLinkedList(head)

    //insert elements into linked list using reduce but reduce is missing last element
//    list.reduce((acc,ele)=>{
//      val newNode:Node=Node(acc,head)
//      head=newNode
//      ele
//    })
//    printLinkedList(head)

    //delete ele from begin
    deleteElementAtBegin(head)

    printLinkedList(head)

    //delete element at end
    deleteElementAtEnd(head)

    printLinkedList(head)

    //delete element at any random position pos
    val pos:Int=3
    deleteAtPosition(head,pos)

    printLinkedList(head)


  }
}
