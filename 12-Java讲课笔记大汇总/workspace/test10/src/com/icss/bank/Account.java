package com.icss.bank;

public class Account {
	
	public int number;
	public int password;
	public int balance;
	
	public Account(int number, int password, int balance) {
		super();
		this.number = number;
		this.password = password;
		this.balance = balance;
	}
	
	public boolean deposit(int amt) {

		// ��Ǯ
		if (amt % 100 == 0) {
			this.balance += amt;
			return true;
		} else {
			return false;
		}

	}

	public boolean withdraw(int amt) {
		// ȡǮ
		if (this.balance >= amt) {
			this.balance -= amt;
			return true;
		} else {
			return false;
		}

	}

	public int getBalance() {
		return this.balance;
	}
}
