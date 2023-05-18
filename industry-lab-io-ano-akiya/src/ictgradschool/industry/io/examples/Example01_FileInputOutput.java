package ictgradschool.industry.io.examples;

import java.io.*;
import java.util.Arrays;

/**
 * Created by anhyd on 28/03/2017.
 */
public class Example01_FileInputOutput {

    public void start() {

        File file = new File("mydata.dat");

        write(file);
        read(file);
    }

    private void write(File file) {
        try (FileOutputStream fos = new FileOutputStream(file)) {

            byte[] data = { 1, 2, 3, 4, 5 };
            fos.write(data);

            System.out.println("Data written to " + file.getName() + " successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void read(File file) {
        try (FileInputStream fIn = new FileInputStream(file)) {

            byte[] input = new byte[5];
            for (int i = 0; i < input.length; i++) {
                input[i] = (byte) fIn.read();
            }

            System.out.println(Arrays.toString(input));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Example01_FileInputOutput().start();
    }

}
