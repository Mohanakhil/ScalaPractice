package LinkedLists

import scala.annotation.tailrec

object InsertIntoLinkedList1
{
  case class Node(var data:Int,var next:Node)
  {

  }

  var head:Node=_

  @tailrec
  def addElementAtBegin(list:List[Int]): Unit = {
    list match {
      case Nil=>
      case  _=>
        val newNode: Node = Node(list.head, head)
        head = newNode
        addElementAtBegin(list.tail)
    }
  }

  @tailrec
  def printLinkedList(t:Node):Unit={
    t match {
      case null=>println()
      case _=> print(t.data+" ")
        printLinkedList(t.next)
    }
  }


  @tailrec
  def addElementAtPos(temp:Node,pos: Int, value: Int):Node={
    pos match {
      case h=>if(h<0) head
      else if(h==0){
        val newNode:Node=Node(value,temp.next)
        temp.next=newNode
        head
      }
      else addElementAtPos(temp.next,pos-1,value)
    }
  }

  @tailrec
  def addElementAtEnd(temp: Node, value: Int):Unit={
    if(temp.next==null){
      val newNode:Node=Node(value,null)
      temp.next=newNode
    }
    else addElementAtEnd(temp.next,value)
  }


  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(4,3,2,1)
    //insert element at begin using tail recursion
    addElementAtBegin(list)
    printLinkedList(head)

//    insert elements into linkedList at begin using foldLeft
    list.foldLeft()((_,ele)=>{
      val newNode:Node=Node(ele,head)
      head=newNode
    })

    printLinkedList(head)

    //insert element after any position pos using tail rec
    val value:Int=101
    val pos:Int=2
    addElementAtPos(head,pos,value)
    printLinkedList(head)

    //insert element after any pos using foldLeft
//    val t: Node = head
//    val counter:Int= 0
//    list.foldLeft(counter,t)((acc,_)=>{
//      if(acc._1==pos){
//        val newNode:Node=Node(value,acc._2.next)
//        acc._2.next=newNode
//        (acc._1+1,acc._2.next)
//      }
//      else (acc._1+1,acc._2.next)
//    })

    //print linkedList
//    printLinkedList(head)


    //insert element at end of linked list using tail recursion
    val last:Int=105
    addElementAtEnd(head,last)

    printLinkedList(head)








  }
}
