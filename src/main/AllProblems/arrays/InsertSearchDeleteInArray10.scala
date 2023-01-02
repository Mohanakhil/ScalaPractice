package arrays

import scala.annotation.tailrec

object InsertSearchDeleteInArray10
{
  var n:Int=5
  var counter:Int=0
  val a:Array[Int]=new Array[Int](n)
    def insertElement(value: Int):Unit={
      a(counter)=value
      counter=counter+1
    }

  @tailrec
  def binarySearch(a: Array[Int], ele: Int,left:Int,right:Int): Int ={
    if(left>right) -1
    else{
      val mid=(left+right)/2
      if(a(mid)==ele){
        mid
      }
     else if(ele>a(mid)){
        binarySearch(a,ele,mid+1,right)
      }
      else{
        binarySearch(a,ele,left,mid-1)
      }
    }
  }

  def removeElement(k:Int):Array[Int]={
    val b:Array[Int]=Array()
    a.foldLeft(b)((acc,ele)=>{
      if(ele==k){
        acc
      }
      else{
        acc:+ele
      }
    })
  }
    def main(Args:Array[String]):Unit={
      insertElement(101)
      insertElement(201)
      insertElement(301)
      insertElement(401)
      insertElement(501)
      println(a.mkString("Array(",",",")"))

      val ele:Int=scala.io.StdIn.readInt()
      println(binarySearch(a,ele,0,a.length))

      println(removeElement(501).mkString("Array(", ", ", ")"))
    }
}
