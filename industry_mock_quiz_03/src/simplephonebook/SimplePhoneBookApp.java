package simplephonebook;

import java.util.HashMap;
import java.util.Map;

/**
 * This the application for running the simple phone book. Do not change the code in this class unless otherwise specified.
 * 
 * @author Yu-Cheng Tu
 *
 */
public class SimplePhoneBookApp {

	public static void main(String[] args) {

		System.out.println("Welcome to Simple Phone Book App");
		System.out.println("================================");
		System.out.print("Please enter the name you like to add: ");
		
		String userInput = Keyboard.readInput();
		
		System.out.print("Please enter the number for that person: ");
		
		int number = Integer.parseInt(Keyboard.readInput());
		
		SimplePhoneBook sp = new SimplePhoneBook();
		
		System.out.println("--------------------------------");
		
		sp.addMultipleContacts(getMultipleContacts());
		
		sp.addNewContact(userInput, number);
		
		System.out.println("--------------------------------");
		sp.printNumberFor("Kate");
		
		System.out.println("--------------------------------");
		sp.printNumberFor("George");
		
		System.out.println("--------------------------------");
		sp.printTotalNumberOfEntries();
		
		System.out.println("--------------------------------");
		sp.printNameByPhoneNumber(1234567);
	}
	
	// Helper method for creating multiple contacts
	private static Map<String,Integer> getMultipleContacts() {
		HashMap<String,Integer> contacts = new HashMap<String,Integer>();
		contacts.put("Alan", getRandom7Digits());
		contacts.put("George", getRandom7Digits());
		contacts.put("Mary", getRandom7Digits());
		contacts.put("Paul", getRandom7Digits());
		contacts.put("Jennifer", getRandom7Digits());
		contacts.put("Eve", getRandom7Digits());
		
		return contacts;
	}
	
	// Helper method for creating random digits
	private static int getRandom7Digits() {
		return (int) (Math.random() * 9000000) + 1000000;
	}

}
