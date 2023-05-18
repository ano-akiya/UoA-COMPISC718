package ictgradschool;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * A class that randomly generates names.
 */
public class NameGenerator {

    private List<String> namesList;

    /**
     * Creates the name generator by loading names.txt and reading all names from it into a set.
     * Then add the contents of that set to the namesList list.
     */
    public NameGenerator() {

        Set<String> names = new TreeSet<>();

        try (Scanner scanner = new Scanner(new File("names.txt"))) {

            while (scanner.hasNextLine()) {

                String name = scanner.nextLine();

                // This line removes everything from the name that's not a letter.
                // Normally, using trim() would work fine. However, the names.txt file I copy / pasted from a website
                // has some other random characters in it that aren't removed by the trim() function...
                name = name.replaceAll("[^A-Za-z]", "");

                names.add(name);

            }

        } catch (IOException e) {
            // This will not happen unless someone deleted names.txt by mistake or it's been corrupted.
            // If that happens, there's not much the user can do about it, so may as well just crash.
            throw new RuntimeException(e);
        }

        // We first assign to a Set because this will nicely remove duplicates for us.
        // We then add those elements to an ArrayList as its easier to pick an element at random from a List
        // rather than a Set.
        this.namesList = new ArrayList<>(names);

    }

    /**
     * Gets a random name from the set.
     * @return a name
     */
    public String getRandomName() {
        return this.namesList.get((int)(Math.random() * this.namesList.size()));
    }

}
