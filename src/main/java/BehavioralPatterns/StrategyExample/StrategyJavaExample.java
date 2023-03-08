package BehavioralPatterns.StrategyExample;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expirationDate;

    public CreditCardStrategy(String name, String cardNumber, String cvv, String expirationDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with credit card " + cardNumber);
    }
}

class PaypalStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PaypalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with PayPal account " + email);
    }
}

class ShoppingCart {


    private PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}

class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new CreditCardStrategy("John Doe", "1234567890", "123", "01/23"));
        cart.checkout(100.0);
        cart.setPaymentStrategy(new PaypalStrategy("john.doe@example.com", "password"));
        cart.checkout(50.0);
    }
}

