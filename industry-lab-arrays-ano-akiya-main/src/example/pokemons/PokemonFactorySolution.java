package example.pokemons;

public class PokemonFactorySolution {
    public static void main(String[] args) {
        /** TODO: Creating three pokemons: pikachu, dragonite and kouffing
         *        All three do not have shells.
         *        You can pick your own colors and evolution stage (1 - 3)
         */
        Pokemon pikachu = new Pokemon("Pikachu", false, "yellow", 1);
        Pokemon dragonite = new Pokemon("Dragonite", false, "mustard", 3);
        Pokemon kouffing = new Pokemon("Kouffing", false, "purple", 1);

        // TODO: Creating an array of size 3 to store pokemons
        Pokemon[] pokemons = new Pokemon[3];

        // TODO: Assign each element of the pokemons array
        pokemons[0] = pikachu;
        pokemons[1] = dragonite;
        pokemons[2] = kouffing;

        System.out.println("****************************************************");
        System.out.println("Introducing pokemons: ");
        // TODO: Print message at the console to see the status of the 3 pokemons that have been created
        for (int i = 0; i < pokemons.length; i++) {
            System.out.println(pokemons[i]);
        }
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("All pokemons in the array are attacking dragonite");
        System.out.println();
        // TODO: Using a for loop for all pokemons to attack draonite
        for (int i = 0; i < pokemons.length; i++) {
            pokemons[i].attack(dragonite);
        }
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("Dragonite fights back");
        System.out.println();
        // TODO: dragnoite is attacking pikachu
        dragonite.attack(pikachu);
        // TODO: dragnoite is attacking kouffing
        dragonite.attack(kouffing);
        System.out.println();

        System.out.println("****************************************************");
        System.out.println("The health status of each pokemon");
        // TODO: Print message at the console to check the health status of each pokemon
        for (int i = 0; i < pokemons.length; i++) {
            System.out.println(pokemons[i]);
        }
    }
}
