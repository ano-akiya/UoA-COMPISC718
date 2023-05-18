package ictgradschool;
import java.util.Scanner;

public class test_is_valid
{
    Scanner scan = new Scanner(System.in);
    public void start()
    {
        System.out.println("Please enter your amount: ");
        String user_input_amount = scan.next();
        if (is_input_int(user_input_amount))
        {
            int amount = Integer.valueOf(user_input_amount);
            start_test(amount);
        }
        else
        {
            while (! is_input_int(user_input_amount))
            {
                System.out.println("Please enter your amount: ");
                user_input_amount= scan.next();
            }
            if (is_input_int(user_input_amount))
            {
                int amount = Integer.valueOf(user_input_amount);
                start_test(amount);
            }
        }
    }

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

    public void start_test(int amount)
    {

    }

    public static void main(String[] args)
    {
        test_is_valid e = new test_is_valid();
        e.start();
    }
}
