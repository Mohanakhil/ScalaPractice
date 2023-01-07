import scala.annotation.tailrec

object CheckIfAPairExistsWithGivenSum15
{
    def findPair_v1(a: Array[Int],sum:Int):(Int,Int)={
        for(i<-0 until a.length)
            {
                for(j<- i+1 until a.length){
                    if(a(i)+a(j)==sum){
                        return (a(i),a(j))
                    }
                }
            }
        (-1,-1)
    }

    def main(Args:Array[String]):Unit={
        var a:Array[Int]=Array(0,-1,2,-3,1)
        val sum:Int=3
        println(findPair_v1(a,sum))
        a=a.sorted


        //using 2 pointers
//        var i=0;
//        var j=a.length-1
//        while(i<j)
//            {
//                if(a(i)+a(j)==sum){
//                    println(a(i),a(j))
//                    break();
//                }
//                else if(a(i)+a(j)<sum)
//                    {
//                        i=i+1
//                    }
//                else j=j-1
//            }


        //using binarySearch

        @tailrec
        def binarySearch(a: Array[Int], searchKey: Int, left:Int, right:Int, mid:Int):Int={
            if(left>right) -1
            else if(a(mid)==searchKey) mid
            else if(searchKey>a(mid)) binarySearch(a,searchKey, mid+1, right,(left+right)/2)
            else binarySearch(a,searchKey, left, mid-1,(left+right)/2)
        }

        for(i<- 0 until a.length)
            {
                val search=sum-a(i)
                val index:Int=binarySearch(a,search,0,a.length-1,(0+a.length-1)/2)
                if(index!= -1){
                    println(a(i)+" "+a(index))
                }
            }

        //using hashing
        var set:Set[Int]=Set()
        for(i<-0 until  a.length)
            {
                val rem:Int=sum-a(i)
                if(set.contains(rem)){
                        println(a(i)+" "+rem)
                }
                else{
                    set+=a(i)
                }
            }
    }
}
