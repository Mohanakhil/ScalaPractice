package main.AllProblems.arrays

import scala.annotation.tailrec

object MedianOf2SortedArrays11
{
  def mergeAndSort(a:Array[Int],b:Array[Int]):Int={
    val c:Array[Int]=(a++b).sorted
    if(c.length%2!=0) c(c.length/2)
    else (c(c.length/2)+c(c.length/2-1))/2
  }

  @tailrec
  def median(a: Array[Int], b: Array[Int],acc:Array[Int]):Array[Int]={
    if(a.isEmpty){
      acc++b
    }
    else if(b.isEmpty){
      acc++a
    }
    else if(a.head<b.head) median(a.tail,b,acc:+a.head)
    else median(a,b.tail,acc:+b.head)
  }


val medianOfSortedArrays:(Array[Int],Array[Int])=>Int=(a:Array[Int],b:Array[Int])=>{
  val totalSize=a.length+b.length
  @tailrec
  def median(a:Array[Int], b:Array[Int], counter:Int,x:Int,y:Int):Int={
     if(a.nonEmpty&&b.nonEmpty){
       if (totalSize % 2 != 0 && counter > totalSize / 2) {
         x
       }
       else if (totalSize % 2 == 0 && counter > totalSize / 2) {
         (x + y) / 2
       }
       else if (a.head < b.head) {
         median(a.tail, b, counter + 1, a.head, x)
       }
       else {
         median(a, b.tail, counter + 1, b.head, x)
       }
     }
    else{
       if (totalSize % 2 != 0 && counter > totalSize / 2) {
         x
       }
       else if (totalSize % 2 == 0 && counter > totalSize / 2) {
         (x + y) / 2
       }
       else if(a.isEmpty){
         median(a,b.tail,counter+1,b.head,x)
       }
       else{
         median(a.tail,b,counter+1,a.head,x)
       }
     }
  }
  median(a,b,0,0,0)
}

  def findMedians(a: Array[Int], b: Array[Int]):(Int,Int)={
    if(a.length%2!=0&&b.length%2!=0){
      (a(a.length/2),b(b.length/2))
    }
    else if(a.length%2==0&&b.length%2==0){
      ((a(a.length/2)+a(a.length-1))/2, (b(b.length/2)+b(b.length-1))/2)
    }
    else if(a.length%2!=0&&b.length==0){
      (a(a.length/2), a(a.length/2)+a(a.length-1)/2)
    }
    else{
      (b(b.length/2), b(b.length/2)+b(b.length-1)/2)
    }
  }

//  val medianDiscardHalf:(Array[Int],Array[Int])=>Int=(a:Array[Int],b:Array[Int])=>{
//
//    @tailrec
//    def median(a:Array[Int], b:Array[Int]):Int={
//      if(a.length==0){
//        findMedians(Array(),b)._2
//      }
//      else if(b.length==0){
//        findMedians(a,Array())._1
//      }
//      val (median1:Int,median2:Int)=findMedians(a,b)
//      if(median1<median2){
//        median(a.splitAt(median1)._2,b.splitAt(median2)._1)
//      }
//      else if(median2>median1){
//        median(a.splitAt(median1)._1,b.splitAt(median2)._2)
//      }
//      else{
//
//      }
//    }
//    median(a,b)
//  }

  //formula is
  //l1<r2
  //l2<r1

  val medianByPartition:(Array[Int],Array[Int])=>Int=(a:Array[Int],b:Array[Int])=>{
    def median(a:Array[Int],b:Array[Int]):Int={
      var low=0;var high=a.length
      val n1 = a.length
      val n2 = b.length
      while(low<=high){
        val cut1 = (low + high) / 2
        val cut2 = (a.length + b.length) / 2 - cut1
        var l1=0
        cut1 match {
          case 0=> l1=Integer.MIN_VALUE
          case _=> l1=a(cut1-1)
        }
        var l2=0
        cut2 match {
          case 0=>l2=Integer.MIN_VALUE
          case _=>l2=b(cut2-1)
        }
        var r1=0
        if(cut1==n1){
          r1=Integer.MAX_VALUE
        }
      else{
        r1=a(cut1)
        }
        var r2=0
        if(cut2==n2){
          r2=Integer.MAX_VALUE
        }
        else{
          r2=b(cut2)
        }
        if(l1>r2){
          high=cut1-1
        }
        else if(l2>r1){
          low=cut1+1
        }
        else{
          if ((n1+n2) % 2 == 0) {
            return (Math.max(l1, l2) + Math.min(r1, r2))/2
          } else {
            return Math.min(r1, r2)
          }
        }
      }
      -1
    }
    median(a,b)
  }


  def main(Args:Array[String]):Unit={
    val a:Array[Int]=Array(1,5,8,10,18,20)
    val b:Array[Int]=Array(2,3,6,7)
    //merge and sort and return the median
    //1,2,4,5,9,12,13,14,15
    println(mergeAndSort(a,b))


    //naive approach
    val acc:Array[Int]= median(a,b,Array())
    if(acc.length%2!=0){
      println(acc(acc.length/2))
    }
    else
      println((acc(acc.length/2)+acc((acc.length-1)/2))/2)

    //using counter and storing 2 adjacent values
    println(medianOfSortedArrays(a, b))


    //using recursion and cutting
//    println(medianDiscardHalf(a,b))

    //Using Hard approach
    println(medianByPartition(a,b))
  }
}
