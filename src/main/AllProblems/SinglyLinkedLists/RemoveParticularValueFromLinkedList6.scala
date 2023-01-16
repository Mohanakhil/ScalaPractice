import scala.annotation.tailrec

object RemoveParticularValueFromLinkedList6
{
  class Node(var data:Int,var next:Node)

  var head:Node=_
  var tail:Node=_

  val insertElementAtEnd:Int=>Unit=(ele:Int)=>{
    val newNode:Node=new Node(ele,null)
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

  val removeParticularValue:Int=>Unit=(ele:Int)=>{
    @tailrec
    def remove(temp:Node):Unit={
      if(temp.next==null) return
      else if(temp.data==ele){
        head=head.next
      }
      else if(temp.next.data==ele){
        val t: Node = temp
        t.next=t.next.next
        remove(t)
      }
      else remove(temp.next)
    }
    remove(head)
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

    println("enter element to remove from list")
    val ele:Int=scala.io.StdIn.readInt()
    removeParticularValue(ele)
    printLinkedList()
  }
}
