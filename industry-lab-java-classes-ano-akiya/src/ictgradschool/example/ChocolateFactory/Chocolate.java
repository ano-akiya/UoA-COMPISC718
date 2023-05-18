package ictgradschool.example.ChocolateFactory;

import java.util.Objects;

public class Chocolate {
    private int code;
    private String description;
    private double price;

    public Chocolate(int code, String description, double price){
        this.code = code;
        this.description = description;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void setDescription(String desc) {
        description = desc;
    }
    public void assignRandomCode(int code) {
        code = (int)(Math.random() * 1000);
    }

    public void print(){
        System.out.println("Description: " + description +", Price: $" + price);
    }

    @Override
    public String toString() {
        return "This Chocolate " + description + " is delicious.";
    }

    @Override
    public boolean equals(Object other) {
       if(other instanceof Chocolate){
           Chocolate otherC = (Chocolate) other;
           return this.price == otherC.price && this.description.equals(otherC.description) && this.code == otherC.code;
       }

       return false;
    }

}
