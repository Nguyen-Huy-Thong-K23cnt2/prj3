package com.nht.day2.dependency_injection;

public class DependencyInjectionApp {
    public static void main(String[] args) {
        DrawShape drawShape = new DrawShape(new CircleShape());
        drawShape.Draw();

        drawShape = new DrawShape(new RectangleShape());
        drawShape.Draw();
    }
}
