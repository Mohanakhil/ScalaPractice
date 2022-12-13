

object HigherOrderFunctions1To17
{

def main(Args:Array[String]):Unit={
  val list:List[Int]=List(1,2,3,4,5)
  //Find the last element in list
  println(list.fold(0)((_, x)=>x))

  //Find the last but one element
  println(list.filter(x=>list.indexOf(x)==list.length-1).head)

  //Find no of eles of list
  println("total no of eles="+list.fold(0)((acc,x)=>x))

  //reverse a list
  println("after reversal ="+list.foldRight(List[Int]()) { (h,r) => r :+ h })

  val list2:List[Int]=List(1,2,3,2,1)
  //find if list is palindrome or not
  println(list2.equals(list2.foldLeft(List[Int]()){ (r, h) => h :: r }))

  println("after  left reversal ="+list.foldLeft(List[Int]()) { (h,r) => r +: h })

  //flatten nested list structure
//  val list3:List[List[Int]]=List(List(1,1),List(3,4))
//  println(list3.flatten)
//  flatten(list3)


}
}
