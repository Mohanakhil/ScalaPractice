package main.AllProblems.Dequeue

import scala.annotation.tailrec

object DeQueue
{
  //Double ended queue
  //any side can be used to insert and allow from both ends
  //using deque both stack and queue can be implemented at a time
  //we are using circular arrays here

  val n:Int=5
  val dequeue:Array[Int]=new Array[Int](n)
  var front:Int= -1
  var end:Int= -1

  def enqueueFront(ele: Int):Unit={
    if(front==end-1||(front==0&&end==n-1)) println("overflow condition")
    else if(front== -1&& end== -1){
      front=0
      end=0
      dequeue(front)=ele
    }
    else if(front==0){
      front=n-1
      dequeue(front)=ele
    }
    else{
      front=front-1
      dequeue(front)=ele
    }
  }

  def enqueueEnd(ele:Int):Unit={
    if(front==0&&end==n-1||(front==end+1)) println("dequeue is full")
    else if(front== -1 && end== -1){
      front=0
      end=0
      dequeue(end)=ele
    }
    else if(end==n-1){
      end=0
      dequeue(end)=ele
    }
    else{
      end=end+1
      dequeue(end)=ele
    }
  }

  val printDequeue:()=>Unit=()=>{
    @tailrec
    def printDQ(front: Int): Unit = {
    if(front!=end){
      print(dequeue(front)+" ")
      printDQ((front+1)%n)
    }
    }
    printDQ(front)
    print(dequeue(end))
  }

  def getFront(): Unit = {
    if (front == -1 || end == -1) println("underflow condition")
    else println(dequeue(front))
  }

  def getRear():Unit={
    if(front== -1|| end== -1) println("underflow condition")
    else println(dequeue(end))
  }

  def dequeueFront():Unit={
    if(front== -1|| end == -1) println("underflow condition")
    else if(front==end){
      front= -1
      end= -1
    }
    else if(front==n-1){
      front=0
    }
    else{
      front=front+1
    }
  }

  def dequeueEnd():Unit={
    if(front== -1|| end== -1) println("underflow condition")
    else if(front==end){
      front= -1
      end= -1
    }
    else if(end==0){
      end=n-1
    }
    else{
      end=end-1
    }
  }

  def main(Args:Array[String]):Unit={
    enqueueFront(101)
    enqueueFront(202)
    enqueueEnd(-100)
    enqueueEnd(700)
    printDequeue()
    getFront()
    getRear()
    dequeueFront()
    dequeueEnd()
    dequeueFront()
  }
}
