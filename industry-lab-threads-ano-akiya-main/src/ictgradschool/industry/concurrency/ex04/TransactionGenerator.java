package ictgradschool.industry.concurrency.ex04;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class that provides operations to generate and retrieve a set of 
 * Transaction objects. When generating Transactions, the Transactions are 
 * written to a (human-readable) test file on disk. Transactions are retrieved
 * by reading the text file.
 * 
 * This class is useful for testing purposes. 
 *
 */
public class TransactionGenerator {
	
	// Name of the text file to store Transaction data.
	private static final String DATA_FILE = "transactions.txt";
	
	/**
	 * Returns a List of Transaction objects.
	 * 
	 * This method reads the text file to populate Transaction objects with a 
	 * type (deposit or withdraw) and an amount.
	 *  
	 * @return a populated List of Transaction objects if the text file has 
	 * previously been created, or null otherwise. 
	 */
	public static List<Transaction> readDataFile() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		try {
			// Create a Scanner object bound to the text file.
			Scanner in = new Scanner(new FileReader(DATA_FILE));	
		
			while(in.hasNextInt()) {
				// Read a pair of type/amount values (one pair per line in the 
				// text file).
				int type = in.nextInt();
				int amount = in.nextInt();
			
				// Create a Transaction object based on the pair of read values.
				Transaction newTransaction = null;
				if(type == 0) {
					// type of 0 represents a deposit.
					newTransaction = new Transaction(Transaction.TransactionType.Deposit, amount);
				} else {
					// type of 1 represents a withdraw.
					newTransaction = new Transaction(Transaction.TransactionType.Withdraw, amount);
				}
				
				// Add the new Transaction to the List.
				transactions.add(newTransaction);
			}
			
			System.out.println("Read " + transactions.size() + " transactions from " + DATA_FILE);
			
			in.close();
		} catch(Exception e) {
			// Where there is any error with opening/reading from the text 
			// file, set the result of this method to null.
			transactions = null;
		}

		return transactions;
	}
	
	/**
	 * Generates and writes a set of Transaction objects to a text file.
	 * 
	 * This method uses a random number generate to compute Transaction 
	 * attributes. Transactions are written to the text file, one per line, in
	 * the form:
	 * 
	 * <type> <amount>
	 * 
	 * where type is an integer (0 for deposit, 1 for withdraw), and amount is
	 * an integer representing an amount in cents. The cents value is 
	 * constrained to be in the range 50 to 100000.
	 * 
	 * @param numberOfTransactions the number of Transactions to be generated
	 * and written to the text file.
	 */
	public static void writeDataFile(int numberOfTransactions) {
		try {
			PrintWriter writer = new PrintWriter("transactions.txt", "UTF-8");
			
			for(int i = 0; i < numberOfTransactions; i++) {
				int transactionType = ThreadLocalRandom.current().nextInt(0, 2);
				int transactionAmount = ThreadLocalRandom.current().nextInt(50, 100001);
				writer.println(Integer.toString(transactionType) + " " + Integer.toString(transactionAmount));
			}
				
			System.out.println("Written " + numberOfTransactions + " transactions to " + DATA_FILE);
			writer.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main method to generate 100 Transactions and to read them into a List.
	 */
	public static void main(String[] args) {
		writeDataFile(100);
		readDataFile();
	}
}

