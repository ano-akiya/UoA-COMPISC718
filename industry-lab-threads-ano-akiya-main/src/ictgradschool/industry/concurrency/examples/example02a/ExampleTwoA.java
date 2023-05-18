package ictgradschool.industry.concurrency.examples.example02a;

import ictgradschool.NameGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * A demonstration of non-thread-safe behaviour (specifically, the lost update problem).
 *
 * This code may work fine, or, multiple customers might report that they could book the same theatre seat. There's
 * no way to tell before running the code, what will happen.
 */
public class ExampleTwoA {

    private void start() throws InterruptedException {
        NameGenerator nameGen = new NameGenerator();

        // A single non-thread-safe seat which every customer wants to book.
        final NonThreadSafeSeat seat = new NonThreadSafeSeat();

        // Create 100 threads representing customers trying to book the seat
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            final String customer = nameGen.getRandomName();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean success = seat.book(customer);
                    if (success) {
                        System.out.println(customer + " thinks they booked the seat!");
                    }
                }
            });
            threads.add(t);
        }

        // Run all the threads
        for (Thread t : threads) {
            t.start();
        }

        // Wait for them all to finish
        for (Thread t : threads) {
            t.join();
        }

        // Print out who actually got the seat
        System.out.println("Seat is actually booked by: " + seat.getCustomer());

    }

    public static void main(String[] args) throws InterruptedException {

        new ExampleTwoA().start();

    }
}
