package com.icss.test1;

import java.util.Scanner;

public class TestIf3 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("����������");
		int day = sc.nextInt();
		if( day >= 1 && day <= 5){
			System.out.println("ѧϰ");
		}else if(day == 6){
			System.out.println("˯��");
		}else if(day == 7){
			System.out.println("����Ϸ");
		}else{
			System.out.println("û����һ��");
		}
	}

}
