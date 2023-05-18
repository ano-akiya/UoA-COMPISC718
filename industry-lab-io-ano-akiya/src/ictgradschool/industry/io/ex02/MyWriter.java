package ictgradschool.industry.io.ex02;

import ictgradschool.Keyboard;

import java.io.*;

/**
 * A simple program which should allow the user to type any number of text lines. The program will then
 * write them out to a file.
 */
public class MyWriter {

    public void start() {

        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();

        // TODO Open a file for writing, using a PrintWriter.
        PrintWriter writer = null;
        File open = new File(fileName);
        try
        {
            writer = new PrintWriter(open);
        }
        catch (IOException e)
        {
            System.out.println("IO problem");
        }

        while (true) {

                System.out.print("Type a line of text, or just press ENTER to quit: ");
                String text = Keyboard.readInput();

                if (text.isEmpty()) {
                    break;
                }

                // TODO Write the user's line of text to a file.
                writer.write(text + "\n");
        }
        writer.close();

        System.out.println("Done!");

    }

    public static void main(String[] args) {

        new MyWriter().start();

    }
}
