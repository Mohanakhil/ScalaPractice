object ImplementMinHeapUsingPriorityQueue3
{
  //initializing min heap using priority queue
  //by default priority queue is always max heap so using reverse
  val minHeap:collection.mutable.PriorityQueue[Int]=collection.mutable.PriorityQueue.empty[Int].reverse

  def main(Args:Array[String]):Unit={

    val inputArray:Array[Int]=Array(45,38,30,20,10,7,2)

    for(i<-0 until inputArray.length){
      println(minHeap)
      minHeap.enqueue(inputArray(i))
    }

    //print minHeap in scala
    println(minHeap)

    //print min element  from minHeap
    println(minHeap.head)

    //remove min element from minHeap
    println(minHeap.dequeue())

    //after removing the min ele then min Heap becomes
    println(minHeap)
  }
}
