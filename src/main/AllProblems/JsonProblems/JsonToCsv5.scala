import java.io.{File, PrintWriter}

object JsonToCsv5
{
    def main(Args:Array[String]):Unit={
      val json:String="""[{ "country" : "India” , "State" : "AP" },{ "country" : "England” , "State" : "UK" },{ "country" : "USA“, "State" : "Virginia” }]"""
      val fileObject=new File("/home/mohandenduluri/Videos/AkhilPractice/ScalaPractice/ScalaPractice/src/main/resources/sample2.csv")
      val printWriter = new PrintWriter(fileObject)
      val acc2:List[(String,String)]=List.empty[(String,String)]
      json.substring(1,json.length-1).replaceAll(" ","").split("},\\{")
        .map(_.stripPrefix("{").stripSuffix("}"))
        .map(x=>x.split(",")
          .map(x=>{val temp=x.split(":"); (temp(0),temp(1))}))
        .foldLeft(acc2)((acc2,ele)=>{acc2:+(ele(0)._2,ele(1)._2)})
        .foldLeft(printWriter)((acc,ele)=>{printWriter.append(s"${ele._1},${ele._2}");
          printWriter.append("\n");})
      printWriter.close()

    }
}
