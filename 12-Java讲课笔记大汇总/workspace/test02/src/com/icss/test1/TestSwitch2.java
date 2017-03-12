package com.icss.test1;

import java.util.Scanner;

/**
 * 给出百分成绩 ： 1-100 ：60 E 60-70 D 70-80 C 80-90 B 90-100 A
 * 
 * @author Administrator
 * 
 */
public class TestSwitch2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个成绩:");
		int a = s.nextInt();
		if(a >= 0 && a <= 100){
		switch (a / 10) {
		case 10:
			System.out.println("成绩等级是A");
			break;
		case 9:
			System.out.println("成绩等级是A");
			break;
		case 8:
			System.out.println("成绩等级是B");
			
			break;
		case 7:
			System.out.println("成绩等级是C");
			break;
		case 6:
			System.out.println("成绩等级是D");
			break;
		default:
			System.out.println("成绩等级是E");
			break;
		}
		}else{
			System.out.println("分不合法");
		}
	}
}
