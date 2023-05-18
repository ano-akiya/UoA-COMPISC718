package ictgradschool.industry.introtojava.casting;

/**
 * This is an exercise to practise casting
 *
 * Casting is when we convert one data type to another.
 *
 * This exercise will get you to convert a floating
 * point number (e.g., a number of the data type double)
 * an integer which will remove any numbers after the
 * decimal point.
 *
 * Note that this is different to rounding as it will
 * always remove the numbers after the decimal point
 * and never round up.
 *
 * */

public class CastingExercise {

    public void start(){

        // Create a variable named 'testDouble' of the data type 'double'
        double testDouble = 42.8242;

        // Output a System.out... message to display the value stored in 'testDouble'
        System.out.println("The number stored in 'testDouble' of the datatype double is: " + testDouble);

        // TODO: Cast the variable 'testDouble' to an integer and assign the result to the variable 'testInt' (hint: it should look something like this -->  (int) variableName )
        int testInt = 0;
        testInt = (int)testDouble;

        // Output a System.out... message to display the result; when you complete the casting correctly on the line above, you should see the correct result in the output:
        System.out.println("The variable 'testDouble' containing the value " + testDouble + " when cast to an integer is " + testInt + ".");


        // TODO: try uncommenting these lines and use casting to cast the floating point number to an integer

        int intVariableOne = (int) 12.87654;

        System.out.println("The value of 'intVariableOne' is: " + intVariableOne);

    }

    public static void main(String[] args) {
        CastingExercise castingExercise = new CastingExercise();
        castingExercise.start();
    }

}
