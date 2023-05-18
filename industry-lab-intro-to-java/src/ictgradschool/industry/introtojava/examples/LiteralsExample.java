package ictgradschool.industry.introtojava.examples;

/**
 * Run this code to observe the outputs in the console within your code editor
 *
 * Within IntelliJ, you should be able to see the output to the console within the 'Run' tab which
 * will often be around the bottom-left of your window.
 *
 * Check that you can see the contents of each 'System.out.println(...);' statement in the console
* */

public class LiteralsExample {

    public void start(){

        // Various different data types output as literals:
        System.out.println(-45); // negative integer
        System.out.println(0.034); // floating point number
        System.out.println(true); // boolean
        System.out.println('g'); // character
        System.out.println("This is a String"); // String

        // We can join other literals to Strings with the '+' operator
        System.out.println("The number is " + 50);

        // When the first literal is a String, we can join multiple literals together with the '+' operator
        System.out.println("You score is " + 30 + " out of " + 60 + " which is " + 50 + " percent.");

        // We can use the escape character to include certain characters in Strings:
        System.out.println("This is how we include \"quotes\" inside of Strings...");

    }

    public static void main(String[] args) {

        /* The following two lines are the convention used to run the start method on an instance of this class
        *  you will learn more about this in later lectures:
        * */

        LiteralsExample literalsExample = new LiteralsExample();
        literalsExample.start();

    }

}
