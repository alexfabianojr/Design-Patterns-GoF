package BehavioralPatterns.MementoExample;

import java.util.*;

// Originador
class Editor {
    private String content;

    public Editor() {
        this.content = "";
    }

    public void type(String words) {
        this.content = this.content + " " + words;
    }

    public String getContent() {
        return content;
    }

    public Memento save() {
        return new Memento(this.content);
    }

    public void restore(Memento m) {
        this.content = m.getContent();
    }
}

// Memento
class Memento {
    private final String content;

    public Memento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Caretaker
class History {
    private List<Memento> mementos = new ArrayList<>();

    public void add(Memento m) {
        mementos.add(m);
    }

    public Memento get(int index) {
        return mementos.get(index);
    }
}

// Main
class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.type("Hello");
        editor.type(" World");
        history.add(editor.save());

        editor.type(", how are you?");
        history.add(editor.save());

        editor.type(" I'm fine.");
        System.out.println(editor.getContent());

        editor.restore(history.get(1));
        System.out.println(editor.getContent());

        editor.restore(history.get(0));
        System.out.println(editor.getContent());
    }
}
