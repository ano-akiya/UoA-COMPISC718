package ictgradschool.industry.io.examples;

import java.io.*;

/**
 * Created by anhyd on 28/03/2017.
 */
public class Example05_PrintWriter {

    public void start() {

        File file = new File("doge.txt");

        write(file);

        // You can read it by opening it in a text editor!
    }

    private void write(File file) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {

            boolean b = true; double dNum = 4.56; int num = 245;

            writer.println("Much PrintWriter! Such wow!");
            writer.print(b + " ");
            writer.printf("%10.1f\n", dNum );
            writer.printf("%-4d %15s", num, "NEAT");

        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Example05_PrintWriter().start();
    }

}
