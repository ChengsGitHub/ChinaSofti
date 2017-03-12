package com.icss.test;

public class TestFbnq {
	
	public static void main(String[] args) {
		int a = 1, b = 1;
		System.out.print(a + "\t" + b + "\t");
		for (int i = 1; i < 9; i += 2) {
			a = a + b;
			b = a + b;
			System.out.print(a + "\t" + b + "\t");
		}
		
	}

}
