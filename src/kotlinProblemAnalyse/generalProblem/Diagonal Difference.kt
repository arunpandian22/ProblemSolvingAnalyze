package kotlinProblemAnalyse.generalProblem

import kotlin.math.abs


fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<Int>>(n) { Array<Int>(n) { 0 } }

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}


fun diagonalDifference(arr: Array<Array<Int>>): Int {
    println("index ${arr.size}")
    // Write your code here
    var d1 = 0
    var d2 = 0

    for (x in arr.indices)
    {
        d1 = +arr[x][x]
        d2 = +arr[x][arr.size-1-x]
    }
//    arr.forEachIndexed { index, element ->
//
//        println("outside index: ${index}")
//        element.forEachIndexed { indexInside, i ->
//            if (indexInside==index)
//            d1 = +i
//
////            if ()
//        }
//
////        d1 = +arr[index][index]
////        d2 = +arr[index][arr.size-index]
//    }

    return abs(d1 - d2)
}



