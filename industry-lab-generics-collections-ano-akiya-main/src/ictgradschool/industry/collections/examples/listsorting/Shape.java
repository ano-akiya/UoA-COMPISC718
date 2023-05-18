package ictgradschool.industry.collections.examples.listsorting;

public abstract class Shape implements Comparable<Shape> {
    public abstract double getArea();

    @Override
    public int compareTo(Shape other) {
        double difference = this.getArea() - other.getArea();
        if (difference > 0)
            return 1;
        else if (difference < 0)
            return -1;
         else
            return 0;

    }

    @Override
    public String toString() {
        return this.getArea() + " cm2";
    }

/*

    @Override
    public int compareTo(Shape other){
        return Double.valueOf(this.getArea()).compareTo(other.getArea());
    }
*/

}
