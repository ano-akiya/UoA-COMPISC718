package ictgradschool.industry.io.ex02;

import ictgradschool.Keyboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyReader {

    public void start() {

        // TODO Prompt the user for a file name, then read and print out all the text in that file.
        // TODO Use a BufferedReader.
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

        BufferedReader file = null;
        int item;
        try
        {
            file = new BufferedReader(new FileReader(open));
            while ((item = file.read()) != -1)
            {
                System.out.println((char) item);
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
            catch(IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        new MyReader().start();
    }
}
