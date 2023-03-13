package BehavioralPatterns.VisitorExampleKotlin

interface Visitor {
    fun visit(elementA: ElementA)
    fun visit(elementB: ElementB)
}

interface Element {
    fun accept(visitor: Visitor)
}

class ElementA : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

    fun operationA() {
        println("ElementA operationA")
    }
}

class ElementB : Element {
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

    fun operationB() {
        println("ElementB operationB")
    }
}

class ConcreteVisitor : Visitor {
    override fun visit(elementA: ElementA) {
        elementA.operationA()
    }

    override fun visit(elementB: ElementB) {
        elementB.operationB()
    }
}

fun main(args: Array<String>) {
    val elements = arrayOf(ElementA(), ElementB())

    val visitor = ConcreteVisitor()

    for (element in elements) {
        element.accept(visitor)
    }
}
