package ictgradschool.industry.collections.challenges.ex06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class that creates some lists of stuff and then filters them based on whether items in those lists meet some
 * predicated conditions.
 */
public class ExerciseSix {

    /**
     * Overall program flow is in this method.
     */
    private void start() {

        // Create a list of Strings
        List<Object> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("hello");
        strings.add(Math.PI); // Umm.... this seems fishy...
        strings.add("HELLO");

        // Create a list of Integers
        List<Object> ints = new ArrayList<>();
        ints.add(3);
        ints.add(2);
        ints.add("Not actually a number"); // Someone doesn't know how to code...
        ints.add(4624);
        ints.add(397);

        // Filter the list of Strings, removing any which aren't entirely uppercase
        filterList(strings, new UpperCaseStringPredicate());

        // Filter the list of Integers, removing any which aren't odd numbers
        filterList(ints, new UpperCaseStringPredicate());

        // Print out the items left in the strings list - should just be "HELLO".
        System.out.println("Strings:");
        for(Object obj : strings) {
            String s = (String) obj;
            System.out.println(" - " + s);
        }
        System.out.println();

        // Print out the items left in the ints list - should be 3 and 397.
        System.out.println("Integers:");
        for(Object obj : ints) {
            Integer i = (Integer) obj;
            System.out.println(" - " + i);
        }

    }

    /**
     * This method iterates through the list and removes all items in the list which don't satisfy the given predicate.
     * @param list
     * @param predicate
     */
    private void filterList(List<Object> list, IPredicate predicate) {

        Iterator<Object> iter = list.iterator();
        while (iter.hasNext()) {
            Object obj = iter.next();
            if (!predicate.test(obj)) {
                iter.remove();
            }
        }
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        new ExerciseSix().start();
    }
}
