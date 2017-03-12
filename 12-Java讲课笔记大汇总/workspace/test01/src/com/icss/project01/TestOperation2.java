package com.icss.project01;

public class TestOperation2 {
	public static void main(String[] args) {
//		System.out.println( 5 == 6);
//		System.out.println(3 + 9 != 6);
		byte b = 10;
		int i = 10;
		char c = 10;
		float f = 10;
		double d = 10.0;
		
		System.out.println(b == i);//t t t t f t t
		System.out.println(c == i);//t t f t f t f
		System.out.println(c == f);//t f f f t f f
		System.out.println(f == d);//f f t t f t t
		System.out.println(d == b);//f f t f f f f
	}

}
