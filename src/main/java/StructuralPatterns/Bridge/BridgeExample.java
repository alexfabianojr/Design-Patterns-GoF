package StructuralPatterns.Bridge;

interface Shape {
    void draw();
}

class Circle implements Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing circle at x: " + x + " y: " + y + " with radius: " + radius);
    }
}

class Square implements Shape {
    private int x, y, side;

    public Square(int x, int y, int side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public void draw() {
        System.out.println("Drawing square at x: " + x + " y: " + y + " with side: " + side);
    }
}
