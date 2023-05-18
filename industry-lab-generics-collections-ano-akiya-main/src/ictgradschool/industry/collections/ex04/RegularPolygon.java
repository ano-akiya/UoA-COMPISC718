package ictgradschool.industry.collections.ex04;

/**
 * Represents a regular polygon - an n-sided polygon with all sides of an equal length, and all interior
 * angles equal.
 */
public class RegularPolygon extends Shape {

    private int numSides;
    private int sideLength;

    public RegularPolygon(int numSides, int sideLength) {
        this.numSides = numSides;
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return getApothem() * getPerimeter() / 2;
    }

    @Override
    public double getPerimeter() {
        return numSides * sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    @Override
    public int getNumSides() {
        return numSides;
    }

    @Override
    protected String getDataString() {
        return "numSides=" + numSides + ", sideLength=" + sideLength;
    }

    /**
     * Gets the polygon's apothem. The apothem is the shortest distance from the center to one of the sides.
     *
     * <p>See: http://www.wikihow.com/Find-the-Area-of-Regular-Polygons</p>
     */
    public double getApothem() {

        double rads = Math.toRadians(180.0 / numSides);
        return sideLength / (2.0 * Math.tan(rads));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RegularPolygon) {
            RegularPolygon other = (RegularPolygon) obj;
            return  this.numSides == other.numSides && this.sideLength == other.sideLength;
        }
        return false;
    }
}
