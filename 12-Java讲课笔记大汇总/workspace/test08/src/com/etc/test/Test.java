package com.etc.test;

import java.util.Arrays;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] x={3,1,5,2,4};
		for(int i=0;i<x.length;i++){
			System.out.print(x[i]+"\t");
		}
		Arrays.sort(x);
		System.out.println();
		for(int i=0;i<x.length;i++){
			System.out.print(x[i]+"\t");
		}

	}

}
