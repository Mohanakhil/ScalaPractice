object FindOddIntegersBetweenAB7
{
    def main(Args:Array[String]):Unit={
      println(List.range(-200,201).filter(x=>x%2!=0))
    }
}
