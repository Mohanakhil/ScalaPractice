object calculateSumOfAllNodesInTree2{


class Node(var data:Int,var left:Node,var right:Node)

class BinaryTree {

  def createNewNode:Node={
    println("enter data for new node and -1 to terminate")
    val ele:Int=scala.io.StdIn.readInt()
    ele match {
      case -1=>null
      case _=>
        val newNode:Node=new Node(ele,null, right = null)
        println("enter left child of "+ele)
        newNode.left=createNewNode
        println("enter right child of "+ele)
        newNode.right=createNewNode
        newNode
    }
  }

  def inOrder(root:Node):Unit={
   root match {
     case null=>
     case _=>
       inOrder(root.left)
       println(root.data)
       inOrder(root.right)
   }
  }

  def sumOfAllNodes(root:Node):Int={
    root match {
      case null=>0
      case _=>
        root.data+sumOfAllNodes(root.left)+sumOfAllNodes(root.right)
    }
  }

}
  def main(Args:Array[String]):Unit={
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode

    //print binary tree using inorder traversal
    println("inorder traversal")
    b.inOrder(root)

    println("sum of all nodes is")
    println(b.sumOfAllNodes(root))
  }
}

