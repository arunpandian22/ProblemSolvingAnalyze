package javaProblemAnalyze.intern

interface Login {
    fun validation(userName: String, password: String)
}

class ShaKeyValidation : Login {
    override fun validation(userName: String, password: String) {
        print("sha key 1 validation")
    }
}

class ShaKey2Validation : Login {
    override fun validation(userName: String, password: String) {
        print("sha key 2 validation")
    }
}


fun main() {
//    val shaKeyValidation: Login = ShaKey2Validation()
//    shaKeyValidation.validation("jayanees", "adkjcnadkjl")
//    val team = Team("FI")
//    team.showDevelopers()

    var i = 10
    when {
        i < 11 -> {
            print("arun")
        }
        i < 100 -> {
            print("arun 100")
        }
    }

    fun someMethod() {
//        sfvsf
    }
}