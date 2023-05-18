package gamedata;

/**
 * This class has information about a game, including its id, name, platform,
 * year, genre, and publisher. You may modify this class as long as it will not
 * break the supplied code.
 * 
 * @author Yu-Cheng Tu
 *
 */
public class Game implements Comparable<Game>{
	private int id;
	private String name;
	private String platform;
	private int year;
	private Genre genre;
	private String publisher;

	public Game(int id, String name, String platform, int year, Genre genre, String publisher) {
		this.id = id;
		this.name = name;
		this.platform = platform;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
	}

	public String toString() {
		return String.format("The game \"%s\" (id:%d) was released by \"%s\" in %4d", name, id, publisher, year);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPlatform() {
		return platform;
	}

	public int getYear() {
		return year;
	}

	public String getGenre() {
		return genre.toString();
	}

	public String getPublisher() {
		return publisher;
	}

	public int compareTo(Game game)
	{
		int yearOther = game.getYear();
		int yearThis = this.getYear();
		if (yearThis < yearOther)
		{
			return 1;
		}
		else if (yearThis > yearOther)
		{
			return -1;
		}
		else {
			return this.getPublisher().compareTo(game.getPublisher());
		}
	}

}
