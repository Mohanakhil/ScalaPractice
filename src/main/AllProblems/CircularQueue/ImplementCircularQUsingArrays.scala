package main.AllProblems.CircularQueue

import scala.annotation.tailrec

object ImplementCircularQUsingArrays
{
  //(end+1)%N==front

    val n:Int=5
    val queue:Array[Int]=new Array[Int](n)
    var front:Int= -1
    var end:Int= -1

    def enqueue(ele:Int):Unit={
      if(front== -1&& end== -1){
        front=0
        end=0
        queue(end)=ele
      }
      else if((end+1)%n==front){
        println("queue is overflowing")
      }
      else{
        end=(end+1)%n
        queue(end)=ele
      }
    }

  def dequeue():Unit={
    if(front == -1 && end == -1) println("queue is empty")
    else if(front==end){
      front = -1
      end= -1
    }
    else{
      front=(front+1)%n
    }
  }

  val printQueue:()=>Unit=()=>{
    @tailrec
    def printQ(front:Int):Unit={
      if(front== -1 && end== -1) println("\nqueue is empty")
      else if(front!=end){
        print(queue(front)+" ")
        printQ(front+1%n)
      }
      else
      print(queue(end)+" \n")
    }
    printQ(front)
    println()
  }

    def main(Args:Array[String]):Unit={
      enqueue(200)
      enqueue(-100)
      enqueue(500)
      enqueue(600)
      enqueue(700)
      printQueue()
      dequeue()
      printQueue()
    }
}
