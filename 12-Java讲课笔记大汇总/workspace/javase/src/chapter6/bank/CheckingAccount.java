package chapter6.bank;

/**
 * ���ÿ�
 * @author Administrator
 *
 */
public class CheckingAccount extends Account {
	
	private double protection;//͸֧���

	public CheckingAccount(double balance, String password, double protection) {
		super(balance, password);
		this.protection = protection;
	}

	public boolean withdraw(double amt) {
		if (amt <= this.balance + protection) {
			this.balance = this.balance - amt;
			return true;
		}
		
		return false;
	}

}
