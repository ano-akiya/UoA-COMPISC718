package ictgradschool.industry.oop.removechar;

import java.util.Scanner;

/**
 * Write a program that prompts the user to enter a sentence, then prints out the sentence with a random character
 * missing. The program is to be written so that each task is in a separate method. See the comments below for the
 * different methods you have to write.
 */
public class RemoveCharacter {

    private void start() {

        String sentence = getSentenceFromUser();

        int randomPosition = getRandomPosition(sentence);

        printCharacterToBeRemoved(sentence, randomPosition);

        String changedSentence = removeCharacter(sentence, randomPosition);

        printNewSentence(changedSentence);
    }

    /**
     * Gets a sentence from the user.
     * @return
     */
    private String getSentenceFromUser() {

        // TODO Prompt the user to enter a sentence, then get their input.
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a sentence: ");
        String sentence_from_user = scan.nextLine();
        return sentence_from_user;
    }

    /**
     * Gets an int corresponding to a random position in the sentence.
     */
    private int getRandomPosition(String sentence) {

        // TODO Use a combination of Math.random() and sentence.length() to get the desired result.
        int sentence_length = sentence.length();
        // System.out.println(sentence_length);

        int random_number = (int)(Math.random() * (sentence_length + 1));
        // System.out.println(random_number);

        return random_number;
    }

    /**
     * Prints a message stating the character to be removed, and its position.
     */
    private void printCharacterToBeRemoved(String sentence, int position) {

        // TODO Implement this method
        char character_to_be_removed = sentence.charAt(position);
        System.out.println("The character to be removed is : " + character_to_be_removed);

    }

    /**
     * Removes a character from the given sentence, and returns the new sentence.
     */
    private String removeCharacter(String sentence, int position) {

        // TODO Implement this method
        char character_to_be_removed = sentence.charAt(position);

        int sentence_length = sentence.length();

        String changed_sentence = "";
        for (int i = 0; i < sentence_length; i++)
        {
            if (sentence.charAt(i) != character_to_be_removed)
            {
                changed_sentence = changed_sentence + sentence.charAt(i);
            }
        }
        return changed_sentence;

    }

    /**
     * Prints a message which shows the new sentence after the removal has occured.
     */
    private void printNewSentence(String changedSentence) {

        // TODO Implement this method
        System.out.println("The new sentence is: ");
        System.out.println(changedSentence);
    }

    public static void main(String[] args) {
        RemoveCharacter ex = new RemoveCharacter();
        ex.start();
    }
}
