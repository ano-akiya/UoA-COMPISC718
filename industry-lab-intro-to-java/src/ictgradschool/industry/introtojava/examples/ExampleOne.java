package ictgradschool.industry.introtojava.examples;

/**
 * Programming for Industry - Lab 01
 *
 * Run this example to observe the order of the output statements
 * and how to view them in IntelliJ.
 *
 * This example is repeated from the introductory lab but it is really important
 * that you revise where you can and cannot write code within Java classes and
 * that you understand the order in which code is executed.
 *
 * Read the comments in the code for important notes about the basics of Java classes.
 * */

// Do NOT put any code here as it is outside of the closing curly brace for the class

public class ExampleOne {

    /* Notice how the code that runs is inside the curly braces
       of the 'start(...){ code in here... }' and 'main(...){...}' methods

       Do NOT write normal lines of code outside of methods' curly braces
    * */

    // This is a 'method' named start; the code inside the curly braces will run when the method is 'called'
    public void start() {
        System.out.println("3) First output from inside the 'start' method");
        System.out.println("4) Any remaining code in 'main' will run after this code in 'start'");
        System.out.println("5) There are no more lines in 'start' so it will go back to main");
    }
    // Do NOT put code here as it is outside of the methods' curly braces

    // This is a 'method' named main; the code inside the curly braces will run when the program is run
    public static void main(String[] args) {

        // This 'System.out...' statement is the first statement that will run
        System.out.println("1) First output from inside of the 'main' method");

        /* ExampleOne exampleOne = new ExampleOne(); creates an instance
           of the 'ExampleOne' class with the identifier name 'exampleOne':
        */
        ExampleOne exampleOne = new ExampleOne();
        // You will learn more about classes, objects and instances in later lectures

        System.out.println("2) Second output from inside of the 'main' method");

        // When the 'start' method is called, the code inside the 'start' method will run
        exampleOne.start();
        // Pay attention to the order the code runs in
        // The 'System.out...' statement below will only run after all of the code in the start method
        System.out.println("6) Any code that appears after a method call will run after all the code in that method");

    }

    // Do NOT put any code here as it is outside of the closing curly brace for the method

}

// Do NOT put any code here as it is outside of the closing curly brace for the class