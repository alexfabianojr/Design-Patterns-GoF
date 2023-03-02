package BehavioralPatterns

// Interface de comando
interface Command {
    fun execute()
}

// Implementação do comando
class ConcreteCommand(private val receiver: Receiver) : Command {
    override fun execute() {
        receiver.action()
    }
}

// Receptor do comando
class Receiver {
    fun action() {
        println("Receptor: executando uma ação.")
    }
}

// Classe cliente que usa o comando
fun main() {
    val receiver = Receiver()
    val command = ConcreteCommand(receiver)
    val invoker = Invoker(command)
    invoker.executeCommand()
}

// Classe invocadora que executa o comando
class Invoker(private val command: Command) {
    fun executeCommand() {
        command.execute()
    }
}
