package gamedata;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.*;
import java.util.*;

/**
 * This class imports the games.csv file, and prints games from the collection.
 * 
 * @author Yu-Cheng Tu
 *
 */
public class GameCollector {
	List<Game> games;

	/**
	 * This is the main method, do not modify this.
	 */
	public static void main(String[] args) {
		GameCollector gc = new GameCollector();

		String currentDir = System.getProperty("user.dir");
		gc.processFile(currentDir + "/games.csv");

		System.out.println("The first 5 games");
		System.out.println("===================");
		gc.printFirstFiveGames();
		System.out.println("===================");

		System.out.println("Number of Action games in the collection: " + gc.getNumberOfGamesByGenre(Genre.ACTION));
		System.out.println("Number of Puzzle games in the collection: " + gc.getNumberOfGamesByGenre(Genre.PUZZLE));
		System.out.println("Number of Role-Playing games in the collection: " + gc.getNumberOfGamesByGenre(Genre.RPG));
		System.out.println("Number of Sports games in the collection: " + gc.getNumberOfGamesByGenre(Genre.SPORTS));
		System.out.println("===================");

		System.out.println("The top 10 games by year and publisher");
		System.out.println("===================");
		gc.printTopTenSortedGames();
		System.out.println("===================");

		gc.exportSortedGames(currentDir + "/sortedGames.csv");

		System.out.println("Number of games per year");
		System.out.println("===================");
		Map<Integer, Integer> numOfGamesPerYear = gc.getCountOfGamesPerYear();
		gc.printGamesPerYear(numOfGamesPerYear);
	}

	private void printGamesPerYear(Map<Integer, Integer> numOfGamesPerYear) {
		Set<Integer> years = numOfGamesPerYear.keySet();
		for (Integer year : years) {
			System.out.printf("Games:%-5d Year: %4d%n", numOfGamesPerYear.get(year), year);
		}

	}

	// step c i.
	private int checkYear(String yearStr) throws InvalidYearException, GameInFutureException
	{
		int year = 0;
		if (yearStr.equals(""))
		{
			year = 2016;
		}
		else{
			try
			{
				year = Integer.parseInt(yearStr);
				if(year < 1950)
				{
					throw new InvalidYearException("The game is too old!");
				}
				else if (year > 2016)
				{
					throw new GameInFutureException("The game is too new!");
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid year format!");
			}
		}
		return year;
	}

	// step c ii.
	private Genre getGenre(String genre)
	{
		genre = genre.toLowerCase();
		if (genre.equals("action"))
		{
			return Genre.ACTION;
		}
		else if (genre.equals("misc"))
		{
			return Genre.MISC;
		}
		else if (genre.equals("sports"))
		{
			return Genre.SPORTS;
		}
		else if (genre.equals("role-playing"))
		{
			return Genre.RPG;
		}
		else if (genre.equals("puzzle"))
		{
			return Genre.PUZZLE;
		}
		else {
			return Genre.OTHER;
		}
	}

	// step c iii.
	private Game processGameDetails(String[] gameDetails) throws InvalidYearException, GameInFutureException{
		try{
			int id = Integer.parseInt(gameDetails[0]);
			String game = gameDetails[1];
			String platform = gameDetails[2];
			int year = checkYear(gameDetails[3]);
			Genre genre = getGenre(gameDetails[4]);
			String publisher = gameDetails[5];
			if(year < 1950)
			{
				throw new InvalidYearException("The game is too old!");
			}
			if (year > 2016)
			{
				throw new GameInFutureException("The game is too new!");
			}
			return new Game(id, game, platform, year, genre, publisher);
		}
		catch(Exception e)
		{
			System.out.println("Invalid year format!");
			throw e;
		}
	}

	// step c iv.
	private void processFile(String filePath) {
		File file = new File(filePath);
		games = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line;
			line = reader.readLine();
			while ((line = reader.readLine()) != null)
			{
				String[] data = line.split(",");
				Game new_game = processGameDetails(data);
				games.add(new_game);
			}
		}
		catch(Exception e)
		{
			System.out.println("err: " + e);
		}
	}

	// step c v.
	private void printFirstFiveGames() {
		int num = 5;
		for (int i = 0; i < num; i ++)
		{
			Game game = games.get(i);
			String name = game.getName();
			int id = game.getId();
			String publisher = game.getPublisher();
			int year = game.getYear();
			System.out.println("The game \" " + name + " \" (id: " + id + ") was released by \" " + publisher + " \" in " + year);
		}
	}

	// step c vi.
	private int getNumberOfGamesByGenre(Genre genre) {
		return 0;
	}

	// step c vii.
	private void printTopTenSortedGames() {
		List<Game> new_list = new ArrayList<>();
		for (int i = 0; i < games.size(); i++)
		{
			new_list.add(games.get(i));
		}
		Collections.sort(new_list);

		int num = 10;
		for (int i = 0; i < num; i++)
		{
			Game game = new_list.get(i);
			String name = game.getName();
			int id = game.getId();
			String publisher = game.getPublisher();
			int year = game.getYear();
			System.out.println("The game \" " + name + " \" (id: " + id + ") was released by \" " + publisher + " \" in " + year);
		}
	}



	// step c viii.
	private void exportSortedGames(String filePath) {
		List<Game> game_list = new ArrayList<>();
		for (int i = 0; i < games.size(); i++)
		{
			game_list.add(games.get(i));
		}

		File file = new File(filePath);
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
		{
			String[] name = new String[game_list.size()];
			int[] year = new int[game_list.size()];
			String[] publisher = new String[game_list.size()];
			for (int i = 0; i < game_list.size(); i++)
			{
				name[i] = game_list.get(i).getName();
				year[i] = game_list.get(i).getYear();
				publisher[i] = game_list.get(i).getPublisher();
			}

			for (int i = 0; i < game_list.size(); i++)
			{
				writer.write("Game name: " + name[i] + ", year: " + year[i] + ", publisher: " + publisher[i]);
				writer.newLine();
				writer.flush();
			}
		}
		catch(Exception e)
		{
			System.out.println("err: " + e);
		}
	}

	// step c ix.
	private Map<Integer, Integer> getCountOfGamesPerYear() {
		List<Game> game_list = new ArrayList<>();
		for (int i = 0; i < games.size(); i++)
		{
			game_list.add(games.get(i));
		}

		Map<Integer, Integer> yearCounter = new TreeMap<>();
		for (int i = 0; i < game_list.size(); i++)
		{
			int year = game_list.get(i).getYear();
			if (yearCounter.containsKey(year))
			{
				int counter = yearCounter.get(year);
				yearCounter.replace(year, counter + 1);
			}
			else
			{
				int counter = 1;
				yearCounter.put(year,counter);
			}
		}
		return yearCounter;
	}
}
