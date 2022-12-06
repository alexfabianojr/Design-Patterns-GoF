package factoryMethod

fun main() {
    val factory = AnimalFactory()
    factory.getAnimal(Animals.DOG).type()
    factory.getAnimal(Animals.CAT).type()
    factory.getAnimal(Animals.HORSE).type()
}

class AnimalFactory {
    fun getAnimal(type : Animals) : Animal = when(type) {
        Animals.DOG -> Dog()
        Animals.CAT -> Cat()
        Animals.HORSE -> Horse()
    }
}

enum class Animals {
    DOG, CAT, HORSE
}

interface Animal {
    fun type()
}

class Dog : Animal {
    override fun type() {
        println("Canis lupus familiaris")
    }
}

class Cat : Animal {
    override fun type() {
        println("Felis catus")
    }
}

class Horse : Animal {
    override fun type() {
        println("Equus caballus")
    }
}
