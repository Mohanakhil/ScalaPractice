import scala.annotation.tailrec

object HCF32 extends App
{
  @tailrec
  def hcf(a:Int, b:Int):Int={
    if(b==0) a
    else hcf(b,a%b)
  }
  val (a:Int,b:Int)=(35,64)
  println(hcf(a,b))

  //checking if coprimes
  if(hcf(a,b)==1){println(true)}
  else println(false)

}
