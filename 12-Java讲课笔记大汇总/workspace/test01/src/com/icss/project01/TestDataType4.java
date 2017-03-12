package com.icss.project01;

public class TestDataType4 {
	public static void main(String[] args) {
		char c = 'a';
		c = 'жа';
		int i = 65;
		c = (char)i;
		i = c;
		System.out.println((int)c);
		System.out.println(" aaa\bbbb");
		System.out.println('\\');
		System.out.println('\u0000');
		System.out.println("sss");
		
		boolean b = true;
		
		b = false;
		
		//b = 0;
	}

}
