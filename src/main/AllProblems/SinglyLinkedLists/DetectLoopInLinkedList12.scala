import scala.annotation.tailrec

object DetectLoopInLinkedList12
{
  class Node(var data:Int,var next:Node,var flag:Boolean)

  var head:Node=_
  var tail:Node=_

  val insertElementAtEnd:Int=>Unit=(ele:Int)=>{
    val newNode:Node=new Node(ele,null,false)
    if(head==null){
      head=newNode
      tail=newNode
    }
    else{
      tail.next=newNode
      tail=newNode
    }
  }
  val printLinkedList:()=>Unit=()=>{
    @tailrec
    def printList(temp:Node):Unit={
      if(temp==null) return
      else{
        print(temp.data+" ")
        printList(temp.next)
      }
    }
    printList(head)
  }

  val detectLoopUsingHashing:()=>Boolean=()=>{
    @tailrec
    def detect(temp:Node, s:Set[Int]):Boolean={
      if(temp==null) false
      else if(s.contains(temp.data)) true
      else detect(temp.next,s+temp.data)
    }
    detect(head,Set())
  }

  val detectLoopUsingFlag:()=>(Boolean)=()=>{
    @tailrec
    def detectLoop(temp:Node):Boolean={
      if(temp==null) false
      else if(temp.flag) true
      else{
        temp.flag=true
        detectLoop(temp.next)
      }
    }
    detectLoop(head)
  }

  val detectLoopUsingCycle:()=>(Boolean,Int)=()=>{
    @tailrec
    def findLoopLength(slow:Node, fast:Node, count:Int):Int={
      if(slow==fast) count
      else findLoopLength(slow.next,fast,count+1)
    }

    @tailrec
    def detect(slow:Node, fast:Node):(Boolean,Int)={
      if(fast==null) (false,0)
      else if(slow==fast) (true,findLoopLength(slow.next,fast,1))
      else detect(slow.next,fast.next.next)
    }
    detect(head,head.next.next)
  }

  def main(Args:Array[String]):Unit={
    var n:Int=scala.io.StdIn.readInt()
    while(n>0)
      {
        val ele:Int=scala.io.StdIn.readInt()
        insertElementAtEnd(ele)
        n=n-1
      }
      printLinkedList()

    //creating loop in linked list
   head.next.next.next.next.next=head.next

    println("\n detect loop =="+detectLoopUsingHashing())

    //detect loop using modification of node structure
    println(detectLoopUsingFlag())

    //using floyds cycle count the length of cycle
    println(detectLoopUsingCycle())
  }
}
