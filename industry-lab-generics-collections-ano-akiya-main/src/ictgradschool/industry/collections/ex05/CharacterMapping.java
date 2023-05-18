package ictgradschool.industry.collections.ex05;

import java.util.HashMap;
import java.util.Map;

/**
 * Main program for Lab 9 Ex 5, which should print out a table showing the frequency of all alphanumeric characters
 * in a text block.
 */
public class CharacterMapping {

    /**
     * Loops through the given String and builds a Map, relating each alphanumeric character in the String (key)
     * with how many times that character occurs in the string (value). Ignore case.
     *
     * @param text the text to analyze
     * @return a mapping between characters and their frequencies in the text
     */
    private Map<Character, Integer> getCharacterFrequencies(String text) {

        // Ignore case. We need only deal with uppercase letters now, after this line.
        text = text.toUpperCase();
        char[] character = text.toCharArray();

        // TODO Initialize the frequencies map to an appropriate concrete instance
        Map<Character, Integer> frequencies = new HashMap<>();

        // Loop through all characters in the given string
        for (char c : text.toCharArray()) {

            // If c is alphanumeric...
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {

                // TODO If the map already contains c as a key, increment its value by 1.
                // TODO Otherwise, add it as a new key with the initial value of 1.
                int counter;
                if (!frequencies.containsKey(c))
                {
                    counter = 1;
                    frequencies.put(c, counter);
                }
                else
                {
                    counter = frequencies.get(c) + 1;
                    frequencies.put(c, counter);
                }
            }
        }

        // TODO BONUS: Add any missing keys to the map
        // (i.e. loop through all characters from A-Z and 0-9. If that character doesn't appear in the text,
        // add it as a key here with frequency 0).
        char[] total = new char[36];
        for (int i = 0; i < total.length; i++)
        {
            if (i < 26)
            {
                total[i] = (char) ('A' + i);
            }
            else
            {
                total[i] = (char) ('0' + i - 26);
            }
        }

        for (int i = 0; i < total.length; i++)
        {
            if (!frequencies.containsKey(total[i]))
            {
                frequencies.put(total[i], 0);
            }
        }

        return frequencies;
    }

    /**
     * Prints the given map in a user-friendly table format.
     *
     * @param frequencies the map to print
     */
    private void printFrequencies(Map<Character, Integer> frequencies) {

        System.out.println("Char:\tFrequencies:");
        System.out.println("--------------------");

        // TODO Loop through the entire map and print out all the characters (keys)
        // TODO and their frequencies (values) in a table.
        for(Map.Entry<Character, Integer> entry : frequencies.entrySet())
        {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("'" + key + "'" +"\t\t" + value);
        }
    }

    /**
     * Main program flow. Do not edit.
     */
    private void start() {
        Map<Character, Integer> frequencies = getCharacterFrequencies(Constants.TEXT);
        printFrequencies(frequencies);
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        new CharacterMapping().start();
    }
}
