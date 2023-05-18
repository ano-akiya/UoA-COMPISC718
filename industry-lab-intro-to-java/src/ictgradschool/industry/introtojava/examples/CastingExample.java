package ictgradschool.industry.introtojava.examples;

public class CastingExample {

    public void start(){
        // An example double to cast to an integer
        double exampleDouble = 135.735;

        // We can cast a double to an integer like this:
        int exampleInteger = (int) exampleDouble;
        System.out.println(exampleDouble + " cast to an integer is " + exampleInteger + ".");

        int exampleIntegerTwo = 123;
        // We don't need to cast when going from an int to a double or from any 'smaller type' to a 'larger type'
        double exampleDoubleTwo = exampleIntegerTwo;


        // An example integer to cast to a char
        int intToChar = 87;
        // An integer can be cast to a char like this:
        char exampleChar = (char) intToChar;
        System.out.println("The integer '" + intToChar + "' can be cast to the character " + exampleChar + ".");

        // An example char to demonstrate that we don't need to cast when going from char to int
        char exampleCharTwo = 'W';
        int exampleIntTwo = exampleCharTwo;

    }

    public static void main(String[] args) {
        CastingExample castingExample = new CastingExample();
        castingExample.start();
    }

}
