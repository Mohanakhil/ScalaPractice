object ConvertMapToJson1
{

  def main(Args:Array[String]):Unit={
    case class Person(name:String,city:String){
      def convertToJson:String={
        s"{\"name\":\"$name\",\"city\":\"$city\"}"
      }
    }
    val m:Map[String,String]=Map("name"->"akhil","city"->"vijayawada")
     val p:Person=Person(m("name"),m("city"))
    println(p.convertToJson)
  }
}
