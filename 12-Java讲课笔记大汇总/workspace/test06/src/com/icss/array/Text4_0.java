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
				System.out.println("\t��ӭʹ���������ع������ϵͳ1.0��");
				System.out.println();
				System.out.println();
				System.out.println("\t\t1.��¼ϵͳ");
				System.out.println();
				System.out.println("\t\t2.�˳�");
				System.out.println();
				System.out
						.println("* * * * * * * * * * * * * * * * * * * * * * * *");
				System.out.print("��ѡ���������֣�");
				p = sc.nextInt();
				while (p != 1 && p != 2) {
					System.out.println("�������");
					System.out.print("��ѡ���������֣�");
					p = sc.nextInt();
				}
			} else {
				p = 0;
				System.out.println("�������ع������ϵͳ  > �ͻ���Ϣ����  > ��ӿͻ���Ϣ");
				System.out.println();
				System.out.println();
				System.out.print("�������Ա��<4λ����>:");
				int name = sc.nextInt();
				System.out.print("�������Ա����(��/��<����λ����ʾ>):");
				String birth = sc.next();
				System.out.print("���������:");
				int f = sc.nextInt();
				System.out.println("��¼��Ļ�Ա��Ϣ��:");
				System.out.println(name + "   " + birth + "   " + f);
				while (true) {
					System.out.println();
					System.out.println();
					System.out.println("\t\t1.��ѯ��Ʒ�۸�");
					System.out.println();
					System.out.println("\t\t2.������Ʒ");
					System.out.println();
					System.out.println("\t\t3.�����ۿ۲�ѯ");
					System.out.println();
					System.out.println("\t\t4.�������");
					System.out.println();
					System.out.println("\t\t5.ע��");
					System.out.println();
					System.out.println();
					System.out.print("��ѡ��:");
					int n1 = sc.nextInt();
					if (n1 == 1) {
						System.out.println("���\t��Ʒ\t�۸�");
						System.out.println("1\tT��\t245");
						System.out.println("2\t����Ь\t570");
						System.out.println("3\t������\t320");
					} else if (n1 == 4) {
						System.out.println("�������ع������ϵͳ  > ���˳齱");
						System.out.println();
						System.out.print("������4λ��Ա�ţ�");
						int c = sc.nextInt();
						if (c == 8192) {
							System.out.println("8192�����˿ͻ�������Mp3һ����");
						} else {
							System.out.println(c + "  лл���֧��");
						}
					} else if (n1 == 3) {
						System.out.println();
						System.out.println("��Ա����X\t\t\t\t�ۿ�");
						System.out.println("x �� 2000\t\t\t\t9��");
						System.out.println("2000 �� x �� 4000\t\t\t8��");
						System.out.println("4000 �� x �� 8000\t\t\t7��");
						System.out.println("x �� 8000\t\t\t\t6��");
						System.out.println();
						System.out.print("�������Ա����:");
						int d = sc.nextInt();
						if (d < 2000) {
							System.out.println("�û�Ա���ܵ��ۿ���:" + 0.9);
							y = 0.9;
						} else if (d < 4000) {
							System.out.println("�û�Ա���ܵ��ۿ���:" + 0.8);
							y = 0.8;
						} else if (d < 8000) {
							System.out.println("�û�Ա���ܵ��ۿ���:" + 0.7);
							y = 0.7;
						} else {
							System.out.println("�û�Ա���ܵ��ۿ���:" + 0.6);
							y = 0.6;
						}
						System.out.println();
					} else if (n1 == 2) {
						System.out.println();
						System.out.println("�������ع������ϵͳ  > �������");
						System.out.println();
						System.out
								.println("* * * * * * * * * * * * * * * * * * * * *");
						System.out.println("��ѡ�������Ʒ���:");
						System.out.println();
						System.out.println("1.T��\t2.����Ь\t3.������");
						System.out
								.println("* * * * * * * * * * * * * * * * * * * * *");
						System.out.println();
						int sum = 0, m = 0;
						String r;
						do {
							System.out.print("��������Ʒ���:");
							int r1 = sc.nextInt();
							System.out.print("�����빺������:");
							int r2 = sc.nextInt();
							if (r1 == 1) {
								m = 245;
								System.out
										.println("T��\t��" + m + "\t��" + m * r2);
							} else if (r1 == 2) {
								m = 570;
								System.out
										.println("T��\t��" + m + "\t��" + m * r2);
							} else if (r1 == 3) {
								m = 320;
								System.out
										.println("T��\t��" + m + "\t��" + m * r2);
							}
							sum += m * r2;
							System.out.println();
							System.out.print("�Ƿ����(y/n):");
							r = sc.next();
						} while (r.equals("y"));
						System.out.println("�ۿ�:" + y);
						System.out.println("����ܼ� :  ��" + sum * y);
						System.out.print("ʵ�ʽ���:  ��");
						int jq = sc.nextInt();
						System.out.println("��Ǯ       :" + (jq - sum * y));

					} else {
						break;
					}

				}
			}
		}
		System.out.println("лл����ʹ�ã�");
	}

}
