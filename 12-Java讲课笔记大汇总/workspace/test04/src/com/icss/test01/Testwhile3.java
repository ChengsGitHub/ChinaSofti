package com.icss.test01;

import java.util.Scanner;

//²Ëµ¥³ÌÐò
public class Testwhile3 {
	public static void main(String[] args) {
		while(true){
			System.out.println("ATM");
			System.out.println("1 deposit 2 withdraw 3 select balance 4 exit");
			
			System.out.println("please choose the operation");
			Scanner sc = new Scanner(System.in);
			int s = sc.nextInt();
			if(s == 1){
				System.out.println("cun");
			}else if(s == 2){
				System.out.println("qu");
			}else if(s == 3){
				System.out.println("cha");
			}else if(s == 4){
				System.out.println("Ð»Ð»»Ý¹Ë");
				System.exit(0);
			}
		}
	}

}
