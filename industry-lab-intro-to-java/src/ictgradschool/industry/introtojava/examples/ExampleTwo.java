package ictgradschool.industry.introtojava.examples;

/**
 * Programming for Industry - Intro to Java
 *
 * This example shows you how the code will execute when multiple
 * methods are present.
 *
 * The program begins execution within the 'main' method as it does
 * in the other examples. Observe the code and read the contents of
 * the System.out... statements to see where the methods are called.
 *
 * It is common for larger programs to be broken into many methods
 * so take time to observe how methods can be called and how that
 * affects the order in which code is run.
 *
 * For this course, many exercises will use methods for very clearly
 * defined things like converting one type of unit to another or getting
 * the highest value from a collection of values.
 *
 * When a method is called, the program will execute all code within
 * the method.
 * */

public class ExampleTwo {

    public void exampleMethodTwo(){
        System.out.println("7) Now we are in exampleMethodTwo");
    }

    public void exampleMethodOne(){
        System.out.println("5) Now we are in exampleMethodOne");
        System.out.println("6) We will now call exampleMethodTwo()");
        exampleMethodTwo();
        System.out.println("8) We are now back in exampleMethodOne");
    }

    public void start(){
        System.out.println("3) Now we are in the start method");
        System.out.println("4) Now we will call exampleMethodOne()");
        exampleMethodOne();
        System.out.println("9) Now we are back in the start method");
    }

    public static void main(String[] args) {

        System.out.println("1) First we create a new instance of the ExampleTwo class");
        ExampleTwo exampleTwo = new ExampleTwo();
        System.out.println("2) Now we call start()");
        exampleTwo.start();
        System.out.println("10) Now we are back in the main method");

    }

}
