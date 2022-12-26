package LinkedLists

import scala.annotation.tailrec

object DetectALoopInLinkedList3
{
  class Node(var data:Int,var next:Node)
  {

  }

  var head:Node=_

  @tailrec
  def printList(temp: Node):Unit={
    temp match {
      case null=>
      case _=>print(temp.data+" ")
      printList(temp.next)
    }
  }

  @tailrec
  def detectLoop(slow:Node, fast:Node):Boolean={
    (slow,fast) match {
      case (null,null)=>false
      case (null,_)=>false
      case (_,null)=>false
      case (a,b)=>if(a==b) true
      else detectLoop(slow.next,fast.next.next)
    }
  }



  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(8,7,6,5,4,3,2,1)

    list.foldLeft()((_, ele)=>{
      val newNode:Node=new Node(ele,head)
      head=newNode
    })
    printList(head)

    println()

    //to make linked list as cyclic
    head.next.next.next.next=head.next //getting stackoverflow error in this line


        //using slow and fast pointers
    println(detectLoop(head.next,head.next.next))
  }
}
