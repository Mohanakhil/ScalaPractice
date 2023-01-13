object ConvertStringToCaseClass8
{
  case class Person(id:Int,name:String,age:Int)

    def main(Args:Array[String]):Unit={
      val s:String="101,\"akhil\",24;102,\"rama\",25;"
      s.split(";").map(x => x.split(","))
        .map(x => Person(x(0).toInt, x(1), x(2).toInt)).foreach(x=>println(x))
    }
}
