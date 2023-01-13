import scala.annotation.tailrec

object LeafSimilarTrees
{

  class Node(var data:Int,var left:Node,var right:Node)

  var root1:Node=_
  var root2:Node=_

  def create():Node={
    println("enter data and -1 for No node")
    val ele:Int=scala.io.StdIn.readInt()
    if(ele== -1)
      {
        null
      }
      else{
      val newNode:Node=new Node(ele,null,null)
      println("enter left child of ele "+ele)
      newNode.left=create()
      println("enter right child of ele "+ele)
      newNode.right=create()
      newNode
    }
  }

  var temp:List[Int]=List()

  def createList(root:Node):List[Int]={
    if(root==null) return temp
    if(root.left==null&&root.right==null)
      {
       temp=temp:+root.data
      }
    createList(root.left)
    createList(root.right)
  }

  @tailrec
  def compare2Lists(list1: List[Int], list2: List[Int]):Boolean={
    if(list1.isEmpty||list2.isEmpty)
      return true
    if (!(list1.head == list2.head)) {
      false
    }
    else{
      compare2Lists(list1.tail,list2.tail)
    }
  }

  def leafSimilar(root1:Node,root2:Node):Boolean=
  {
    val list1=createList(root1)
    temp=List()
    val list2=createList(root2)
    if(list1.size!=list2.size)
      {
        false
      }
      else
    {
      compare2Lists(list1,list2)
    }

  }


  //basic traversal of trees using depth first search
  def main(Args:Array[String]):Unit={


    //first create 2 trees with leaf similar

    root1=create()


    root2=create()

    //check leaf similar or not
    println(leafSimilar(root1,root2))
  }
}
