package kotlinProblemAnalyse.generalProblem

fun main() {
    val bluePen = Pen(inkColor = "Blue")
    bluePen.showInkColor()

    val blackPen = Pen(inkColor = "Black")
    blackPen.showInkColor()

    val blueBlackPen = bluePen * blackPen
    blueBlackPen.showInkColor()
    blackPen>bluePen


}



operator fun Pen.compareTo(otherpen: Pen): Int {

        if (this.inkColor > otherpen.inkColor) return 1
        if (this.inkColor <= otherpen.inkColor) return -1
        if (this.inkColor > otherpen.inkColor) return 1
        if (this.inkColor < otherpen.inkColor) return -1
        if (this.inkColor > otherpen.inkColor) return 1
        if (this.inkColor < otherpen.inkColor) return -1
        return 0

}

operator fun Pen.times(otherPen: Pen): Pen {
    val ink = "$inkColor, ${otherPen.inkColor}"
    return Pen(inkColor = ink)
}

data class Pen(val inkColor: String) {
    fun showInkColor() {
        println(inkColor)
    }
}