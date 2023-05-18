package ictgradschool.industry.controlflow.guessing;
import java.util.Random;
import java.util.Scanner;

/**
 * A guessing game!
 */
public class GuessingGame {

    public void start() {
        // TODO Write your code here.

        Random r = new Random();
        int goal = r.nextInt(100) + 1;
        int guess = 0;

        Scanner scan = new Scanner(System.in);
        String input = "";

        do
        {
            System.out.println("Enter your guess (1 – 100): ");
            input = scan.next();
        }
        while(!is_input_valid(input));

        if (is_input_valid(input))
        {
            guess= Integer.parseInt(input);
            do {
                System.out.println("Too high, try again");
                System.out.println("Enter your guess (1 – 100): ");
                input = scan.next();
                guess = Integer.parseInt(input);
            }
            while(guess > goal);

            do {
                System.out.println("Too low, try again");
                System.out.println("Enter your guess (1 – 100): ");
                input = scan.next();
                guess = Integer.parseInt(input);
            }
            while(guess < goal);

            if (guess == goal)
            {
                System.out.println("Perfect!!");
                System.out.println("Goodbye!");
            }
        }

    }
    private Boolean is_input_valid(String input)
    {
        int guess = 0;
        try
        {
            guess = Integer.parseInt(input);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {

        GuessingGame ex = new GuessingGame();
        ex.start();

    }
}
