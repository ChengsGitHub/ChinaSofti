package com.icss.test01;

import java.util.Scanner;

/**
 * �ַ����ж���� �� s1.equals(s2)
 * @author Administrator
 *
 */
public class TestWhile2 {
	public static void main(String[] args) {
		System.out.println("-----WELCOME  LOL--------");
		System.out.println("�Ƿ������Ϸ Y/N");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		while(s.equals("Y")){
			System.out.println("��һ��");
			System.out.println("�Ƿ������һ��");
			s = sc.next();
			
		}
		System.out.println("Game over");
		
		
	}

}
