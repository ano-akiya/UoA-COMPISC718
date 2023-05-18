package ictgradschool.industry.concurrency.examples.example01;

/**
 * A simple Runnable that will continually increment the counter until its thread is interrupted.
 */
public class ExampleOneRunnable implements Runnable {

    private long counter = 0;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            counter++;
        }
    }

    public long getCounter() {
        return counter;
    }
}
