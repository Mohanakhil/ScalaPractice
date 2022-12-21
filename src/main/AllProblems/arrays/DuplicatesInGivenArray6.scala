package arrays

import scala.annotation.tailrec

object DuplicatesInGivenArray6
{
  val duplicatesInGivenArray: Array[Int]=>Array[Int] = (a:Array[Int])=>{
    @tailrec
    def duplicatesInArray(s:Set[Int], counter:Int, acc:Array[Int]):Array[Int]={
      counter match {
        case -1=>acc
        case h=>
          if(s.contains(a(h))) duplicatesInArray(s,counter-1,acc:+a(h))
          else duplicatesInArray(s+a(h),counter-1,acc)
      }
    }
    duplicatesInArray(Set(),a.length-1,Array())
  }


  def main(Args:Array[String]):Unit={
    val arr:Array[Int]=Array(1,5,4,2,1,4,7,5,2)
    println(duplicatesInGivenArray(arr).mkString("Array(",",",")"))
  }
}
