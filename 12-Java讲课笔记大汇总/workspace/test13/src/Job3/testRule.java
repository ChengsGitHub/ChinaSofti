package Job3;

import java.util.Scanner;

public class testRule {
	
	public static void main(String[] args) {
		
		System.out.println("------欢迎进入游戏世界------");
		System.out.println("***************");
		System.out.println("** 猜拳，开始 **");
		System.out.println("***************");
		System.out.println("出拳规则：1、剪刀 2、石头 3、布");
		System.out.print("请选择角色（1：刘备 2：孙权 3：曹操）：");
		
		Rule r = new Rule();
		Computer c = new Computer();
		Person p = new Person();
		
		r.computer = c;
		r.person = p;
		
		p.personHero();
		c.computerHero();
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("要开始吗？（y/n）");
		String s = sc.next();
		
		while (s.equals("y")) {
			System.out.print("请出拳：1.剪刀 2.石头 3.布（输入相应数字）：");
			p.showFist();
			c.showFist();
			r.ruleFist();
			
			System.out.println();
			System.out.print("是否开始下一轮（y/n）:");
			
			r.count++;
			
			Scanner sc1 = new Scanner(System.in);
			
			s = sc1.next();
			
			if (s.equals("n")) {
				break;
			}
		}
		
		System.out.println("------------------");
		System.out.println(p.name + "vs" + c.name);
		System.out.println("对战次数：" + r.count + "，电脑积分：" + c.score + ",用户积分：" + p.score);
		r.showResult();
	}
}