package com.icss.test01;

public class TestWan {
	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if(i % j == 0){
					sum += j;
				}
			}
			if(sum == i){
				System.out.println(i);
			}
		}
	}

}
