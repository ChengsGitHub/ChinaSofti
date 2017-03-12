package com.icss.test1;

public class TestOperation3 {
	public static void main(String[] args) {
		int i = 1,j = 1,k = 1;
		boolean b1 = i ++ == 1 & j ++ == 1 | -- k == 1;//t i 2 j 2
		boolean b2 = ++ j == 3 | i ++ == 2 & k == 1; // 3
		
		System.out.println(b1);// t
		System.out.println(b2);// t 
		System.out.println(i);//2
		System.out.println(j);//3
		System.out.println(k);//1
		
	}

}
