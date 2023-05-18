package ictgradschool.industry.abstraction.farmmanager.animals;

/**
 * This class defines a Cow. A cow has an initial value of $1000, and a maximum value of $1500.
 * The cost to feed a cow is $50.
 * You may modify this class according to the assignment.
 *
 * @author write your name and UPI here.
 */
public class Cow extends Animal implements IProductionAnimal{
    private final int MAX_VALUE = 1500;

    public Cow() {
        value = 1000;
    }

    public void feed() {
        if (value < MAX_VALUE) {
            value += 100;
        }
    }

    public int costToFeed() {
        return 60;
    }

    public String getType() {
        return "Cow";
    }

    public String toString() {
        return getType() + " - $" + value;
    }

    public boolean harvestable()
    {
        if (value == MAX_VALUE)
        {
            return true;
        }
        else if (value < MAX_VALUE)
        {
            return false;
        }
        return false;
    }

    public int harvest()
    {
        int earn;
        if (harvestable())
        {
            earn = 20;
            return earn;
        }
        else
        {
            earn = 0;
            return earn;
        }
    }

}
