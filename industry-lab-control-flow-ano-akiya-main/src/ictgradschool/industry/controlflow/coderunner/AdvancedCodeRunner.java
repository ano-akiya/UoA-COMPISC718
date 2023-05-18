package ictgradschool.industry.controlflow.coderunner;

/**
 * Please run TestCodeRunner to check your answers
 */
public class AdvancedCodeRunner {

    /**
     * Q1. When given an integer, return an integer that is the reverse (its numbers are in reverse to the input order).
     *
     * @param number
     * @return the integer with digits in reverse order
     */
    public int reverseInt(int number)
    {
        int reverseNum = 0;
        // TODO write answer for Q1
        int length = (String.valueOf(number)).length();
        for (int i = 0; i < length; i ++)
        {
            int temp = number / 10;
            int dec = number % 10;
            int max_position = 1;
            for (int j = 0; j < length - (i + 1) ; j ++)
            {
                max_position = 10 * max_position;
            }
            reverseNum = dec * max_position + reverseNum;
            number = temp;
        }
        return reverseNum;
    }


    /**
     * Q2. Determine if the given integer is a palindrome (ignoring negative sign).
     *
     * @param num
     * @return true is int is palindrome, false otherwise
     */
    public boolean isIntPalindrome(int num) {

        // TODO write answer for Q2
        int length = (String.valueOf(num)).length();
        int[] digit = new int[length];
        for (int i = 0; i < length; i++)
        {
            digit[i] = num % 10;
            System.out.println(digit[i]);
            num = num / 10;
        }
        int equal = 0;
        int not_equal = 0;
        for (int i = 0; i < length; i++)
        {
            if (digit[i] == digit[length - (i+1)])
            {
                equal = equal + 1;
            }
            else
            {
                not_equal = not_equal + 1;
            }
        }
        if (equal == length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Q3. Determines the Excel column name of the given column number.
     *
     * @param num
     * @return the column title as a String
     */
    public String convertIntToColTitle(int num) {
        String columnName = "";
        // TODO write answer for Q3
        if (num < 0)
        {
            System.out.println("Input is invalid");
        }
        else
        {
            for (int i = num; i > 0; i = i - 26)
            {
                if (i < 26)
                {
                    columnName = columnName + i;
                }
                else if (i > 26)
                {
                    int remain = i % 26;
                    columnName = columnName + remain;
                }
            }
        }
        return columnName;
    }


}
