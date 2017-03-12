package com.icss.product;

import java.util.Scanner;

public class TestOrder {
	public static void main(String[] args) {

		// TODO 自动生成的方法存根
		Order o = new Order();

		Scanner sc = new Scanner(System.in);
		System.out.println("欢迎来到订餐系统：");
		System.out.println("请填写用户信息：");
		System.out.println("用户名");
		o.c.setName(sc.next());
		System.out.println("电话");
		o.c.setTel(sc.next());
		System.out.println("地址");
		o.c.setAddress(sc.next());

		// 初始化菜品信息
		o.p1.setName("西红柿蛋炒饭");
		o.p2.setName("鱼香肉丝盖饭");
		o.p3.setName("山西刀削面");
		o.p1.setId(1);
		o.p2.setId(2);
		o.p3.setId(3);
		o.p1.setPrice(10);
		o.p2.setPrice(14.5);
		o.p3.setPrice(20);

		while (true) {
			System.out.println("1.查询菜单");
			System.out.println("2.订餐");
			System.out.println("3.查询订单");
			System.out.println("4.退出");
			System.out.println("请选择：");
			
			int q = sc.nextInt();
			
			if (q == 1) {
				System.out.println("菜名\t\t菜单编号\t单价");
				System.out.println(o.p1.getName() + "\t" + o.p1.getId() + "\t"
						+ o.p1.getPrice());
				System.out.println(o.p2.getName() + "\t" + o.p2.getId() + "\t"
						+ o.p2.getPrice());
				System.out.println(o.p3.getName() + "\t\t" + o.p3.getId()
						+ "\t" + o.p3.getPrice());
				System.out.println();
			} else if (q == 2) {
				System.out.println("请输入菜单编号：");
				int l = sc.nextInt();
				System.out.println("订购数量：");
				int l1 = sc.nextInt();
				if (l == 1) {
					int l2 = o.p1.getCount();
					l2 += l1;
					o.p1.setCount(l2);
					// o.sumPrice += o.getPrice(o.p1);
				} else if (l == 2) {
					int l2 = o.p2.getCount();
					l2 += l1;
					o.p2.setCount(l2);
					// o.sumPrice += o.getPrice(o.p2);
				} else {
					int l2 = o.p3.getCount();
					l2 += l1;
					o.p3.setCount(l2);
					// o.sumPrice += o.getPrice(o.p3);
				}
			} else if (q == 3) {
				o.getInformation();
			} else if (q == 4) {
				break;
			} else {
				System.out.println("输入错误");
			}
		}

		System.out.println("欢迎下次再来。");
	}

}