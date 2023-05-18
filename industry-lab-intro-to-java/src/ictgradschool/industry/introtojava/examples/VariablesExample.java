package ictgradschool.industry.introtojava.examples;

public class VariablesExample {

    public void start(){

        // Declaring a variable called age of the data type integer and assigning the value 38 to it:
        int age = 38;
        // Outputting the variable to the console with System.out
        System.out.println("My age is " + age + ".");

        // Declaring a variable called heightInMetres of the data type double and assigning the value 1.73 to it
        double heightInMetres = 1.73;
        // Outputting the variable to the console with System.out
        System.out.println("My height is " + heightInMetres + " metres.");

        // Declaring a variable called isFamous of the data type boolean and assigning the value false to it
        boolean isFamous = false;
        // Outputting the variable to the console with System.out
        System.out.println("It is " + isFamous + " that I am famous.");


        char favouriteLetter = 't';
        // Outputting the variable to the console with System.out
        System.out.println("My favourite letter is " + favouriteLetter);

        // We can also change the value assigned to a variable
        age = 39;
        System.out.println("My age is now " + age + ".");

        // But we cannot change values that are assigned to a constant
        final double pi = 3.14159;
        System.out.println("pi is: " + pi);
        // Try removing the comment ( '//' ) at the start of the line below to observe what happens:
        // pi = 3.14;

        // Note: we can break the declaration and initialisation of variables into multiple lines:
        int age2;
        age2 = 38;
        System.out.println("My age is " + age2);

        double heightInMetres2;
        heightInMetres2 = 1.73;
        System.out.println("My height is " + heightInMetres2 + " metres.");

    }

    public static void main(String[] args) {
        VariablesExample variablesExample = new VariablesExample();
        variablesExample.start();
    }

}
