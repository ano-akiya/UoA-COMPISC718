package ictgradschool.industry.abstraction.farmmanager;

import ictgradschool.industry.abstraction.farmmanager.animals.Cow;
import ictgradschool.industry.abstraction.farmmanager.animals.Animal;
import ictgradschool.industry.abstraction.farmmanager.animals.*;

import java.util.Arrays;

/**
 * This class consists of methods for the farm operations.
 *
 * @author Write your name and UPI here.
 */
public class Farm {
    private Animal[] animals;
    private final int STARTING_MONEY;
    private int money;

    /**
     * Constructor of Farm
     *
     * @param money The amount of money for starting the farm
     */
    public Farm(int money) {
        // TODO Complete the constructor so that money and STARTING_MONEY are
        // TODO initialised to the money from the constructor, and the pets array is
        // TODO big enough to hold 10 Animal objects.
        this.money = money;
        this.STARTING_MONEY = money;
        this.animals = new Animal[10];
    }

    /**
     * Constructor of Farm. The default starting money is $10000.
     */
    public Farm() {
        this(10000);
    }

    /**
     * Returns how much money the farm currently has.
     *
     * @return amount of money the farm currently has.
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Returns how much money the farm started with.
     */
    public int getStartingMoney() {
        return this.STARTING_MONEY;
    }

    /**
     * Purchases an animal and bills the farm for it.
     *
     * @param animalType The name of the type of animal you wish to buy.
     * @return true if the animal can be bought, otherwise false.
     */
    public boolean buyAnimal(String animalType) {
        Animal newAnimal = getAnimal(animalType);
        // Returns false if the animal type does not exist
        if (newAnimal == null) {
            return false;
        }
        // Calculates the price of the new animal
        int price = (int) (newAnimal.getValue() * 1.15);

        // Returns false if you have insufficient funds
        if (money < price) {
            return false;
        }

        // TODO Go through the pets array, and add the new animal
        // TODO to the pets array if the pets array is not already full.
        // TODO Also, deduct the animal price from money once the new animal has been
        // TODO added to the pets array.
        for (int i = 0; i < animals.length; i ++)
        {
            if (animals[i] == null)
            {
                animals[i] = newAnimal;
                this.money = money - price;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an Animal object based on the given animal type.
     *
     * @param animalType name of the animal type.
     * @return an Animal object if the given animal type exists, otherwise null.
     */
    private Animal getAnimal(String animalType) {
        switch (animalType.toLowerCase()) {
            case "cow":
                return new Cow();
            case "chicken":
                return new Chicken();
            default:
                // Animal type does not exist;
                return null;
        }
    }

    /**
     * Sells all of the pets on the farm.
     *
     * @return the total price of all the pets on the farm.
     */
    public int sell() {
        // Calculate the value of all of your pets
        int totalPrice = 0;

        for (int i = 0; i < animals.length; i++) {
            Animal a = animals[i];
            if (a == null) {
                break;
            }
            totalPrice += a.getValue();
        }

        // Remove the pets from your farm and add their values to your money.
        // Using java.util.Arrays to set all elements in pets to null.
        Arrays.fill(animals, null);
        money += totalPrice;
        return totalPrice;
    }

    /**
     * Feeds all pets on the farm.
     */
    public void feedAll() {
        for (int i = 0; i < animals.length; i++) {
            Animal a = animals[i];
            // Stop going through if there is no more animal
            if (a == null) {
                break;
            }
            // See if you have enough money
            if (money >= a.costToFeed()) {
                // Subtract the cost to feed the animal
                money = money - a.costToFeed();
                a.feed();
            }
        }
    }

    /**
     * Feeds all pets of the type specified on the farm.
     */
    public void feed(String animalType) {
        // TODO Go through the pets array, and feed each animal of the type specified
        // TODO if you have enough money to feed it. When you fed an animal, don't forget to subtract
        // TODO the cost to feed from the money you have on the farm, and call the feed method on the
        // TODO animal.
        for (int i = 0; i < animals.length; i ++)
        {
            if ((animals[i].getType()).equals(animalType))
            {
                this.money = money - animals[i].costToFeed();
            }
            else if (animals[i] == null)
                break;
        }
    }

    /**
     * Prints information for all pets on the farm.
     */
    public void printStock() {
        // TODO Go through the pets array, and print information for each animal on the farm.
        // TODO If there are no pets on the farm, simply print "No pets on the farm!"
        if (animals[0] == null)
        {
            System.out.println("No animals on the farm!");
        }
        for (int i = 0; i < animals.length; i ++)
        {
            if (animals[i] == null)
            {
                break;
            }
            else
            {
                System.out.println(animals[i].toString());
            }
        }
    }

    /**
     * Harvests products from all pets that can produce products such as milk.
     */
    public void harvestAll() {
        // TODO Go through the pets array, and harvest the product from each animal on the farm
        // TODO if the animal is an instance of IProductionAnimal and it is harvestable. When you have harvested an
        // TODO animal, don't forget to increase the money you have on the farm with the money you made.
        for (int i = 0; i < animals.length; i ++)
        {
            if (animals[i] instanceof IProductionAnimal)
            {
                if (((IProductionAnimal)animals[i]).harvestable())
                {
                    this.money = money + ((IProductionAnimal)animals[i]).harvest();
                }
            }
        }
    }
}
