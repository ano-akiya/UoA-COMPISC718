package ictgradschool.industry.controlflow.coderunner;

import java.lang.String;

/**
 * Please run TestCodeRunner to check your answers
 */
public class CodeRunner {
    /**
     * Q1. Compare two names and if they are the same return "Same name",
     * otherwise if they start with exactly the same letter return "Same
     * first letter", otherwise return "No match ".
     *
     * @param firstName
     * @param secondName
     * @return one of three Strings: "Same name", "Same first letter",
     * "No match"
     */
    public String areSameName(String firstName, String secondName) {
        String message = "";
        // TODO write answer to Q1

        if (firstName.equals(secondName))
        {
            message = "Same name";
        }
        else if(firstName.charAt(0)==(secondName.charAt(0)))
        {
            message = "Same first letter";
        }
        else
        {
            message = "No match";
        }
        return message;
    }


    /**
     * Q2. Determine if the given year is a leap year.
     *
     * @param year
     * @return true if the given year is a leap year, false otherwise
     */
    public boolean isALeapYear(int year) {
        boolean leapYear = false;
        // TODO write answer for Q2
        if (year % 100 != 0)
        {
            if ( year % 4 == 0)
            {
                leapYear = true;
            }
            else
            {
                leapYear = false;
            }
        }
        else
        {
            if (year % 400 == 0)
            {
                leapYear = true;
            }
            else
            {
                leapYear = false;
            }
        }

        return leapYear;
    }


    /**
     * Q3. Return the given string in reverse order.
     *
     * @param str
     * @return the String with characters in reverse order
     */
    public String reverseString(String str)
    {
        String reverseStr = "";
        // TODO write answer for Q3
        int length = str.length();
        char[] enter_string = new char[length];
        for (int i = 0; i < length; i ++)
        {
            enter_string[i] = str.charAt(i);
        }
        for (int i = 0; i < length; i ++)
        {
                reverseStr = reverseStr + enter_string[length - (i + 1)];
        }
        return reverseStr;
    }


    /**
     * Q4. Determine if the given number is a prime number.
     *
     * @param num
     * @return true is the given number is a prime, false otherwise
     */
    public boolean isPrime(int num) {
        // TODO write answer for Q4
        if (num < 4 && num != 1)
        {
            return true;
        } else if (num == 1)
        {

            return false;
        }
        else if (num >= 4)
        {
            for (int i = 2; i < num; i++)
            {
                if (num % i == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }
        return true;
    }


    /**
     * Q5. Determine if the given string is a palindrome (case folded).
     *
     * @param str
     * @return true if string is palindrome, false otherwise
     */
    public boolean isStringPalindrome(String str)
    {
        // TODO write answer for Q5
        String lower_str = str.toLowerCase();
        String no_blank_str = lower_str.replace(" ","");
        int length = no_blank_str.length();
        char[] input = new char[length];
        for (int i = 0; i < length; i ++)
        {
            input[i] = no_blank_str.charAt(i);
        }

        for (int i = 0; i < length; i ++)
        {
            if (input[i] == input[length - i - 1])
            {
                return true;
            }
            else
                return false;
        }
        return false;
    }


    /**
     * Q6. Generate a space separated list of all the prime numbers from 2
     * to the highest prime less than or equal to the given integer.
     *
     * @param num
     * @return the primes as a space separated list
     */
    public String printPrimeNumbers(int num) {
        String primesStr = "";
        // TODO write answer for Q6
        String pri_num;
        if (num <= 1)
        {
            primesStr ="No prime number found";
        }
        else if (num > 1)
        {
            for (int i = 2; i <= num; i++)
            {
                int can_div = 0;
                for (int j = 2; j < i; j++)
                {
                    if (i % j == 0)
                    {
                        can_div = 1;
                    }
                }
                if (can_div == 0)
                {
                    pri_num = String.valueOf(i);
                    primesStr = primesStr + pri_num + " ";
                }
            }
        }
        return primesStr.trim();
    }

    /**
     * Q7. Generates the simple multiplication table for the given integer.
     * The resulting table should be 'num' columns wide and 'num' rows tall.
     *
     * @param num
     * @return the multiplication table as a newline separated String
     */
    public String simpleMultiplicationTable(int num) {
        String multiplicationTable = "";
        // TODO write answer for Q7
        if(num > 1)
        {
            for (int row = 1; row <= num; row++)
            {
                String output = "";
                int multi = 0;
                for (int colum = 1; colum <= num; colum++)
                {
                    multi = row * colum;
                    output = output + String.valueOf(multi) + " ";
                }
                if (row == 1)
                {
                    multiplicationTable = output.trim();
                }
                else if (row > 1)
                {
                    multiplicationTable = multiplicationTable + "\n" + output.trim();
                }
            }
        }
        else if (num == 1)
        {
            multiplicationTable = "1";
        }
        return multiplicationTable;
    }
}
