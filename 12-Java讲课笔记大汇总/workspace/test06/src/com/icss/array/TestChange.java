package com.icss.array;

import java.util.Arrays;

/**
 *  0 7
 *  1 6
 *  2 5
 *  3 4
 * 
 * @author Administrator
 *
 */
public class TestChange {
	public static void main(String[] args) {
		int[] a = { 5, 11, 15, 24, 36, 47, 59, 66 };
		
		for (int i = 0; i < a.length / 2; i++) {
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
			
		}
		System.out.println(Arrays.toString(a));
		
	}

}
