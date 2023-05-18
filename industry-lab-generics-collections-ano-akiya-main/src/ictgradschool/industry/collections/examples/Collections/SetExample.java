package ictgradschool.industry.collections.examples.Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        SetExample app = new SetExample();
        app.start();
    }

    private void start() {

        System.out.println("Set example");
        Set<String> mySet = new HashSet<>();
        System.out.println(mySet.add("A"));
        System.out.println(mySet.add("B"));
        System.out.println(mySet.add("A"));
        System.out.println();

        for(String s : mySet){
            System.out.println(s);
        }

        /*
        System.out.println();
        System.out.println("=================================");
        System.out.println("Set example2");
        Set<Duck> myDuckSet = new HashSet<>();
        //Set<Duck> myDuckSet = new TreeSet<>();
        Duck d = new Duck(5,5);
        myDuckSet.add(d);
        myDuckSet.add(new Duck(2,2));
        myDuckSet.add(new Duck(4,4));
        myDuckSet.add(new Duck(6,6));
        myDuckSet.add(new Duck(2,8));

        for(Duck duck : myDuckSet){
            System.out.println(duck);
        }
        */

        /*
        System.out.println();
        System.out.println("=================================");
        System.out.println("Set remove");
        Iterator<Duck> myIterator = myDuckSet.iterator();
        while(myIterator.hasNext()){
            Duck currentDuck = myIterator.next();
            if(currentDuck == d){
                myIterator.remove();
            }
        }

        for(Duck duck : myDuckSet){
            System.out.println(duck);
        }
        */
    }
}
