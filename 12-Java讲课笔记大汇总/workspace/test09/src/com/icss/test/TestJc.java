package com.icss.test;
import java.util.Scanner;
public class TestJc {
	
	//Çó½×³Ë
	public int getJc(int n){
		if(n == 1){
			return 1;
		}
		return n * getJc(n - 1);
	}
	public static void main(String[] args) {
		System.out.println(new TestJc().getJc(6));
	}
}
