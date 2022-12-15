
import scala.annotation.tailrec
import scala.util.Random

object ExtractRandomList27 {
  @tailrec
  def extractRandom(list: List[Int],randomList: List[Int],k:Int):List[Int]={
    if(list.isEmpty||k<=0) randomList
    else{
      val rand:Random=new Random()
      val randomNumber:Int=rand.nextInt(list.size-1)
      if(!randomList.contains(list(randomNumber))){
        extractRandom(list,randomList:+list(randomNumber),k-1)
      }
      else extractRandom(list, randomList, k)
    }

  }

def main(Args:Array[String]):Unit={
  val list:List[Int]=List(1,2,3,4,5,6)
  val k:Int=3
  println(extractRandom(list,List(),k))


}
}
