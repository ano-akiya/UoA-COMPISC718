package ictgradschool.industry.arrays;

/**
 * CHALLENGING ARRAY TASKS: these array tasks are more challenging logical problems
 *
 * In some of these tasks it is because the size of the array to be returned is undetermined at the start of the
 * method; think carefully about how you can solve this; it may take a few extra steps and the creation of some
 * extra variables or loops
 *
 * These tasks are more challenging than normal use cases for arrays and the general sorts of tasks you will be
 * doing in labs and test; don't stress if you get stuck but they are included to give you a taste of solving
 * more logically complex problems so it is suggested you attempt them and think carefully about the logical
 * steps to solve them
 *
 * */

public class AdvancedArrayProgramming {

    public void start(){

        /*
        * The code below has method calls to all of the methods you will complete in this task.
        * There are also System.out... statements so you can see what is returned from each method call.
        *
        * You can use the tests for these methods from the test class within the 'test' directory,
        * or you can run the class and check the output in the System.out... statements below.
        */

        String pairSumTo = getPairSumTo(new int[]{1, 2, 3, 4, 5, 6}, 10);
        System.out.println("Pair sum to: " + pairSumTo);

        String[] noDuplicates = removeDuplicates(new String[]{"abc", "123"});
        System.out.println("No duplicates array:");
        for (int i = 0; i < noDuplicates.length; i++) {
            System.out.println(noDuplicates[i]);
        }

        int[] commonNumbers = findCommonNumbers(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 2, 4});
        System.out.println("Common numbers: ");
        for (int i = 0; i < commonNumbers.length; i++) {
            System.out.println(commonNumbers[i]);
        }

        String binaryString = convertIntToBinary(4);
        System.out.println("Binary String: " + binaryString);


    }

    public static void main(String[] args) {
        AdvancedArrayProgramming advancedArrayProgramming = new AdvancedArrayProgramming();
        advancedArrayProgramming.start();
    }



    /**
     * A. Complete the method getPairSumTo() that takes two parameters, an
     * integer array and an integer number. The method will then return a
     * String containing two numbers where the sum of the two numbers is equal
     * to the given integer number (from the parameter). The number will be
     * in ascending order and separated by ", ". For example,
     * getPairSumTo(new int[] {1, 2, 3, 4, 5, 6}, 10)
     * will return the following:
     * "4, 6"
     * If the method cannot find the right numbers for the sum, the method
     * will print "0" instead. If the integer array has less than 2 elements,
     * the method will also print "0".
     *
     * @param addends   An array of integers that may be used as addends for
     *                  the target sum.
     * @param targetSum The sum we are attempting to generate from available
     *                  addends.
     * @return A String containing the two integers that add the to target
     * sum or "0".
     */
    public String getPairSumTo(int[] addends, int targetSum) {
        // TODO write statements here
        return "";
    }
    /** getPairSumTo(int[], int) => String **/


    /**
     * B. Write a method removeDuplicates() that removes duplicate
     * elements from a given string array and returns the array of unique
     * elements. Order must not be changed. For example:
     * removeDuplicates(new String[] {"abc", "123", "abc"})
     * <p>
     * will return the following (as a String array):
     * {"abc", "123"}
     *
     * @param stringValues An array of String values
     * @return A String array containing only the unique values of the input
     * array
     */
    public String[] removeDuplicates(String[] stringValues) {
        // TODO write statements here
        return null;
    }
    /** removeDuplicates(String[]) => String[] **/


    /**
     * C. Write a method findCommonNumbers() that returns an array of
     * the common elements between two integer arrays. The common numbers
     * must remain in the order that they are encountered in the first
     * array. For example:
     * findCommonNumbers(new int[] {1, 2, 3, 4, 5},
     * new int[] {6, 7, 8, 9, 2, 4})
     * <p>
     * will return the common elements (as an integer array):
     * {2, 4}
     * <p>
     * If there are no common elements, the method will return an empty
     * array, such as:
     * {}
     * <p>
     * Do *not* use Arrays or Collection library methods.
     *
     * @param arrayOne The first array of integers
     * @param arrayTwo The second array of integers
     * @return An array of integers that are common to both given arrays
     */
    public int[] findCommonNumbers(int[] arrayOne, int[] arrayTwo) {
        // TODO write statements here
        return null;
    }
    /** findCommonNumbers(int[], int[]) => int[] **/


    /**
     * D. Write a method convertIntToBinary that converts a given positive
     * integer to the binary format. The method will return the binary as a
     * String. For example:
     * convertIntToBinary(4)
     * <p>
     * will return the following:
     * "100"
     *
     * @param toConvert An integer to convert to binary
     * @return the binary representation of the given number as a String
     */
    public String convertIntToBinary(int toConvert) {
        // TODO write statements here

        return null;
    }
    /** convertIntToBinary(int) => String **/
}
