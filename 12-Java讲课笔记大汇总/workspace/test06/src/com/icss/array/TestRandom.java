package com.icss.array;
/**
 * Math.random() 产生 [0.0-1.0)之间的随机小数 [1,33] 
 * @author Administrator
 * A——Z的任意一个字母
 */
public class TestRandom {
	public static void main(String[] args) {
		while(true)
			System.out.println((char)((90 - 65 + 1) * Math.random() + 65));
		//System.out.println((int)(Math.random()*10) % 3 + 1);
		//	System.out.println((int)((3 - 1 + 1) * Math.random() + 1));
	}

}
