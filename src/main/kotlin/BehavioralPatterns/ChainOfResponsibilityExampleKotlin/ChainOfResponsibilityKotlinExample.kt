package BehavioralPatterns.ChainOfResponsibilityExampleKotlin

// Interface do manipulador
interface Handler {
    fun setNext(handler: Handler)
    fun handleRequest(request: Request)
}

// Implementação do manipulador
class ConcreteHandler1 : Handler {
    private var nextHandler: Handler? = null

    override fun setNext(handler: Handler) {
        this.nextHandler = handler
    }

    override fun handleRequest(request: Request) {
        if (request.type == RequestType.TYPE1) {
            println("ConcreteHandler1 tratou a solicitação.")
        } else {
            nextHandler?.handleRequest(request)
        }
    }
}

// Implementação do manipulador
class ConcreteHandler2 : Handler {
    private var nextHandler: Handler? = null

    override fun setNext(handler: Handler) {
        this.nextHandler = handler
    }

    override fun handleRequest(request: Request) {
        if (request.type == RequestType.TYPE2) {
            println("ConcreteHandler2 tratou a solicitação.")
        } else {
            nextHandler?.handleRequest(request)
        }
    }
}

// Classe solicitação
class Request(val type: RequestType)

// Enumeração de tipos de solicitação
enum class RequestType {
    TYPE1, TYPE2
}

fun main() {

}
