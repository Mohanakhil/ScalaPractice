import scala.annotation.tailrec

object FirstMissingPositive
{
  @tailrec
  def firstMissingPositive(set:Set[Int],counter:Int,max:Int):Int={
    if(counter>max) -1
    else{
      if(set.contains(counter))
      {
        firstMissingPositive(set,counter+1,max)
      }
      else  counter
    }
  }

  def firstMissingUsingPosition(a:Array[Int]):Int={
    var i=0
    while (i<a.length)
    {
      val element=a(i)
      if(element>0&&element<a.length){
        val chair = element - 1
        if (element != a(chair)) {
          val temp = a(i)
          a(i) = a(chair)
          a(chair) = temp
          i = i - 1
        }
        i = i + 1
      }
      else{
        i=i+1
      }
    }
    for(i<- 0 until a.length)
    {
      if(i+1!=a(i)){
        return i+1
      }
    }
    a.length+1
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(2,3,1,-3,8,2,4)
    val max:Int=a.max
    val s:Set[Int]=a.toSet
    println(firstMissingPositive(s,1,max))

    //using position approach
    println(firstMissingUsingPosition(a))
  }
}
