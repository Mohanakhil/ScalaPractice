package Basics

import scala.annotation.tailrec

object CountVowelsInStr1
{
  @tailrec
  def countVowelsOfString(str: String, count:Int):Int={
    if(str.isEmpty) count
    else{
      str.charAt(0) match {
        case h => if (h == 'a' || h == 'e' || h == 'i' || h == 'o' || h == 'u') countVowelsOfString(str.tail, count + 1)
        else countVowelsOfString(str.tail, count)
      }
    }
  }
  def main(Args:Array[String]):Unit={
    val s:String="denduluri rama sai mohan akhil"
    println(countVowelsOfString(s,0))
  }
}
