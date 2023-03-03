package BehavioralPatterns.MediatorExampleKotlin

// Mediator
interface Mediator {
    fun sendMessage(message: String, colleague: Colleague)
}

// Concrete Mediator
class ConcreteMediator : Mediator {
    private lateinit var colleagueA: ColleagueA
    private lateinit var colleagueB: ColleagueB

    fun setColleagueA(colleagueA: ColleagueA) {
        this.colleagueA = colleagueA
    }

    fun setColleagueB(colleagueB: ColleagueB) {
        this.colleagueB = colleagueB
    }

    override fun sendMessage(message: String, colleague: Colleague) {
        if (colleague == colleagueA) {
            colleagueB.receiveMessage(message)
        } else {
            colleagueA.receiveMessage(message)
        }
    }
}

// Colleague
abstract class Colleague(private val mediator: Mediator) {
    abstract fun sendMessage(message: String)
    abstract fun receiveMessage(message: String)

    protected fun send(message: String) {
        mediator.sendMessage(message, this)
    }
}

// Concrete Colleague A
class ColleagueA(mediator: Mediator) : Colleague(mediator) {
    override fun sendMessage(message: String) {
        send(message)
    }

    override fun receiveMessage(message: String) {
        println("ColleagueA received message: $message")
    }
}

// Concrete Colleague B
class ColleagueB(mediator: Mediator) : Colleague(mediator) {
    override fun sendMessage(message: String) {
        send(message)
    }

    override fun receiveMessage(message: String) {
        println("ColleagueB received message: $message")
    }
}

// Main
fun main() {
    val mediator = ConcreteMediator()

    val colleagueA = ColleagueA(mediator)
    val colleagueB = ColleagueB(mediator)

    mediator.setColleagueA(colleagueA)
    mediator.setColleagueB(colleagueB)

    colleagueA.sendMessage("Hello, ColleagueB!")
    colleagueB.sendMessage("Hi, ColleagueA!")
}
