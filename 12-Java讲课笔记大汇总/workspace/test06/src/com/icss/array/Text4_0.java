package com.icss.array;

import java.util.Scanner;

public class Text4_0 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int p = 0;
		double y = 1.0;
		while (p != 2) {
			if (p != 1) {
				System.out.println();
				System.out.println();
				System.out.println("\t欢迎使用我行我素购物管理系统1.0版");
				System.out.println();
				System.out.println();
				System.out.println("\t\t1.登录系统");
				System.out.println();
				System.out.println("\t\t2.退出");
				System.out.println();
				System.out
						.println("* * * * * * * * * * * * * * * * * * * * * * * *");
				System.out.print("请选择，输入数字：");
				p = sc.nextInt();
				while (p != 1 && p != 2) {
					System.out.println("输入错误");
					System.out.print("请选择，输入数字：");
					p = sc.nextInt();
				}
			} else {
				p = 0;
				System.out.println("我行我素购物管理系统  > 客户信息管理  > 添加客户信息");
				System.out.println();
				System.out.println();
				System.out.print("请输入会员号<4位整数>:");
				int name = sc.nextInt();
				System.out.print("请输入会员生日(月/日<用两位数表示>):");
				String birth = sc.next();
				System.out.print("请输入积分:");
				int f = sc.nextInt();
				System.out.println("已录入的会员信息是:");
				System.out.println(name + "   " + birth + "   " + f);
				while (true) {
					System.out.println();
					System.out.println();
					System.out.println("\t\t1.查询商品价格");
					System.out.println();
					System.out.println("\t\t2.购买商品");
					System.out.println();
					System.out.println("\t\t3.积分折扣查询");
					System.out.println();
					System.out.println("\t\t4.真情回馈");
					System.out.println();
					System.out.println("\t\t5.注销");
					System.out.println();
					System.out.println();
					System.out.print("请选择:");
					int n1 = sc.nextInt();
					if (n1 == 1) {
						System.out.println("编号\t商品\t价格");
						System.out.println("1\tT恤\t245");
						System.out.println("2\t网球鞋\t570");
						System.out.println("3\t网球拍\t320");
					} else if (n1 == 4) {
						System.out.println("我行我素购物管理系统  > 幸运抽奖");
						System.out.println();
						System.out.print("请输入4位会员号：");
						int c = sc.nextInt();
						if (c == 8192) {
							System.out.println("8192是幸运客户，获精美Mp3一个。");
						} else {
							System.out.println(c + "  谢谢你的支持");
						}
					} else if (n1 == 3) {
						System.out.println();
						System.out.println("会员积分X\t\t\t\t折扣");
						System.out.println("x ＜ 2000\t\t\t\t9折");
						System.out.println("2000 ≤ x ＜ 4000\t\t\t8折");
						System.out.println("4000 ≤ x ＜ 8000\t\t\t7折");
						System.out.println("x ≥ 8000\t\t\t\t6折");
						System.out.println();
						System.out.print("请输入会员积分:");
						int d = sc.nextInt();
						if (d < 2000) {
							System.out.println("该会员享受的折扣是:" + 0.9);
							y = 0.9;
						} else if (d < 4000) {
							System.out.println("该会员享受的折扣是:" + 0.8);
							y = 0.8;
						} else if (d < 8000) {
							System.out.println("该会员享受的折扣是:" + 0.7);
							y = 0.7;
						} else {
							System.out.println("该会员享受的折扣是:" + 0.6);
							y = 0.6;
						}
						System.out.println();
					} else if (n1 == 2) {
						System.out.println();
						System.out.println("我行我素购物管理系统  > 购物结算");
						System.out.println();
						System.out
								.println("* * * * * * * * * * * * * * * * * * * * *");
						System.out.println("请选择购买的商品编号:");
						System.out.println();
						System.out.println("1.T恤\t2.网球鞋\t3.网球拍");
						System.out
								.println("* * * * * * * * * * * * * * * * * * * * *");
						System.out.println();
						int sum = 0, m = 0;
						String r;
						do {
							System.out.print("请输入商品编号:");
							int r1 = sc.nextInt();
							System.out.print("请输入购买数量:");
							int r2 = sc.nextInt();
							if (r1 == 1) {
								m = 245;
								System.out
										.println("T恤\t￥" + m + "\t￥" + m * r2);
							} else if (r1 == 2) {
								m = 570;
								System.out
										.println("T恤\t￥" + m + "\t￥" + m * r2);
							} else if (r1 == 3) {
								m = 320;
								System.out
										.println("T恤\t￥" + m + "\t￥" + m * r2);
							}
							sum += m * r2;
							System.out.println();
							System.out.print("是否继续(y/n):");
							r = sc.next();
						} while (r.equals("y"));
						System.out.println("折扣:" + y);
						System.out.println("金额总计 :  ￥" + sum * y);
						System.out.print("实际交易:  ￥");
						int jq = sc.nextInt();
						System.out.println("找钱       :" + (jq - sum * y));

					} else {
						break;
					}

				}
			}
		}
		System.out.println("谢谢您的使用！");
	}

}
