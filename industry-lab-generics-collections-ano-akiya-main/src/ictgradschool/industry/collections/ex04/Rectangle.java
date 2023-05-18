package ictgradschool.industry.collections.ex04;

/**
 * Represents a Rectangle.
 */
public class Rectangle extends Shape {

    private int width;
    private int length;

    /**
     * Creates a new Rectangle with the given properties
     *
     * @param width the rectangle's width
     * @param length the rectangle's height
     */
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

    @Override
    protected String getDataString() {
        return "width=" + width + ", length=" + length;
    }


    /**
     * Returns a value indicating if this Rectangle is equal to the given object.
     * The object is equal if its also a Rectangle and it has the same width and length.
     *
     * @param obj the object to test
     * @return true if the object is equal to this one, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            return this.width == other.width && this.length == other.length;
        }
        return false;
    }
}
