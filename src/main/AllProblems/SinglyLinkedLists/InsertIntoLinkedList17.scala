object InsertIntoLinkedList17 {

  class Node(var data:Int,var next:Node)

  var head:Node=_
  var tail:Node=_

  class LinkedList{
    def insertElementAtEnd(ele:Int):Node={
      val newNode:Node=new Node(ele,null)
      if(head==null){
        head=newNode
        tail=newNode
        head
      }
      else{
        tail.next=newNode
        tail=newNode
        head
      }
    }

    def printLinkedList(temp:Node):Unit={
      if(temp==null) return
      else{
        print(temp.data+" ")
        printLinkedList(temp.next)
      }
    }
  }
  def main(Args:Array[String]):Unit={
    var flag:Int=0
    val l1:LinkedList=new LinkedList
    do{
      println("\nenter ele to insert into linkedlist")
      val ele:Int=scala.io.StdIn.readInt()
      l1.insertElementAtEnd(ele)
      println("enter 0 for termination")
      flag=scala.io.StdIn.readInt()
      println("linkedlist is")
      l1.printLinkedList(head)
    }
    while(flag!=0)


    println("linkedlist is")
    l1.printLinkedList(head)
  }
}
