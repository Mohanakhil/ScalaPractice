package Basics
import scala.io.Source
object csvToJson
{
  def main(Args:Array[String]):Unit={
    case class Person(id:Int,name:String,age:Int){
      def convertToJson: String = {
        s"{\"id\":$id,\"name\":$name,\"age\":$age}"
      }
    }
    val lines:Iterator[String]=Source.fromFile("/home/mohandenduluri/Videos/AkhilPractice/ScalaPractice/ScalaPractice/src/main/resources/sample.csv").getLines()
    println(lines.map(x=>x.split(","))
      .map(x=>Person(x(0).toInt,x(1),x(2).toInt))
      .map(x=>x.convertToJson)
      .mkString("[\n",",\n","\n]"))
  }
}
