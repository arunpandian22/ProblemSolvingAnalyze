package kotlinProblemAnalyse.generalProblem

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val bnm = scan.nextLine().split(" ")

    val b = bnm[0].trim().toInt()

    val n = bnm[1].trim().toInt()

    val m = bnm[2].trim().toInt()

    val keyboards = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val drives = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    val moneySpent = getMoneySpent(keyboards, drives, b)

    println(moneySpent)
}

fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {
    var most = -1
    keyboards.forEach { keyboardPrice ->
        drives.forEach { drivePrice ->
            keyboardPrice.plus(drivePrice).apply {
                if (this in (most + 1)..b)
                    most = this
            }
        }
    }
    return most

}
