package com.icss.test1;

import java.util.Scanner;

/**
 * �����ٷֳɼ� �� 1-100 ��60 E 60-70 D 70-80 C 80-90 B 90-100 A
 * 
 * @author Administrator
 * 
 */
public class TestSwitch2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("������һ���ɼ�:");
		int a = s.nextInt();
		if(a >= 0 && a <= 100){
		switch (a / 10) {
		case 10:
			System.out.println("�ɼ��ȼ���A");
			break;
		case 9:
			System.out.println("�ɼ��ȼ���A");
			break;
		case 8:
			System.out.println("�ɼ��ȼ���B");
			
			break;
		case 7:
			System.out.println("�ɼ��ȼ���C");
			break;
		case 6:
			System.out.println("�ɼ��ȼ���D");
			break;
		default:
			System.out.println("�ɼ��ȼ���E");
			break;
		}
		}else{
			System.out.println("�ֲ��Ϸ�");
		}
	}
}
