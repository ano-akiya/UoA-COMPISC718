package ictgradschool.industry.collections.challenges.ex06;

/**
 * Created by Andrew Meads on 25/03/2017.
 */
public class OddNumbersPredicate implements IPredicate {

    /**
     * Tests if the given object is an odd integer.
     *
     * @param obj the object to test
     * @return true if the object is an odd number, false otherwise
     * @throws ClassCastException if the provided object is not an Integer.
     */
    @Override
    public boolean test(Object obj) {
        Integer i = (Integer) obj;
        return i % 2 == 1;
    }
}
