object FromJsonPrintOutShortNamesOfStates6
{
  def main(Args:Array[String]):Unit={
    val json:String="""[{"country": "India","states": [{"name": "AndhraPradesh","capital": "Amaravathi","official_language": "Telugu","other names":[{"shortName": "AP","type": "SHORT_NAME"}]},{"name": "Telangana", "capital": "Hyderabad", "official_language": "Telugu","other names":[{"shortName": "TN","type": "SHORT_NAME"}]}]}]"""
    val acc1:List[String]=List.empty[String]
    println(json.substring(32, json.length - 3).split("},\\{").map(_.stripPrefix("{").stripSuffix("}")).flatMap(x => x.split(",").map(x => x.replace("other names\":[{\"", "").replace("}]", ""))).map(x=>{val temp=x.split(":").map(_.replaceAll(" ",""));(temp(0),temp(1))}))
  }
}
