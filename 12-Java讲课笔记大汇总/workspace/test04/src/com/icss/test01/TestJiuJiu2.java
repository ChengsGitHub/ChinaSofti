package com.icss.test01;

public class TestJiuJiu2 {
	public static void main(String[] args) {
		for (int i = 9; i >= 1; i --) {
			for (int j = 1; j < 10 - i; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}

}
