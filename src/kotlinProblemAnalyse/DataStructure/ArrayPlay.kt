package kotlinProblemAnalyse.DataStructure

fun main(){
    var arrayInt = arrayOfNulls<Int>(10)

    arrayInt[0] = 1
    arrayInt[1] = 2
    arrayInt[2] = 2
    arrayInt[3] = 2
    arrayInt[4] = 2
    arrayInt[5] = 2
    arrayInt[6] = 2
    arrayInt[7] = 1
    arrayInt[8] = 9
    for(i in 0 .. 9 step 3)
//    for (ar in arrayInt) {
      println(arrayInt[i])
//    }
}
class ArrayPlay {

}