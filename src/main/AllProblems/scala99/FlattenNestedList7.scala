object FlattenNestedList7
{
    def main(Args:Array[String]):Unit={
      val list:List[List[Int]]=List(List(1,2),List(3,4))
      println(list.flatten)
    }
}
