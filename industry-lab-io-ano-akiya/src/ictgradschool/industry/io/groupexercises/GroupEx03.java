package ictgradschool.industry.io.groupexercises;

import java.io.File;
import java.io.IOException;

public class GroupEx03 {

    private void start() throws IOException {

        File file = new File("ge03-customer.txt");

        // Load and display customer
        Customer loadedCustomer = readCustomer(file);
        System.out.println("Customer details:");
        System.out.println(loadedCustomer);

    }

    private Customer readCustomer(File file) throws IOException {

        return null;

    }

    public static void main(String[] args) throws IOException {
        new GroupEx03().start();
    }
}
