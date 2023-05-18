package ictgradschool.industry.collections.examples.Generics;

public class Box {
    private Object stuff;

    public void set(Object stuff){
        this.stuff = stuff;
    }

    public Object get(){
        return stuff;
    }

    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();

        box1.set("Hello World");
        box2.set(new SteakSandwich());
        box3.set(new Tyrannosaurus());
        String myString = (String)box1.get();
        SteakSandwich mySandwich = (SteakSandwich)box2.get();
        Tyrannosaurus myTRex = (Tyrannosaurus)box3.get();

        System.out.println(myString);
        System.out.println(mySandwich);
        System.out.println(myTRex);

/*
      // Wrong type of objects are casted. Run-time error.
        String myString1 = (String)box3.get();
        SteakSandwich mySandwich1 = (SteakSandwich)box1.get();
        Tyrannosaurus myTRex1 = (Tyrannosaurus)box2.get();

        System.out.println(myString1);
        System.out.println(mySandwich1);
        System.out.println(myTRex1);
        */
    }
}
