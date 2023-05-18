package ictgradschool.industry.uml.example;

/**
 * Represents a Rectangle.
 */
public class Rectangle extends Shape {

    private int width;
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public int getNumSides() {
        return 4;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
