package ictgradschool.industry.collections.challenges.ex07;

import java.util.ArrayList;
import java.util.List;

public class ExerciseSeven {

    /**
     * Main program flow.
     *
     * DO NOT EDIT THIS METHOD, other than to uncomment three lines of code when they'll no longer cause
     * compile errors.
     */
    private void start() {

        // Create a ShapeBox and add some single shapes to it
        ShapeBox box = new ShapeBox();
        box.addShape(new Circle(10));
        box.addShape(new Rectangle(10, 15));
        box.addShape(new RegularPolygon(6, 5));

        // Create some lists with even more shapes in them
        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(6));
        circles.add(new Circle(8));
        circles.add(new Circle(12));
        circles.add(new Circle(9));
        circles.add(new Circle(2));
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(8, 4));
        rectangles.add(new Rectangle(6, 13));
        rectangles.add(new Rectangle(12, 8));
        rectangles.add(new Rectangle(11, 1));
        List<RegularPolygon> polygons = new ArrayList<>();
        polygons.add(new RegularPolygon(8, 2));
        polygons.add(new RegularPolygon(10, 4));
        polygons.add(new RegularPolygon(16, 3));

        // TODO These next three lines cause compile errors. Uncomment them when you've changed ShapeBox to allow this.
        // box.addShapes(circles);
        // box.addShapes(rectangles);
        // box.addShapes(polygons);

        // Will print the ShapeBox's toString() method.
        System.out.println(box);

        // TODO Answer this question: What is the total area of all  15 shapes we've created here (to 2dp)?
        // Total area:
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        new ExerciseSeven().start();
    }
}
