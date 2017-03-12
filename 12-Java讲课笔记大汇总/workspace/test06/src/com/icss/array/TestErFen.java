package com.icss.array;

import java.util.Arrays;
import java.util.Scanner;

public class TestErFen {
	public static void main(String[] args) {
		int [] a = {3,56,23,77,5,90};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		Scanner sc = new Scanner(System.in);
		System.out.println("������");
		int num = sc.nextInt();
		int index = -1;//�����ҵ����±�
		int start = 0;
		int end = a.length - 1;
		while(start <= end){
			int middle = (start + end) / 2;
			if(a[middle] == num){
				index = middle;
				break;
			}
			else if(num > a[middle]){
				start = middle + 1 ;
			}
			else if(num < a[middle]){
				end = middle - 1;
			}
		}
		System.out.println(index);
	}

}
