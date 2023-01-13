import scala.collection.immutable.ListMap

object SortNamesByAge1
{
  val sortByAge:Map[String,Int]=>Unit=(persons:Map[String,Int])=>{
    println(ListMap(persons.toSeq.sortBy(_._2):_*))
    println(ListMap(persons.toSeq.sortWith(_._2>_._2):_*))

  }


  def main(Args:Array[String]):Unit={
    val persons:Map[String,Int]=Map("akhil"->24,"ravi"->22,"c"->25)
    println(sortByAge(persons))





  }
}
