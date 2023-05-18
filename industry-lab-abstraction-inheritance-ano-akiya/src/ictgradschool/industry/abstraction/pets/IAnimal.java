package ictgradschool.industry.abstraction.pets;

/**
 * An interface intended to be implemented by pets, who have legs, a name,
 * may or may not be mammals, and can say hello.
 */
public interface IAnimal {

    /**
     * Returns a string containing the greeting
     */
    public String sayHello();

    /**
     * Returns true or false
     */
    public boolean isMammal();

    /**
     * Returns the name, followed by “the” followed by the animal type, e.g. “George the Monkey”
     */
    public String myName();

    /**
     * Returns the number of legs
     */
    public int legCount();

}
