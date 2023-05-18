package example.pokemons;

/**
 * Created by ytu001 on 14/11/2017.
 */
public class Pokemon {

    private String colour;
    private boolean hasShell;
    private int healthPoints;
    private int evolutionStage;
    private String name;


    /** The constructor of Pokemon class
     *  It takes four arguments and assign the values to the instance variables
     *  The healthPoints are randomly assigned between 100 - 200 points
     */
    public Pokemon(String name, boolean hasShell, String colour, int evolutionStage) {
        this.name = name;
        this.hasShell = hasShell;
        this.colour = colour;
        this.evolutionStage = evolutionStage;
        this.healthPoints = (int)(Math.random() * 101) + 100;
    }


    /**
     * The pokemon is underAttacked.The pokemon will lose 'damage' amount of healthPoints
     * If the pokemon healthPoints is negative, 'Game Over' message will be printed
     * @param damage The amount of damaged healthPoints
     */
    public void underAttack(int damage) {
        healthPoints -= damage;
        System.out.println(this.name + " loses " + damage + " points");
        if (healthPoints < 0) {
            System.out.println("Game Over!");
        }
    }


    /**
     * The pokemon is attacking the 'other' pokemon
     * It can cause 0 - 150 points damage that are randomly generated
     * This method calls other.underAttack method to perform the attacking action
     * @param other The underattacked pokemon
     */
    public void attack(Pokemon other) {
        int attackingPoints = (int)(Math.random() * 150);
        if(!this.equals(other)) {
            other.underAttack(attackingPoints);
        } else{
            System.out.println("Pokemon does not attack itself");
        }
    }


    /**
     * This method compares the name of the 'other' pokemon with the current pokemon
     * to determine if they are the same object.
     * @param other The other object is passing in for comparison.
     * @return A boolean to show if the two pokemons are the same
     */
    public boolean equals(Object other) {
        if (other instanceof Pokemon) {
            Pokemon otherPokemon = (Pokemon)other;
            if (this.name.equals(otherPokemon.name)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return A String representation of the current pokemon
     */

    public String toString() {
        String healthStatus = "good";
        if (healthPoints < 0) {
            healthStatus = "very bad";
        }
        return "I am " + name + ", and my health is " + healthStatus + " (" + healthPoints + ")";
    }
}
