package com.icss.test;

public class HomeWork4 {
	public static void main(String[] args) {
		System.out.println("输出100~999的水仙花数：");
		for (int i = 100; i <= 999; i++) {
			int a, b, c;
			a = i / 100;// 百位数
			b = i % 100 / 10;// 十位数
			c = i % 10;// 个位数
			if (a * a * a + b * b * b + c * c * c == i) {
				System.out.print(i + "\t");
			}
		}
	}

}
