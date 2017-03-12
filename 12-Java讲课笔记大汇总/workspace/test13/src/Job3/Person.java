package Job3;

import java.util.Scanner;

/**
 * 用户
 * @author Administrator
 *
 */
public class Person {
	int score=0;
	int num;
	String name;

	/**
	 * 用户选择人物角色
	 * @return
	 */
	public String personHero() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if (a == 1)
			return name = "刘备";
		if (a == 2)
			return name = "孙权";
		else
			return name = "曹操";
	}

	/**
	 * 用户选择出拳
	 */
	public void showFist() {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num == 1) {
			System.out.println("你出拳：剪刀");
		} else if (num == 2) {
			System.out.println("你出拳：石头");
		} else if (num == 3) {
			System.out.println("你出拳：布");
		}
	}
	
}