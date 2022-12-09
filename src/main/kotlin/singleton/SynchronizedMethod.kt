package singleton

fun main() {
    val singletonOne = SingletonSynchronized.getInstance()

    singletonOne.value = "[ A ]"

    val singletonTwo = SingletonSynchronized.getInstance()

    println(singletonTwo.value)

    singletonOne.value = "[ B ]"

    println(singletonTwo.value)
}

object SingletonSynchronized {
    private var singleton: SomethingTwo? = null
    init {
        synchronized(this) {
            singleton = singleton ?: SomethingTwo()
        }
    }

    fun getInstance(): SomethingTwo = singleton!!
}

class SomethingTwo {
    var value: String? = null
}
