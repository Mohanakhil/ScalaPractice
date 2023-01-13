import scala.annotation.tailrec

object RotateArray18
{
  val leftRotate: (Array[Int],Int)=>Array[Int] = (a:Array[Int],n:Int)=>{
    val length:Int=a.length
    @tailrec
    def rotate(a:Array[Int], counter:Int):Array[Int]={
      if(counter>n||counter>length) a
      else rotate(a.tail:+a.head,counter+1)
    }
    rotate(a,1)
  }

  val rightRotate:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
    val length:Int=a.length
    @tailrec
    def rotate(a:Array[Int], counter:Int):Array[Int]={
      if(counter>n||counter>length) a
      else rotate(Array(a.last)++a.slice(0,length-1),counter+1)
    }
    rotate(a,1)
  }

  @tailrec
  def reverse(a: Array[Int], acc:Array[Int]):Array[Int]={
    if(a.isEmpty) acc
    else reverse(a.tail,a.head+:acc)
  }

  val leftRotateUsingReversal:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
   def rotate(a:Array[Int],n:Int):Array[Int]={
     var newArray:Array[Int]=new Array[Int](a.length)
     newArray=reverse(a.slice(0,n),Array())++reverse(a.slice(n,a.length),Array())
     newArray=reverse(newArray.slice(0,a.length),Array())
     newArray
   }
   rotate(a,n)
  }

  val rightRotationUsingReversal:(Array[Int],Int)=>Array[Int]=(a:Array[Int],n:Int)=>{
    def rotate(a:Array[Int],n:Int):Array[Int]={
      var newArray:Array[Int]=new Array[Int](a.length)
      newArray=reverse(a.slice(0,a.length-n),Array())++reverse(a.slice(a.length-n,a.length),Array())
      newArray=reverse(newArray.slice(0,a.length),Array())
      newArray
    }
    rotate(a, n)
  }

    def main(Args:Array[String]):Unit={
      val a:Array[Int]=Array(3,4,5,6,7,8)
      println(a.mkString("Array(",",",")"))
      val n:Int=2

      println("left rotation")
      //first way using tail recursion and one by one
      println(leftRotate(a,n).mkString("Array(",",",")"))

      //second way using acc and fold left
      val tempArray:Array[Int]=Array()
      val counter:Int=0
      println((a.foldLeft(tempArray, counter)((acc, ele) => {
        if (acc._2 >=n) (acc._1 :+ ele, acc._2 + 1)
        else (acc._1, acc._2 + 1)
      })._1 ++ a.slice(0, n)).mkString("Array(", ", ", ")"))

      //using reversal algorithm
      println(leftRotateUsingReversal(a, n).mkString("Array(", ", ", ")"))




      println("right rotation")
      //right rotate
      println(rightRotate(a,n).mkString("Array(",",",")"))
      val temp= a.slice(0, a.length - n)
      println(a.foldRight(temp, counter)((ele, acc) => {
        if (acc._2 < n) (Array(ele)++acc._1, acc._2 + 1)
        else (acc._1, acc._2 + 1)
      })._1.mkString("Array(", ", ", ")"))

      println(rightRotationUsingReversal(a, n).mkString("Array(", ", ", ")"))
    }
}
