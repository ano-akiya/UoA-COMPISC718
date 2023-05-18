package ictgradschool.industry.recursion.ex01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Runs the pancake simulation
 */
public class PancakeApp {

    private void start() {

        // Create a queue of customers
        Deque<Customer> customers = createCustomerQueue();

        // Create the pancake shop
        PancakeShop shop = new PancakeShop("PancakeTopia", customers);

        // Simulate a day's business.
        shop.serveLunch();
    }

    /**
     * Creates a queue consisting of a random number of customers.
     * @return
     */
    private Deque<Customer> createCustomerQueue() {

        // An object which will allow us to give our customers names.
        NameGenerator nameGen = new NameGenerator();

        // Each day there'll be between 100 - 200 customers
        int numCustomers = Util.randomValueBetwen(100, 200);

        // TODO Initialize the queue variable appropriately
        Deque<Customer> queue = new LinkedList<>();

        for (int i = 1; i <= numCustomers; i++) {

            // Each customer can eat between 1 and 10 pancakes per session.
            int bellySize = Util.randomValueBetwen(1, 10);
            Customer customer = new Customer(bellySize, nameGen.getRandomName() + " [" + i + "]");

            // TODO Add customer to the queue.
            // HINT: Remember, queues are First-In-First-Out.
            queue.addLast(customer);
        }
        return queue;
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        new PancakeApp().start();
    }

}
