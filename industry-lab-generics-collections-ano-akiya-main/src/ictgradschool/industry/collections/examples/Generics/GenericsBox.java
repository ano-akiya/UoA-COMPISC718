package ictgradschool.industry.collections.examples.Generics;

public class GenericsBox<T> {
    private T thing;

    public void set(T thing){
        this.thing = thing;
    }

    public T get(){
        return thing;
    }

    public static void main(String[] args) {
        GenericsBox<String> box1 = new GenericsBox<String>();
        GenericsBox<SteakSandwich> box2 = new GenericsBox<>();
        GenericsBox<Tyrannosaurus> box3 = new GenericsBox<>();

        box1.set("Hello World");
        box2.set(new SteakSandwich());
        box3.set(new Tyrannosaurus());

        String myString = box1.get();
        SteakSandwich mySandwich = box2.get();
        Tyrannosaurus myTRex = box3.get();

        System.out.println(myString);
        System.out.println(mySandwich);
        System.out.println(myTRex);

/*
        // Wrong type of objects are passed in the box. Compile-time error.
        // Type checking at compile time - safer
        box1.set("Hello World");
        box2.set(new Tyrannosaurus());
        box3.set(new SteakSandwich());

        String myString2 = box2.get();
        SteakSandwich mySandwich2 = box3.get();
        Tyrannosaurus myTRex2 = box1.get();
        */
    }
}
