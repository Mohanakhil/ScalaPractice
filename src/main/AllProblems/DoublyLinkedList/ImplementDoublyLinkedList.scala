package main.AllProblems.DoublyLinkedList

import scala.annotation.tailrec

object ImplementDoublyLinkedList
{
  class  Node(var data:Int,var prev:Node,var next:Node)

  var head:Node=_
  var temp:Node=_

  def insert(ele:Int):Unit={
    val newNode:Node=new Node(ele,null,null)
    if(head==null){
      head=newNode
      temp=head
    }
    else{
      temp.next=newNode
      newNode.prev=temp
      temp=newNode
    }
  }

  val printDoublyLinkedList:()=>Unit=()=>{
    @tailrec
    def printDLL(temp:Node):Unit={
      if(temp!=null){
        print(temp.data+" ")
        printDLL(temp.next)
      }
    }
    printDLL(head)
  }

  def main(Args:Array[String]):Unit={
    insert(100)
    insert(200)
    insert(-300)
    printDoublyLinkedList()
  }
}
