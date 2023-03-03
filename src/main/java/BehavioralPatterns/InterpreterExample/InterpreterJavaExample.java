package BehavioralPatterns.InterpreterExample;

interface Expression {
    int interpret();
}

class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int interpret() {
        return number;
    }
}

class Add implements Expression {

    private Expression left, right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class Subtract implements Expression {

    private Expression left, right;

    public Subtract(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class Main {
    public static void main(String[] args) {
        Expression expression = new Add(new Number(3), new Subtract(new Number(5), new Number(2)));

        System.out.println("--> " + expression.interpret());
    }
}

