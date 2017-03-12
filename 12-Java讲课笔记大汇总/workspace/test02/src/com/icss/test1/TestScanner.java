package com.icss.test1;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		//创建一个对象
		Scanner sc = new Scanner(System.in);//有控制台接收功能
		System.out.println("请输入三个数");
		//接收
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println( a + "," + b + "," + c);
		
	}

}
