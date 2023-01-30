object UpperCaseLast4CharactersofAllWords4
{
  def main(Args:Array[String]):Unit={
    val s1:String="mohan akhil denduluri is working in techsophy currently"
    println(s1.split(" ")
      .map(x => {
        if (x.length >= 4) x.slice(0, x.length - 4).concat(x.slice(x.length - 4, x.length).toUpperCase())
        else x.toUpperCase()
      }).mkString("Array(", ", ", ")"))

  }
}
