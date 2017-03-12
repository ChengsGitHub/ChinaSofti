package com.icss.test1;

public class TestSum {
	public static void main(String[] args) {
		int num = 345;
		int a,b,c,sum;
		a = num / 100;//百位
		b = num % 100 / 10;//十位
		c = num % 10;//个位
		sum = a + b + c;
		System.out.println(num + "的三位数上的和为" + sum);
		
		
		
		
	}

}
