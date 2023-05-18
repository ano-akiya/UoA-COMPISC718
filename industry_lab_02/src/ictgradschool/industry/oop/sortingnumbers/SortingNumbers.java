package ictgradschool.industry.oop.sortingnumbers;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a program that prompts the user to enter a range – 2 integers representing a lower bound and an upper bound.
 * You should use Keyboard.readInput() for this. Then, convert these bounds from String to int using Integer.parseInt().
 * Your program should then use Math.random() to generate 3 random integers that lie between the range entered (inclusive),
 * and then use Math.min() to determine which of the random integers is the sm、allest.
 */
public class SortingNumbers {

    /**
     * TODO Your code here. You may also write additional methods if you like.
     */

    Scanner scan = new Scanner(System.in);
    public int getUserInput() {
        int validInt = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                validInt = scan.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input");
                scan.next();
            }
        }

        return validInt;
    }

    private void start()
    {
        int bound1 = get_the_bound();
        int bound2 = get_the_bound();

        int upper_bound = 0;
        int lower_bound = 0;

        if (bound1 == bound2)
        {
            System.out.println("Please enter two different number.");
            start();
        }
        else
        {
            if (bound1 < bound2)
            {
                upper_bound = bound2;
                lower_bound = bound1;
            }
            else
            {
                upper_bound = bound1;
                lower_bound = bound2;
            }
            int random1 = lower_bound + (int)(Math.random() * (upper_bound + 1 - lower_bound));
            int random2 = lower_bound + (int)(Math.random() * (upper_bound + 1 - lower_bound));
            int random3 = lower_bound + (int)(Math.random() * (upper_bound + 1 - lower_bound));

            int min = Math.min(Math.min(random1,random2),random3);

            System.out.println("The random number is : ");
            System.out.println("Random 1: " + random1);
            System.out.println("Random 2: " + random2);
            System.out.println("Random 3: " + random3);

            System.out.println("The min of the random number in the range is : "+ min);

        }
    }
    private int get_the_bound()
    {
        System.out.println("The bound is: ");
        int bound = getUserInput();
        return bound;
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {

        SortingNumbers ex = new SortingNumbers();
        ex.start();

    }
}
