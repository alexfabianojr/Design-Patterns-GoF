package BehavioralPatterns.StrategyExampleKotlin

interface PaymentStrategy {
    fun pay(amount: Double)
}

class CreditCardStrategy(
    private val name: String,
    private val cardNumber: String,
    private val cvv: String,
    private val expirationDate: String
) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount with credit card $cardNumber")
    }
}

class PaypalStrategy(
    private val email: String,
    private val password: String
    ) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount with PayPal account $email")
    }
}

class ShoppingCart(var paymentStrategy: PaymentStrategy) {
    fun checkout(amount: Double) {
        paymentStrategy.pay(amount)
    }
}

fun main() {
    val cart = ShoppingCart(CreditCardStrategy("John Doe", "1234567890", "123", "01/23"))
    cart.checkout(100.0)
    cart.paymentStrategy = PaypalStrategy("john.doe@example.com", "password")
    cart.checkout(50.0)
}
