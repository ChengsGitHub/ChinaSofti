package com.icss.test1;
/**
 * 1 + 2 + 3+ бнбн + 100
 * @author Administrator
 *
 */
public class TestFor1 {
	public static void main(String[] args) {
		int sum = 0;
//		for (int i = 1; i <= 100; i+= 2) {
//			sum += i;
//		}
		for (int i = 1; i <= 100; i++) {
			if(i % 2 != 0){
				sum += i;
			}
		}
		System.out.println("sum =" + sum);
		
	}

}
