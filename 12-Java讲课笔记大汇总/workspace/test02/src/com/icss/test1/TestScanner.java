package com.icss.test1;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		//����һ������
		Scanner sc = new Scanner(System.in);//�п���̨���չ���
		System.out.println("������������");
		//����
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println( a + "," + b + "," + c);
		
	}

}
