package ictgradschool.industry.collections.examples.Collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        DequeExample app = new DequeExample();
        app.start();
    }

    private void start() {

        Deque<String> myDeque = new ArrayDeque<>();

        System.out.println("Deque as a Queue (FIFO)");

        myDeque.addLast("A");
        myDeque.addLast("B");
        myDeque.addLast("C");

        System.out.println(myDeque.removeFirst());
        System.out.println(myDeque.removeFirst());
        System.out.println(myDeque.removeFirst());
        System.out.println();

        System.out.println("=================================");
        System.out.println("Deque as a Stack (FILO)");

        myDeque.addFirst("A");
        myDeque.addFirst("B");
        myDeque.addFirst("C");

        System.out.println(myDeque.removeFirst());
        System.out.println(myDeque.removeFirst());
        System.out.println(myDeque.removeFirst());

    }

}
