package ictgradschool.industry.collections.ex02;

import java.util.*;


public class ArrayOfString {
    public void start(){
        String[] array = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN"};

        ArrayList<String> newArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++)
        {
            newArray.add(array[i]);
        }

        Iterator<String> iterator = newArray.iterator();

        ArrayList<String> refresh = new ArrayList<>();
        while (iterator.hasNext())
        {
            String temp = "";
            temp = iterator.next();
            temp = temp.toLowerCase();
            refresh.add(temp);
            System.out.println(refresh);
        }
    }

    public static void main(String[] args) {
        new ArrayOfString().start();
    }

}
