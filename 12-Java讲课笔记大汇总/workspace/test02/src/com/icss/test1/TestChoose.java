package com.icss.test1;
/**
 * 给三个整数： 输出最大的数
 * @author Administrator
 *
 */
public class TestChoose {
	public static void main(String[] args) {
//		int i = 5 > 3 ? 5 : 3;
//		System.out.println(i);
//		double d = i ++ == 7 ? 90.0: 56.9;
//		String s = 7 != 9 ? "是":"否";
//		System.out.println(7 != 9 ? true:false);
//		System.out.println(16 % 5 == 1 ? 90 : 99.0);
		int a = 110, b = 554, c = 78;
		int max = a > b ? a : b;
		max = max > c ? max : c;
		System.out.println(max);
	}

}
