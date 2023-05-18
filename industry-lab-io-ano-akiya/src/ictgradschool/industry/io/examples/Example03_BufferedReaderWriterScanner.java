package ictgradschool.industry.io.examples;

import java.io.*;
import java.util.Scanner;

/**
 * Created by anhyd on 28/03/2017.
 */
public class Example03_BufferedReaderWriterScanner {

    public void start() {

        File file = new File("mytextfile.txt");

        write(file);
        read(file);
        System.out.println();
        scan(file);
    }

    private void write(File file) {
        try (BufferedWriter bW = new BufferedWriter(new FileWriter(file))) {

            int num = 'H';
            bW.write(num);
            bW.write('e');
            bW.write("llo \nthere!");
            bW.newLine();
            bW.write("How are you today?");
            bW.newLine();
            bW.write("I am personally very well.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void read(File file) {
        System.out.println("Reading using a BufferedReader:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void scan(File file) {
        System.out.println("Reading using a Scanner:");
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Example03_BufferedReaderWriterScanner().start();
    }

}
