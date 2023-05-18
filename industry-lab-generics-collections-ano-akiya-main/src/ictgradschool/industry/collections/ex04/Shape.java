package ictgradschool.industry.collections.ex04;

/**
 * Represents a Shape.
 *
 * TODO Make this class implement the Comparable&lt;Shape&gt; interface
 */
public abstract class Shape implements Comparable<Shape>{

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract int getNumSides();

    /**
     * Gets the name of this shape. By default, just returns the class name.
     *
     * <p>Notes:</p>
     * <ul>
     *     <li>{@link #getClass()} returns a {@link Class} object representing an object's class.</li>
     *     <li>{@link Class#getSimpleName()} returns the name of the class, as written in the *.java file.</li>
     *     <li>{@link Class#getName()} reutnrs the name of the class, including the package name.</li>
     * </ul>
     * @return the shape's name.
     */
    public String getName() {
        return getClass().getSimpleName();
    }

    protected abstract String getDataString();

    @Override
    public String toString() {
        return getName() + " [" + getDataString() + "]";
    }

    public boolean hasSmallerAreaThan(Shape other) {

        return this.getArea() < other.getArea();

    }

    // TODO Implement the compareTo method, which should order shapes by their perimeter, in ascending order.
    public int compareTo(Shape other)
    {
        double pmOther = other.getPerimeter();
        double pmThis = this.getPerimeter();
        if (pmThis - pmOther > 0)
        {
            return 1;
        }
        else if (pmThis - pmOther < 0)
        {
            return -1;
        }
        else if (pmThis - pmOther == 0)
        {
            return 0;
        }
        return 0;
    }

}
