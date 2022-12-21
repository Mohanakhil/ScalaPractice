package arrays

import scala.annotation.tailrec

object FindPairsWithGivenSum7
{
  @tailrec
  def findPairsAndCount(arr: Array[Int], sum: Int, i:Int, acc:List[(Int,Int)], j:Int):List[(Int,Int)]={
      if(i>=arr.length-1) acc
      else  if(j>=arr.length) findPairsAndCount(arr,sum,i+1,acc,i+2)
      else if(arr(i)+arr(j)==sum) findPairsAndCount(arr,sum,i,acc:+(arr(i),arr(j)),j+1)
      else findPairsAndCount(arr,sum,i,acc,j+1)
    }

  //
  @tailrec
  def findPairsAndCountUsingSorting(arr: Array[Int], sum:Int, left:Int, right:Int, acc:List[(Int,Int)]):List[(Int,Int)]={
    if(left>=right) acc
    else if(arr(left)+arr(right)==sum)  findPairsAndCountUsingSorting(arr, sum, left+1, right, acc:+(arr(left),arr(right)))
    else if(arr(left)+arr(right)<sum) findPairsAndCountUsingSorting(arr,sum,left+1,right,acc)
    else findPairsAndCountUsingSorting(arr,sum,left,right-1,acc)
  }

  @tailrec
  def findPairsAndCountUsingSet(arr: Array[Int], sum: Int, s:Set[Int], counter:Int, acc:List[(Int,Int)]):List[(Int,Int)]={
    counter match {
      case h=>if(h==arr.length) acc
      else  if(s.contains(sum-arr(h))) findPairsAndCountUsingSet(arr,sum,s+ arr(h),counter+1,acc:+(arr(h),sum-arr(h)))
      else findPairsAndCountUsingSet(arr,sum,s+arr(h),counter+1,acc)

    }
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(3,2,5,6,6,9,7,10)
    val sum=12
    println(findPairsAndCount(a,sum,0,List(),1))


    //if elements are distinct and sorted
    println(a.sorted.mkString("Array(",",",")"))

    println(findPairsAndCountUsingSorting(a.sorted,sum,0,a.length-1,List()))


    //using extra space ie set
    println(findPairsAndCountUsingSet(a,sum,Set(),0,List()))


    val s:Set[Int]=Set()
    val pairList:List[(Int,Int)]=List()
    //using foldLeft
    println(a.foldLeft(s,pairList)((acc,ele)=>{
      if(acc._1.contains(sum-ele)) (acc._1,acc._2:+(ele,sum-ele))
      else (acc._1+ele, acc._2)
    })._2)
  }
}
