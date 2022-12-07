package abstractFactoryMethod

fun main() {
    var factory: AbstractFactory

    factory = RectangleFactory()
    factory.getShape().draw()

    factory = CircleFactory()
    factory.getShape().draw()

    factory = SquareFactory()
    factory.getShape().draw()
}

abstract class AbstractFactory {
    abstract fun getShape(): Shape
}

class RectangleFactory : AbstractFactory() {
    override fun getShape(): Shape = Rectangle()
}

class SquareFactory : AbstractFactory() {
    override fun getShape(): Shape = Square()
}

class CircleFactory : AbstractFactory() {
    override fun getShape(): Shape = Circle()
}

interface Shape {
    fun draw()
}

class Rectangle : Shape {
    override fun draw() {
        println("Inside rectangle::draw")
    }
}

class Square : Shape {
    override fun draw() {
        println("Inside square::draw")
    }
}

class Circle : Shape {
    override fun draw() {
        println("Inside circle::draw")
    }
}
