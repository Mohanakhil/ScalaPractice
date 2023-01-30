import scala.annotation.tailrec

object RearrangeArrayAlternatePositiveNegative38
{
  val rearrangeUsingAnotherArray:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def seperateNumbers(pos:Array[Int], negative:Array[Int],a:Array[Int]):(Array[Int],Array[Int])={
      if(a.isEmpty) (pos,negative)
      else if(a.head>=0) seperateNumbers(pos:+a.head,negative,a.tail)
      else seperateNumbers(pos,negative:+a.head,a.tail)
    }
   val (pos:Array[Int],negative:Array[Int])= seperateNumbers(Array(),Array(),a)

    @tailrec
    def addIntoArray(pos:Array[Int], negative:Array[Int],acc:Array[Int]):Array[Int]={
      if(pos.isEmpty||negative.isEmpty){
        if(pos.isEmpty) return acc++negative
        else return acc++pos
      }
        addIntoArray(pos.tail, negative.tail,acc:+negative.head:+pos.head)
    }
    addIntoArray(pos,negative,Array())
  }

  val rearrangeUsingRotation:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    val newArray:Array[Int]=new Array[Int](a.length)
    for(i<- 0 until a.length){
      if(i%2==0&&a(i)>0||(i%2!=0&&a(i)<0)){
        val left=i
        for(k<- i+1 until a.length){
          if(k%2==0&&a(k)>0||(k%2!=0&&a(k)<0)){
            val right=k
           val newArray:Array[Int]= a.slice(0,left):+a(right)
            newArray++a.slice(left,right)
          }
        }
      }
    }
    newArray
  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8)

    //using extra space
    println(rearrangeUsingAnotherArray(a).mkString("Array(", ", ", ")"))

    //using rotation and no extra space
    println(rearrangeUsingRotation(a).mkString("Array(", ", ", ")"))
  }
}
