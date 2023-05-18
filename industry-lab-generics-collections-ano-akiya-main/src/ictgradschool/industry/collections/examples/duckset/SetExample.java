package ictgradschool.industry.collections.examples.duckset;


import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        SetExample app = new SetExample();
        app.start();
    }

    private void start() {

        System.out.println();
        System.out.println("HashSet example");
        Set<Duck> DuckHashSet = new HashSet<>();

        Duck d = new Duck("Daffy Duck",5,5);
        DuckHashSet.add(d);
        DuckHashSet.add(new Duck("Huey",2,2));
        DuckHashSet.add(new Duck("Donald Duck",4,4));
        DuckHashSet.add(new Duck("Scrooge McDuck",6,6));
        DuckHashSet.add(new Duck("Dewey",2,8));
        printDuckSet(DuckHashSet);

        /*
        System.out.println();
        System.out.println("=================================");
        System.out.println("Set remove");
        Iterator<Duck> myIterator = DuckHashSet.iterator();
        while(myIterator.hasNext()){
            Duck currentDuck = myIterator.next();
            if(currentDuck == d){
                myIterator.remove();
            }
        }
        printDuckSet(DuckHashSet);
        */

        System.out.println();
        System.out.println("=================================");
        System.out.println("TreeSet example");
        Set<Duck> DuckTreeSet = new TreeSet<>();
        DuckTreeSet.add(new Duck("Daffy Duck",5,5));
        DuckTreeSet.add(new Duck("Huey",2,2));
        DuckTreeSet.add(new Duck("Donald Duck",4,4));
        DuckTreeSet.add(new Duck("Scrooge McDuck",6,6));
        DuckTreeSet.add(new Duck("Dewey",2,8));
        printDuckSet(DuckTreeSet);

    }



    public void printDuckSet(Set<Duck> set){
        for(Duck duck : set){
            System.out.println(duck);
        }
    }
}
