object GetHeightOfBinaryTreeOrNode7
{
  class Node(var data:Int,var left:Node,var right:Node)

  class BinaryTree{

    def createNewNode:Node={
      println("enter data or press -1 for termination")
      val ele:Int=scala.io.StdIn.readInt()
      ele match {
        case -1=> null
        case _=>
          val newNode:Node=new Node(ele,null,null)
          println("enter left child of ele "+ele)
          newNode.left=createNewNode
          println("enter right child of ele "+ele)
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

    def heightOfTree(root:Node):Int={
      if(root==null) -1
      else Math.max(heightOfTree(root.left),heightOfTree(root.right))+1
    }
  }

  def main(Args:Array[String]):Unit={
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode
    b.inOrder(root)

    //height of tree
    println("height of binary tree is ")
    println(b.heightOfTree(root))
  }
}
