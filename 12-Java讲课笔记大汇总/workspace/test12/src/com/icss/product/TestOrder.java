package com.icss.product;

import java.util.Scanner;

public class TestOrder {
	public static void main(String[] args) {

		// TODO �Զ����ɵķ������
		Order o = new Order();

		Scanner sc = new Scanner(System.in);
		System.out.println("��ӭ��������ϵͳ��");
		System.out.println("����д�û���Ϣ��");
		System.out.println("�û���");
		o.c.setName(sc.next());
		System.out.println("�绰");
		o.c.setTel(sc.next());
		System.out.println("��ַ");
		o.c.setAddress(sc.next());

		// ��ʼ����Ʒ��Ϣ
		o.p1.setName("������������");
		o.p2.setName("������˿�Ƿ�");
		o.p3.setName("ɽ��������");
		o.p1.setId(1);
		o.p2.setId(2);
		o.p3.setId(3);
		o.p1.setPrice(10);
		o.p2.setPrice(14.5);
		o.p3.setPrice(20);

		while (true) {
			System.out.println("1.��ѯ�˵�");
			System.out.println("2.����");
			System.out.println("3.��ѯ����");
			System.out.println("4.�˳�");
			System.out.println("��ѡ��");
			
			int q = sc.nextInt();
			
			if (q == 1) {
				System.out.println("����\t\t�˵����\t����");
				System.out.println(o.p1.getName() + "\t" + o.p1.getId() + "\t"
						+ o.p1.getPrice());
				System.out.println(o.p2.getName() + "\t" + o.p2.getId() + "\t"
						+ o.p2.getPrice());
				System.out.println(o.p3.getName() + "\t\t" + o.p3.getId()
						+ "\t" + o.p3.getPrice());
				System.out.println();
			} else if (q == 2) {
				System.out.println("������˵���ţ�");
				int l = sc.nextInt();
				System.out.println("����������");
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
				System.out.println("�������");
			}
		}

		System.out.println("��ӭ�´�������");
	}

}