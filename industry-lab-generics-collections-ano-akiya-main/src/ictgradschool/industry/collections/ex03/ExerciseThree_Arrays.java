package ictgradschool.industry.collections.ex03;

import java.util.Arrays;


public class ExerciseThree_Arrays {

    /**
     * Tests the union, intersection, and difference methods using some dummy data.
     */
    private void start() {

        String[] testArray1 = {"A", "B", "C"};
        String[] testArray2 = {"A", "D", "E"};

        // Should print [A, B, C, A, D, E]
        System.out.println("Union: " + Arrays.toString(union(testArray1, testArray2)));

        // Should print [A]
        System.out.println("Intersection: " + Arrays.toString(intersection(testArray1, testArray2)));

        // Should print [B, C]
        System.out.println("Difference: " + Arrays.toString(difference(testArray1, testArray2)));

    }

    /**
     * Returns an array that contains all elements in the first array plus all elements in the second array.
     * @param arr1 the first array
     * @param arr2 the second array
     */
    private String[] union(String[] arr1, String[] arr2) {

        String[] result = new String[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for(int i = 0; i < arr2.length; i++) {
            result[i + arr1.length] = arr2[i];
        }
        return result;
    }

    /**
     * Returns an array that contains all elements in the first array which are also in the second array.
     * @param arr1 the first array
     * @param arr2 the second array
     */
    private String[] intersection(String[] arr1, String[] arr2) {

        int numCommonValues = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j=0; j < arr2.length; j++) {

                if (arr1[i].equals(arr2[j])) {
                    numCommonValues++;
                    break;
                }

            }
        }

        String[] result = new String[numCommonValues];
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j=0; j < arr2.length; j++) {

                if (arr1[i].equals(arr2[j])) {
                    result[counter++] = arr1[i];
                    break;
                }

            }
        }

        return result;

    }

    /**
     * Returns an array that contains all elements in the first array which are NOT in the second array.
     * @param arr1 the first array
     * @param arr2 the second array
     */
    private String[] difference(String[] arr1, String[] arr2) {

        int numValues = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean contains = false;
            for (int j=0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    contains =true;
                    break;
                }

            }
            if (!contains) {
                numValues++;
            }
        }

        String[] result = new String[numValues];
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean contains = false;
            for (int j=0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) {
                    contains =true;
                    break;
                }

            }
            if (!contains) {
                result[counter++] = arr1[i];
            }
        }

        return result;

    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        new ExerciseThree_Arrays().start();
    }

}
