package com.icss.array;

import java.util.Arrays;

public class TestArray2 {
	public static void main(String[] args) {
		int[] a = new int[]{23,4,44,6,7};
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if(a[i] > a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
