package BehavioralPatterns.IteratorExampleKotlin

fun main() {
    val colors = arrayOf("Red", "Green", "Blue")

    // Iterator
    for (i in colors.indices) {
        val color = colors[i]
        println(color)
    }
}
