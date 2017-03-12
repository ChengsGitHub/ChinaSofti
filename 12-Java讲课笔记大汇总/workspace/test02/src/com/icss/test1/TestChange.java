package com.icss.test1;
/**
 * 交换
 * @author Administrator
 *
 */
public class TestChange {
	public static void main(String[] args) {
		int a = 10,b = 20,temp;
		//方法1：
//		System.out.println("交换前" + a + "," + b);
//		temp = a;
//		a = b;
//		b = temp;
//		System.out.println("交换后" + a + "," + b);
		//方法2：
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("交换后" + a + "," + b);
	}

}
