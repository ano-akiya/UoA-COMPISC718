package ictgradschool.industry.collections.challenges.ex06;

/**
 * Classes implementing this interface are capable of testing an object to see if some condition is true.
 */
public interface IPredicate {

    /**
     * Tests the given object to see if some condition is true.
     *
     * @param obj the object to test
     * @return true if the condition is met, false otherwise.
     */
    public boolean test(Object obj);

}
