package com.icss.bank;

public class TestAccount2 {
	
	public static void main(String[] args) {
		
		Account account = new Account(10001,123456,5000);		
		Customer customer = new Customer("tom","101","10086",account);
		
		Account account2 = customer.getAccount();
		account2 = new Account(10001,123456,5000); 
		
		account2.withdraw(500);
						
		System.out.println(account.getBalance());
	}

}