package main.AllProblems.CircularLinkedList

import scala.annotation.tailrec

object InsertIntoCircularList
{
  class Node(var data:Int,var next:Node)

  var head:Node=_
  var temp:Node=_

  def insert(ele:Int):Unit={
    val newNode:Node=new Node(ele,null)
    if(head==null){
      head=newNode
      temp=newNode
    }
    else{
      temp.next=newNode
      temp=newNode
    }
    //to make it circular list
    temp.next=head
  }

  val printCircularList:()=>Unit=()=>{
    @tailrec
    def printList(temp:Node):Unit={
      if(temp.next!=head) {
        print(temp.data+"  ")
        printList(temp.next)
      }
      else
      print(temp.data)
    }
    printList(head)
  }

  def main(Args:Array[String]):Unit={
    insert(200)
    insert(300)
    insert(-400)
    printCircularList()
    //to check circular linkedList or not
    println("\n"+temp.next.data)
  }
}

