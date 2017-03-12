package com.icss.test;
/**
 * 
 * *  1 1
 * ** 2 2
 * ***
 * ****
 * ***** i i
 * @author Administrator
 *
 */
public class TestFor2 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
