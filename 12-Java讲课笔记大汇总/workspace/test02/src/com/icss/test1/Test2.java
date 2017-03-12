package com.icss.test1;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入三个数");
		int a = sc.nextInt();
		if(a % 2 == 0){
			if(a % 6 == 0){
				System.out.println("能被6整除的偶数");
			}else{
				
			}
		}else{
			System.out.println("奇数");
		}
	}

}
