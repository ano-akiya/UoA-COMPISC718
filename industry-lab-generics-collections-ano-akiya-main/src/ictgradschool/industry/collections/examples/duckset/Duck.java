package ictgradschool.industry.collections.examples.duckset;

public class Duck implements Comparable<Duck>{
    private String name;
    private int numLegs, numWings;

    public Duck(String name, int numLegs, int numWings){
        this.name = name;
        this.numLegs = numLegs;
        this.numWings = numWings;
    }

    public String getName(){
        return this.name;
    }

    public int getNumLegs(){
        return this.numLegs;
    }

    public int getNumWings() {
        return numWings;
    }

    @Override
    public String toString(){
        return name + " duck has " + numLegs + " legs and " + numWings + " wings.";
    }

/*

    @Override
    public int compareTo(Duck other) {
        // Sorting the ducks by the name in alphabetical order.
        return this.name.compareTo(other.name);
    }
*/


    @Override
    public int compareTo(Duck other) {
    // Sorting the ducks by the number of legs in ascending order first. If the number of legs are the same, then sort by the name in alphabetical order.
        if(numLegs > other.numLegs){
            return -5;
        }else if(this.numLegs < other.numLegs){
            return  5;
        }else{
            return this.name.compareTo(other.name);
        }
    }


}