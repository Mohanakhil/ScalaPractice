object calculateProductOfAllNodesInTree3
{
  class Node(var data:Int,var left:Node,var right:Node)

  class BinaryTree{
    def createNewNode:Node={
      println("enter data for new node and -1 to terminate")
      val ele:Int=scala.io.StdIn.readInt()
      ele match {
        case -1=>return  null
        case _=>
          val newNode:Node=new Node(ele,null,null)
          println("enter left child of"+ele)
          newNode.left=createNewNode
          println("enter right child of"+ele)
          newNode.right=createNewNode
          newNode
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

    def calculateProduct(root:Node):Int={
      root match {
        case null=>1
        case _=> root.data*calculateProduct(root.left)*calculateProduct(root.right)
      }
    }
  }
  def main(Args:Array[String]):Unit={
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode
    //print binary tree using inorder traversal
    b.inOrder(root)

    println(b.calculateProduct(root))
  }
}
