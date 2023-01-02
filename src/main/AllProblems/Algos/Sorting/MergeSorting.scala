package main.AllProblems.Algos.Sorting

object MergeSorting
{
  val mergeSort:Array[Int]=>Unit=(a:Array[Int])=>{
    def merge(a:Array[Int],lb:Int,mid:Int,ub:Int):Array[Int]={
      var i=lb
      var j=mid+1
      var k=lb
      val b:Array[Int]=new Array[Int](a.length)
      while(i<=mid&&j<=ub)
        {
          if(a(i)<a(j))
            {
              b(k)=a(i)
              k=k+1
              i=i+1
            }
            else{
            b(k)=a(j)
            k=k+1
            j=j+1
          }
        }

        if(i<=mid)
          {
            while(i<=mid) {
              b(k) = a(i)
              k = k + 1
              i = i + 1
            }
          }
          else{
          while(j<=ub)
            {
              b(k)=a(j)
              k=k+1
              j=j+1
            }
        }
      b
    }

    def divide(a:Array[Int],lb:Int,ub:Int):Unit={
      var b:Array[Int]=new Array[Int](a.length)
      if(lb<ub)
        {
          val mid:Int= lb+(ub-lb)/2
          divide(a,lb,mid)
          divide(a,mid+1,ub)
         b= merge(a,lb,mid,ub)
        }
        println(b.mkString("Array(",",",")"))
    }
    divide(a,0,a.length-1)
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(15,5,6,8)
    mergeSort(a)
    println(a.mkString("Array(", ", ", ")"))
  }
}
