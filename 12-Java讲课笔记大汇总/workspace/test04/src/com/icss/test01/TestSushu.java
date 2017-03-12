package com.icss.test01;

public class TestSushu {
	public static void main(String[] args) {
//		for (int i = 10; i <= 100; i++) {
//			//int t = 0;
//			boolean b = true;
//			for (int j = 2; j < i; j++) {
//				if(i % j == 0){
//					//t ++;
//					b = false;
//				}
//			}
//			if(b){
//				System.out.println(i);
//			}
//		}
		for (int i = 10; i <= 100; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {
				if(i % j == 0){
					count ++;
				}
			}
			if(count == 2){
				System.out.println(i);
			}
		}
	}

}
