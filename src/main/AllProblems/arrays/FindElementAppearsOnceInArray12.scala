import scala.collection.mutable

object FindElementAppearsOnceInArray
{
  //using o(n2) searching everything
  def find_v2(a: Array[Int]):Int={
    for(i<-0 until  a.length)
      {
        var count:Int=0
        for(j<-0 until  a.length){
          if(a(i)==a(j)){
            count=count+1
          }
        }
        if(count==1){
          return a(i)
        }
      }
      -1
  }

  //use set or hashing
  def find_v3(a: Array[Int]): Int = {
    var acc: Map[Int, Int] = Map()
    for (i <- 0 until a.length) {
      if (acc.contains(a(i))) {
        acc += (a(i) -> (acc.get(a(i)).get + 1))
      }
      else {
        acc += (a(i) -> 1)
      }
    }
    (acc.filter(x => x._2 == 1).keys.head)
  }

  //using XOR of all elements
  def find(a:Array[Int]):Int={
    val e:Int=0
    a.foldLeft(e)((acc,ele)=> {
      acc^ele
    })
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(3,3,5,4,5,4,7)
    println(find(a))
    println(find_v2(a))
    println(find_v3(a))
  }
}
