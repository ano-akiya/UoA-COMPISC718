package ictgradschool.industry.concurrency.examples.example02a;

/**
 * A non-thread-safe seat
 */
public class NonThreadSafeSeat {

    private String customer;
    private boolean isBooked;

    public boolean book(String customer) {

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

    public String getCustomer() {
        return customer;
    }

    public boolean isBooked() {
        return isBooked;
    }
}
