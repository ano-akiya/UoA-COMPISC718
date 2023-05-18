package ictgradschool.industry.arrays;

/**
 * Complete the incomplete methods within the ProgrammingExercises class.
 *
 * You can run the tests to check your answers or you can run the class to use
 * the pre-written method calls and System.out... outputs to run all the methods
 * and view the output in the console.
 *
 */

public class BasicArrayProgramming {

    /*
    * The start method here contains some method calls and variable
    * that will allow you to test your code as you complete the exercises.
    *
    * Scroll further down to see the methods that need completion.
    *
    * */
    private void start(){

        int[] intArrayToTest = new int[] {2, 3, 4, 7};
        int highestInt = getHighestInt(intArrayToTest);
        System.out.println("The integer returned is: " + highestInt);

        double[] doubleArrayToTest = new double[]{10.0, 12.0, 15.0, 23.0};
        double average = getAverage(doubleArrayToTest);
        System.out.println("The average is: " + average);

        double[] doubleArrayToTestTwo = new double[]{3.0, 8.0, 10.5};
        double[] cumulativeValues = getCumulativeValues(doubleArrayToTestTwo);
        System.out.println("The new cumulative values are: ");

        for (int i = 0; i < cumulativeValues.length; i++) {
            System.out.println(cumulativeValues[i]);
        }


    }

    public static void main(String[] args) {

        /*
        * You may run this class to test the methods you write below but there are also tests for
        * the methods below within the TestProgrammingExercises within the 'test' directory
        * */

        BasicArrayProgramming basicArrayProgramming = new BasicArrayProgramming();
        basicArrayProgramming.start();

    }

    /*
    * BASIC ARRAY TASKS: these array tasks are much easier than the tasks
    * in 'AdvancedArrayProgramming'
    * */

    /** A. Complete the method getHighestInt() that takes an integer array as
     * a parameter and returns the highest integer in the array
     *
     * @param intArray an array of integers
     * @return an integer which is the highest integer in intArray
     * */
    public int getHighestInt(int[] intArray)
    {
        // TODO write your code to loop through 'intArray' and return the highest integer
        int highest = 0;
        int temp = 0;
        int length = intArray.length;
        for (int i = 0; i < length; i ++)
        {
            for (int j = i + 1; j < length; j ++)
            {
                if (intArray[i] < intArray[j])
                {
                    temp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
        highest = intArray[0];

        return highest;
    }

    /** B. Complete the method getAverage() that takes a double array as a parameter
     * and returns a double that is the average of all doubles
     *
     * @param doubleArray an array of doubles
     * @return a double that is the average of all doubles in doubleArray
     * */
    public double getAverage(double[] doubleArray) {

        // TODO write your code here to loop through 'floatArray' and return the average of all floats in floatArray
        double average = 0.0;
        double total = 0.0;
        double length = doubleArray.length;
        for (int i = 0; i < length; i++)
        {
            total = total + doubleArray[i];
        }
        average = total / length;
        return average;
    }

    /** C. Make the method below convert an array of daily measurements to an array
     *  containing the cumulative total from each day. The cumulative total for each day should
     *  be the total of the current daily measurement combined with all previous measurements.
     *
     *  For example, if the original array of daily measurements was [3.0, 5.0, 2.5], the
     *  array of cumulative totals would be [3.0, 8.0, 10.5]
     *
     * @param dailyMeasurements an array of daily measurements
     * @return an array of doubles that contains the cumulative total for each day
     * */

    public double[] getCumulativeValues(double[] dailyMeasurements){

        // TODO write your code here to complete the contents of the method
        int length = dailyMeasurements.length;
        double[] result = new double[length];

        for (int i = 0; i < length; i ++)
        {
            if (i == 0)
            {
                result[i] = dailyMeasurements[i];
            }
            else if(i > 0)
            {
                for (int j = 0; j <= i; j ++)
                {
                    result[i] = result[i] + dailyMeasurements[j];
                }
            }
        }
        return result;
    }


}
