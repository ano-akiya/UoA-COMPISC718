package simplephonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * Complete this class for adding names and phone numbers to a collection.
 * @author Write your UPI here.
 *
 */
public class SimplePhoneBook {

	Map<String, Integer> phoneBook;
	
	// 2a. Adds multiple contacts to the phone book collection
	public void addMultipleContacts(Map<String, Integer> multipleContacts)
	{
		phoneBook = new HashMap<>();
		Iterator<Map.Entry<String, Integer>> iterator = multipleContacts.entrySet().iterator();
		while (iterator.hasNext())
		{
			Map.Entry<String, Integer> book = iterator.next();
			String name = book.getKey();
			int number = book.getValue();
			phoneBook.put(name, number);
		}
	}
	
	// 2b. Adds a single contact to the phone book collection
	public void addNewContact(String name, int number) {
		if (phoneBook.containsKey(name)) {
			System.out.println("Current number for " + name + " is " + number);
			phoneBook.replace(name, number);
		}
		else {
			System.out.println("Number for " + name + " is " + number);
			phoneBook.put(name, number);
		}

	}
	
	// 2c. Prints the number for a given name
	public void printNumberFor(String name) {
		if (phoneBook.containsKey(name))
		{
			int number = phoneBook.get(name);
			System.out.println("Current number for " + name + " is " + number);
		}
		else
		{
			System.out.println("The person " + name + " does not exist in the phone book");
		}

	}
	
	// 2d. Prints the total number of entries of the phone book collection
	public void printTotalNumberOfEntries(){
		int total = phoneBook.size();
		System.out.println("There are " + total + " entries in the phone book");
	}
	
	// 2e. Prints the name for a given phone number
	public void printNameByPhoneNumber(int phoneNumber) {
		Iterator<Map.Entry<String, Integer>> iterator = phoneBook.entrySet().iterator();
		int counter = 0;
		while(iterator.hasNext())
		{
			Map.Entry<String, Integer> book = iterator.next();
			int number = book.getValue();
			String name = book.getKey();
			if (number == phoneNumber)
			{
				System.out.println("The person with the number " + phoneNumber + " is: " + name);
				break;
			}
			else
			{
				counter = counter + 1;
			}
		}
		if (counter == phoneBook.size())
		{
			System.out.println("Cannot find person in the phone book with the number " + phoneNumber);
		}
	}
}
