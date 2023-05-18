package ictgradschool.industry.io.ex04;

import ictgradschool.industry.io.ex03.Movie;
import ictgradschool.industry.io.ex03.MovieReader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by anhyd on 20/03/2017.
 */
public class Ex4MovieReader extends MovieReader {

    @Override
    protected Movie[] loadMovies(String fileName) {

        // TODO Implement this with a Scanner
        Movie[] movie_list = null;
        File open = new File(fileName);
        Scanner movie_file = null;
        int movie_num = 0;
        String content = "";

        try {
            movie_file = new Scanner(open);
            boolean has_next = true;

            String line = "";

        while (movie_file.hasNextLine())
            {
                line = movie_file.nextLine();
                System.out.println(line);
                content = content + line + ",";
                movie_num = movie_num + 1;
            }
        }
        catch (IOException e)
        {
            System.out.println("IO exception");
        }
        finally
        {
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
            try
            {
                movie_file.close();
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Movies loaded successfully from " + fileName + "!");
        return movie_list;

    }

    public static void main(String[] args) {
        new Ex4MovieReader().start();
    }
}
