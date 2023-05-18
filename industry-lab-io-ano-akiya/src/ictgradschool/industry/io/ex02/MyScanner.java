package ictgradschool.industry.io.ex02;

import ictgradschool.Keyboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyScanner {

    public void start() {

        // TODO Prompt the user for a file name, then read and print out all the text in that file.
        // TODO Use a Scanner.
        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();
        File open = null;
        try{
            open = new File(fileName);
        }
        catch (Exception e)
        {
            System.out.println("throw exception");
        }

        Scanner file = null;
        try
        {
            file = new Scanner(open);
            boolean has_next = true;
            while(has_next)
            {
                if (file.hasNext())
                {
                    System.out.println(file.next());
                }
                else
                {
                    has_next = false;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("IO problem");
        }
        finally
        {
            try
            {
                file.close();
            }
            catch(Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new MyScanner().start();
    }
}
