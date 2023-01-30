object GetNumberOfNodesInBinaryTree4
{
  class Node(var data:Int,var left:Node,var right:Node)

  class BinaryTree{
    def createNewNode:Node={
      println("enter data or press -1 for termination")
      val ele:Int=scala.io.StdIn.readInt()
      ele match {
        case -1=>return null
        case _=>{
          val newNode:Node=new Node(ele,null,null)
          println("enter left child of ele"+ele)
          newNode.left=createNewNode
          println("enter right child of ele"+ele)
          newNode.right=createNewNode
          newNode
        }
      }
    }

    def inOrder(root:Node):Unit={
      root match {
        case null=>return null
        case _=>{
          inOrder(root.left)
          println(root.data)
          inOrder(root.right)

        }
      }
    }

    def calculateNumberOfNodes(root:Node):Int={
      if(root==null) 0
      else{
        1+calculateNumberOfNodes(root.left)+calculateNumberOfNodes(root.right)
      }
    }
  }
  def main(Args:Array[String]):Unit={
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode

    //Inorder traversal
    b.inOrder(root)

    println("total no of nodes is ")
    println(b.calculateNumberOfNodes(root))
  }
}
