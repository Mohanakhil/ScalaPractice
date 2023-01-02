import scala.util.control.Breaks.break

object TripletThatSumToGivenValue
{
  def findTriplet(a:Array[Int],sum:Int):Unit={
    for(i<- 0 until a.length){
      for(j<- i+1 until a.length){
        for(k<-j+1 until a.length){
          if(a(i)+a(j)+a(k)==sum){
            println(a(i)+" "+a(j)+" "+a(k))
          }
        }
      }
    }
  }

  def findTriplet_v2(a: Array[Int], sum: Int):Unit={
    val a2 = a.sorted
    for(i<- 0 until a2.length){
      var left=0
      var right=a2.length-1
      while(left<right){
        if(a(left)+a(right)==sum-a(i)){
          println(a(i)+" "+a(left)+" "+a(right))
          return
        }
        else if(a(left)+a(right)<(sum-a(i))){
          right=right-1
        }
        else left=left+1
      }
    }
  }

  def findTriplet_v3(a: Array[Int], sum: Int):Unit={
    var set:Set[Int]=Set()
    for(i<- 0 until a.length){
      for(j<-i+1 until a.length){
        if(set.contains(sum-(a(i)+a(j)))){
          println(a(i)+" "+a(j)+" "+(sum-a(i)-a(j)))
          return
        }
        else{
          set+=a(j)
        }
      }
    }

  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(12, 3, 4, 1, 6, 9)
    val sum:Int=24
    //using O(n3)
    findTriplet(a,sum)


    //using 2 pointer approach
    findTriplet_v2(a,sum)

    findTriplet_v3(a,sum)
  }
}
