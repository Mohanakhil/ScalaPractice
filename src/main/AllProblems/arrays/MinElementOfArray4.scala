package arrays

object MinElementOfArray4
{
  def main(Args:Array[String]):Unit={
    val arr:Array[Int]=Array(3,10,2,9,-100)


    //using foldLeft
    println(arr.foldLeft(100)((acc,ele)=>{
      if(ele<acc) ele
      else acc
    }))

  }
}
