package com.icss.test01;

public class Test2048 {
	public static void main(String[] args) {
		loop:
			
		for (int i = 1; i <= 2048; i++) {
			for (int j = 1; j <= 2048; j++) {
				if(i * j == 2048 && i > j){
				System.out.println(i + "," + j);
				break loop;
				}
			}
		}
	}

}
