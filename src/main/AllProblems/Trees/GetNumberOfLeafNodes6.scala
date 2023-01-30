object GetNumberOfLeafNodes6
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

    def inOrder(root: Node): Unit = {
      root match {
        case null => return
        case _=>
          inOrder(root.left)
          println(root.data)
          inOrder(root.right)
      }
    }

    def getNumberOfLeafNodes(root:Node):Int={
      root match {
        case null=>0
        case _=>
          if(root.left==null&&root.right==null) return 1
          getNumberOfLeafNodes(root.left)+getNumberOfLeafNodes(root.right)
      }
    }
  }

  def main(Args:Array[String]):Unit={
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode
    b.inOrder(root)

    println("number of leaf nodes are ")
    println(b.getNumberOfLeafNodes(root))
  }
}
