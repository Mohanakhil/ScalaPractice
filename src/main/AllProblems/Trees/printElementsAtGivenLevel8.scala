object printElementsAtGivenLevel8
{
  class Node(var data:Int,var left:Node,var right:Node)

  class BinaryTree{
    def createNewNode:Node={
      println("enter data or press -1 for termination")
      val ele: Int = scala.io.StdIn.readInt()
      ele match {
        case -1 =>null
        case _=>
          val newNode:Node=new Node(ele,null,null)
          println("enter left child of ele"+ele)
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

    def printElementsAtLevel(root:Node,level:Int):Unit={
      if(root==null) return
      if(level==1){
        println(root.data)
        return
      }
      printElementsAtLevel(root.left,level-1)
      printElementsAtLevel(root.right,level-1)
    }
  }

  def main(Args:Array[String]):Unit={
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode
    b.inOrder(root)

    println("enter level")
    val level:Int=scala.io.StdIn.readInt()
    println("printing elements at given level")
    b.printElementsAtLevel(root,level)

  }
}
