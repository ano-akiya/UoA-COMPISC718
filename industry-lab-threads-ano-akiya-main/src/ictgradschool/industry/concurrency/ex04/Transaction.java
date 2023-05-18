package ictgradschool.industry.concurrency.ex04;

/**
 * Class to represent a simple banking transaction.
 * 
 * A Transaction object has two pieces of state: type and amount. The type is 
 * either deposit or withdraw, and the amount is the amount of money, in units
 * of cents, to deposit or withdraw.
 *
 */
class Transaction {
	// Enumerated type to represent transaction types.
	public enum TransactionType {Deposit, Withdraw};
	
	// Instance variables are final, meaning that they can be set only once.
	// They are set using the constructor, and cannot subsequently be modified.
	// They are public so that they can be accessed conveniently without the 
	// need for getter methods. 
	public final TransactionType _type;
	public final int _amountInCents;
	
	/**
	 * Creates a Transaction object with a given type and amount. 
	 */
	public Transaction(TransactionType type, int amount) {
		_type = type;
		_amountInCents = amount;
	}
}

