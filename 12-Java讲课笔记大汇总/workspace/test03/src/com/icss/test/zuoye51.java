package com.icss.test;

import java.util.Scanner;


public class zuoye51 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m,n,temp,x,y;
		Scanner sc=new Scanner(System.in);
		System.out.println("������������:");
		m=sc.nextInt();
		n=sc.nextInt(); 
		x=m*n;
		if(n<m){
			temp=n;n=m;m=temp;
		}
		while(n%m!=0){
			temp=n%m;
			n=m;
			m=temp;
			
		}
		System.out.println("���Լ��:"+m);
		y=x/m;
        System.out.println("��С������:"+y);
	}

}
