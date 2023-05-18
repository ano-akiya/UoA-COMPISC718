package ictgradschool.industry.collections.examples.listsorting;

public class Rectangle extends Shape implements Polygon {
    private double width, height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public int getNumSides() {
        return 4;
    }

    @Override
    public double getArea() {
        return width * height;
    }

  /*  public int compareTo(Shape other){
        Rectangle r = (Rectangle)other;
        return Double.valueOf(this.width).compareTo(r.width);
    }*/

    @Override
    public String toString() {
        return this.width + " cm";
    }
}
