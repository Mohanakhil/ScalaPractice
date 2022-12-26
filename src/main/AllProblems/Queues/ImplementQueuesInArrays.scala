package main.AllProblems.Queues

import scala.annotation.tailrec

object ImplementQueuesInArrays
{

  val n:Int=5
  val queue:Array[Int]=new Array[Int](n)
  //insertion happens at rear/tail end  enqueue
  //deletion happens at head/front end  dequeue
  //wastage of space in normal queues

  var front:Int= -1
  var end:Int= -1

  val enqueue: Int=>Array[Int] = (ele:Int)=>{
    if(end==queue.length){ //queue is overflowing
      println("overflow condition")
      queue
    }
    else if(front== -1 && end== -1){ //starting position
      front=0;end=0
      queue(end)=ele
      queue
    }
    else{
      end=end+1
      queue(end)=ele
      queue
    }
  }

  val dequeue:()=>Array[Int]=()=>{
    if(front== -1 && end== -1){
      println("underflow condition")
      queue
    }
    else if(front==end){  //it means there is only 1 element left in queue
      front= -1
      end= -1
      queue
    }
    else{
        //remove always from front in queue
      println("dequeued value from queue is "+queue(front))
      front=front+1
      queue
    }
  }

  val printQueue:()=>Unit=()=>{
    @tailrec
    def printQ(queue:Array[Int], front:Int, end:Int):Unit={
      if(front== -1 && end== -1) println("queue is empty")
      else if(front<=end){
        print(queue(front)+" ")
        printQ(queue, front+1, end)
      }
    }
    printQ(queue,front, end)
  }

  val peek:()=>Int=()=>{
    def peekQueue():Int={
      queue.head
    }
    peekQueue()
  }


  //static memory location
  def main(Args:Array[String]):Unit={
    enqueue(200)
    enqueue(300)
    enqueue(-100)
    printQueue()
    peek()
    dequeue()
    peek()
    printQueue()

  }


}
