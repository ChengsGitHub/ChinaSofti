package com.icss.array;

import java.util.Scanner;

/**
 * 随即产生50-100的随机数：
 * 从控制台猜数： 四次机会 猜中了 提示高了 低了
 * 显示游戏结束 
 * @author Administrator
 *
 */
public class TestRandom2 {
	public static void main(String[] args) {
		int j = (int)((100 - 50 + 1) * Math.random() + 50);	
		int s = 0;
		//System.out.println(j);
		Scanner sc = new Scanner(System.in);
		while(s < 4){
			int t = sc.nextInt();
			if(t == j){
				System.out.println("猜中了");
				break;
			}else if(t > j){
				System.out.println("高了");
			}else{
				System.out.println("低了");
			}
			s = s + 1;
			if(s == 4){
				System.out.println("游戏结束" + j);
				break;
			}
		}

	}
	

}
