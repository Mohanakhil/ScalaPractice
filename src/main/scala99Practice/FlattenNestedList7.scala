

object FlattenNestedList7
{
  val flatten: List[Any]=>List[Any] = (list:List[Any])=>{

    def flattenNestedList(list:List[Any]):List[Any]= {
      val (nested, flatValues) = list.partition(x => x.isInstanceOf[List[_]])
      if (nested.isEmpty) {
        list
      } else {
        val updatedList = flatValues ::: nested.asInstanceOf[List[List[Any]]].flatten
        flatten(updatedList)
      }}
    flattenNestedList(list)
  }

  def main(Args:Array[String]):Unit={
   val list:List[Any]=List(List(1,1),2,List(3,List(5,8)))
   println(flatten(list))
 }
}
