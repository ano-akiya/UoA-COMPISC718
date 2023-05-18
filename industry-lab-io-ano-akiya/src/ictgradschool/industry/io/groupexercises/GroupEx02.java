package ictgradschool.industry.io.groupexercises;

import java.io.File;
import java.io.IOException;

public class GroupEx02 {

    private void start() throws IOException {

        File file = new File("ge02-customer.dat");

        // Save customer
        Customer customerToSave = new Customer("Bob", 42, "123 Some Street", true);
        writeCustomer(customerToSave, file);

        // Load and display customer
        Customer loadedCustomer = readCustomer(file);
        System.out.println("Customer details:");
        System.out.println(loadedCustomer);

    }

    private void writeCustomer(Customer customer, File file) throws IOException {

    }

    private Customer readCustomer(File file) throws IOException {

        return null;

    }

    public static void main(String[] args) throws IOException {
        new GroupEx02().start();
    }
}
