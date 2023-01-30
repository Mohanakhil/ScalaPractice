object GetDifferenceOfValuesAtEvenOddLevels5
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

    def getDifferenceOfLeftRight(root:Node):Int={
      if(root==null) return 0
      root.data- getDifferenceOfLeftRight(root.left) -getDifferenceOfLeftRight(root.right)
    }
  }

  def main(Args:Array[String]):Unit={
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode
    println("in order traversal for")
    b.inOrder(root)


    //get difference of values at even and odd levels
    println("difference between even and odd levels")
    println(b.getDifferenceOfLeftRight(root))
  }
}
