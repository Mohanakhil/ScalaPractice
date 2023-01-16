import scala.annotation.tailrec

object GetNthNodeFromEndOfList15
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

  val getNthNodeFromEnd: Int =>Int= (n:Int)=>{
    @tailrec
    def getNthFromStart(temp:Node, count:Int):Node={
      if(count==n) temp
      else getNthFromStart(temp.next,count+1)
    }
    val second:Node=getNthFromStart(head,0)

    @tailrec
    def findFromLast(first:Node, second:Node):Int={
      if(second==null) first.data
      else findFromLast(first.next,second.next)
    }
    findFromLast(head,second)
  }

  val removeNthElementFromLast:Int=>Unit=(n:Int)=>{
    @tailrec
    def findFromFirst(current:Node, prev:Node, count:Int):Unit={
      if(current==null)return
      else if(count==1){ //for the first element to remove
        head=current.next
        return
      }
      else if(count==n){
        prev.next=current.next
        return
      }
      else{
        findFromFirst(current.next,current, count+1)
      }
    }
    findFromFirst(head,null,1)
  }

  @tailrec
  def findLengthOfList(temp:Node, count:Int):Int={
    if(temp==null) count
    else findLengthOfList(temp.next,count+1)
  }

  def main(Args:Array[String]):Unit={
    var number:Int=scala.io.StdIn.readInt()
    while(number>0){
      val ele:Int= scala.io.StdIn.readInt()
      insertElementAtEnd(ele)
      number=number-1
    }
    printLinkedList()
    println("enter value of n")
    val n:Int=scala.io.StdIn.readInt()
    println(getNthNodeFromEnd(n))

   val length:Int= findLengthOfList(head,0)

    //remove nth element from last
    removeNthElementFromLast(length-n+1)
    printLinkedList()
  }


}
