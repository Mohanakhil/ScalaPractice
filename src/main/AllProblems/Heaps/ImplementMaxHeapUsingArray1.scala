import scala.annotation.tailrec

//time complexity for inserting new element is O(logn)
//for removing element is also O(logn)
//

object ImplementMaxHeapUsingArray1
{
  val a:Array[Int]=new Array[Int](20)
  var size:Int=0

  def insertNewElement(x:Int):Unit={
    var index:Int=size
    a(index)=x
    var parent:Int=(index-1)/2
    while(parent>=0&&a(parent)<a(index))
      {
        val temp:Int=a(parent)
        a(parent)=a(index)
        a(index)=temp

        index=parent
        parent=(index-1)/2
      }
      size=size+1
  }

  def getMaxValue:Int={
    a(0)
  }

  @tailrec
  def maximumHeapify(index:Int):Unit=
  {
    val leftChildIndex:Int=2*index+1
    val rightChildIndex:Int=2*index+2
    var largest:Int=index
    if(leftChildIndex<size&&a(leftChildIndex)>a(largest))
    {
      largest=leftChildIndex
    }
    if(rightChildIndex<size&&a(rightChildIndex)>a(largest))
    {
      largest=rightChildIndex
    }
    if(largest!=index)
    {
      val temp:Int=a(largest)
      a(largest)=a(index)
      a(index)=temp
      maximumHeapify(largest)
    }
  }

  def removeMax():Unit={
    val max:Int=a(0)
    a(0)=a(size-1)
    // we have removed a(0) max element
    size=size-1
    maximumHeapify(0)
  }



  def main(Args:Array[String]):Unit={
    val arr:Array[Int]=Array(10,7,11,30,20,38,2,45)
    for(i<- 0 until arr.length)
    {
      insertNewElement(arr(i))
    }
    println(a.mkString("Array(", ", ", ")"))
    //to max value its just first index
    println(getMaxValue)

    //how to remove maximum element
    removeMax()
    println(a.mkString("Array(", ", ", ")"))


    println(getMaxValue)
  }
}
