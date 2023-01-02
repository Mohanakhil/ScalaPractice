package main.AllProblems.Trees

object ImplementBinaryTreesUsingLinkedLists
{
  class Node(var data:Int,var left:Node,var right:Node)

  var root:Node=_

  //create tree recursively
  def create():Node={
    println("enter data and -1 for no node")
    val ele: Int = scala.io.StdIn.readInt()
    if(ele== -1){
      return null
    }
    val newNode: Node = new Node(ele, null, null)
    println("enter left child of "+ele)
    newNode.left=create()
    println("enter right child of " + ele)
    newNode.right=create()
    newNode
  }

  //preorder traversal of tree
  //root left right
  def preOrder(root:Node):Unit={
    if(root==null) return
    else{
      print(root.data + " ")
      preOrder(root.left)
      preOrder(root.right)
    }
  }

  //inOrder Traversal of tree
  //left root right
  def inOrder(root:Node):Unit={
    if(root==null) return
    else{
      inOrder(root.left)
      print(root.data+" ")
      inOrder(root.right)
    }
  }

  //postOrder traversal of tree
  //left right root
  def postOrder(root:Node):Unit={
    if(root==null) return
    else{
      postOrder(root.left)
      postOrder(root.right)
      print(root.data+" ")
    }
  }

  def main(Args:Array[String]):Unit={
    val root: Node = create()

    //preOrder traversal to print the tree
    println("\npreOrder \n")
    preOrder(root)

    println("\ninOrder traversal ")
    inOrder(root)

    println("\npostOrder traversal ")
    postOrder(root)
  }
}
