package main.AllProblems.Queues

import scala.annotation.tailrec

object ImplementQueueUsingLinkedList
{
  class Node(var data:Int,var next:Node)

  var front:Node=_
  var end:Node=_

  def enqueue(element:Int):Unit={
    val newNode:Node=new Node(element,null)
    if(front==null&&end==null)
    {
        front=newNode
        end=newNode
    }
    else{
      end.next=newNode
      end=newNode
    }
  }

  val printQueue: ()=>Unit =()=> {
    @tailrec
    def printQ(front:Node, end:Node): Unit ={
      if (front == null || end == null) println("\nqueue is empty")
      else {
        print(front.data+" ")
        printQ(front.next, end)
      }
    }
    printQ(front, end)
  }

  def dequeue():Unit={
    if(front==null&&end==null) println("underflow condition")
    else
    println("dequeue element is "+front.data)
    front=front.next
  }

 def peek:Int={
   if(front==null&&end==null)
   {
     println("queue is empty")
     -1
   }
   else front.data
 }


  def main(Args:Array[String]):Unit={
    enqueue(500)
    enqueue(300)
    enqueue(-300)
    printQueue()
    dequeue()
    printQueue()
    println("peek is "+peek)
  }
}
