package com.icss.test1;

import java.util.Scanner;

public class TestIf3 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入日期");
		int day = sc.nextInt();
		if( day >= 1 && day <= 5){
			System.out.println("学习");
		}else if(day == 6){
			System.out.println("睡觉");
		}else if(day == 7){
			System.out.println("玩游戏");
		}else{
			System.out.println("没有这一天");
		}
	}

}
