package ictgradschool.industry.abstraction.farmmanager.animals;

import ictgradschool.industry.abstraction.pets.AnimalApp;

public class Chicken extends Animal implements  IProductionAnimal
{
    private final int  MAX_VALULE = 300;

    public Chicken()
    {
        value = 200;
    }

    public void feed()
    {
        if (this.value < MAX_VALULE)
        {
            this.value = value + (MAX_VALULE - value) / 2;
        }
    }

    public int costToFeed()
    {
        int feed_value = 3;
        return feed_value;
    }

    public String getType()
    {
        String type = "Chicken";
        return type;
    }
    public String toString()
    {
        return getType() + " - $" + value;
    }

    public boolean harvestable()
    {
        return true;
    }

    public int harvest()
    {
        int earn;
        if (harvestable())
        {
            earn = 5;
            return earn;
        }
        else
        {
            earn = 0;
            return earn;
        }
    }
}
