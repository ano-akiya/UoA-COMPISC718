package ictgradschool.industry.abstraction.pets;

/**
 * Represents a dog.
 *
 * TODO Make this class implement the IAnimal interface, then implement all its methods.
 */
public class Dog implements IAnimal
{
    public String sayHello()
    {
        String greet = "";
        greet = "woof";
        return greet;
    }

    @Override
    public boolean isMammal()
    {
        return true;
    }

    @Override
    public String myName()
    {
        String name = "";
        name = "Bruno the dog";
        return name;
    }

    @Override
    public int legCount()
    {
        int number;
        number = 4;
        return number;
    }
}
