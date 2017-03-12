package chapter6.bank;

/**
 * ¿Í»§
 * @author Administrator
 *
 */
public class Customer {
	
	private String name;
	private boolean vip;
	private Account account;

	public Customer(String name, boolean vip, Account account) {
		this.name = name;
		this.vip = vip;
		this.account = account;
		
	}

	public String getName() {
		return name;
	}

	public boolean isVip() {
		return vip;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
}
