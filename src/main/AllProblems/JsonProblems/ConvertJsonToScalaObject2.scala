import scala.annotation.unused

object ConvertJsonToScalaObject2
{
  case class Person(var name:String,var city:String){
    def setCity(x:String):Unit={
      city=x
    }
    def setName(y:String):Unit={
      name=y
    }
  }

 def main(Args:Array[String]):Unit={

//   val j1=json.replace("{\"","")
//   val j2=j1.replace("}","")
//   val res = j2.split(",").foldLeft(List():List[String])((acc,ele)=> acc:+ele.split(":")(1))
//   val p = Person(res.head,res.last)
//   println(p)

   val json: String =
     """[{"name":"akhil","city":"vijayawada"},{"name":"sai","city":"hyd"},{"name":"rama","city":"india"}]"""


   println(
     json.substring(1,json.length-1).split("},\\{")
       .map(_.stripPrefix("{").stripSuffix("}"))
       .map(_.split(",").map(y=>{val temp=y.split(":")
         .map(_.stripPrefix("\"").stripSuffix("\"")); (temp(0),temp(1))}))
       .map(x=>{Person(x(0)._2,x(1)._2)}).mkString(""))








 }
}
