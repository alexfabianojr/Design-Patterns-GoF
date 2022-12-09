package singleton

fun main() {
    val singletonOne = SingletonDoubleCheckedLocking.getInstance()

    singletonOne.value = "[ A ]"

    val singletonTwo = SingletonDoubleCheckedLocking.getInstance()

    println(singletonTwo.value)

    singletonOne.value = "[ B ]"

    println(singletonTwo.value)
}

object SingletonDoubleCheckedLocking {

    @Volatile
    private var singleton: SomethingThree? = null

    init {
        if (singleton == null) {
            synchronized(this) {
                singleton = SomethingThree()
            }
        }
    }

    fun getInstance(): SomethingThree = singleton!!
}

class SomethingThree {
    var value: String? = null
}
