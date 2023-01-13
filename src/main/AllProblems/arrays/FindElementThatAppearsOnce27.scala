import scala.annotation.tailrec

object FindElementThatAppearsOnce27
{
  def findElementLoop(a:Array[Int]):Int={
    for(i<- 0 until a.length)
      {
        var count:Int=0
        for(j<- 0 until a.length){
          if(a(i)==a(j)){
            count=count+1
          }
        }
        if(count<2) return a(i)
      }
      -1
  }


  val countMap:Array[Int]=>Map[Int,Int]=(a:Array[Int])=>{
    @tailrec
    def count(a:Array[Int], m:Map[Int,Int]):Map[Int,Int]={
      if(a.isEmpty) m
      else if(!m.contains(a.head)) count(a.tail,m+(a.head->1))
      else count(a.tail,m+(a.head->(m.get(a.head).get+1)))
    }
    count(a,Map.empty[Int,Int])
  }

  def main(Args:Array[String]):Unit={

    val a:Array[Int]=Array(3,4,3,5,4,9,6,5,6,2,2)
    //o(n2)
    println(findElementLoop(a))

    val m:Map[Int,Int]=countMap(a)
    println(m.filter(x=>x._2==1).keys)

    //using XOR
    println(a.foldLeft(0)((acc,ele)=>{
      acc^ele
    }))
  }
}
