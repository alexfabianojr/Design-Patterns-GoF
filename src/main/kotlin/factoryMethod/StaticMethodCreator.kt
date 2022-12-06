package factoryMethod

fun main() {
    val ferrari = StaticMethodCreator.carFactotry(StaticMethodCreator.Cars.FERRARI)
    val volkswagen = StaticMethodCreator.carFactotry(StaticMethodCreator.Cars.VOLKSWAGEN)
    val chevrolet = StaticMethodCreator.carFactotry(StaticMethodCreator.Cars.CHEVROLET)

    ferrari.type()
    volkswagen.type()
    chevrolet.type()
}

class StaticMethodCreator {
    companion object StaticFactory {
        fun carFactotry(type: Cars) : Car = when (type) {
            Cars.FERRARI -> Ferrari()
            Cars.CHEVROLET -> Chevrolet()
            Cars.VOLKSWAGEN -> Volkswagen()
        }
    }

    enum class Cars {
        FERRARI, VOLKSWAGEN, CHEVROLET
    }
}

interface Car {
    fun type()
}

class Ferrari : Car {
    override fun type() {
        println("Ferrari")
    }
}

class Volkswagen : Car {
    override fun type() {
        println("Volkswagen")
    }
}

class Chevrolet : Car {
    override fun type() {
        println("Chevrolet")
    }
}
