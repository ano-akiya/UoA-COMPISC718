package ictgradschool.industry.oop.lowestweight;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a program which asks the user to enter the weights of two people,
 * then uses Math.min() to determine the lowest weight, and prints out the result.
 */
public class LowestWeight {

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
                //without line 26 it will print out line 23 forever
                //what did it do
                scan.next();
            }
        }

        return validInt;
    }

    /**
     * TODO Your code here. You may also write additional methods if you like.
     */
    private void start() {
        /* My answer */


        System.out.println("This System will tell the lowest weight.");
        System.out.println("Please write the weight down!");

        System.out.println("The first weight is: ");
        int weight_one = getUserInput();

        System.out.println("The second weight is: ");
        int weight_two = getUserInput();

        int lowest_weight;
        if (weight_one < weight_two) {
            lowest_weight = weight_one;
        } else if (weight_two < weight_one) {
            lowest_weight = weight_two;
        } else {
            System.out.println(weight_one + " is equal to " + weight_two);
        }
    }


    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {

        LowestWeight ex = new LowestWeight();
        ex.start();

    }
}
