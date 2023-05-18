package ictgradschool.industry.concurrency.ex04;

import java.util.List;

/**
 * Class to implement serial processing of Transactions on a single 
 * BankAccount object. 
 * 
 * This program simple acquires a List of Transaction objects from 
 * TransactionGenerator and applies each Transaction to the BankAccount object.
 * The balance of the BankAccount is initially zero. Hacing applied all
 * Transactions to the account, SerialBankingApp displays the final balance of
 * the account.
 *
 */
public class SerialBankingApp {
	public static void main(String[] args) {
		
		// Acquire Transactions to process.
		List<Transaction> transactions = TransactionGenerator.readDataFile();
		
		// Create BankAccount object to operate on.
		BankAccount account = new BankAccount();

		// For each Transaction, apply it to the BankAccount instance.
		for (Transaction transaction : transactions) {
			switch (transaction._type) {
			case Deposit:
				account.deposit(transaction._amountInCents);
				break;
			case Withdraw:
				account.withdraw(transaction._amountInCents);
				break;
			}
		}

		// Print the final balance after applying all Transactions. 
		System.out.println("Final balance: " + account.getFormattedBalance());
	}
}