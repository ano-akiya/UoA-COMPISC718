package ictgradschool.industry.abstraction.pets;

/**
 * Main program.
 */
public class AnimalApp {

    public void start() {


        IAnimal[] animals = new IAnimal[3];

        // TODO Populate the pets array with a Bird, a Dog and a Horse.
        animals[0] = new Bird();
        animals[1] = new Dog();
        animals[2] = new Horse();

        processAnimalDetails(animals);

    }

    private void processAnimalDetails(IAnimal[] list) {
        // TODO Loop through all the pets in the given list, and print their details as shown in the lab handout.
        // TODO If the animal also implements IFamous, print out that corresponding info too.
        for (int i = 0; i < list.length; i++)
        {
            String output_line_one = "";
            output_line_one = list[i].myName() + " says " + list[i].sayHello() + " " + list[i].sayHello() + ".";
            System.out.println(output_line_one);

            String output_line_two = "";
            if (list[i].isMammal())
            {
                output_line_two = list[i].myName() + " is a mammal.";
                System.out.println(output_line_two);
            }
            else
            {
                output_line_two = list[i].myName() + " is not a mammal.";
                System.out.println(output_line_two);
            }

            String output_line_three = "";
            output_line_three = "Did I forget to tell you that I have " + Integer.valueOf(list[i].legCount()) + " legs.";
            System.out.println(output_line_three);

            if (list[i] instanceof IFamous)
            {
                String output_line_four = "";
                output_line_four = "This is a famous name of my animal type: " + (((IFamous) list[i]).famous());
                System.out.println(output_line_four);
            }

        }
    }

    public static void main(String[] args) {
        new AnimalApp().start();
    }
}
