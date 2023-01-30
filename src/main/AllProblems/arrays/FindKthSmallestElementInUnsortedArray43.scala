import scala.annotation.tailrec
import scala.collection.SortedMap

object FindKthSmallestElementInUnsortedArray43
{
  val findKthSmallest:(Array[Int],Int)=>Int=(a:Array[Int],k:Int)=>{
    a(k-1)
  }

  val findKthSmallestUsingMinHeap:(Array[Int],Int)=>Int=(a:Array[Int],k:Int)=>{
    //use priority queue to create min heap
    val minHeap:collection.mutable.PriorityQueue[Int]=collection.mutable.PriorityQueue.empty[Int].reverse
    for(i<- 0 until a.length){
      minHeap.enqueue(a(i))
    }

    @tailrec
    def findKth(k:Int):Int={
      if(k==1) minHeap.head
      else{
        minHeap.dequeue()
        findKth(k-1)
      }
    }
    findKth(k)
  }

  val findKthSmallestUsingMaxHeap:(Array[Int],Int)=>Int=(a:Array[Int],k:Int)=>{
    val maxHeap:collection.mutable.PriorityQueue[Int]=collection.mutable.PriorityQueue.empty[Int]
    for(i<- 0 until k){
      maxHeap.enqueue(a(i))
    }
    for(i<- k until a.length){
      if(a(i)<maxHeap.head){
        maxHeap.dequeue()
        maxHeap.enqueue(a(i))
      }
    }
    maxHeap.head
  }

  val findKthSmallestUsingOrderedMap:(Array[Int],Int)=>Int=(a:Array[Int],k:Int)=>{
    @tailrec
    def storeInMap(a:Array[Int], m:SortedMap[Int,Int]):SortedMap[Int,Int]={
      if(a.isEmpty) m
      else if(!m.contains(a.head)) storeInMap(a.tail,m+(a.head->1))
      else storeInMap(a.tail,m+(a.head->(m(a.head)+1)))
    }
    val m:SortedMap[Int,Int]=storeInMap(a,SortedMap())


    @tailrec
    def findKthSmallest(m:SortedMap[Int,Int],acc:Int):Int={
      if(acc==k-1) m.head._1
      else findKthSmallest(m.tail,acc+m.head._2)
    }
    findKthSmallest(m,0)
  }

  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(7, 10, 4, 3, 20,2,1,6,8,101,9)
    val k:Int=scala.io.StdIn.readInt()

    //using sorted
    println(findKthSmallest(a.sorted,k))

    //using minHeap dataStructure
    println(findKthSmallestUsingMinHeap(a,k))

    //using max heap datastructure
    println(findKthSmallestUsingMaxHeap(a,k))

    //using ordered map
    println(findKthSmallestUsingOrderedMap(a,k))
  }
}
