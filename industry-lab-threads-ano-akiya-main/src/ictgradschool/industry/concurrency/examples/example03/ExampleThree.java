package ictgradschool.industry.concurrency.examples.example03;

import ictgradschool.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * An example that demonstrates ArrayBlockingQueue.
 *
 * Allows users to enter some maths problems, which will be solved on background threads.
 */
public class ExampleThree {

    private void start() {

        // The queue where we'll dump our mathy requests.
        BlockingQueue<IComputeTask<?>> queue = new ArrayBlockingQueue<>(100);

        System.out.println("Creating consumers...");
        List<Thread> consumers = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Consumer c = new Consumer(queue);
            Thread t = new Thread(c,"Consumer #" + i); // Threads can be assigned an arbitrary name so we can keep track of them.
            t.start();
            consumers.add(t);
        }
        System.out.println("5 consumers OK and ready to go.");
        System.out.println();

        while (true) {

            System.out.println("Enter your command (case insensitive):");
            System.out.println("Fib <n> - calculate the nth fibonacci number (e.g. Fib 3)");
            System.out.println("PrimeFactors <n> - calculate the prime factors of n (e.g. PrimeFactors 4)");
            System.out.println("Quit - quits");
            System.out.print("> ");

            String input = Keyboard.readInput();
            Scanner s = new Scanner(input);
            String cmd = s.next();

            IComputeTask<?> task = null;

            if (cmd.equalsIgnoreCase("fib")) {
                task = new Fibonacci(s.nextInt());
            }
            else if (cmd.equalsIgnoreCase("primefactors")) {
                task = new PrimeFactors(s.nextLong());
            }
            else if (cmd.equalsIgnoreCase("quit")) {
                break;
            }

            if (task != null) {

                // Add the task to the queue for processing
                try {
                    queue.put(task);
                } catch (InterruptedException e) {
                    // The put method might throw an InterruptedException if the calling thread (in this case, the main() method)
                    // is interrupted. Since we know that won't happen in our program we don't really need to handle this properly.
                    e.printStackTrace();
                }

            } else {
                System.out.println("Enter a valid command!");
            }

            System.out.println();
        }

        // Once we're done adding commands, then we can quit the consumer threads.
        // It is always a good idea to close threads, or else they'll keep running in the background.
        for (Thread t : consumers) {
            t.interrupt();
            try {
                t.join();
                System.out.println(t.getName() + " finished successfully.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new ExampleThree().start();
    }
}
