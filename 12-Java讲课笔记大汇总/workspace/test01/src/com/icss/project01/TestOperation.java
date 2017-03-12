package com.icss.project01;

public class TestOperation {
	public static void main(String[] args) {
		int a = 5;
		double b = 2.0;
		
		System.out.println(a / b);
		System.out.println(a / 2);
		System.out.println(a + b);
		System.out.println(1 % 3);
		
		int i = 10;
		int j = i ++;// j = 10 i = 11
		int z = -- j;// j = 9 z = 9
		System.out.println(i);//11
		System.out.println(j ++);//10
		System.out.println(j);
		System.out.println(-- z);//8
	}

}
