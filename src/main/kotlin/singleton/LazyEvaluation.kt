package singleton

fun main() {
    val singletonOne = SingletonLazy.singleton

    singletonOne.value = "[ A ]"

    val singletonTwo = SingletonLazy.singleton

    println(singletonTwo.value)

    singletonOne.value = "[ B ]"

    println(singletonTwo.value)
}

object SingletonLazy {
    val singleton: Something by lazy { Something() }
}

class Something {
    var value: String? = null
}
