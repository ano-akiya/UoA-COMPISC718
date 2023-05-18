package ictgradschool.industry.introtojava.examples;

public class ExpressionsExample {

    public void start(){

        // Basic addition of numbers:
        double valueOne = 3;
        double valueTwo = 7;
        double valueThree = 2;
        double valueFour = 13;
        double totalOfValues = valueOne + valueTwo + valueThree + valueFour;
        System.out.println("The total is: " + totalOfValues);

        // Basic division and multiplication of `double` variables to calculate a percentage:
        double score = 45;
        double total = 60;
        double percentage = score / total * 100;
        System.out.println("The score is " + score + " out of " + total + " which is " + percentage + " percent.");

        // Using integer division and modulo/remainder to work out hours and minutes from a total number of minutes:
        int totalMinutes = 195;
        // Because this is integer division, 195 / 60 will be 3 as integers can only divide into whole numbers
        int hours = totalMinutes / 60;
        // The % operator is modulo/remainder which is the number left over after dividing by 60
        int minutes = totalMinutes % 60;
        System.out.println(totalMinutes + " total minutes is " + hours + " hours and " + minutes + " minutes.");

    }

    public static void main(String[] args) {
        ExpressionsExample expressionsExample = new ExpressionsExample();
        expressionsExample.start();
    }


}
