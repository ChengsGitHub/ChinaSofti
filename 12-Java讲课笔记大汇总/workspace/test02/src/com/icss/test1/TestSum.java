package com.icss.test1;

public class TestSum {
	public static void main(String[] args) {
		int num = 345;
		int a,b,c,sum;
		a = num / 100;//��λ
		b = num % 100 / 10;//ʮλ
		c = num % 10;//��λ
		sum = a + b + c;
		System.out.println(num + "����λ���ϵĺ�Ϊ" + sum);
		
		
		
		
	}

}
