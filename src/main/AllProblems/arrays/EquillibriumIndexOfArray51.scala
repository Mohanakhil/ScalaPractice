import scala.annotation.tailrec

object EquillibriumIndexOfArray51
{

  val findEquillibriumIndex: Array[Int] =>Int= (a:Array[Int])=>{
    @tailrec
    def calculateLeftSum(index: Int, counter:Int, leftSum:Int):Int={
      if(counter==index) leftSum
      else calculateLeftSum(index,counter+1,leftSum+a(counter))
    }
    @tailrec
    def calculateRightSum(index:Int, counter:Int, rightSum:Int):Int={
      if(counter==index) rightSum
      else calculateRightSum(index,counter-1,rightSum+a(counter))
    }
    @tailrec
    def find(leftSum:Int, rightSum:Int, index:Int):Int={
      if(index>=a.length) -1
      else if(leftSum==rightSum) index-1
      else find(calculateLeftSum(index,0,0),calculateRightSum(index,a.length-1,0),index+1)
    }
    find(-1,0,0)
  }

  val findEquillibriumUsingTotalSum:Array[Int]=>Int=(a:Array[Int])=>{
    val arraySum: Int = a.sum
    @tailrec
    def find(leftSum:Int, rightSum:Int, index:Int):Int={
      if(index>=a.length) -1
      else if(leftSum==rightSum) index-1
      else find(leftSum+a(index-1), rightSum-a(index), index+1)
    }
    find(a(0),arraySum-a(0)-a(1),2)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(-7, 1, 5, 2, -4, 3, 0)
    println(findEquillibriumIndex(a))


    //find equillibrium using totalSum concept
    println(findEquillibriumUsingTotalSum(a))
  }
}
