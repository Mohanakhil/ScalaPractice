import scala.annotation.tailrec

object SortingLinkedList16
{
  class Node(var data:Int,var next:Node)

  var head:Node=_
  var tail:Node=_

  val insertElementAtEnd:Int=>Unit=(ele:Int)=>{
    val newNode:Node=new Node(ele,null)
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

  val bubbleSorting:Node=>Unit=(head:Node)=>{
    @tailrec
    def sorting(current:Node, prev:Node):Unit={
      if(prev==null||prev.next==null) return
      else if(current==null){
      sorting(prev.next,prev.next)
      }
      else if(prev.data>current.data){
        val temp:Int=prev.data
        prev.data=current.data
        current.data=temp
        sorting(current,prev)
      }
      else sorting(current.next, prev)
    }
    sorting(head.next,head)
  }


  val selectionSort:()=>Unit=()=>{
    @tailrec
    def findMinNode(temp:Node, min:Int, minNode:Node):Node={
      if(temp==null) minNode
      else if(temp.data<min){
        findMinNode(temp.next,temp.data,temp)
      }
      else findMinNode(temp.next,min,minNode)
    }
    @tailrec
    def sorting(first:Node):Unit={
      if(first==null) return
      else{
        val minNode: Node = findMinNode(first.next, first.data, first)
        val t:Int=first.data
        first.data=minNode.data
        minNode.data=t
        sorting(first.next)
      }
    }
    sorting(head)
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
    //using bubble sorting
//    bubbleSorting(head)
//    println("after sorting linkedlist")
//    printLinkedList()


    //using selection sorting
    println("after sorting linkedlist")
    selectionSort()
    printLinkedList()


  }
}
