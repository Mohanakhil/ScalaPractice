object FactorialOfGivenNumber
{
  def factorial(n:Int):Unit={
    var fact:Int=1
    var k=n
    while(k > 0){
      fact=fact*k
      k=k-1
    }
    println(fact)
  }


  def  main(args:Array[String]):Unit={
    factorial(4)
  }
}
