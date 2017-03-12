package chapter11;

import java.util.Scanner;

public class TestGuessNum {
	
	public static void main(String[] args) {
		
		//随机产生一个价格
		int a = (int) ((100 - 50 + 1) * Math.random() + 50);
		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("请输入1个50至100之间的数");

		for (int i = 1; i <= 5; i++) {
			
			int b = sc.nextInt();
			
			if (b == a) {
				System.out.println("你猜中了");
				break;
			} else {
				if (i < 5) {
					if (b > a)
						System.out.println("数字大了，还有" + (5 - i) + "次机会，请重新输入一次");
					else
						System.out.println("数字小了，还有" + (5 - i) + "次机会，请重新输入一次");
				} else {
					if (b > a) {
						System.out.println("数字大了");
						System.out.println("这个数字是" + a + "，游戏结束");					
					} else {
						System.out.println("数字小了");
						System.out.println("这个数字是" + a + "，游戏结束");
					}

				}
			}
		}

	}
}
