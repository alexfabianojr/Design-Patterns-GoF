package BehavioralPatterns.InterpreterExampleKotlin

interface Expression {
    fun interpret(context: Map<String, Any>): String
}

class VariableExpression(private val name: String) : Expression {
    override fun interpret(context: Map<String, Any>): String {
        return context[name].toString()
    }
}

class TextExpression(private val text: String) : Expression {
    override fun interpret(context: Map<String, Any>): String {
        return text
    }
}

class TemplateExpression(private val expressions: List<Expression>) : Expression {
    override fun interpret(context: Map<String, Any>): String {
        val sb = StringBuilder()
        for (exp in expressions) {
            sb.append(exp.interpret(context))
        }
        return sb.toString()
    }
}

fun main() {
    val context = mapOf("name" to "John")
    val template = TemplateExpression(listOf(TextExpression("Hello, "), VariableExpression("name"), TextExpression("!")))
    println(template.interpret(context))
}
