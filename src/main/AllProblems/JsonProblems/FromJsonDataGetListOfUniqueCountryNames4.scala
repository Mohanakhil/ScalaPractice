object FromJsonDataGetListOfUniqueCountryNames4
{
  def main(Args:Array[String]):Unit={
    val json:String="""[{ "country" : "India” , "State" : "AP" },{ "country" : "England” , "State" : "UK" },{ "country" : "USA“, "State" : "Virginia” }]"""
    val acc:List[String]=List.empty[String]
    println(
      json.substring(1,json.length-1).replaceAll(" ","").split("},\\{").map(_.stripPrefix("{").stripSuffix("}")).map(x=>x.split(",").map(y=>{val t=y.split(":"); (t(0),t(1))})).foldLeft(acc)((acc,ele)=>{acc:+ele(0)._2})
    )
  }
}
