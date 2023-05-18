package ictgradschool.industry.recursion.ex02;

/**
 * Created by anhyd on 27/03/2017.
 */
public class Recursion {

    /**
     * Returns the sum of all positive integers between 1 and num (inclusive).
     */
    public int getSum(int num) {

        // TODO Implement a recursive solution to this method.
        if (num > 1)
        {
            return num + getSum(num - 1);
        }
        else {
            return num;
        }
    }


    /**
     * Returns the smallest value in the given array, between the given first (inclusive) and second (exclusive) indices
     *
     * @param nums the array
     * @param firstIndex the inclusive lower index
     * @param secondIndex the exclusive upper index
     */
    public int getSmallest(int[] nums, int firstIndex, int secondIndex) {

        // TODO Implement a recursive solution to this method.
        if (firstIndex == secondIndex - 1)
        {
            return nums[firstIndex];
        }
        else
        {
            int min = getSmallest(nums, firstIndex + 1, secondIndex);
            return Math.min(nums[firstIndex], min);
        }
    }

    /**
     * Prints all ints from n down to 1.
     */
    public void printNums1(int n) {

        // TODO Implement a recursive solution to this method.
        if (n == 1)
        {
            System.out.println(n);
        }
        else {
            System.out.println(n);
            printNums1(n - 1);
        }
    }

    /**
     * Prints all ints from 1 up to n.
     */
    public void printNums2(int n) {

        // TODO Implement a recursive solution to this method.
        if (n > 1)
        {
            printNums2(n - 1);
        }
        System.out.println(n);
    }

    /**
     * Returns the number of 'e' and 'E' characters in the given String.
     *
     * @param input the string to check
     */
    public int countEs(String input) {

        // TODO Implement a recursive solution to this method.
        if (input.length() == 0)
        {
            return 0;
        }
        else {
            if (input.charAt(0) == 'e' || input.charAt(0) == 'E')
            {
                return 1 + countEs(input.substring(1));
            }
            else
            {
                return 0 +  countEs(input.substring(1));
            }
        }
    }

    /**
     * Returns the nth number in the fibonacci sequence.
     */
    public int fibonacci(int n) {

        // TODO Implement a recursive solution to this method.

        if (n == 1 || n == 2)
        {
            return 1;
        }
        else if (n == 0)
        {
            return 0;
        }
        else
        {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /**
     * Returns true if the given input String is a palindrome, false otherwise.
     *
     * @param input the String to check
     */
    public boolean isPalindrome(String input) {

        // TODO Implement a recursive solution to this method.
        if (input == null || input.length() <= 1)
        {
            return true;
        }
        else
        {
            char first = input.charAt(0);
            char last = input.charAt(input.length() - 1);
            if (first != last)
            {
                return false;
            }
            else
            {
                String middle = input.substring(1, input.length() - 1);
                return isPalindrome(middle);
            }
        }
    }
}
