package com.icss.test;
/**
 * *****
 * *****
 * *****
 * @author Administrator
 *
 */
public class TestFor1 {
	public static void main(String[] args) {
		//行
		for (int i = 1; i < 4; i++) {
			//行里的
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
