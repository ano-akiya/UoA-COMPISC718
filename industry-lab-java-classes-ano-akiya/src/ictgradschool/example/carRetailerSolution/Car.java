package ictgradschool.example.carRetailerSolution;

public class Car {
    /**
     * Field:
     * instance variables that store the properties of the car
     * that are important to this class
     */
    private String brand, model;
    private double accelerateTime, fuelConsumption;
    private int topSpeed, price;

    /**
     * Constructor:
     * to create a new object, can take no or many arguments
     * The functionality of constructor is usually to initialise the instance variables
     */
    public Car(String brand, String model, double accelerateTime, int topSpeed, double fuelConsumption, int price) {
        this.brand = brand;
        this.model = model;
        this.accelerateTime = accelerateTime;
        this.topSpeed = topSpeed;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
    }

    /**
     * The following methods are instance methods:
     * to define the behaviours of the object
     * Each method should perform one task only
     */

    /**
     * This speedUP method will print out the required time (in secs) for the car to reach 100km/h
     * and it will also print out the maximum speed of the car.
     */
    public void speedUp() {
        System.out.println(model + " can reach 100km/h in " + accelerateTime + "secs, and the max speed is " + topSpeed + "km/h.");
    }


    /**
     * This getModel method will return the car model.
     * @return model, a String value
     */
    public String getModel() {
        return model;
    }


    /**
     * This getFuelConsumption method will return the fuel consumption of the car.
     * @return fuelConsumption, a double value
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }


    /**
     * This toString method will return some information about the car in a String.
     * The information being return is the brand, model and price of the car.
     * @return A String representation of the car
     */
    public String toString() {
        return brand + " " + model + " is currently $ " + price;
    }

}
