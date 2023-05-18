package ictgradschool.industry.uml.example;

public class ShapeCollection {

    public Shape[] shapes;

    public ShapeCollection(int size) {
        this.shapes = new Shape[size];
    }

    public Shape[] getShapes() {
        return shapes;
    }
}
