package chapter6.bank;

import java.util.Scanner;

/**
 * ����ϵͳ
 * 
 * @author Administrator
 * 
 */
public class TestAccount {

	public static void main(String[] args) {

		TestAccount t = new TestAccount();

		Account account1 = new Account(1000, "123456");// ��ͨ�˻�
		CheckingAccount account2 = new CheckingAccount(1000, "123456", 500);// ���ÿ��˻�

		Customer customer1 = new Customer("����", false, account1);// �ͻ�1
		Customer customer2 = new Customer("����", true, account2);// �ͻ�2

		atm(customer2);
	}

	/**
	 * ��ȡ��ϵͳ
	 * 
	 * ����ϵͳ��Ҫ�������������룬��������3�δ��󣬳�����ʾ���Զ���ֹ ������ȷ�������Ѻ���ʾ�� ��ӭ����xxx�����ĵ�ǰ����ǣ�XXX ���ֹ��ܲ˵�
	 * 1-��� 2-ȡ��ǻ�Ա��ȡ���ȡ���ã��ǻ�Ա��ÿ��ȡ�������ȡ5Ԫ�����ѣ� 3-�鿴��� 4-�˳�
	 */
	public static void atm(Customer customer) {

		Account account = customer.getAccount();
		
		Scanner sc = new Scanner(System.in);

		//������֤
		for (int i = 1; i <= 3; i++) {
			System.out.println("���������룺");
			String password = sc.next();

			if (!password.equals(account.getPassword())) {
								
				if (i >= 3) {
					System.out.println("����3��������󣬳�����ֹ����");
					return;
				}
				
				System.out.println("���벻��ȷ������������");
				
			} else {
				break;
			}
		}

		System.out.println("�����Ѻ���ʾ�� ��ӭ����" + customer.getName() + "�����ĵ�ǰ����ǣ�"
				+ (customer.isVip() ? "��Ա" : "�ǻ�Ա"));

		//���ܲ˵�
		while (true) {
			System.out.println("1-���");
			System.out.println("2-ȡ��");
			System.out.println("3-�鿴���");
			System.out.println("4-�˳�");
			
			int cmd = sc.nextInt();
			
			if (cmd == 1) {
				System.out.println("��������Ľ�");
				int amt = sc.nextInt();
				account.deposit(amt);
				System.out.println("���ɹ�����ǰ������ǣ�" + account.getBalance());
			} else if (cmd == 2) {
				System.out.println("������ȡ��Ľ�");
				int amt = sc.nextInt();
				
				if (!customer.isVip())
					amt = amt + 5;
				
				if (account.withdraw(amt)){
					System.out.println("ȡ��ɹ�����ǰ������ǣ�" + account.getBalance());
				}else{
					System.out.println("��������");
				}
			} else if (cmd == 3) {
				System.out.println("����ǰ������ǣ�" + account.getBalance());
			} else if (cmd == 4) {
				System.out.println("ллʹ�ã�ϵͳ�˳�");
 				System.exit(0);
			} else {
				System.out.println("�����������������");
			}
		}
	}
	
}