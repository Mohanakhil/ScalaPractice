object MeanAndMedianOfUnSortedArray46
{
  val mean:Array[Int]=>Float=(a:Array[Int])=>{
    (a.sum.toFloat)/(a.length)
  }

  val median:Array[Int]=>Float=(b:Array[Int])=>{
    if(b.length%2!=0) b(b.length/2)
    else (b(b.length/2)+b(b.length/2-1)).toFloat/2
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1, 3, 4, 2, 6, 5, 8, 7)

    println(mean(a))

    println(median(a.sorted))
  }
}
