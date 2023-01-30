object ImplementMinHeapUsingArray2
{
  class MinHeap
  {
    val minHeapArray:Array[Int]=new Array[Int](20)
    var size:Int=0

    def insertIntoMinHeap(value:Int):Unit={
      minHeapArray(size)=value
      var index:Int=size
      var parent:Int=(index-1)/2
      while(parent>=0&&(minHeapArray(parent)>minHeapArray(index)))
      {
        val temp:Int=minHeapArray(parent)
        minHeapArray(parent)=minHeapArray(index)
        minHeapArray(index)=temp
        index=parent
        parent=(index-1)/2
      }
      size=size+1
    }

    def getMinElement():Int={
      minHeapArray(0)
    }

    def minHeapify(index:Int):Unit={
      val leftChildIndex:Int=2*index+1
      val rightChildIndex:Int=2*index+2
      var smallest:Int=index

      if(leftChildIndex<size&&minHeapArray(leftChildIndex)<minHeapArray(index)){
        smallest=leftChildIndex
      }
      if(rightChildIndex<size&&minHeapArray(rightChildIndex)<minHeapArray(index)){
        smallest=rightChildIndex
      }

      if(smallest!=index){
        val temp:Int=minHeapArray(smallest)
        minHeapArray(smallest)=minHeapArray(index)
        minHeapArray(index)=temp
        minHeapify(smallest)
      }
    }

    def removeMinElement:Unit={
      minHeapArray(0)=minHeapArray(size-1)
      size=size-1
      minHeapify(0)
    }
  }

  def main(Args: Array[String]): Unit = {
    val m: MinHeap = new MinHeap
    val inputArray: Array[Int] = Array(45,38,30,20,10,7,2)

    //insert into minHeap
    for (i <- 0 until inputArray.length) {
      m.insertIntoMinHeap(inputArray(i))
    }
    println(m.minHeapArray.mkString("Array(", ", ", ")"))

    //get min Element from minHeap
    println(m.getMinElement())


    //remove min element from minHeap
    m.removeMinElement
    println(m.minHeapArray.mkString("Array(", ", ", ")"))

    println(m.getMinElement())
  }


}
