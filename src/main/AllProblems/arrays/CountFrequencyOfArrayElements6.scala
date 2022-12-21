package arrays

import scala.annotation.tailrec

object CountFrequencyOfArrayElements6
{
  val countFrequencyOfArray: Array[Int]=>Map[Int,Int] = (arr:Array[Int])=>{
    @tailrec
    def countFrequency(acc:Map[Int,Int], counter:Int):Map[Int,Int]={
      counter match {
        case -1=>acc
        case h=> if(acc.contains(arr(h))) countFrequency(acc+(arr(h) ->(acc(arr(h))+1)),counter-1)
        else countFrequency(acc+(arr(h)->1),counter-1)
      }
    }
    countFrequency(Map(),arr.length-1)
  }




  def main(Args:Array[String]):Unit={
    val arr:Array[Int]=Array(3,4,5,6,3,4,5,6,8)
    val frequencyMap:Map[Int,Int] =countFrequencyOfArray(arr)
    println(frequencyMap)





    //to prepare frequency map using foldLeft
    val requiredMap:Map[Int,Int]=Map()
    println(arr.foldLeft(requiredMap)((acc,ele)=>{
      if(acc.contains(ele)) acc+(ele->(acc(ele)+1))
      else acc+(ele->1)
    }))





    //to prepareFrequencyMap using map
     var requiredMap2:Map[Int,Int]=Map()
    arr.foreach(x => {
      if (requiredMap2.contains(x)) requiredMap2=requiredMap2 + (x -> (requiredMap2(x) + 1))
      else requiredMap2=requiredMap2 + (x -> 1)
    })
    println(requiredMap2)

    println("hello "+arr.groupBy(x=>x).map(x=>(x._1,x._2.length)))




    //if count is greater than 1 then print
    val reqList:List[Int]=List()
    println(frequencyMap.foldLeft(reqList)((acc,ele)=>{
      if(ele._2>1) acc:+ele._1
      else acc
    }))

    //if count is greater than 1 then print using map(ie if they are duplicate
    println(frequencyMap.filter(x=>x._2>1).map(x=>x._1))


  }
}
