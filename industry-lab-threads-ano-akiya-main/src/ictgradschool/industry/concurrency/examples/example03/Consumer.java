package ictgradschool.industry.concurrency.examples.example03;

import java.util.concurrent.BlockingQueue;

/**
 * Continually consumes IComputeTasks, executes them, and prints the results.
 */
public class Consumer implements Runnable {

    /** The queue of tasks to execute */
    private BlockingQueue<IComputeTask<?>> queue;

    public Consumer(BlockingQueue<IComputeTask<?>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            // Continually...
            while (true) {

                // Grab the next task to execute on this thread
                IComputeTask<?> task = queue.take();

                // Compute the result (possible long-running task)
                Object result = task.computeResult();

                // Do something with the result. In this case, just print it.
                // We will also print the name of the Thread, so we can tell which thread actually executed this.
                // This way we can see for ourselves that multiple threads are executing the tasks.
                System.out.println(Thread.currentThread().getName() + ": " + task + " = " + result);

            }
        } catch (InterruptedException e) {
            // If the thread is interrupted while waiting for a new task, an InterruptedException will be thrown.
            // Since this is the proper way to stop threads in Java, we must deal with the InterruptedException somehow.
            // In this case we just print out a message and terminate the run() method gracefully.
            System.err.println(Thread.currentThread().getName() + " was interrupted and is quitting gracefully.");
        }
    }
}
