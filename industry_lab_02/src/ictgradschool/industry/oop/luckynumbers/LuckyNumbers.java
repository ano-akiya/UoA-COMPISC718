package ictgradschool.industry.oop.luckynumbers;

/**
 * Write a program which generates 2 random integers between 25 and 30 (inclusive),
 * then uses Math.min() and Math.max() to display them in descending sequence.
 */
public class LuckyNumbers {
    /**
     * TODO Your code here. You may also write additional methods if you like.
     */
    private void start()
    {
        int min = 25;
        int max = 30;
        int random1 = 0;
        int random2 = 0;

        random1 = (int) (Math.random() * (max - min + 1) + min);
        random2 = (int) (Math.random() * (max - min + 1) + min);

        System.out.println("Your lucky number is " + Math.min(random1,random2) + " and " + Math.max(random1,random2));
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {

        LuckyNumbers ex = new LuckyNumbers();
        ex.start();

    }
}
