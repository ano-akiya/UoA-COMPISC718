package ictgradschool.industry.collections.ex03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExerciseThree_Lists {

    /**
     * Tests the union, intersection, and difference methods using some dummy data.
     *
     * You shouldn't need to edit this class, other than to uncomment two lines once you've implemented those methods.
     */
    private void start() {

        // Tip: You can make hardcoded lists in one lin like this! HOWEVER! If you try to add() extra items to these
        // lists, it will fail.
        // See: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html#asList(T...)
        List<String> testList1 = Arrays.asList("A", "B", "C");
        List<String> testList2 = Arrays.asList("A", "D", "E");

        // Should print [A, B, C, A, D, E]
        // Note #1: Arrays.toString() returns a nice String representation of any array for us to print.
        // Note #2: List.toArray() will return an Object[] array containing all the elements in our list.
        System.out.println(Arrays.toString(union(testList1, testList2).toArray()));

        // Should print [A]
        // TODO Uncomment this line once you've completed the intersection method
        System.out.println(Arrays.toString(intersection(testList1, testList2).toArray()));

        // Should print [B, C]
        // TODO Uncomment this line once you've completed the difference method
        System.out.println(Arrays.toString(difference(testList1, testList2).toArray()));

    }


    /**
     * Returns a list that contains all elements in the first list plus all elements in the second list.
     *
     * @param list1 the first list
     * @param list2 the second list
     * @return the result list
     */
    private List<String> union(List<String> list1, List<String> list2) {

        List<String> result = new ArrayList<>();

        // TODO Add all items from list1 and list2 to the result
        Iterator<String> iterator1 = list1.iterator();
        Iterator<String> iterator2 = list2.iterator();

        while (iterator1.hasNext())
        {
            String temp = "";
            temp = iterator1.next();
            result.add(temp);
        }

        while (iterator2.hasNext())
        {
            String temp = "";
            temp = iterator2.next();
            result.add(temp);
        }
        return result;
    }

    // TODO Write an intersection method
    private List<String> intersection(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++)
        {
            String temp1 = "";
            temp1 = list1.get(i);
            for (int j = 0; j < list2.size(); j++)
            {
                String temp2 = "";
                temp2 =list2.get(j);
                if (temp1 == temp2)
                {
                    result.add((temp1));
                    break;
                }
            }
        }
        return result;
    }

    // TODO Write a difference method
    private List<String> difference(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        ArrayList<Integer> same = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++)
        {
            String temp1 = "";
            temp1 = list1.get(i);
            for (int j = 0; j < list2.size(); j++)
            {
                String temp2 = "";
                temp2 = list2.get(j);
                if (temp1 == temp2)
                {
                    same.add(j);
                }
            }
        }

        for (int i = 0; i < list1.size(); i++)
        {
            String temp1 = "";
            temp1 = list1.get(i);
            for (int j = 0; j < same.size(); j++)
            {
                if (temp1 != list1.get(same.get(j)))
                {
                    result.add(temp1);
                }
            }
        }
        return result;
    }


    /**
     * Program entry point. Do not edit.
     */

    public static void main(String[] args) {
        new ExerciseThree_Lists().start();
    }

}
