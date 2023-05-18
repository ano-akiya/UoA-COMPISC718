package ictgradschool.industry.abstraction.pets;

/**
 * Represents a Bird.
 *
 * TODO Correctly implement these methods, as instructed in the lab handout.
 */
public class Bird implements IAnimal {

    @Override
    public String sayHello()
    {
        String greet = "";
        greet = "tweet";
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
        name = "Tweety the bird";
        return name;
    }

    @Override
    public int legCount()
    {
        int number;
        number = 2;
        return number;
    }
}
