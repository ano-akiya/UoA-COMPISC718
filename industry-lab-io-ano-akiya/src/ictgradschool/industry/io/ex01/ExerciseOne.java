package ictgradschool.industry.io.ex01;
import java.io.*;

public class ExerciseOne {

    public void start() {

        printNumEsWithFileReader();

        printNumEsWithBufferedReader();

    }

    private void printNumEsWithFileReader() {

        int numE = 0;
        int total = 0;

        // TODO Read input2.txt and print the total number of characters, and the number of e and E characters.
        // TODO Use a FileReader.
        try
        {
            FileReader ex02_file = new FileReader("input2.txt");
            int item;
            while ((item = ex02_file.read()) != -1)
            {
                total = total + 1;
                if ((char) item == 'E' || (char) item == 'e')
                {
                    numE = numE + 1;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("IO problem");
        }
        System.out.println("Number of e/E's: " + numE + " out of " + total);
    }

    private void printNumEsWithBufferedReader() {

        int numE = 0;
        int total = 0;

        // TODO Read input2.txt and print the total number of characters, and the number of e and E characters.
        // TODO Use a BufferedReader.
        BufferedReader ex02_buffer = null;
        File myFile = new File("input2.txt");
        int item;

        try {
            ex02_buffer = new BufferedReader(new FileReader(myFile));
            while ((item = ex02_buffer.read()) != -1)
            {
                total = total + 1;

                if ((char) item == 'E' || (char) item == 'e')
                {
                    numE = numE + 1;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("IO problem");
        }
        finally
        {
            try
            {
                ex02_buffer.close();
            }
            catch(IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Number of e/E's: " + numE + " out of " + total);
    }

    public static void main(String[] args)
    {
        new ExerciseOne().start();
    }

}
