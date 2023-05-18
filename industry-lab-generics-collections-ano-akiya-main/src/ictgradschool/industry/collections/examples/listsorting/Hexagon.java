package ictgradschool.industry.collections.examples.listsorting;

public class Hexagon extends Shape implements Polygon  {
    private double sideLength;

    public Hexagon(double sideLength){
        this.sideLength = sideLength;
    }

    @Override
    public int getNumSides() {
        return 6;
    }

    @Override
    public double getArea() {
        return Math.round(3.0 / 2 * Math.sqrt(3) * Math.pow(sideLength,2));
    }
}
