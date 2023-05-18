package ictgradschool.industry.collections.ex04;

/**
 * Represents a circle.
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public int getNumSides() {
        return 1;
    }

    @Override
    protected String getDataString() {
        return "radius=" + radius;
    }

    /**
     * Returns a value indicating if this Circle is equal to the given object.
     * The object is equal if its also a Circle and it has the same radius (with a small tolerance to account for
     * rounding errors).
     *
     * @param obj the object to test
     * @return true if the object is equal to this one, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle other = (Circle) obj;
            return Math.abs(other.radius - this.radius) < 1e-15;
        }
        return false;
    }
}
