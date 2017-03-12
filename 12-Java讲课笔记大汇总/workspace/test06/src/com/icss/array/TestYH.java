package com.icss.array;

public class TestYH {
	public static void main(String[] args) {
		//创建数组，初始化二维元素
		int[][] a = new int[10][];

		for (int i = 0; i < a.length; i++) {
			a[i] = new int[i + 1];
		}
		
		//按照杨辉三角形赋值
		for (int i = 0;i < a.length; i ++) {
			a[i][0] = 1;
			a[i][i] = 1;
			
			for (int j = 1;j < a[i].length - 1;j ++) {				
				a[i][j] = a[i-1][j] + a[i-1][j-1];				
			}
		}		

		// 遍历二维数组
		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}

			System.out.println();
		}
	}

}
