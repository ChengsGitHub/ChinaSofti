package com.icss.test01;

import java.util.Scanner;

/**
 * 字符串判定相等 ： s1.equals(s2)
 * @author Administrator
 *
 */
public class TestWhile2 {
	public static void main(String[] args) {
		System.out.println("-----WELCOME  LOL--------");
		System.out.println("是否进入游戏 Y/N");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		while(s.equals("Y")){
			System.out.println("来一局");
			System.out.println("是否进入下一局");
			s = sc.next();
			
		}
		System.out.println("Game over");
		
		
	}

}
