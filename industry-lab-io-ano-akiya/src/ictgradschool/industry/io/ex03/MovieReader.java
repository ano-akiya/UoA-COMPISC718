package ictgradschool.industry.io.ex03;

import ictgradschool.Keyboard;
import java.io.*;
import java.lang.*;

/**
 * Created by anhyd on 20/03/2017.
 */
public class MovieReader {

    public void start() {


        // Get a file name from the user
        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();

        // Load the movie data
        Movie[] films = loadMovies(fileName);

        // Do some stuff with the data to check that its working
        printMoviesArray(films);
        Movie mostRecentMovie = getMostRecentMovie(films);
        Movie longestMovie = getLongestMovie(films);
        printResults(mostRecentMovie, longestMovie);
        System.out.println();
        printDirector("Searching for Sugar Man", films);
        printDirector("Liberal Arts", films);
        printDirector("The Intouchables", films);

    }

    /**
     * Reads movies from a file.
     *
     * @param fileName
     * @return
     */
    protected Movie[] loadMovies(String fileName) {

        // TODO Implement this method
        Movie[] movie_list = null;
        File open = new File(fileName);
        DataInputStream movie_file = null;
        int movie_num = 0;
        try
        {
            movie_file = new DataInputStream(new FileInputStream(open));
            boolean has_next = true;

            String line = null;
            String content = null;
            while (has_next)
            {
                if ((line = movie_file.readLine()) != null)
                {
                    content = content + line + ",";
                    movie_num = movie_num + 1;

                }
                else
                {
                    has_next = false;
                }
            }
            movie_list = new Movie[movie_num];
            String[] element = new String[movie_num * 4];
            element = content.split(",");
            String[] name = new String[movie_num];
            int[] year = new int[movie_num];
            int[] lengthInMinutes = new int[movie_num];
            String[] director = new String[movie_num];

            for (int i = 0; i < movie_num ; i++)
            {
                name[i] = element[i * 4];
                year[i] = Integer.parseInt(element[i * 4 + 1]);
                lengthInMinutes[i] = Integer.parseInt(element[i * 4 + 2]);
                director[i] = element[i * 4 + 3];
                movie_list[i] = new Movie(name[i], year[i], lengthInMinutes[i], director[i]);
            }
        }
        catch (IOException e)
        {
            System.out.println("IO exception");
        }
        finally
        {
            try
            {
                movie_file.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Movies loaded successfully from " + fileName + "!");
        return movie_list;
    }

    private void printMoviesArray(Movie[] films) {
        System.out.println("Movie Collection");
        System.out.println("================");
        // Step 2.  Complete the printMoviesArray() method
        for(int i = 0; i<films.length; i++){
            System.out.println(films[i].toString());
        }
    }
    private Movie getMostRecentMovie(Movie[] films) {
        // Step 3.  Complete the getMostRecentMovie() method.
        Movie temp=null;
        for(int i = 1; i<films.length; i++){
            if(films[i].isMoreRecentThan(films[i-1])){
                temp = films[i];
            }
        }
        return temp;
    }
    private Movie getLongestMovie(Movie[] films) {
        // Step 4.  Complete the getLongest() method.
        Movie temp=null;
        for(int i = 1; i<films.length; i++){
            if(films[i].isLongerThan(films[i-1])){
                temp = films[i];
            }
        }
        return temp;
    }
    private void printResults(Movie mostRecent, Movie longest) {
        System.out.println();
        System.out.println("The most recent movie is: " + mostRecent.toString());
        System.out.println("The longest movie is: " + longest.toString());
    }
    private void printDirector(String movieName, Movie[] movies) {
        // Step 5. Complete the printDirector() method
        for(int i = 0; i<movies.length; i++){
            if(movieName.equals(movies[i].getName())){
                System.out.println(movieName + " was directed by " + movies[i].getDirector());
                return;
            }
        }
        System.out.println(movieName + " is not in the collection.");
    }

    public static void main(String[] args) {
        new MovieReader().start();
    }
}
