package ictgradschool.industry.introtojava.examples;

public class MethodsExample {

    public void start(){

        int integerOne = 5;
        int integerTwo = 3;
        int highestInteger = Math.max(integerOne, integerTwo);
        System.out.println("The highest integer is: " + highestInteger);

        System.out.println("2 to the power of 3 is " + Math.pow(2, 3));
        System.out.println("8 to the power of 8 is " + Math.pow(2, 3));
        System.out.println("The square root of 64 is " + Math.sqrt(64));

    }

    public static void main(String[] args) {
        MethodsExample methodsExample = new MethodsExample();
        methodsExample.start();
    }

}
