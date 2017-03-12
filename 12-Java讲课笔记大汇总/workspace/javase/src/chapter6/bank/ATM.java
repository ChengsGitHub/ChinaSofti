package chapter6.bank;

import java.util.Scanner;

/**
 * ATMȡ���������
 * 
 * @author Administrator
 */
public class ATM {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * ������
	 * @param args
	 */
	public static void main(String[] args) {

		int select = 0;

		Account account = null;

		Customer customer = null;

		System.out.println("��ӭ������XXX���й���ϵͳ\n");
		
		/**
		 * ��ѭ����������ʾҵ��˵�
		 */
		do {
			System.out.println("1���쿨����");
			System.out.println("2��ȡ��ҵ��");
			System.out.println("3�����ҵ��");
			System.out.println("4����ѯ���");
			System.out.println("5���˳�\n");
			System.out.println("����ѡ�������");
			
			select = sc.nextInt();
			
			if (select == 1) {
				customer = createCustomer();//�����ͻ�
				account = creatAccount();//�����˻�
				
				customer.setAccount(account);//���˻�����ֵ���ͻ�
				
				//������֤
				if (!checkPasswd(customer)) {
					break;
				}
				
				if (customer.isVip()) {
					System.out.println("\n��ӭ�㣬" + customer.getName()
							+ "�����Ǳ��еĻ�Ա��ȡ���ȡ�κη��ã�\n");
				} else {
					System.out.println("\n��ӭ�㣬" + customer.getName() + "��\n");
				}
				
			} else if (select == 2) {
				if (customer == null) {
					System.out.println("�����ȿ�����");
				} else {
					withdraw(customer);
				}
			} else if (select == 3) {
				if (customer == null) {
					System.out.println("�����ȿ�����");
				} else {
					deposit(customer);
				}
			} else if (select == 4) {
				if (customer == null) {
					System.out.println("�����ȿ�����");
				} else {
					System.out.println("�˻�����ǣ�"
							+ customer.getAccount().getBalance() + "Ԫ");
				}
			} else if (select == 5) {
				break;
			} else {
				System.out.print("�����������");
			}
		} while (select != 5);
		
	}

	/**
	 * �����ͻ��������������Ƿ��Ա��
	 * @return
	 */
	public static Customer createCustomer() {
		System.out.println("������������");
		String name = sc.next();
		System.out.println("�Ƿ��Ա<1����Ա��2.���ǻ�Ա>��");
		boolean vip = sc.nextInt() == 1 ? true : false;
		Customer customer = new Customer(name, vip, null);
		return customer;
	}

	/**
	 * ������ҵ��
	 * 
	 * @return
	 */
	public static Account creatAccount() {
		Account account = null;
		try {
			System.out.println("1����ǿ�����͸֧��");
			System.out.println("2�����ÿ�������͸֧150000��");
			System.out.println("����ѡ��Ҫ����Ŀ��Ķ�Ӧ�ı��:");
			int card = sc.nextInt();
			if (card == 1) {
				account = new Account(0, passwd());
			} else if (card == 2) {
				account = new CheckingAccount(0, passwd(), 150000);
			}
			System.out.println("�����ɹ���");
		} catch (Exception e) {
			System.out.println("���������Ĳ������֣�");
		}
		return account;
	}

	/**
	 * ��������ģ��
	 * 
	 * @return
	 */
	public static String passwd() {
		String pwd1 = "";
		String pwd2 = "";
		
		System.out.println("������6λ���룺");
		pwd1 = sc.next();
		
		System.out.println("���ٴ�����6λ���룺");
		pwd2 = sc.next();
		
		while (!pwd1.equals(pwd2)) {
			System.out.println("�������벻��ͬ��������6λ���룺");
			pwd1 = sc.next();
			System.out.println("���ٴ�����6λ���룺");
			pwd2 = sc.next();
		}
		
		return pwd1;
	}

	/**
	 * ȡǮ��ҵ���߼�
	 * 
	 * @param account
	 */
	public static void withdraw(Customer customer) {
		System.out.println("��������Ҫȡ�ý�");
		double amt = sc.nextDouble();
		while (amt % 100 != 0) {
			System.out.println("ȡǮ����Ŀ������100������������ȡ���");
			amt = sc.nextDouble();
		}
		if (!customer.getAccount().withdraw(amt)) {
			System.out.println("������㣡");
		} else {
			if (!customer.isVip()) {
				customer.getAccount().withdraw(5);
				System.out.println("��ȡ������5Ԫ��");
			}
			System.out.println("ȡ��ɹ�����" + customer.getAccount().getBalance());
		}
	}

	public static void deposit(Customer customer) {
		System.out.println("�����������Ľ�");
		double amt = sc.nextDouble();
		while (amt % 100 != 0) {
			System.out.println("�����������100����������������");
			amt = sc.nextDouble();
		}
		customer.getAccount().deposit(amt);
		System.out.println("���Ѿ��ɹ�����" + amt + "Ԫ���˻����Ϊ��"
				+ customer.getAccount().getBalance());
	}

	/**
	 * �������
	 * 
	 * @param customer
	 * @return
	 */
	public static boolean checkPasswd(Customer customer) {
		
		System.out.print("�����¼,");
		
		String pwd = null;
		
		int i = 0;//���������������
		
		do {
			System.out.println("������6λ���룺");
			pwd = sc.next();
			if (pwd.equals(customer.getAccount().getPassword())) {
				break;
			} else {
				i++;
				System.out.println("����" + (3 - i) + "�λ���");
			}
		} while (i < 3);
		
		if (i < 3) {
			return true;
		} else {
			return false;
		}
	}
}
