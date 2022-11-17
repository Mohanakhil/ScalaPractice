object CalculatorProgram
{
  def add(a:Int,b:Int):Int={
    a+b
  }
  def sub(a:Int,b:Int):Int={
    a-b
  }
  def multiplication(a:Int,b:Int):Int={
    a*b
  }
  def division(a:Int,b:Int):Int={
    a/b
  }
  def abs(a:Int,b:Int):Int={
    val c:Int=a-b
    c.abs
  }
  def remainder(a:Int,b:Int):Int={
    a%b
  }
  def main(args:Array[String]):Unit={
    val a:Int=scala.io.StdIn.readInt()
    val b:Int=scala.io.StdIn.readInt()
    println(add(a,b))
    println(sub(a,b))
    println(multiplication(a,b))
    println(division(a,b))
    println(abs(a,b))
    println(remainder(a,b))
  }

}
