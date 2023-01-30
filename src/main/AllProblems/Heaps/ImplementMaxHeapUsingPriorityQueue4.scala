object ImplementMaxHeapUsingPriorityQueue4
{
  val maxHeap:collection.mutable.PriorityQueue[Int]=collection.mutable.PriorityQueue.empty[Int]
  def main(Args:Array[String]):Unit={
    val inputArray:Array[Int]=Array(3,4,5,6,7,8,9)
    for(i<- 0 until inputArray.length){
      println(maxHeap)
      maxHeap.enqueue(inputArray(i))
    }
    //print max heap

    println(maxHeap)

    //print max element
    println(maxHeap.head)

    //remove max element
    maxHeap.dequeue()
    println(maxHeap)
  }
}
