package main.AllProblems.Algos.Sorting

object RadixSorting
{
  def bucketSort(a: Array[Int]):Unit={
    var big:Int=0
    var noOfDigits=0
    var loc=0
    var division=1
    val n:Int=a.length
    var k: Int = 0
    big=a.foldLeft(big)((acc,ele)=>{
      if(ele>acc) ele
      else acc
    })
    println(big)
    while(big>0){
      noOfDigits=noOfDigits+1
      big=big/10
    }
    for(steps<- 1 until noOfDigits){
      for(j<- 0 until 10){
        val noOfElementsInEachBucket: Array[Int] = new Array[Int](10)
        val bucket: Array[Array[Int]] = Array.ofDim[Int](10, 10)
        for(i<-  0 until n){
          loc=(a(i)/division)%10
          bucket(loc)(noOfElementsInEachBucket(loc))=a(i)
          noOfElementsInEachBucket(loc)=noOfElementsInEachBucket(loc)+1
        }
        k=0
        for(m<-0 until 10 ){
            for(i<- 0 until noOfElementsInEachBucket(m)){
              a(k)=bucket(m)(i)
              k=k+1
            }
        }
        division=division*10
      }
    }


  }
  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(66,98,105,61,54,136,12,1001)
    bucketSort(a)
    println(a.mkString("Array(", ", ", ")"))

  }
}
