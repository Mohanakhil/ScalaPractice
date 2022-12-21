package arrays

object InsertElementToArray1
{
  def insertAtStart(a: Array[Int], n: Int):Array[Int]={
    Array(n)++a
  }
  def insertAtLast(a: Array[Int], n: Int):Array[Int]={
    a++Array(n)
  }
  def insertAtK(a: Array[Int], n: Int, k: Int):Array[Int]={
    if(k>a.length) a
    else
      a.slice(0,k)++Array(n) ++a.slice(k,a.length)
  }

  def insertElementUsingArrayList(arr: Array[Int],element:Int,pos:Int):Array[Int]={
    val arrayList1:List[Int]=arr.toList
    (arrayList1.slice(0,pos):::List(element):::arrayList1.slice(pos,arrayList1.length)).toArray

  }

  def main(Args:Array[String]):Unit={
    val arr:Array[Int]=Array(3,4,5,6,7,8,9)
    //insert element at starting
    val n:Int=101
    println(insertAtStart(arr, n).mkString("Array(", ", ", ")"))

    //insert at last position
    println(insertAtLast(arr,n).mkString("Array(",",",")"))


    //insert at any position k using new array
    val k:Int=4
    println(insertAtK(arr, n, k).mkString("Array(", ", ", ")"))


    //insert at any pos using foldLeft
    val reqArray:Array[Int]=Array()
    val pos: Int = 7
    val element:Int=102
    val counter:Int=0
    println(arr.foldLeft(reqArray,counter)((acc,ele)=>{
      if(acc._2+1==pos) (acc._1:+element,acc._2+1)
      else if(acc._2==pos)  (acc._1:+element:+ele,acc._2+1)
      else (acc._1:+ele,acc._2+1)
    })._1.mkString("Array(",",",")"))


    //insert an element into array using arrayList
    println(insertElementUsingArrayList(arr,element,pos).mkString("Array(",",",")"))
  }
}
