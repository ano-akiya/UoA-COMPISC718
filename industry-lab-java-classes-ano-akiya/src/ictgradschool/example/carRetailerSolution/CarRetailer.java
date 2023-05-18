package ictgradschool.example.carRetailerSolution;

public class CarRetailer {

    public static void main(String[] args) {
        CarRetailer p = new CarRetailer();
        p.start();
    }

    public void start() {
        // Create a cars array to store the three Car objects
        Car[] cars = new Car[3];

        // Initialise three Car objects, Mazda6, Camry, and Civic
        cars[0] = new Car("Mazda", "Mazda6", 8.5, 220, 7.7, 23700);
        cars[1] = new Car("Toyota", "Camry", 8.3, 210, 6.9, 29500);
        cars[2] = new Car("Honda", "Civic", 10.2, 270, 6.2, 21500);

        // Use a for loop to process through the cars array. The information of each element will be processed.
        for (int i = 0; i < cars.length; i++) {

            System.out.println(cars[i]);  // Note: No need to call toString() method ourselves, automatically call inside sout().

            cars[i].speedUp();  // Instance method is to be called by "object_variable_id.method_id"

            System.out.println("The fuel consumption of " + cars[i].getModel() + " is " + cars[i].getFuelConsumption() + "L/100km."); // Getter method is used here.

            System.out.println();
        }

    }
}