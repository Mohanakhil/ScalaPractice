import scala.annotation.tailrec

object LengthOfLinkedList5
{
  class Node(var data:Int,var next:Node)

  var head:Node=_
  var tail:Node=_

  val insertElementAtEnd:Int=>Unit=(ele:Int)=>{
    val newNode=new Node(ele,null)
    if(head==null)
      {
        head=newNode
        tail=newNode
      }
      else{
      tail.next=newNode
      tail=newNode
    }
  }

  val findLength:()=>Int=()=>{
    @tailrec
    def find(temp:Node, count:Int):Int={
      if(temp==null) count
      else find(temp.next,count+1)
    }
    find(head,0)
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

  def main(Args:Array[String]):Unit={
    var n:Int=scala.io.StdIn.readInt()
    while(n>0)
      {
        val ele:Int=scala.io.StdIn.readInt()
        insertElementAtEnd(ele)
        n=n-1
      }
      printLinkedList()
    println()
    println(findLength())
  }
}
