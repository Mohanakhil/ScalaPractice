object MajorityElement
{
  def majority(a: Array[Int]):Int={
    var max=0
    var count=0
    var maximum=0
    for(i<- 0 until a.length){
      count=1
      for(j<- i+1 until a.length){
        if(a(i)==a(j)){
          count=count+1
        }
      }
      if (count > max) {
        max = count
        maximum=a(i)
      }
    }
    if(max>(a.length/2)){
     return maximum
    }
    -1
  }



    class Node(var data:Int,var count:Int,var left:Node,var right:Node)

    var maximumCount:Int=0

    def newNode(data:Int):Node={
      new Node(data,1,null,null)
    }


    def insert(node:Node,data:Int):Node={
      //if tree is empty
      if(node==null)
      {
        if(maximumCount==0)
        {
          maximumCount=1
        }
        return newNode(data)
      }

      //otherwise recur down the tree
      if(data<node.data){
        node.left=insert(node.left,data)
      }
      else if(data>node.data){
        node.right=insert(node.right,data)
      }
      else node.count=node.count+1
      maximumCount=Math.max(maximumCount,node.count)
      node
    }

  //inorder traversal
  def inorder(root:Node,size:Int):Unit={
    if(root!=null){
      inorder(root.left,size)
      if(root.data>size/2)
        {
          println(root.data+" ")
        }
      inorder(root.right,size)
    }

  }

    def main(Args:Array[String]):Unit={
      var root:Node=null
      val a:Array[Int]=Array(3,3,4,2,4,4,2,4,4)
      //using 2 for loops
      println(majority(a))

      //using binary search tree approach
      for(i<- 0 until a.length){
        root=insert(root,a(i))
      }
    }
}
