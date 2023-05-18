package ictgradschool.industry.oop.truncateamount;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a program that prompts the user to enter an amount and a number of decimal places.  The program should then
 * truncate the amount to the user-specified number of decimal places using String methods.
 *
 * To truncate the amount to the user-specified number of decimal places, the String method indexOf() should be used
 * to find the position of the decimal point, and the method substring() should then be used to extract the amount to
 * the user-specified number of decimal places.  The program is to be written so that each task is in a separate method.
 * You need to write four methods, one method for each of the following tasks:
 *
 * 1. Printing the prompt and reading the amount from the user
 * 2. Printing the prompt and reading the number of decimal places from the user
 * 3. Truncating the amount to the user-specified number of DP's
 * 4. Printing the truncated amount
 *
 */
public class TruncateAmount {
    Scanner scan = new Scanner(System.in);
    public void start()
    {
        /*
            prompt user to enter the amount
         */
        String user_input_amount = prompt_user_enter_amount();
        /*
            is the input amount an int
         */
        if (is_input_int(user_input_amount))
        {
            /*
                if the amount an int
                prompt user to enter the decimal position they want
             */
            String user_input_decimal = prompt_user_enter_decimal_position();
            /*
                is the input position an int
             */
            if (is_input_int(user_input_decimal))
            {
                /*
                    if the input an int
                    start the truncate process
                 */
                int decimal = Integer.parseInt(user_input_decimal);
                truncates(user_input_amount, decimal);
            }
            /*
                if the enter position not int
             */
            else
            {
                /*
                    prompt user to enter the position
                    until they enter an int
                 */
                while (! is_input_int(user_input_decimal))
                {
                    user_input_decimal = prompt_user_enter_decimal_position();
                }
                if (is_input_int(user_input_decimal))
                {
                    int decimal = Integer.parseInt(user_input_decimal);
                    truncates(user_input_amount, decimal);
                }
            }
        }
        /*
            if the amount not an int
         */
        else
        {
            /*
                prompt them enter the amount
                until they enter an int
                and if they enter an int amount
                prompt them enter the decimal position
             */
            while (!is_input_int(user_input_amount))
            {
                user_input_amount = prompt_user_enter_amount();
            }
            if (is_input_int(user_input_amount))
            {
                /*
                    prompt them enter the decimal position
                 */
                String user_input_decimal = prompt_user_enter_decimal_position();
                if (is_input_int(user_input_decimal))
                {
                    /*
                        if they enter an int position
                        start truncate
                     */
                    int decimal = Integer.parseInt(user_input_decimal);
                    truncates(user_input_amount, decimal);
                }

                else
                {
                    /*
                        if the don't enter an int position
                     */
                    while (!is_input_int(user_input_decimal))
                    {
                        /*
                            prompt them to enter an int position
                            until they enter an int
                         */
                        user_input_decimal = prompt_user_enter_decimal_position();
                    }
                    /*
                        if they enter an int position
                        start truncate
                     */
                    if (is_input_int(user_input_decimal))
                    {
                        int decimal = Integer.parseInt(user_input_decimal);
                        truncates(user_input_amount, decimal);
                    }
                }
            }
        }
    }

    /*
        prompt user enter their amount
     */
    private String prompt_user_enter_amount()
    {
        System.out.println("Please enter your amount: ");
        String user_input_amount = scan.next();
        return user_input_amount;
    }

    /*
        prompt user enter their decimal position
     */
    private String prompt_user_enter_decimal_position()
    {
        System.out.println("Please enter your decimal position: ");
        String user_input_decimal = scan.next();
        return user_input_decimal;
    }

    /*
        is user enter an int
     */
    public boolean is_input_int(String input)
    {
        try{
            int amount = Integer.valueOf(input);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    private void truncates(String amount, int decimal)
    {
        int length = amount.length();
        String truncate_amount_before = amount.substring(0,length - 1 - decimal);
        String truncate_amount_after = amount.substring((length -1 - decimal) + 1, length);
        System.out.println(truncate_amount_before + "." + truncate_amount_after);
    }
    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        TruncateAmount ex = new TruncateAmount();
        ex.start();
    }
}
