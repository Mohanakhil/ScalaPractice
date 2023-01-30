object PrintElementsInLevelOrder9
{
  class Node(var data:Int,var left:Node,var right:Node)

  class BinaryTree{
    def createNewNode:Node={
      println("enter data or press -1 for termination")
      val ele:Int=scala.io.StdIn.readInt()
      ele match {
        case -1=>null
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

    def calculateHeight(root:Node):Int={
      if(root==null) -1
      else Math.max(calculateHeight(root.left),calculateHeight(root.right))+1
    }

    def printAtLevel(root:Node,level:Int):Unit={
      if(root==null) return
      if(level==1) print(root.data+" ")
      printAtLevel(root.left,level-1)
      printAtLevel(root.right,level-1)
    }

    def printElementsInLevel(root:Node):Unit={
      if(root==null) return
      val height:Int=calculateHeight(root)
      for(i<- 0 to  height){
        printAtLevel(root,i+1)
      }
    }

  }
  def main(Args:Array[String]):Unit={
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode

    b.inOrder(root)

    println("below is in level printing of elements")
    b.printElementsInLevel(root)
  }
}
