package Job3;

import java.util.Scanner;

/**
 * �û�
 * @author Administrator
 *
 */
public class Person {
	int score=0;
	int num;
	String name;

	/**
	 * �û�ѡ�������ɫ
	 * @return
	 */
	public String personHero() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if (a == 1)
			return name = "����";
		if (a == 2)
			return name = "��Ȩ";
		else
			return name = "�ܲ�";
	}

	/**
	 * �û�ѡ���ȭ
	 */
	public void showFist() {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num == 1) {
			System.out.println("���ȭ������");
		} else if (num == 2) {
			System.out.println("���ȭ��ʯͷ");
		} else if (num == 3) {
			System.out.println("���ȭ����");
		}
	}
	
}