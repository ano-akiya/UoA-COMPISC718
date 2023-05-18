package duckstats;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 
 * This class is used for storing the number of ducks and ducklings per pond.
 * You may modify this class as long as it will not break the supplied code.
 * 
 * @author Yu-Cheng Tu
 *
 */
public class DuckCounter {
	private LocalDate date;
	private int ducks;
	private int ducklings;

	public DuckCounter(String date, int ducks, int ducklings) throws DuckCounterException {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			this.date = LocalDate.parse(date, formatter);
			this.ducks = ducks;
			this.ducklings = ducklings;
		} catch (DateTimeParseException e) {
			throw new DuckCounterException("Error in duck data!");
		}
	}

	public LocalDate getDate() {
		return date;
	}

	public int getDuckCount() {
		return ducks;
	}

	public int getDucklingCount() {
		return ducklings;
	}
}
