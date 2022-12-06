package factoryMethod

fun main() {
    val rectangle = RectangleFactory().factoryMethod()
    val square = SquareFactory().factoryMethod()
    val circle = CircleFactory().factoryMethod()

    rectangle.draw()
    square.draw()
    circle.draw()
}

abstract class AbstractShapeFactory {
    abstract fun factoryMethod() : Shape
}

class RectangleFactory : AbstractShapeFactory() {
    override fun factoryMethod(): Shape = Rectangle()
}

class SquareFactory : AbstractShapeFactory() {
    override fun factoryMethod(): Shape = Square()
}

class CircleFactory : AbstractShapeFactory() {
    override fun factoryMethod(): Shape = Circle()
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
