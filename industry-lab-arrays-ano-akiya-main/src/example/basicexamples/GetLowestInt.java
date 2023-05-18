package example.basicexamples;

/**
 * This is a basic example that uses an array, loop and some other
 * code to find the lowest value in an array.
 *
 * This example has several System.out... statements to help you trace
 * what is happening in the loop and how the code works.
 *
 * In this example, all of the code is within the start method.
 *
 * You should compare this example to the GetLowestIntExtraMethod example
 * to compare how the code can be moved into an extra method that is called
 * from the start method.
 *
 * Many of the later exercises in this lab will involve many extra methods that
 * may be called from the start method.
 * */

public class GetLowestInt {

    private void start(){

        // Create an array of integers:
        int[] integerArray = new int[]{4, 3, 6, 2, 7};

        // Create a variable to store the lowest integer so far:
        int lowestInt = 1000000;
        // This assumes that there will be no values over one million

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

        // Use System.out... to output the lowest integer:
        System.out.println("The lowest integer in the array is: " + lowestInt);

    }

    public static void main(String[] args) {
        GetLowestInt getLowestInt = new GetLowestInt();
        getLowestInt.start();
    }

}
