package chapter11;

import java.util.Scanner;

public class TestGuessNum {
	
	public static void main(String[] args) {
		
		//�������һ���۸�
		int a = (int) ((100 - 50 + 1) * Math.random() + 50);
		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("������1��50��100֮�����");

		for (int i = 1; i <= 5; i++) {
			
			int b = sc.nextInt();
			
			if (b == a) {
				System.out.println("�������");
				break;
			} else {
				if (i < 5) {
					if (b > a)
						System.out.println("���ִ��ˣ�����" + (5 - i) + "�λ��ᣬ����������һ��");
					else
						System.out.println("����С�ˣ�����" + (5 - i) + "�λ��ᣬ����������һ��");
				} else {
					if (b > a) {
						System.out.println("���ִ���");
						System.out.println("���������" + a + "����Ϸ����");					
					} else {
						System.out.println("����С��");
						System.out.println("���������" + a + "����Ϸ����");
					}

				}
			}
		}

	}
}
