import scala.annotation.tailrec

object RearrangeArrayInOrderSmallestLargest41
{
  val rearrangeMinMax:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def findMin(a:Array[Int], index:Int, counter:Int, min:Int):Int={
     if(counter==a.length) index
     else if(a(counter)<min) findMin(a,counter,counter+1,a(counter))
     else findMin(a,index,counter+1,min)
    }

    @tailrec
    def findMax(a:Array[Int], index:Int, counter:Int, max:Int):Int={
      if(counter==a.length) index
      else if(a(counter)>max) findMax(a,counter,counter+1,a(counter))
      else findMax(a,index,counter+1,max)
    }
    @tailrec
    def rearrange(counter:Int, acc:Array[Int], a:Array[Int]):Array[Int]={
      if(a.isEmpty) acc
      else if(counter%2==0){
        val index=findMin(a,0,0,a.head)
        rearrange(counter+1,acc:+a(index),a.slice(0,index)++a.slice(index+1,a.length))
      }
      else{
        val index=findMax(a,0,0,a.head)
        rearrange(counter+1,acc:+a(index),a.slice(0,index)++a.slice(index+1,a.length))
      }
    }
    rearrange(0,Array(),a)
  }

  val rearrangeMinMaxUsingSort:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def rearrange(left:Int, right:Int, acc:Array[Int]):Array[Int]={
      if(left>right) acc
      else if(left==right) acc:+a(left)
      else rearrange(left+1,right-1, acc++Array(a(left),a(right)))
    }
    rearrange(0,a.length-1,Array())

  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(5, 8, 1, 4, 2, 9, 3, 7, 6,3)
    //finding min and maximum
    println(rearrangeMinMax(a).mkString("Array(", ", ", ")"))

    //using sorting
    println(rearrangeMinMaxUsingSort(a.sorted).mkString("Array(", ", ", ")"))
  }
}
