package javaProblemAnalyze.generics
sealed class DoorState
object Open: DoorState()
object Closed: DoorState()

/*
class Door(val state: DoorState) {
    fun open() = Door(Open).also { println("open()") }
    fun close() = Door(Closed).also { println("close()") }
}
 */

class Door<out T: DoorState>(val state: T)
fun open() = Door(Open).also { println("open()") }
fun close() = Door(Closed).also { println("close()") }
//const val arun ="zdvds"




fun main() {
    open()
        .also { println("state: ${it.state}") }
    close()
        .also { println("state: ${it.state}") }

    // will no longer compile :) ...
    /*
    Door(Open)
            .also { println("=========") }
            .also { println("state: ${it.state}") }
            .open()
            .also { println("state: ${it.state}") }
    Door(Closed)
            .also { println("=========") }
            .also { println("state: ${it.state}") }
            .close()
            .also { println("state: ${it.state}") }
     */

}