package com.icss.test;

import java.util.Scanner;

public class TestMonth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������");
		int year = sc.nextInt();
		System.out.println("�����������");
		int month = sc.nextInt();
		
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12 : System.out.println("31��");
		case 4 :
		case 6:
		case 9:
		case 11: System.out.println("30��");
		case 2 :if(year % 4 == 0 && year % 100 != 100 || year % 400 == 0){
			System.out.println("29��");
		}else{
			System.out.println("28��");
		}
		default  : System.out.println("û�и��·�");
		}
	}

}
