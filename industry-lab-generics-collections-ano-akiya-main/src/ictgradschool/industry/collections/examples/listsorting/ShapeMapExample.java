package ictgradschool.industry.collections.examples.listsorting;

import java.util.Map;
import java.util.TreeMap;

public class ShapeMapExample {

    public static void main(String[] args) {
        ShapeMapExample app = new ShapeMapExample();
        app.start();
    }

    private void start() {

        Map<String, Shape> shapes = new TreeMap<>();

        shapes.put("Circle", new Circle(5.0));
        shapes.put("Rectangle", new Rectangle(4.0, 5.0));
        shapes.put("Hexagon", new Hexagon(5.0));

        Shape shape = shapes.get("Rectangle");
        System.out.println(shape.getClass().getName());
        System.out.println();

        System.out.println("=================================");
        System.out.println("Loop through the map using keySet");
        /*
        for(String key: shapes.keySet()){
            Shape value = shapes.get(key);
            System.out.println("Key: " + key + ", Value: " + value.toString());
        }
        System.out.println();
        */

        System.out.println("=================================");
        System.out.println("Loop through the map using Map.EntrySet");
        /*
        for(Map.Entry<String, Shape> entry: shapes.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue().toString());
        }
        */

    }
}
