import scala.annotation.tailrec

object RemoveAllOccurencesInList9
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

  val remove:Int=>Unit=(ele:Int)=>{
    @tailrec
    def removeAllOccurences(temp:Node):Unit={
      if(temp==null) return
      else if(temp.data==ele){
        head=temp.next
        removeAllOccurences(head)
      }
      else if(temp.next==null) return
      else if(temp.next.data==ele){
        temp.next=temp.next.next
        removeAllOccurences(temp)
      }
      else removeAllOccurences(temp.next)
    }
    removeAllOccurences(head)
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
    println("enter ele to remove from list")
    val e:Int=scala.io.StdIn.readInt()
    println("after removing "+e+" is")
    remove(e)
    printLinkedList()
  }
}
