object GetDifferenceBetweenLargestAndSmallestInArray5
{
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(6,3,4,2,5)
    println(a.max-a.min)

    val max:Int= a.foldLeft(0)((acc, ele) => {
      if (ele > acc) ele
      else acc
    })
   val min=a.foldLeft(Integer.MAX_VALUE)((acc,ele)=>{
     if(ele<acc) ele
     else acc
   })

    println(max-min)

  }
}
