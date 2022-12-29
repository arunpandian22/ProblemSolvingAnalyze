package javaProblemAnalyze.chaningPattern

fun main() {

    //https://siddroid.com/post/kotlin/build-function-chains-using-composition-in-kotlin/?hmsr=joyk.com&utm_source=joyk.com&utm_medium=referral


    // Composing our car
    val car = Car.compose(Chain.carEngineType(EngineType.ELECTRIC)
        .carOwnerDetails(
            name = "Android Dev Community",
            licenceNo = "API31",
            address = "California"
        ).carSpecs(
            wheelCount = 4,
            seats = 2,
            manufacturer = "Tesla"
        ).carVisuals(
            color = "Green"
        )
    )

    // Use the car
    println("Safe for environment? -> ${car.ownerDetails()}")
}


/**
 * Chainer core interface
 */
interface Chain {

    /**
     * Fold aggregator
     * Direction: Left -> Right
     * @param initial the inital object
     * @param operation the operation to perform
     * @return the type-specified object
     */
    fun <R> fold(initial: R, operation: (R, ChainUnit) -> R): R

    /**
     * Form LinkedChain object linking two ChainUnits
     * @return [LinkedChain] object
     */
    fun then(other: Chain): Chain = LinkedChain(this, other)

    /**
     * A chain-unit
     * Building block of our chain
     */
    interface ChainUnit : Chain {
        /**
         * Fold aggregator
         * Direction: Left -> Right
         * @param initial the inital object
         * @param operation the operation to perform
         * @return the type-specified object
         */
        override fun <R> fold(initial: R, operation: (R, ChainUnit) -> R): R =
            operation(initial, this)
    }

    /**
     * Companion builder for starting chains
     */
    companion object : Chain {

        override fun <R> fold(initial: R, operation: (R, ChainUnit) -> R): R = initial

        override fun then(next: Chain): Chain = next
    }
}


class LinkedChain(
    private val outer: Chain,
    private val inner: Chain
) : Chain {
    override fun <R> fold(initial: R, operation: (R, Chain.ChainUnit) -> R): R =
        inner.fold(outer.fold(initial, operation), operation)
}

interface Vehicle {
    fun isSafeForEnvironment(): Boolean

    fun color(): String

    fun seatCapacity(): Int

    fun ownerDetails(): String

    fun wheels(): Int

    fun manufacturer(): String
}


// All modules of our object, which are Chain units

class CarEngine(var engineType: EngineType) : Chain.ChainUnit {

    fun needRecharge(): Boolean {
        return (engineType == EngineType.ELECTRIC)
    }

    fun causesPollution(): Boolean {
        return engineType == EngineType.DIESEL || engineType == EngineType.PETROL
    }
}

class CarVisuals(var color: String) : Chain.ChainUnit {
    fun isColorMetallic(): Boolean {
        // some color determining logic here
        // dummy response
        return true
    }
}

class CarSpecs(var wheelCount: Int, var seats: Int, var manufacturer: String) : Chain.ChainUnit {
    // other function here for car specification module to be called in the implementing class

}

class CarOwner(var name: String, var licenceNo: String, var address: String) : Chain.ChainUnit {
    fun isLicenceExpired(): Boolean {
        // Some logic based on licenceNo
        // dummy response
        return false
    }
}

enum class EngineType {
    ELECTRIC,
    DIESEL,
    PETROL
}


class Car private constructor(chainer: Chain) : Vehicle {

    private var carEngine: CarEngine? = null
    private var carOwner: CarOwner? = null
    private var carSpecs: CarSpecs? = null
    private var carVisuals: CarVisuals? = null

    companion object {

        fun compose(chainer: Chain): Car {
            return chainer.fold(Car(chainer)) { car, chainUnit ->
                when (chainUnit) {
                    is CarEngine -> car.carEngine = chainUnit
                    is CarVisuals -> car.carVisuals = chainUnit
                    is CarSpecs -> car.carSpecs = chainUnit
                    is CarOwner -> car.carOwner = chainUnit
                }
                car
            }
        }

    }

    override fun isSafeForEnvironment(): Boolean {
        return if (carEngine != null) {
            !carEngine!!.causesPollution()
        } else {
            // default, handle as needed
            false
        }
    }

    override fun color(): String {
        return if (carVisuals != null) {
            carVisuals!!.color
        } else {
            // default, handle as needed
            "NA"
        }
    }

    override fun seatCapacity(): Int {
        return if (carSpecs != null) {
            carSpecs!!.seats
        } else {
            // default, handle as needed
            4
        }
    }

    override fun ownerDetails(): String {
        return if (carOwner != null) {
            "${carOwner?.name} ${carOwner?.licenceNo}"
        } else {
            // default, handle as needed
            "No owner"
        }
    }

    override fun wheels(): Int {
        return if (carSpecs != null) {
            carSpecs!!.wheelCount
        } else {
            4
        }
    }

    override fun manufacturer(): String {
        return if (carSpecs != null) {
            carSpecs!!.manufacturer
        } else {
            "NA"
        }
    }
}


// Kotlin extension functions over our chain

fun Chain.carEngineType(engineType: EngineType): Chain = this.then(
    CarEngine(engineType)
)

fun Chain.carOwnerDetails(name: String, licenceNo: String, address: String): Chain = this.then(
    CarOwner(name, licenceNo, address)
)

fun Chain.carSpecs(wheelCount: Int, seats: Int, manufacturer: String): Chain = this.then(
    CarSpecs(wheelCount, seats, manufacturer)
)

fun Chain.carVisuals(color: String): Chain = this.then(
    CarVisuals(color)
)

//object:  Modifier {
//
//}

