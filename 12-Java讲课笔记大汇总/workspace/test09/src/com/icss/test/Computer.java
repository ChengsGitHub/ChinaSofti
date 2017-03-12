package com.icss.test;

public class Computer {
	
	
	public int add(int a ,int b){
		
		if(a > 0 && b > 0){
			return a + b;
		}
		return 0;
	}
	
	public int sub(int a ,int b){
		add(a,b);
		if(a > b){
			return a - b;
		}
		return b - a;
	}

}
