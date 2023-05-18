package ictgradschool.industry.collections.examples.listsorting;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius){
        this.radius = radius;

    }

    @Override
    public double getArea() {
        return Math.round(Math.PI * radius * radius);
    }
}
