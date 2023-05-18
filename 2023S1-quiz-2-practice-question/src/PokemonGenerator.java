public class PokemonGenerator {

    private Pokemon[] pokemons;

    public static void main(String[] args) {
        PokemonGenerator pokemonGenerator = new PokemonGenerator();
        pokemonGenerator.start();
    }

    // TODO Step i. Create the generateRandomLevel() method.

    public int generateRandomLevel()
    {
        int random;
        random =(int) Math.random() * 5 + 1;
        return random;

    }
    // TODO Step iii a. Create the printPokemonGreetings() method.
    public void printPokemonGreetings(Pokemon[] pokemons)
    {
        for (int i = 0; i < pokemons.length; i ++)
        {
            System.out.println("I am " + pokemons[i].getName()+ ", my current level is " + pokemons[i].getLevel());
        }
    }
    // TODO Step iv a. Create the printWaterPokemon() method.
    public void printWaterPokemon(Pokemon[] pokemons)
    {
        for (int i = 0; i < pokemons.length; i ++)
        {
            if (pokemons[i].getType() instanceof WaterType)
            {
                System.out.println("I say \"" + ((INoise) pokemons[i]).makeNoise() + "\" when I attack!");
                System.out.println("I say \"" + (pokemons[i]).getName() + "\" when I attack!");
            }
        }
    }


    public void start(){

        // TODO Step ii. Create 4 different types of Pokemon and add them to the pokemons array. Each one should have a random level.

        pokemons = new Pokemon[4];
        pokemons[0] = new Squirtle("Squirtle",generateRandomLevel());
        pokemons[1] = new Charmander("Charmander",generateRandomLevel());
        pokemons[2] = new Pikachu("Pikachu",generateRandomLevel());
        pokemons[3] = new Psyduck("Psyduck",generateRandomLevel());


        System.out.println("Greetings from Pokemon");
        System.out.println("====================");

        // TODO Step iii b. Appropriately call the printPokemonGreetings() method.
        printPokemonGreetings(pokemons);

        System.out.println("====================");
        System.out.println();

        System.out.println("Water Pokemon show-off time");
        System.out.println("-------------------------------");

        // TODO Step iv b. Appropriately call the printWaterPokemon() method.
        printWaterPokemon(pokemons);

        System.out.println("-------------------------------");
        System.out.println();

        System.out.println("Random attack time!");
        System.out.println("-------------------");

        // TODO Step v. Randomly generate an display three attacks.
        int count = 0;
        while (count < 4)
        {
            int random_one =(int) (Math.random() * 4);
            int random_two = (int) (Math.random() * 4);
            if (random_one != random_two)
            {
                count = count + 1;
                System.out.println(pokemons[random_one].getName() + " attacked " + pokemons[random_two]);
                pokemons[random_one].attack(pokemons[random_two]);
            }
        }

        System.out.println("-------------------");
        System.out.println();

        System.out.println("Pokemons' status after the attacks");
        System.out.println("==================================");
        // TODO Step iii b. Appropriately call the printPokemonGreetings() method.

        printPokemonGreetings(pokemons);

        System.out.println("==================================");

    }

}
