package example.basicexamples;

/*
 * This example is functionally the same as the GetLowestInt example.
 * However, this example uses an extra method to put the functionality
 * of getting the lowest integer into a dedicated method that takes the
 * original array of integers as a parameter and returns the lowest int.
 *
 * The class has three methods: main, start and getLowestInt
 *
 * Make sure you understand how code like this can be structured into
 * a method that receives a parameter/s and returns a value.
 *
 * Most of the exercises in this lab will require you to edit the contents of
 * individual methods and return the result; it is essential that you understand
 * how methods can take parameters in, run any code in the method body and then
 * return something back from the method.
 *
 * Look at this example carefully so you understand how the returned value can be
 * assigned to a variable and used elsewhere in the code.
 *
 * For example: int lowestInt = getLowestInt(integerArray);
 * In this excerpt from the code below, the getLowestInt method returns an integer
 * that is assigned to the lowestInt variable.
 *
 * */

public class GetLowestIntExtraMethod {

    private int getLowestInt(int[] integerArray){

        // Create a variable to store the lowest integer so far:
        int lowestInt = 1000000;

        // Create a for loop to loop through each integer in the integer array:
        for (int i = 0; i < integerArray.length; i++) {

            // Output console message for each iteration of the loop
            System.out.println("At index " + i + " in loop. Checking if " + integerArray[i] + " is lower than " + lowestInt + ".");

            // Check if the current integer is the lowest so far:
            if (integerArray[i] < lowestInt){

                // If it is the lowest so far, update the lowestInt variable:
                lowestInt = integerArray[i];
                // Output message when lowest int is modified:
                System.out.println("lowestInt variable updated to: " + lowestInt);

            }
        }

        // Use return to return the lowest integer from the method call:
        return lowestInt;

    }

    private void start(){
        // Create an array of integers:
        int[] integerArray = new int[]{4, 3, 6, 2, 7};
        // Call the getLowestInt method passing in the integerArray as a parameter
        int lowestInt = getLowestInt(integerArray);
        System.out.println("The lowest integer is: " + lowestInt);

    }

    public static void main(String[] args) {
        GetLowestIntExtraMethod getLowestIntExtraMethod = new GetLowestIntExtraMethod();
        getLowestIntExtraMethod.start();
    }

}
