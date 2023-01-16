import scala.annotation.tailrec

object SearchValueInLinkedList4
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
      if(temp==null){
        return
      }
      else{
        print(temp.data+" ")
        printList(temp.next)
      }
    }
    printList(head)
  }

  val searchInList:Int=>Int=(ele:Int)=>{
    @tailrec
    def search(index:Int, temp:Node):Int={
      if(temp.data==ele){
        return index
      }
      else search(index+1,temp.next)
    }
    search(0,head)
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

     println("enter ele to search in list")
     val ele:Int=scala.io.StdIn.readInt()
     println("index= "+searchInList(ele))

  }
}
