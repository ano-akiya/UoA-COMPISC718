package ictgradschool.industry.collections.examples.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        ListExample app = new ListExample();
        app.start();
    }

    private void start() {
        System.out.println("Basic methods from List");
        List<String> myList = new ArrayList<>();
        myList.add("A");
        myList.add("B");
        myList.add(0, "C");

        System.out.println(myList.get(0) + " " + myList.get(1) + " " + myList.get(2));
        System.out.println();

        /*
        System.out.println(myList.size());
        System.out.println(myList.contains("B"));
        System.out.println(myList.remove("A"));
        System.out.println(myList.remove(1));
        System.out.println();
        printList(myList);
        */


        System.out.println("=================================");
        System.out.println("For loop example");
        /*
        myList.add("A");
        myList.add("B");


        for (int i = 0; i < myList.size(); i++) {
            String element = myList.get(i);
            System.out.println("Element #" + (i+1) + ": " + element);
        }
        System.out.println();
        */


        System.out.println("=================================");
        System.out.println("Iterator example");
        /*
        myList.add("A");
        myList.add("B");
        myList.add("C");

        System.out.println("Original list:");
        printList(myList);
        System.out.println();
        System.out.println("List printed using iterator:");
        Iterator<String> myIterator = myList.iterator();
        while(myIterator.hasNext()){
            String element = myIterator.next();
            System.out.println(element);

            if(element.equals("B")){
                myIterator.remove();
            }
        }
        System.out.println();
        System.out.println("List modified using iterator:");
        printList(myList);
        System.out.println();
        */


        System.out.println("=================================");
        System.out.println("Enhanced for-loop example");
        /*
        myList.add("A");
        myList.add("B");
        myList.add("C");

        for(String element: myList){
            System.out.println(element);
        }
        */

        /*
        System.out.println();
        System.out.println("=================================");
        System.out.println("Remove element using enhanced for-loop - ConcurrentModificationException");
        for(String element: myList){
            System.out.println(element);
            if(element.equals("C")){
                myList.remove(element);
            }
        }
        */

        /*
        System.out.println();
        System.out.println("=================================");
        System.out.println("Remove element using enhanced for-loop - Fixed");
        List<String> toRemove = new ArrayList<>();
        for(String element: myList){
            if(element.equals("C")){
                toRemove.add(element);
            }
        }
        myList.removeAll(toRemove);
        printList(myList);
        */
    }


    public void printList(List<String> myList) {
        for (int i = 0; i < myList.size(); i++) {
            if (i == myList.size() - 1) {
                String element = myList.get(i);
                System.out.println(element);
            } else {
                String element = myList.get(i);
                System.out.print(element + ", ");
            }

        }
    }

}
