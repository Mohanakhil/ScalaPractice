import scala.annotation.tailrec

object FindElementThatAppearsOnceInArray47
{
  val findElementThatAppearsOnce:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def findElement(i:Int, j:Int, count:Int,acc:Array[Int]):Array[Int]={
      if(i>=a.length) acc
      else if(j>=a.length){
        if(count==1) findElement(i+1,i+2,1,acc:+a(i))
        else findElement(i+1,0,1,acc)
      }
      else if(a(i)==a(j)) findElement(i,j+1,count+1,acc)
      else findElement(i,j+1,count,acc)
    }
    findElement(0,1,1,Array())
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(2, 3, 5, 4, 5, 3, 4)

    println(findElementThatAppearsOnce(a).mkString("Array(", ", ", ")"))
  }
}
