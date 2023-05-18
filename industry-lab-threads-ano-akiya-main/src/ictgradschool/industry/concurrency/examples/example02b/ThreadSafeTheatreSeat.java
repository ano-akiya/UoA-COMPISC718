package ictgradschool.industry.concurrency.examples.example02b;

/**
 * A non-thread-safe seat
 */
public class ThreadSafeTheatreSeat {

    private String customer;
    private boolean isBooked;

    /**
     * The only thing we've changed from Example2a is that we've made the methods synchronized. This means that
     * only one thread is allowed in here at once. Now it's impossible for multiple customers to try and book this seat
     * at the same time.
     */
    public synchronized boolean book(String customer) {

        boolean success = false;
        if (isBooked == false) {

            // Simulate some small delay, e.g. network traffic etc.
            Thread.yield();

            isBooked = true;
            this.customer = customer;
            success = true;
        }

        return success;
    }

    public synchronized String getCustomer() {
        return customer;
    }

    public synchronized boolean isBooked() {
        return isBooked;
    }
}
