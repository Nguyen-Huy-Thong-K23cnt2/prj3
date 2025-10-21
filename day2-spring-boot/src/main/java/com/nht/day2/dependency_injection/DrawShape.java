package com.nht.day2.dependency_injection;

public class DrawShape {
    private Shape shape;

    // Inject dependency qua constructor
    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    public void Draw() {
        shape.draw();
    }
}
