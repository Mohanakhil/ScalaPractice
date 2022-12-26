package main.AllProblems.Queues

import scala.annotation.tailrec

object ImplementQUsingStacks
{
  //enqueue from stack1 and dequeue from stack2
  //all are arrays only
  val n:Int=5
  val stack1:Array[Int]=new Array[Int](n)
  val stack2:Array[Int]=new Array[Int](n)
  var top1: Int = -1
  var top2: Int = -1
  var count:Int=0

  def enqueue(ele: Int):Unit={
    if(top1==n) println("overflow condition")
    else{
      top1=top1+1
      stack1(top1)=ele
      count=count+1
    }
  }

  @tailrec
  def shiftToStack2():Unit={
    if(count!=0){
      top2=top2+1
      stack2(top2)=stack1(top1)
      top1=top1-1
      count=count-1
      shiftToStack2()
    }
  }

  def popOutStack2():Unit={
    if(top2== -1) println("underflow condition")
    else{
      top2=top2-1
    }
  }

  @tailrec
  def pushBackToStack1():Unit={
    if(top2!= -1){
      top1=top1+1
      stack1(top1)=stack2(top2)
      top2=top2-1
      pushBackToStack1()
    }
  }


  def dequeue():Unit={
    if(top1== -1) println("underflow condition")
    else{
      shiftToStack2()
      println("\ndequeued element is "+stack2(top2))
      popOutStack2()
      count=top2+1
      pushBackToStack1()
    }
  }

  @tailrec
  def printQ(count:Int):Unit={
    if(count<=top1){
      print(stack1(count)+" ")
      printQ(count+1)
    }
  }


  def main(Args:Array[String]):Unit={
    enqueue(101)
    enqueue(201)
    enqueue(301)
    enqueue(401)
    enqueue(501)
    printQ(0)
    dequeue()
    printQ(0)
    dequeue()
    printQ(0)
  }
}
