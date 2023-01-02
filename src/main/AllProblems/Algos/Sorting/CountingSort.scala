

object CountingSort
{

  //does not work on negative numbers


  val countSort:Array[Int]=>Array[Int]=(a:Array[Int])=>{
    val max:Int=a.foldLeft(0)((acc,ele)=>{
      if(ele>acc){
        ele
      }
      else acc
    })
    val count: Array[Int] = new Array[Int](max+1)
    val b:Array[Int]=new Array[Int](a.length)
      def sort(): Array[Int] ={
        for(i<- 0 until   a.length)
          {
            count(a(i))=count(a(i))+1
          }
          for(i<- 1 to  max)
            {
              count(i)=count(i-1)+count(i)
            }
            var i=a.length-1
          while(i>=0)
            {
              b(count(a(i))-1)=a(i)
              count(a(i))=count(a(i))-1
              i=i-1
            }
            b
      }
      sort()
  }
    def main(Args:Array[String]):Unit={
      val a:Array[Int]=Array(2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9)
      println(countSort(a).mkString("Array(", ", ", ")"))
    }
}
