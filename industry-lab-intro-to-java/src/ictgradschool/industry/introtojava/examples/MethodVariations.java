package ictgradschool.industry.introtojava.examples;

public class MethodVariations {

    // Methods can have no arguments, and return nothing (void):
    public void sayHello() {
        System.out.println("Hello, World!");
    }

    // Methods can take one or more arguments, and return nothing:
    public void sayHelloTwo(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Methods can have no arguments, and return something:
    public String getHello() {
        return "Hello, World!";
    }

    // Mthods can take one or more arguments, and return something.
    public String getHelloTwo(String name) {
        return "Hello, " + name + "!";
    }

    public void start(){
        // Calling a method that takes no arguments and returns nothing:
        sayHello();
        // Calling a method that takes a name as an argument:
        sayHelloTwo("Alice");
        // Calling a method that returns a String and storing the String in a variable
        String hello = getHello();
        // Outputting the String returned by the method call on the line above
        System.out.println(hello);
        String helloTwo = getHelloTwo("Bob");
        System.out.println(helloTwo);

    }

    public static void main(String[] args) {
        MethodVariations methodVariations = new MethodVariations();
        methodVariations.start();
    }

}
