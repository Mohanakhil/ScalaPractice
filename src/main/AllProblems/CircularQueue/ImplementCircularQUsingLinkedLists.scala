package main.AllProblems.CircularQueue

import scala.annotation.tailrec

object ImplementCircularQUsingLinkedLists
{
  class Node(var data:Int,var next:Node)

  var front:Node=_
  var end:Node=_

  def enqueue(ele:Int):Unit={
    val newNode:Node=new Node(ele,null)
    if(end==null){
      front=newNode
      end=newNode
    }
    else{
      end.next=newNode
      end=newNode
    }
    //to make circular
    end.next = front
  }

  def dequeue():Unit={
    if(front==null||end==null) println("underflow condition")
    else if(front==end){
      front=null
      end=null
    }
    else{
      front=front.next
    }
  }

  val printQ:()=>Unit=()=>{
    @tailrec
    def printQueue(front:Node, end:Node):Unit={
      if(front==null||end==null) println("queue is empty")
      else if(front!=end){
        print(front.data+" ")
        printQueue(front.next,end)
      }
      else
        print(front.data)
    }
    printQueue(front,end)
  }

  def main(Args:Array[String]):Unit={
    enqueue(101)
    enqueue(102)
    enqueue(103)
    enqueue(104)
    //to check circularity
    println(end.next.data)
    printQ()
    dequeue()
  }
}
