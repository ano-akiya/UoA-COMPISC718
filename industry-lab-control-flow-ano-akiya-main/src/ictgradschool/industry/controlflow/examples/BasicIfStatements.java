package ictgradschool.industry.controlflow.examples;

import ictgradschool.Keyboard;

public class BasicIfStatements {

    public void start(){

        System.out.println("How many hits did you take on this golf hole?");
        int score = Integer.parseInt(Keyboard.readInput());
        System.out.println("What is par for this golf hole?");
        int par = Integer.parseInt(Keyboard.readInput());

        int parMinusScore = par - score;
        String scoreName = "";

        if (score == 1){
            scoreName = "ace";
        } else if (parMinusScore == 3){
            scoreName = "albatross";
        } else if (parMinusScore == 2){
            scoreName = "eagle";
        } else if (parMinusScore == 1){
            scoreName = "birdie";
        } else if (parMinusScore == 0){
            scoreName = "par";
        } else if (parMinusScore == -1){
            scoreName = "bogey";
        } else if (parMinusScore == -2){
            scoreName = "double bogey";
        } else if (parMinusScore == -3){
            scoreName = "triple bogey";
        } else if (parMinusScore < -3){
            scoreName = "not deserving of a name";
        }

        System.out.println("On this hole you got a " + scoreName);

    }

    public static void main(String[] args) {
        BasicIfStatements basicIfStatements = new BasicIfStatements();
        basicIfStatements.start();
    }

}
