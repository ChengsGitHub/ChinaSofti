package com.icss.test1;

import java.util.Scanner;

/**
 * ����̨����3���� �� ��С����������� a 8   b 11  c 10
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������������");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//��һ�� �� ��a�������������С����
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
		//�ڶ��� �� ʣ���������Ƚ�
		if(b > c){
			int temp = b;
			b = c;
			c = temp;
		}
		
		System.out.println(a + "<" + b + "<" + c);
	}
	

}
