package stacks

import scala.annotation.tailrec

object ImplementationOfStackUsingLinkedList2
{
  //in stack head is stack
  class Node(var data:Int,var next:Node)

  var top:Node=_

  val push: Int=>Unit = (ele:Int)=>{
    val newNode: Node = new Node(ele, top)
    top=newNode
  }

  val pop:()=>Unit=()=>{
    if(top==null) println("stack is empty")
    else
    top=top.next
  }

  val peek:()=>Int=()=>{
    println("top most value is")
    top.data
  }


  val printStack:()=>Unit=()=>{
    println("\nstack is ")
    if(top==null) println("stack is empty")

    @tailrec
    def printStackComplete(temp:Node): Unit ={
      temp match {
        case null=>
        case _=>
          println(temp.data+" ")
          printStackComplete(temp.next)
      }
    }
    printStackComplete(top)
    println()
  }


  def main(Args:Array[String]):Unit={
    var choice=0
    do{
      println("enter 1for push\n" +
        "2 for pop\n" +
        "3 for peek\n" +
        "4 for print stack\n" +
        "0 for exit")
      println()
      choice=scala.io.StdIn.readInt()

      choice match {
        case 1=>
          val ele:Int=scala.io.StdIn.readInt()
          push(ele)
        case 2=>
          pop()
        case 3=>println(peek())
        case 4=>printStack()

      }
    }while(choice!=0)


  }
}
