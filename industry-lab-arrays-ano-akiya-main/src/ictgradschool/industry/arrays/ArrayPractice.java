package ictgradschool.industry.arrays;

public class ArrayPractice {

    public int getSumOfPositiveIntegers(int[] integerArray)
    {
        // TODO: complete your code here
        int sum = 0;
        int count = 0;
        int length = integerArray.length;

        for (int i = 0; i < length; i++)
        {
            if (integerArray[i] > 0)
            {
                sum = sum + integerArray[i];
                count = count + 1;
            }
        }
        return sum / count;
    }

    public String getLongestString(String[] stringArray){
        // TODO: complete your code here
        String longest = "";
        int array_length = stringArray.length;
        int[] str_length = new int[array_length];

        String temp = "";
        for (int i = 0; i < array_length; i ++)
        {
            for (int j = i +1; j < array_length; j++)
            {
                if (stringArray[i].length() < stringArray[j].length())
                {
                    temp = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }
        longest = stringArray[0];
        for (int i = 1; i < array_length; i++)
        {
            if (stringArray[i].length() == stringArray[0].length())
            {
                longest = longest +", " + stringArray[i];
            }
        }
        return longest;
    }

    public void start(){
        int[] integerArray = new int[]{3, 56, 23, -4, -12, 34, 2, -7};
        int totalOfPositiveIntegers = getSumOfPositiveIntegers(integerArray);
        System.out.println("The sum of all positive integers is: " + totalOfPositiveIntegers);

        String[] animalArray = new String[]{"cat", "mouse", "pelican", "donkey", "dog", "horse"};
        String longestString = getLongestString(animalArray);
        System.out.println("The longest String in the array is: " + longestString);
    }

    public static void main(String[] args) {
        ArrayPractice arrayPractice = new ArrayPractice();
        arrayPractice.start();
    }

}
