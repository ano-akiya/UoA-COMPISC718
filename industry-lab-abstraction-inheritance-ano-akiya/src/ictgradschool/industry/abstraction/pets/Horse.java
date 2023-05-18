package ictgradschool.industry.abstraction.pets;

/**
 * Represents a horse.
 *
 * TODO Make this implement IAnimal and IFamous, and provide appropriate implementations of those methods.
 */
public class Horse implements IAnimal, IFamous
{
    public String sayHello()
    {
        String greet = "";
        greet = "neigh";
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
        name = "Mr. Ed the horse";
        return name;
    }

    @Override
    public int legCount()
    {
        int number;
        number = 4;
        return number;
    }

    public String famous()
    {
        String output_famous_type = "";
        output_famous_type = "PharLap";
        return output_famous_type;
    }

}
