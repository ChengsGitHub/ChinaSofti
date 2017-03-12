package com.icss.test01;

public class TestRun {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1900; i <= 2100; i++) {
			if(i % 4 == 0 & i % 100 != 0 || i % 400 == 0){
				count ++;
				System.out.print(i+" ");
				if(count % 4 == 0){
					System.out.println();
				}
			}
		}
	}

}
