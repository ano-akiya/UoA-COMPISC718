package ictgradschool.industry.concurrency.examples.example01;

import ictgradschool.Keyboard;

/**
 * A simple example which shows how we can create a Thread that does stuff in the background.
 *
 * While the thread is running, we can still interact with the console, etc.
 */
public class ExampleOne {

    private void start() {

        // Create an ExampleOneRunnable and a Thread to run it
        ExampleOneRunnable runnable = new ExampleOneRunnable();
        Thread thread = new Thread(runnable);

        System.out.println("About to start thread...");

        // Start the thing running
        thread.start();

        System.out.println("Thread started successfully.");
        System.out.println("You'll notice that we're still able to execute code, like this println statement,");
        System.out.println("even though the thread is running and doing stuff in the background.");

        System.out.println();
        System.out.println("Press ENTER to stop the thread...");
        Keyboard.readInput();

        System.out.println("Interrupting thread and waiting for it to finish...");

        // Interrupting a thread requests that it terminates gracefully
        thread.interrupt();


        try {
            // Joining a thread waits for it to finish.
            thread.join();

        } catch (InterruptedException e) {

            // Joining a thread might throw an InterruptedException if the calling thread is interrupted (in this case,
            // that would be the thread that's running the main() method).
            // In practice we know that will never happen so we don't need to really handle it properly here.
            e.printStackTrace();
        }

        System.out.println("... Done.");

        System.out.println("The thread got to #" + runnable.getCounter());


    }

    public static void main(String[] args) {
        new ExampleOne().start();
    }
}
