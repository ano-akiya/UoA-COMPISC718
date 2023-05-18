package ictgradschool.industry.collections.examples.Collections;

public class Duck implements Comparable<Duck>{
    private int numLegs, numWings;

    public Duck(int numLegs, int numWings){
        this.numLegs = numLegs;
        this.numWings = numWings;
    }

    @Override
    public String toString(){
        return "This duck has " + numLegs + " legs and " + numWings + " wings.";
    }

    @Override
    public int compareTo(Duck other) {
        if(this.numLegs > other.numLegs){
            return 1;
        }else if(this.numLegs < other.numLegs){
            return  -1;
        }else{
            if(this.numWings > other.numWings){
                return 1;
            }else if(this.numWings < other.numWings){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
