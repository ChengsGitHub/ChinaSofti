package com.icss.array;

public class TestArray3 {
	public static void main(String[] args) {
		int[][] a = {{1,2,3},{3,4,5},{4,7,6}};
		
//		System.out.println(a[0]);
//		System.out.println(a[1][2]);
		//±éÀú
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
