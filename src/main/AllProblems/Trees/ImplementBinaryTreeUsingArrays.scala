package main.AllProblems.Trees

import scala.annotation.tailrec

object ImplementBinaryTreeUsingArrays
{
  //fill array from left to right
  val n:Int=10
  val tree:Array[Int]=new Array[Int](n)

  def root(ele:Int):Unit={
    tree(0)=ele
  }

  def setLeft(ele: Int, parent: Int):Unit={
    tree(parent*2+1)=ele
  }

  def setRight(ele:Int,parent:Int):Unit={
    tree(parent*2+2)=ele
  }

  val printTree:()=>Unit=()=>{
    @tailrec
    def printTre(tree:Array[Int]):Unit={
      if(tree.nonEmpty){
        print(tree.head+" ")
        printTre(tree.tail)
      }
    }
    printTre(tree)
  }
  def main(Args:Array[String]):Unit={
    root(101)
    setLeft(201,0)
    setRight(202,0)
    setLeft(301,1)
    setRight(302,1)
    setLeft(303,2)
    setRight(304,2)
    printTree()
  }
}
