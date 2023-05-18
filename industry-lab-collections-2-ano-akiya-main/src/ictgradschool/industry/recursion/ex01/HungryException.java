package ictgradschool.industry.recursion.ex01;

/**
 * An Exception to be thrown by a Customer if they're still hungry after lunch.
 */
public class HungryException extends Exception {

    public HungryException(String message) {
        super(message);
    }
}
