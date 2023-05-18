package ictgradschool.industry.concurrency.ex04;

/**
 * Simple class to represent a bank account. BankAccount objects store an 
 * account balance and respond to requests to deposit and withdraw funds.
 *
 */
public class BankAccount {
	private int _balanceInCents;
	
	/**
	 * Constructs a BankAccount object with a balance of zero.
	 */
	public BankAccount() {
		_balanceInCents = 0;
	}
	
	/**
	 * Deposits an amount of money into a BankAccount object. This operation is
	 * always successfully, and increases the account's balance by the deposit
	 * amount.
	 * 
	 * @param amountInCents the amount to be deposited, in units of cents.
	 */
	public void deposit(int amountInCents) {
		_balanceInCents += amountInCents;
	}
	
	/**
	 * Attempts to withdraw funds from a BankAccount object. This operation is
	 * successful only if the withdrawal maintains a non-negative balance.
	 * 
	 * @param amountInCents the amount to withdraw, in units of cents.
	 * 
	 * @return true of the withdrawal succeeds, false otherwise.
	 */
	public boolean withdraw(int amountInCents) {
		boolean success = false;
		int postWithdrawalBalance = _balanceInCents - amountInCents;
		
		if(postWithdrawalBalance >= 0) {
			_balanceInCents = postWithdrawalBalance;
			success = true;
		}
		return success;
	}
	
	/**
	 * Returns the balance, in units of cents, of a BankAccount object.
	 */
	public int getBalance() {
		return _balanceInCents;
	}
	
	/**
	 * Similar to getBalance(), but this method returns a formatted String 
	 * representing a BankAccount's balance. The String is formatted as $XX.XX.
	 */
	public String getFormattedBalance() {
		int dollars = _balanceInCents / 100;
		int cents = _balanceInCents % 100;
		return "$" + Integer.toString(dollars) + "." + Integer.toString(cents);
	}
}
