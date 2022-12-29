package javaProblemAnalyze


// regular function definition
fun add(a: Int, b: Int): Int {
    var sum = a + b
    return sum
}

// higher-order function definition
fun higherfunc(addfunc: (Int, Int) -> Int) {
    // invoke regular function using local name
    var result = addfunc(3, 6)
    print("The sum of two numbers is: $result")
}

fun main(args: Array<String>) {
    // invoke higher-order function
    higherfunc((::add))
}

fun main() {
    var valuer: String? = "null"
    var value: String = "null"

//   val ad = valuer?:"vx":"asdc" // ternery operator
//    val a by lazy {
//        println("hey there")
//        "Hello"
//    }

    val a = valuer ?: ""
    var person: Person? = null
//    person = Person("arun", 5)
    a.let {
        value = a
    }


    if (person != null) {
        print(person.name)
    }

    // null check and do some operation
    person.let { person ->

    }

//    apply mostly while building object we use this


    // intialize and performing operation
    val lengthOfName = Person("Vinay", 29).run {
        println("Age is $age")
        println("Name is $name")
        name.length
    }
    print(lengthOfName)

    person.apply { }


}

class Person(var name: String, var age: Int)

fun whentest() {
    val number = 3
    when {
        number > 1 -> {

        }
        number < 2 -> {

        }
    }

    fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

    var anyType: Any = ""
    when (anyType) {
        is Int -> print("X is integer")
        is String -> print("X is string")
    }

    when (number) {
        1 -> println("One") //statement 1
        2 -> println("Two") //statement 2
        3 -> println("Three") //statement 3
        in 4..8 -> println("Number between 4 and 8") //statement 4
        !in 9..12 -> println("Number not in between 9 and 12") //statement 5
        else -> println("Number is not between 1 and 8") //statement 6
    }


    fun coolFunction() {
        val persons = mutableListOf(
            Person("Vinay", 29),
            Person("Manish", 30),
            Person("Kunal", 24)
        )
        persons.filter { it.age > 25 }.map { it.name }.let {
            println(it)
        }
    }
}