import scala.annotation.tailrec
import scala.collection.mutable

object CheckIfListIsPalindromeOrNot14
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
  val printLinkedList: Node =>Unit= (t:Node)=>{
    println()
    @tailrec
    def printList(temp:Node):Unit={
      if(temp==null) return
      else{
        print(temp.data+" ")
        printList(temp.next)
      }
    }
    printList(t)
  }

  val checkPalindromeUsingStack:()=>Boolean=()=>{
    @tailrec
    def prepareStack(s:mutable.Stack[Int], temp:Node):mutable.Stack[Int]={
      if(temp==null) s
      else prepareStack(s.push(temp.data),temp.next)
    }
    val s:mutable.Stack[Int]= prepareStack(mutable.Stack(),head)

    @tailrec
    def checkPalindrome(s:mutable.Stack[Int], temp:Node):Boolean={
      if(s.isEmpty||temp==null) true
      else if(s.head!=temp.data) false
      else checkPalindrome(s.tail,temp.next)
    }
    checkPalindrome(s,head)
  }

  def main(Args:Array[String]):Unit={
    var n:Int=scala.io.StdIn.readInt()
    while(n>0)
      {
        val ele:Int=scala.io.StdIn.readInt()
        insertElementAtEnd(ele)
        n=n-1
      }
      printLinkedList(head)

    println(checkPalindromeUsingStack())
  }
}
