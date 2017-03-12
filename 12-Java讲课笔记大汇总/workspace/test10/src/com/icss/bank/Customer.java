package com.icss.bank;

public class Customer {
	public String name;
	public String id;
	public String phone;
	private Account account;

	public Customer(String name, String id, String phone, Account account) {
		super();
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.account = account;
	}
	
	public Customer(String name, String id, String phone) {
		super();
		this.name = name;
		this.id = id;
		this.phone = phone;		
	}

	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}