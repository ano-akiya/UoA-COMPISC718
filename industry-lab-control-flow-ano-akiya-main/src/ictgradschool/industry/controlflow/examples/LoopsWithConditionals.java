package ictgradschool.industry.controlflow.examples;

import ictgradschool.Keyboard;

public class LoopsWithConditionals {

    public String promptUser(String prompt){
        System.out.println(prompt);
        return Keyboard.readInput();
    }

    public void start(){
        String userInput = "";

        while (!userInput.equals("a")  && !userInput.equals("b") && !userInput.equals("c") ){
            userInput = promptUser("Please input 'a' for strawberry, 'b' for chocolate or 'c' for vanilla");

            if (userInput.equals("a")){
                System.out.println("You selected strawberry.");
            } else if (userInput.equals("b")){
                System.out.println("You selected chocolate.");
            } else if (userInput.equals("c")){
                System.out.println("You selected vanilla.");
            }

        }


    }

    public static void main(String[] args) {
        LoopsWithConditionals loopsWithConditionals = new LoopsWithConditionals();
        loopsWithConditionals.start();
    }

}
