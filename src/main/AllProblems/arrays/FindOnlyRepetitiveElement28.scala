import scala.annotation.tailrec

object FindOnlyRepetitiveElement28
{
  val findOnlyRepetitiveElement:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def findElement(a:Array[Int], i:Int, j:Int):Int={
      if(i>=a.length) -1
      else if(j<a.length){
        if(a(i)==a(j))
          {
            a(i)
          }
          else
          findElement(a,i,j+1)
      }
      else findElement(a,i+1,i+2)
    }
    findElement(a,0,1)
  }

  val findRepetitiveUsingSet:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def find(a:Array[Int], set:Set[Int], counter:Int):Int={
      if(counter>a.length) -1
      else if(set.contains(a(counter))) a(counter)
      else find(a,set+a(counter),counter+1)
    }
    find(a,Set(),0)
  }
  val findRepetitiveSorting:Array[Int]=>Int=(a:Array[Int])=>{
    @tailrec
    def find(a:Array[Int], index:Int):Int={
      if(index>a.length) -1
      else if(index+1!=a(index)) a(index)
      else find(a,index+1)
    }
    find(a,0)
  }

  val findRepetitiveUsingSum:(Array[Int],Int)=>Int=(a:Array[Int],n:Int)=>{
    a.sum-List.range(1,n+1).sum
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1,3,2,3,4,5)
    //using o(n2)
    println(findOnlyRepetitiveElement(a))


    //using sorting
    println(findRepetitiveSorting(a.sorted))

    //using sets
    println(findRepetitiveUsingSet(a))

    //using sum of N elements
    println(findRepetitiveUsingSum(a,5))

  }
}
