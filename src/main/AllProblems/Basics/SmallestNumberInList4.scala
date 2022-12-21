package Basics

object SmallestNumberInList4
{
  def main(Args:Array[String]):Unit={
    val list:List[Int]=List(8,2,9,1,10,0,-1)
    val min:Int=1000
    val index:Int=0
    val counter:Int=0
    //min element and index where it is found are given below
    println(list.foldLeft(min,index,counter)((acc,ele)=>{
      if(ele<acc._1) (ele,acc._3,acc._3+1)
      else (acc._1,acc._2,acc._3+1)
    }))
  }
}
