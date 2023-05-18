package ictgradschool.industry.io.examples;

import java.io.*;

/**
 * Created by anhyd on 28/03/2017.
 */
public class Example02_DataInputOutput {

    public void start() {

        File file = new File("mydata2.dat");

        write(file);
        read(file);
    }

    private void write(File file) {
        try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream(file))) {

            dOut.writeInt(23);
            dOut.writeBoolean(false);
            dOut.writeUTF("Hello World");
            dOut.writeDouble(4.25);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void read(File file) {
        try (DataInputStream dIn = new DataInputStream(new FileInputStream(file))) {

            System.out.println(dIn.readInt());
            System.out.println(dIn.readBoolean());
            System.out.println(dIn.readUTF());
            System.out.println(dIn.readDouble());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Example02_DataInputOutput().start();
    }

}
