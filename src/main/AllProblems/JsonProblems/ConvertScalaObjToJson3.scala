object ConvertScalaObjToJson3
{
  case class Person(name:String,city:String,age:Int){
    def toJson:String={
      s"{\"name\":\"$name\",\"city\":\"$city\",\"age\":\"$age\"}"
    }
  }

    def main(Args:Array[String]):Unit={
      val p:Person=Person("akhil","vij",23)
      println(p.toJson.mkString("[\n","","\n]"))
    }
}
