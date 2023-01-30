object ImplementBinaryTreeUsingNodes1
{
  class Node(var data:Int,var left:Node,var right:Node)


  class BinaryTree{
    def createNewNode(data:Int):Node={
      new Node(data,null,null)
    }

    def inOrder(temp:Node):Unit={
      if(temp==null) return
      else{
        inOrder(temp.left)
        print(temp.data+" ")
        inOrder(temp.right)
      }
    }

    def preOrder(temp:Node):Unit={
      if(temp==null) return
      else{
        println(temp.data)
        preOrder(temp.left)
        preOrder(temp.right)
      }
    }

    def postOrder(temp:Node):Unit={
      if(temp==null) return
      else{
        postOrder(temp.left)
        postOrder(temp.right)
        println(temp.data)
      }
    }
  }

  def main(Args:Array[String]):Unit={
    //very simple binary tree
    val b:BinaryTree=new BinaryTree
    val root:Node=b.createNewNode(100)
    root.left=b.createNewNode(101)
    root.right=b.createNewNode(102)

    //in order traversal of binary tree
    println("\nin order \n")
    b.inOrder(root)

    //preorder traversal
    println("\npre order traversal\n")
    b.preOrder(root)

    //post order traversal
    println("\npost order traversal\n")
    b.postOrder(root)
  }
}
