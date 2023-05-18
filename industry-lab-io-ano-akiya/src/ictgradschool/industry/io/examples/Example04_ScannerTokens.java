package ictgradschool.industry.io.examples;

import java.io.*;
import java.util.Scanner;

/**
 * Created by anhyd on 28/03/2017.
 */
public class Example04_ScannerTokens {

    public void start() {

        File file1 = new File("myformattedtextfile.txt");
        scan(file1);
        System.out.println();

        File file2 = new File("myformattedtextfile2.txt");
        scanWithDelimiter(file2);


    }

    private void scan(File file) {
        System.out.println("Scanning with default (whitespace) delimiter:");
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNext()) {
                String s = scanner.next();
                int i = scanner.nextInt();
                boolean b = scanner.nextBoolean();
                double d = scanner.nextDouble();
                System.out.println(s + "\t" + i + "\t" + b + "\t" + d);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void scanWithDelimiter(File file) {
        System.out.println("Scanning with csv-style delimiter");
        try (Scanner scanner = new Scanner(file)) {

            scanner.useDelimiter(",|\\r|\\n|\\r\\n");

            while (scanner.hasNext()) {
                String s = scanner.next();
                int i = scanner.nextInt();
                boolean b = scanner.nextBoolean();
                double d = scanner.nextDouble();
                System.out.println(s + "\t" + i + "\t" + b + "\t" + d);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Example04_ScannerTokens().start();
    }

}
