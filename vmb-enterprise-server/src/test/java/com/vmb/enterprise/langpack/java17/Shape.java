package com.vmb.enterprise.langpack.java17;

public sealed interface Shape  permits Shape.Circle, Shape.Rectangle, Shape.Square {

    public final class Circle implements Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double radius() {
        return radius;
    }
    }

    // Rectangle.java
    public final class Rectangle implements Shape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double width() {
            return width;
        }

        public double height() {
            return height;
        }
    }

    // Square.java
    public final class Square implements Shape {
        private final double side;

        public Square(double side) {
            this.side = side;
        }

        public double side() {
            return side;
        }
    }
}
