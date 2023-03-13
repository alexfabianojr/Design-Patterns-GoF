package BehavioralPatterns.VisitorExample;

interface Visitor {
    void visit(ElementA elementA);
    void visit(ElementB elementB);
}

interface Element {
    void accept(Visitor visitor);
}

class ElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        System.out.println("ElementA operationA");
    }
}

class ElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() {
        System.out.println("ElementB operationB");
    }
}

class ConcreteVisitor implements Visitor {
    public void visit(ElementA elementA) {
        elementA.operationA();
    }

    public void visit(ElementB elementB) {
        elementB.operationB();
    }
}

class VisitorDemo {
    public static void main(String[] args) {
        Element[] elements = { new ElementA(), new ElementB() };

        Visitor visitor = new ConcreteVisitor();

        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
