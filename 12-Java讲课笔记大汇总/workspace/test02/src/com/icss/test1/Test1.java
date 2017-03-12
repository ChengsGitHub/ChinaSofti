package com.icss.test1;

import java.util.Scanner;

/**
 * 控制台接收3个数 ： 从小到大依次输出 a 8   b 11  c 10
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入三个数");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//第一步 ： 将a存放三个数的最小的数
		if(a > b){
			int temp = a;
			a = b;
			b = temp;
		}
		if(a > c){
			int temp = a;
			a = c;
			c = temp;
		}
		//第二步 ： 剩下两个做比较
		if(b > c){
			int temp = b;
			b = c;
			c = temp;
		}
		
		System.out.println(a + "<" + b + "<" + c);
	}
	

}
