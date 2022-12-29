package kotlinProblemAnalyse.compilersmart

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {

    val a: Int
    initialize {
        a = 42
    }

    var testingInterface:InterfaceTestingClass = InterfaceTestingClass()
    testingInterface.setInterface(object : TestingInterface {
        override fun callback() {

        }

    })

    print(a)
}

@OptIn(ExperimentalContracts::class)
fun initialize(myLambda: () -> Unit) {
    contract {
        callsInPlace(myLambda, InvocationKind.EXACTLY_ONCE)
    }
    myLambda()
}

 interface TestingInterface {
    fun callback(): Unit
}

class InterfaceTestingClass {
    var testingInterface: TestingInterface? =null ;

     fun setInterface(testingInterface: TestingInterface){
        this.testingInterface = testingInterface
    }

}



