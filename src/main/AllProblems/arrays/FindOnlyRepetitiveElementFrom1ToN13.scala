import scala.Console.println
import scala.math.abs
import scala.util.control.Breaks.break

object FindOnlyRepetitiveElementFrom1ToN13
{
  def findElement(a:Array[Int]):Int={
    for(i<- 0 until a.length){
      for(j<- i+1 until a.length){
        if(a(i)==a(j)){
          return a(i)
        }
      }
    }
    -1
  }
  def main(Args:Array[String]):Unit={
    var a:Array[Int]=Array(9, 8, 2, 6, 1, 8, 5, 3, 4, 7)
    println(findElement(a))

    //using sorting
    println("after soring")
    a=a.sorted
    println(a.mkString("Array(", ", ", ")"))
    for(i<-0 until a.length-1){
      if(a(i)==a(i+1)){
        println(a(i))
      }
    }

    //using hashSet
    var set:Set[Int]=Set()
    println(a.foldLeft(-1)((acc,ele)=>{
      if(set.contains(ele)){
        ele
      }
      else{
        set+=(ele)
        acc
      }
    }))

    println("using sum of natural nos concept")
    //using sum of first n natural numbers concept
    val s1=a.foldLeft(0)((acc, ele) => {
      acc + ele
    })
    val s2= List.range(1,10).foldLeft(0)((acc,ele)=>{
        acc+ele
      }
    )
    println(s1-s2)


    //using xor concept
    println("using xor concept")
    println(a.foldLeft(0)((acc,ele)=>{
      acc^ele
    })^List.range(1,10).foldLeft(0)((acc,ele)=>{
      acc^ele
    }))


    println("using indexing and making visited as -ve value")
    //using indexing to make repeated value as negative
    for(i<- 0 until a.length){
      if(a(abs(a(i)))<0){
        println(abs(a(i)))
        break()
      }
      else{
        a(abs(a(i)))= -a(abs(a(i)))
      }
    }

  }
}
