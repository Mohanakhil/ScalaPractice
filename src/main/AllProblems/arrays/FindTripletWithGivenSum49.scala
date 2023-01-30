import scala.annotation.tailrec

object FindTripletWithGivenSum49
{
  val findTripletWithGivenSum:(Array[Int],Int)=>(Int,Int,Int)=(a:Array[Int],sum:Int)=>{
    @tailrec
    def findTriplet(i:Int, j:Int, k:Int):(Int,Int,Int)={
      if(i>=a.length) (-1,-1,-1)
      else if(j>=a.length) findTriplet(i+1,i+2,i+3)
      else if(k>=a.length) findTriplet(i,j+1,j+2)
      else if(a(i)+a(j)+a(k)==sum) (a(i),a(j),a(k))
      else findTriplet(i,j,k+1)
    }
    findTriplet(0,1,2)
  }

  val findTripletUsingSorting:(Array[Int],Int)=>(Int,Int,Int)=(a:Array[Int],sum:Int)=>{
    @tailrec
    def twoPointerSum(b:Array[Int],target:Int, left:Int, right:Int):(Boolean,Int,Int)={
      if(left>=right) (false,-1,-1)
      else if(b(left)+b(right)==target) (true,b(left),b(right))
      else if(b(left)+b(right)<target) twoPointerSum(b,target,left+1,right)
      else twoPointerSum(b,target, left, right-1)
    }

    @tailrec
    def findTriplet(counter:Int):(Int,Int,Int)={
      if(counter>=a.length) (-1,-1,-1)
      else{
        val (flag:Boolean,second:Int,third:Int)=twoPointerSum(a.slice(0,counter)++a.slice(counter+1,a.length),sum-a(counter),0,a.length-2)
        if(flag) (a(counter),second,third)
        else findTriplet(counter+1)
      }
    }
    findTriplet(0)
  }


  val findTripletUsingHashing:(Array[Int],Int)=>(Int,Int,Int)=(a:Array[Int],sum:Int)=>{
    @tailrec
    def findByUsingSet(targetSum:Int, s:Set[Int], counter:Int):(Boolean,Int)={
      if(counter>=a.length) (false,-1)
      else if(s.contains(targetSum)) (true,targetSum)
      else findByUsingSet(targetSum,s+a(counter),counter+1)
    }
    @tailrec
    def findTriplet(i:Int, j:Int):(Int,Int,Int)={
      if(i>=a.length) (-1,-1,-1)
      else if(j>=a.length) findTriplet(i+1,i+2)
      else{
        val (flag:Boolean,third:Int)=findByUsingSet(sum-(a(i)+a(j)),Set(),j+1)
        if(flag) (a(i),a(j),third)
        else findTriplet(i,j+1)
      }
    }
    findTriplet(0,1)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(12, 3, 4, 1, 6, 9)
    val sum:Int=scala.io.StdIn.readInt()
    //using brute force approach
    println(findTripletWithGivenSum(a,sum))

    //using sorting and 2 pointer technique
    println(findTripletUsingSorting(a.sorted,sum))

    //using hashing based solution
    println(findTripletUsingHashing(a,sum))
  }
}
