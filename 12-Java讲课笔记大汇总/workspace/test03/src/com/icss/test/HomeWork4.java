package com.icss.test;

public class HomeWork4 {
	public static void main(String[] args) {
		System.out.println("���100~999��ˮ�ɻ�����");
		for (int i = 100; i <= 999; i++) {
			int a, b, c;
			a = i / 100;// ��λ��
			b = i % 100 / 10;// ʮλ��
			c = i % 10;// ��λ��
			if (a * a * a + b * b * b + c * c * c == i) {
				System.out.print(i + "\t");
			}
		}
	}

}
