package stacks

import scala.annotation.tailrec

object ImplementationOfStackUsingArray1
{
  //implementation of stack using Array //static memory allocation
  //defining the stack of size 5
  val n: Int = 8
  val stack: Array[Int] = new Array[Int](n)
  var top: Int = -1

  @tailrec
  def push(stack:Array[Int], top:Int, list:List[Int]): Int ={
    if(list.isEmpty) top
    else if(top>=n-1){
      println("overflow error")
      top
    }
    else
    {
      stack(top+1)=list.head
      push(stack,top+1,list.tail)
    }
  }

  def pushElement(ele:Int):Int={
    if(top==n-1) top
    else{
      stack(top+1)=ele
      top=top+1
      top
    }
  }

  val printStack:()=>Unit=()=>{
    @tailrec
    def print(stack: Array[Int],top:Int): Unit = {
      if (top < 0) println("stack is printed above")
      else {
        println(stack(top))
        print(stack,top-1)
      }
  }
    println()
    print(stack, top)
    println()
  }

  def pop():Unit={
    if(top== -1) println("underflow error")
    else{
      println("popped out first item "+stack(top))
      top=top-1
    }
  }

  val peek:()=>Int=()=>{
    def peekStack():Int={
      if(top== -1){
        println("stack is empty")
        -1
      }
      else
      stack(top)
    }
    peekStack()
  }


  def main(Args:Array[String]):Unit= {

    
    val list: List[Int] = List(3, 4, 5, 6, 7, 8)


    top = push(stack, top, list)

    printStack()
    pushElement(1001)
    printStack()

    pop() //8 is removed from stack since  8 is the top most element in stack
    printStack()

    println("peek element is " + peek()) //returns the top element
  }
}
