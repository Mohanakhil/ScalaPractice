//import scala.annotation.tailrec
//
//object SortUsingInsertionSort
//{
//  class Node(var data:Int,var next:Node)
//
//  var head:Node=_
//  var tail:Node=_
//
//  val insertElementAtEnd:Int=>Unit=(ele:Int)=>{
//    val newNode:Node=new Node(ele,null)
//    if(head==null){
//      head=newNode
//      tail=newNode
//    }
//    else{
//      tail.next=newNode
//      tail=newNode
//    }
//  }
//
//  val printLinkedList:()=>Unit=()=>{
//    @tailrec
//    def printList(temp:Node):Unit={
//      if(temp==null) return
//      else{
//        print(temp.data+" ")
//        printList(temp.next)
//      }
//    }
//    printList(head)
//  }
//
//  var sorted:Node=_
//
//  val insertionSort:()=>Unit=()=> {
//
//    def sortedInsert(newNode: Node): Unit = {
//      if (sorted == null) {
//        newNode.next = sorted
//        sorted = newNode
//      }
//      else {
//        var temp: Node = sorted
//        while (temp.next != null && temp.next.data < newNode.data) {
//          temp = temp.next
//        }
//
//
//      }
//    }}
//
//    def main(Args: Array[String]): Unit = {
//      var n: Int = scala.io.StdIn.readInt()
//      while (n > 0) {
//        val ele: Int = scala.io.StdIn.readInt()
//        insertElementAtEnd(ele)
//        n = n - 1
//      }
//      printLinkedList()
//
//    }
//  }
