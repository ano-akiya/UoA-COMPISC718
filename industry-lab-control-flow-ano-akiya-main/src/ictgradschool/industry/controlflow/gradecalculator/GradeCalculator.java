package ictgradschool.industry.controlflow.gradecalculator;

import java.util.Scanner;
import ictgradschool.Keyboard;

public class GradeCalculator {

    public char getLetterGrade(double percentageScore) {
        char letterGrade = '0';
        // TODO: write your code here to set the letter grade based on the percentage
        /*
         * The grades should be determined as follow:
         * 85% - 100% = A; 70% - 84% = B; 50% - 69% = C; 0% - 49% = D
         * */
        if (percentageScore <= 100 && percentageScore >= 85) {
            letterGrade = 'A';
        } else if (percentageScore <= 84 && percentageScore >= 70) {
            letterGrade = 'B';
        } else if (percentageScore <= 69 && percentageScore >= 50) {
            letterGrade = 'C';
        } else if (percentageScore <= 40 && percentageScore >= 0) {
            letterGrade = 'D';
        }


        return letterGrade;
    }


    public double getPercentageScore()
    {
        System.out.println("Please input your percentage score from zero to one hundred");
        // TODO: Modify the contents of this method so that the prompt will repeat if the user does enter a number from 0 - 100
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        double score = 0;
        if (is_valid(input))
        {
            score = Double.parseDouble(input);
            return score;
        }
        else
        {
            while (!is_valid(input))
            {
                System.out.println("Please input your percentage score from zero to one hundred");
                input = scan.next();
            }
            if (is_valid(input))
            {
                score = Double.parseDouble(input);
                return score;
            }
        }
        return score;
    }

    private Boolean is_valid(String input)
    {
        if (is_number(input))
        {
            double number = Double.parseDouble(input);
            if(is_number_between(number))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    private Boolean is_number(String input)
    {
        Double number;
        try
        {
            number = Double.parseDouble(input);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    private Boolean is_number_between(Double number)
    {
        if (number <= 100 && number >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    public void start(){
        double percentageScore = getPercentageScore();
        char letterGrade = getLetterGrade(percentageScore);
        System.out.println("Your grade is: " + letterGrade);
    }



    public static void main(String[] args) {
        GradeCalculator gradeCalculator = new GradeCalculator();
        gradeCalculator.start();
    }

}
