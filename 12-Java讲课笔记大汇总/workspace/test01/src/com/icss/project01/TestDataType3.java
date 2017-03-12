package com.icss.project01;

public class TestDataType3 {
	public static void main(String[] args) {
		byte b = 10;
		short s = 300;//¶þ½øÖÆ 256 + 32 + 8 + 4
		              //              00000001 00101100
		b = (byte)s;
		System.out.println(b);
	}

}
