package Basics

import scala.annotation.tailrec

object reverseString7
{
  @tailrec
  def reverse(s:String, rev:String):String={
    if(s.isEmpty) rev
    else reverse(s.tail,rev+s.head)
  }
  def main(Args:Array[String]):Unit={
    val s:String="radar"
    println(reverse(s,""))

    //to check palindrome or not
    println(reverse(s,"").equals(s))
  }
}
