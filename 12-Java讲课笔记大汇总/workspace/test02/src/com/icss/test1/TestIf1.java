package com.icss.test1;

import java.util.Scanner;

public class TestIf1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("���������");
		int year = sc.nextInt();
		if(year == 1992){
			System.out.println("�����������");
		}
		if(year == 1991 || year == 1992){
			System.out.println("������һ����");
		}
	}

}
