package com.icss.test1;

import java.util.Scanner;

public class TestIf1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入年份");
		int year = sc.nextInt();
		if(year == 1992){
			System.out.println("请走入二教室");
		}
		if(year == 1991 || year == 1992){
			System.out.println("请走入一教室");
		}
	}

}
