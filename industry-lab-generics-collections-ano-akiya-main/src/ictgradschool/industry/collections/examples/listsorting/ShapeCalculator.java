package ictgradschool.industry.collections.examples.listsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShapeCalculator {
    public static void main(String[] args) {
        ShapeCalculator shapeCalculator = new ShapeCalculator();
        shapeCalculator.start();
    }

    private void start() {
        List<Shape> shapes = new ArrayList<>();
       shapes.add(new Circle(2.0));
        shapes.add(new Circle(3.0));
        shapes.add(new Rectangle(4.5, 3));
        shapes.add(new Rectangle(3.5, 6));
        shapes.add(new Rectangle(6, 2));
        shapes.add(new Rectangle(10, 8));


        System.out.println("Print the area of each shape based on insertion order");
        printArea(shapes);
        System.out.println();


        System.out.println("=================================");
        System.out.println("Print the area of each shape after sorting the list based on area in ascending order");
        /* Sort shapes list according to the natural ordering of shapes
         * (i.e. Shape class implements Comparable<T> interface
         * compareTo() method determines the natural ordering of the class
         */

/*
        Collections.sort(shapes);
        printArea(shapes);
        System.out.println();

*/


        System.out.println("=================================");
        System.out.println("Print the area of each shape using Comparator in descending order of the area");
        // We are writing an anonymous class to create the comparator
/*
        Comparator<Shape> shapeComparator = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.getArea() < o2.getArea()) {
                    return 1;
                } else if (o1.getArea() > o2.getArea()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };



        // We override the natural ordering by passing the comparator to sort the list
        Collections.sort(shapes, shapeComparator);
        printArea(shapes);
*/

    }

    private void printArea(List<Shape> shapes) {
        for (Shape s : shapes) {
            System.out.println("Area is " + s.getArea());
        }
    }

}
