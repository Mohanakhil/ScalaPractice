import scala.annotation.tailrec

object FindKthLargestElementInUnSortedArray44
{
  val findKthMaxUsingMaxHeap:(Array[Int],Int)=>Int=(a:Array[Int],k:Int)=>{
    val maxHeap:collection.mutable.PriorityQueue[Int]=collection.mutable.PriorityQueue.empty[Int]
    for(i<- 0 until a.length){
      maxHeap.enqueue(a(i))
    }

    @tailrec
    def find(k:Int):Int={
      if(k==1) maxHeap.head
      else{
        maxHeap.dequeue()
        find(k-1)
      }
    }
    find(k)
  }

  val findKthMaxUsingMinHeap:(Array[Int],Int)=>Int=(a:Array[Int],k:Int)=>{
    val minHeap:collection.mutable.PriorityQueue[Int]=collection.mutable.PriorityQueue.empty[Int].reverse
    for(i<- 0 until k){
      minHeap.enqueue(a(i))
    }

    for(j<- k until a.length){
      if(a(j)>minHeap.head){
        minHeap.dequeue()
        minHeap.enqueue(a(j))
      }
    }
    minHeap.head
  }

  def main(Args:Array[String]):Unit={
    //using maxHeap
    val a:Array[Int]=Array(7, 10, 4, 3, 20, 15)
    val k:Int=scala.io.StdIn.readInt()
    println(findKthMaxUsingMaxHeap(a,k))

    //using minHeap
    println(findKthMaxUsingMinHeap(a,k))
  }
}
