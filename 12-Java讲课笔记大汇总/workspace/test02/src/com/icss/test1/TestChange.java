package com.icss.test1;
/**
 * ����
 * @author Administrator
 *
 */
public class TestChange {
	public static void main(String[] args) {
		int a = 10,b = 20,temp;
		//����1��
//		System.out.println("����ǰ" + a + "," + b);
//		temp = a;
//		a = b;
//		b = temp;
//		System.out.println("������" + a + "," + b);
		//����2��
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("������" + a + "," + b);
	}

}
