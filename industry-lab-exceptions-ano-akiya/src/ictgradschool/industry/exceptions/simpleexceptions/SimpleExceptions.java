package ictgradschool.industry.exceptions.simpleexceptions;

import java.util.Scanner;


public class SimpleExceptions {
    public static void main(String[] args) {

        SimpleExceptions exceptions = new SimpleExceptions();

        //Question 1 & 2
        exceptions.handlingException();

        //Question3
        exceptions.Question3();

        //Question4
        exceptions.Question4();
    }

    /**
     * The following tries to divide using two user input numbers, but is
     * prone to error.
     */
    public void handlingException() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String str1 = sc.next();
        int num1 = Integer.parseInt(str1);
        System.out.print("Enter the second number: ");
        String str2 = sc.next();
        int num2 = Integer.parseInt(str2);

        int division = 0;
        try
        {
            // Output the result
            division = num1 / num2;
            System.out.println("The division of " + num1 + " over " + num2 + " is " + (num1 / num2) + "\n");
        }
        catch(ArithmeticException e)
        {
            throw e;
        }
        catch(NumberFormatException e)
        {
            throw e;
        }
    }

    public void Question3() {
        //Write some Java code which throws a StringIndexOutOfBoundsException
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter five character: ");
        String input = sc.next();
        char[] name = new char[5];

        try{
            for (int i = 0; i < 5; i++)
            {
                name[i] = input.charAt(i);
            }
        }
        catch(StringIndexOutOfBoundsException e)
        {
            throw e;
        }
    }

    public void Question4() {
        //Write some Java code which throws a ArrayIndexOutOfBoundsException
        Scanner sc = new Scanner(System.in);

        int[] arr_num = new int[5];

        System.out.print("Enter the first number: ");
        String str1 = sc.next();
        arr_num[0] = Integer.parseInt(str1);

        System.out.print("Enter the second number: ");
        String str2 = sc.next();
        arr_num[1] = Integer.parseInt(str2);

        try
        {
            System.out.println("The numbers you entered are:");
            for (int i = 0 ; i < 7; i++)
            {
                System.out.println(arr_num[i]);
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw e;
        }
    }
}