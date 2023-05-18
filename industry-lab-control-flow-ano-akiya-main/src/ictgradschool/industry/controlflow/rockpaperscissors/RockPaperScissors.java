package ictgradschool.industry.controlflow.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 A game of Rock, Paper Scissors
 */
public class RockPaperScissors {

    public static final int ROCK = 1;
    // TODO Make similar constants for PAPER and SCISSORS, to improve readability of your code.
    public static final int PAPER = 3;
    public static final int SCISSORS = 2;
    public static final int Quit = 4;
    public String name = "";

    public void start()
    {
        // TODO Write your code here which calls your other methods in order to play the game. Implement this
        // as detailed in the exercise sheet.

        //get user name
        System.out.println("Hi! What is your name?" );
        Scanner scan = new Scanner(System.in);
        name = scan.next();
        String user_choice;

        do {
            //clue
            System.out.println("\r\n");
            System.out.println("1. Rock");
            System.out.println("2. Scissors");
            System.out.println("3. Paper");
            System.out.println("4. Quit");

            do {
                System.out.println("Enter choice: ");
                user_choice = scan.next();
            }
            while (!is_input_valid(user_choice));

            int choice_number = Integer.parseInt(user_choice);
            System.out.print("\r\n");
            displayPlayerChoice(name, choice_number);

            Random r = new Random();
            int computer_choice_number = r.nextInt(2) + 1;
            displayComputerChoice(computer_choice_number);

            String result = getResultString(choice_number, computer_choice_number);
            System.out.println(result);
        }
        while (user_choice != "4");

    }
    public Boolean is_input_number(String input)
    {
        int choice_number;
        try
        {
            choice_number = Integer.parseInt(input);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public Boolean is_input_valid(String input)
    {
        int number;
        if (is_input_number(input))
        {
            number = Integer.parseInt(input);
            if (number >= 1 && number <= 4)
            {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public void displayPlayerChoice(String name, int choice)
    {
        String player_choice = "";
        // TODO This method should print out a message stating that someone chose a particular thing (rock, paper or scissors)
        if(choice <=3 && choice >=1)
        {
            player_choice = string_choice_name(choice);
            System.out.println(name + " choose " + player_choice + ".");
        }
        else
        {
            if (choice == 4)
            {
                System.out.println("Goodbye " + name +". Thanks for playing :)");
                System.exit(0);
            }
        }
    }

    private String string_choice_name(int choice)
    {
        String player_choice = "";
        if (choice == 1)
        {
            player_choice = "ROCK";
        }
        else if (choice == 2)
        {
            player_choice = "SCISSORS";
        }
        else if (choice == 3)
        {
            player_choice = "PAPER";
        }
        return player_choice;
    }

    public void displayComputerChoice(int computerChoice)
    {
        String str_computer_choice = "";
        if (computerChoice == 1)
        {
            str_computer_choice = "ROCK";
        }
        else if (computerChoice == 2)
        {
            str_computer_choice = "SCISSORS";
        }
        else if (computerChoice == 3)
        {
           str_computer_choice = "PAPER";
        }
        System.out.println("Computer chose " + str_computer_choice + ".");
    }

    public boolean userWins(int playerChoice, int computerChoice) {
        // TODO Determine who wins and return true if the player won, false otherwise.

        if (playerChoice == 1)
        {
            if (computerChoice == 2)
            {
                return true;
            }
        }
        if (playerChoice == 2)
        {
            if (computerChoice == 3)
            {
                return true;
            }
        }
        if (playerChoice == 3)
        {
            if (computerChoice == 1)
            {
                return true;
            }
        }
        return false;
    }

    public String getResultString(int playerChoice, int computerChoice) {

        final String PAPER_WINS = "paper covers rock.";
        final String ROCK_WINS = "rock smashes scissors.";
        final String SCISSORS_WINS = "scissors cut paper.";
        final String TIE = " you chose the same as the computer.";


        String result;

        if (userWins(playerChoice, computerChoice))
        {
            if (playerChoice == 1)
            {
                if (computerChoice == 2)
                {
                    result = name + " wins because " + ROCK_WINS;
                    return result;
                }
            }
            else if (playerChoice == 2)
            {
                if (computerChoice == 3)
                {
                    result = name + " wins because " + SCISSORS_WINS;
                    return result;
                }
            }
            else if (playerChoice == 3)
            {
                if (computerChoice == 1)
                {
                    result = name + " wins because " + PAPER_WINS;
                    return result;
                }
            }
        }
        else if (playerChoice == computerChoice)
        {
            result = "No one wins. Because " + TIE;
            return result;
        }
        else if (!userWins(playerChoice, computerChoice))
        {
            if (computerChoice == 1)
            {
                if (playerChoice == 2)
                {
                    result = "The computer wins because " + ROCK_WINS;
                    return result;
                }
            }
            if (computerChoice == 2)
            {
                if (playerChoice == 3)
                {
                    result = "The computer wins because " + SCISSORS_WINS;
                    return result;
                }
            }
            if (computerChoice == 3)
            {
                if (playerChoice == 1)
                {
                    result = "The computer wins because " + PAPER_WINS;
                    return result;
                }
            }
        }
        return null;
        // TODO Return one of the above messages depending on what playerChoice and computerChoice are.
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        RockPaperScissors ex = new RockPaperScissors();
        ex.start();
    }
}
