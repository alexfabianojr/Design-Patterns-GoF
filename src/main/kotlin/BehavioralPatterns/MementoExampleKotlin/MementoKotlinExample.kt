package BehavioralPatterns.MementoExampleKotlin

// Originator
class Editor(var content: String = "") {
    fun type(words: String) {
        content += words
    }

    fun save(): Memento {
        return Memento(content)
    }

    fun restore(memento: Memento) {
        content = memento.state
    }

    fun getContent1(): String {
        return content
    }
}

// Memento
class Memento(val state: String)

// Caretaker
class History {
    private val mementos = mutableListOf<Memento>()

    fun add(memento: Memento) {
        mementos.add(memento)
    }

    fun get(index: Int): Memento {
        return mementos[index]
    }
}

// Main
fun main() {
    val editor = Editor()
    val history = History()

    editor.type("Hello")
    editor.type(" World")
    history.add(editor.save())

    editor.type(", how are you?")
    history.add(editor.save())

    editor.type(" I'm fine.")
    println(editor.getContent1())

    editor.restore(history.get(1))
    println(editor.getContent1())

    editor.restore(history.get(0))
    println(editor.getContent1())
}
