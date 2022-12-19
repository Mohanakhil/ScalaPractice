object CheckLeapYearOrNot2
{
  def checkLeapYear(year:Int):Boolean={
    if(year%400==0||(year%4==0&&year%100!=0))
      true
    else false
  }
    def main(Args:Array[String]):Unit={
      val year:Int=scala.io.StdIn.readInt()
      println(checkLeapYear(year))

      //leap years in given range
      val reqList:List[Int]=List()
      println(List.range(1900,2030).foldLeft(reqList)((acc,ele)=>{
        if(checkLeapYear(ele)) acc:+ele
        else acc
      }))
    }
}
