import scala.annotation.tailrec

object RearrangeAnArraySuchThatIndexEqualsElements37
{
  val rearrange:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def findMax(a: Array[Int], max: Int):Int={
      if(a.isEmpty) max
      else if(a.head>max) findMax(a,a.head)
      else findMax(a.tail,max)
    }
    val max:Int=findMax(a,a.head)
    @tailrec
    def rearrangeArray(acc:Array[Int], counter:Int):Array[Int]={
      if(counter==max+1) acc
      else if(a.contains(counter)) rearrangeArray(acc:+counter,counter+1)
      else rearrangeArray(acc:+ -1,counter+1)
    }
    rearrangeArray(Array(),0)
  }

  val rearrangeUsingTraversal:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def rearrange(i:Int, j:Int, a:Array[Int]):Array[Int]={
      if(i>=a.length) a
      else if(j>=a.length) rearrange(i+1,0,a)
      else if(i==a(j)){
        val temp=a(j)
        a(j)=a(i)
        a(i)=temp
        rearrange(i,j+1,a)
      }
      else{
        rearrange(i,j+1,a)
      }
    }
    rearrange(0,0,a)
  }

  val rearrangeUsingSet:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    val s:Set[Int]=a.toSet
    @tailrec
    def rearrange(counter:Int, a:Array[Int]):Array[Int]={
      if(counter==a.length) a
      else if(s.contains(counter))
        {
          a(counter)=counter
          rearrange(counter+1,a)
        }
      else{
        a(counter)= -1
        rearrange(counter+1,a)
      }
    }
    rearrange(0,a)
  }

  val rearrangeUsingCyclicSort:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    @tailrec
    def rearrange(counter:Int):Array[Int]={
      if(counter>=a.length) a
      else if(a(counter)>=0&&a(counter)!=counter)
        {
         val temp= a(a(counter))
          a(a(counter))=a(counter)
          a(counter)=temp
          rearrange(counter)
        }
      else rearrange(counter+1)
    }
    rearrange(0)
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
      11, 10, 9, 5, 13, 16, 2, 14, 17, 4)
    //using max approach
//    println(rearrange(a).mkString("Array(", ", ", ")"))
//
//    //using traversal approach
//    println(rearrangeUsingTraversal(a).mkString("Array(", ", ", ")"))

    //using set
//    println(rearrangeUsingSet(a).mkString("Array(", ", ", ")"))

    //using another cyclic sorting

    println(rearrangeUsingCyclicSort(a).mkString("Array(", ", ", ")"))
  }
}
