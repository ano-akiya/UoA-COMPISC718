package example.basicexamples;


/**
 * Make sure to look at the GetLowestInt and GetLowestIntExtraMethod examples first as these
 * examples are more simple and use an array with a single for loop.
 *
 * This is a slightly more complex example that filters an array of only even integers
 * from an array of even and odd integers.
 *
 * This example is moderately complex because you need to count how many even integers there
 * are within the original array before you can create the new array for just the even integers.
 *
 * Because Java arrays are not flexible in size, it makes it slightly more complex to complete
 * this task because we cannot create the new array for the even integers until we know the length
 * it should be.
 *
 * The solution below uses two for loops:
 * - One loop to count the number of even integers so an array of that length can be created
 * - Another loop to go back over each integer and add the even integers to the new filtered array.
 *
 * Look at the code below, run it and read the comments to understand how it works.
 *
 * Some of the advanced programming exercises in today's lab have similar challenges to this example.
 *
 * */

public class FilterEvenIntegers {

    private int[] filterEven(int[] unfilteredArray){

        // Create a variable to count the number of even integers:
        int countEven = 0;
        // Loop through the array of unfiltered integers
        for (int i = 0; i < unfilteredArray.length; i++) {
            // Check if each integer in the array is even
            if (unfilteredArray[i]%2 == 0) {
                // If an integer is even, increment the countEven variable
                countEven++;
            }
        }

        // Create a new array that is the right length to store all even values
        int[] filteredArray = new int[countEven];
        // Create a variable to track the next empty index in the new array
        int nextEmptyIndex = 0;

        // Loop through all values in the original array again:
        for (int i = 0; i < unfilteredArray.length; i++) {
            // Check if the value at the current index is even:
            if (unfilteredArray[i]%2 == 0) {
                // If the value is even, store it in the next empty index of the filtered array
                filteredArray[nextEmptyIndex] = unfilteredArray[i];
                // Increment the next empty index so that we can store the next even number in the next empty index
                nextEmptyIndex++;
            }
        }

        return filteredArray;
    }
    private void start(){
        // Create an array of even and odd integers to test the method with:
        int[] unfilteredIntegers = new int[]{3, 4, 7, 8, 2, 5, 7, 14, 10};
        // Call the method and pass in the array and assign the returned array to a new array:
        int[] filteredEvenIntegers = filterEven(unfilteredIntegers);

        System.out.println("Array of filtered even integers: ");
        // Loop through the new array and output each item to test that it worked:
        for (int i = 0; i < filteredEvenIntegers.length; i++) {
            System.out.println(filteredEvenIntegers[i]);
        }
    }

    public static void main(String[] args) {
        FilterEvenIntegers filterEvenIntegers = new FilterEvenIntegers();
        filterEvenIntegers.start();
    }

}
