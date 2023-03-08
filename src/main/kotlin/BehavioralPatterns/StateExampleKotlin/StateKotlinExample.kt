package BehavioralPatterns.StateExampleKotlin

import java.util.*

interface State {
    fun writeName(context: Context, name: String)
}

class LowerCaseState : State {
    override fun writeName(context: Context, name: String) {
        println(name.lowercase(Locale.getDefault()))
        context.state = UpperCaseState()
    }
}

class UpperCaseState : State {
    override fun writeName(context: Context, name: String) {
        println(name.uppercase(Locale.getDefault()))
        context.state = LowerCaseState()
    }
}

class Context(var state: State) {
    fun writeName(name: String) {
        state.writeName(this, name)
    }
}

fun main() {
    val context = Context(LowerCaseState())
    context.writeName("Hello World")
    context.writeName("Goodbye World")
}
