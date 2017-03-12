package chapter6.bank;

/**
 * ∆’Õ®’Àªß 
 */
public class Account {
	
	protected double balance;
	private String password;
	
	public Account() {
		super();
	}

	public Account(double balance, String password) {
		this.balance = balance;
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public String getPassword() {
		return password;
	}

	public boolean withdraw(double amt) {
		if (amt <= balance){
			balance = balance - amt;
			return true;
		} else{			
			return false;
		}
	}

	public void deposit(double amt) {
		balance = balance + amt;
	}

}
