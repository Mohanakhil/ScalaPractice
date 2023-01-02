package main.ProblemsHW

object StringToJson
{
  case class Book(id:Int,name:String,author:String,edition:Int){
    def convertToJson:String={
      s"\"id\":$id,\"name\":$name,\"author\":$author,\"edition\":$edition"
    }
  }
    def main(Args:Array[String]):Unit={
      val s: String = "101,book1,author1,5;" +
                      "102,book2,author2,6"
    val line=s.split(";")
      println(line.map(x=>x.split(",")).
      map(x=>Book(x(0).toInt,x(1),x(2),x(3).toInt))
        .map(x=>x.convertToJson).mkString("[\n",",\n","\n]"))
    }
}
