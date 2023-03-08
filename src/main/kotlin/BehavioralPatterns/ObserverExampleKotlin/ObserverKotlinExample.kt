package BehavioralPatterns.ObserverExampleKotlin

interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

interface Observer {
    fun update(data: Any)
}

class ConcreteSubject : Subject {
    private val observers = mutableListOf<Observer>()
    private var data: Any? = null

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(data!!)
        }
    }

    fun setData(data: Any) {
        this.data = data
        notifyObservers()
    }
}

class ConcreteObserver(private val name: String) : Observer {
    override fun update(data: Any) {
        println("$name received update with data: $data")
    }
}

fun main() {
    val subject = ConcreteSubject()
    val observer1 = ConcreteObserver("Observer 1")
    val observer2 = ConcreteObserver("Observer 2")
    subject.registerObserver(observer1)
    subject.registerObserver(observer2)
    subject.setData("Hello World")
    subject.removeObserver(observer1)
    subject.setData(42)
}
