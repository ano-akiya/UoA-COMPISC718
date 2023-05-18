package ictgradschool.industry.io.ex04;

import ictgradschool.industry.io.ex03.Movie;
import ictgradschool.industry.io.ex03.MovieWriter;

import java.io.*;

/**
 * Created by anhyd on 20/03/2017.
 */
public class Ex4MovieWriter extends MovieWriter {

    @Override
    protected void saveMovies(String fileName, Movie[] films) {

        // TODO Implement this with a PrintWriter
        File open= new File(fileName);
        PrintWriter movie = null;
        try
        {
            movie = new PrintWriter(open);
            for (int i = 0; i < films.length; i ++)
            {
                String name = films[i].getName();
                int year = films[i].getYear();
                int lengthInMinutes = films[i].getLengthInMinutes();
                String director = films[i].getDirector();
                movie.write( name + "," +  String.valueOf(year) + "," + String.valueOf(lengthInMinutes) + "," + director + "\n");
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
                movie.close();
            }
            catch(Exception e)
            {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Movies saved successfully to " + fileName + "!");
    }

    public static void main(String[] args) {
        new Ex4MovieWriter().start();
    }

}
