package kotlinProblemAnalyse.generalProblem

/*
 * Complete the 'aVeryBigSum' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts LONG_INTEGER_ARRAY ar as parameter.
 */

fun aVeryBigSum(ar: Array<Long>): Long {
    // Write your code here
    var sum = 0L
    ar.forEach {
        sum += it
    }
return sum
}

fun main(args: Array<String>) {
    val arCount = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val result = aVeryBigSum(ar)

    println(result)
}