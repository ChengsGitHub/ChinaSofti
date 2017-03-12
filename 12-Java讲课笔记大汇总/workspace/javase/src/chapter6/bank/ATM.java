package chapter6.bank;

import java.util.Scanner;

/**
 * ATM取款机主程序
 * 
 * @author Administrator
 */
public class ATM {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * 主方法
	 * @param args
	 */
	public static void main(String[] args) {

		int select = 0;

		Account account = null;

		Customer customer = null;

		System.out.println("欢迎你来到XXX银行管理系统\n");
		
		/**
		 * 大循环，用来显示业务菜单
		 */
		do {
			System.out.println("1、办卡开户");
			System.out.println("2、取款业务");
			System.out.println("3、存款业务");
			System.out.println("4、查询余额");
			System.out.println("5、退出\n");
			System.out.println("请你选择操作：");
			
			select = sc.nextInt();
			
			if (select == 1) {
				customer = createCustomer();//创建客户
				account = creatAccount();//创建账户
				
				customer.setAccount(account);//把账户对象赋值给客户
				
				//密码验证
				if (!checkPasswd(customer)) {
					break;
				}
				
				if (customer.isVip()) {
					System.out.println("\n欢迎你，" + customer.getName()
							+ "！你是本行的会员，取款不收取任何费用！\n");
				} else {
					System.out.println("\n欢迎你，" + customer.getName() + "！\n");
				}
				
			} else if (select == 2) {
				if (customer == null) {
					System.out.println("请你先开户！");
				} else {
					withdraw(customer);
				}
			} else if (select == 3) {
				if (customer == null) {
					System.out.println("请你先开户！");
				} else {
					deposit(customer);
				}
			} else if (select == 4) {
				if (customer == null) {
					System.out.println("请你先开户！");
				} else {
					System.out.println("账户余额是："
							+ customer.getAccount().getBalance() + "元");
				}
			} else if (select == 5) {
				break;
			} else {
				System.out.print("你的输入有误！");
			}
		} while (select != 5);
		
	}

	/**
	 * 创建客户（传入姓名和是否会员）
	 * @return
	 */
	public static Customer createCustomer() {
		System.out.println("请输入姓名：");
		String name = sc.next();
		System.out.println("是否会员<1：会员，2.不是会员>：");
		boolean vip = sc.nextInt() == 1 ? true : false;
		Customer customer = new Customer(name, vip, null);
		return customer;
	}

	/**
	 * 开户的业务
	 * 
	 * @return
	 */
	public static Account creatAccount() {
		Account account = null;
		try {
			System.out.println("1、借记卡（无透支）");
			System.out.println("2、信用卡（可以透支150000）");
			System.out.println("请你选择要办理的卡的对应的编号:");
			int card = sc.nextInt();
			if (card == 1) {
				account = new Account(0, passwd());
			} else if (card == 2) {
				account = new CheckingAccount(0, passwd(), 150000);
			}
			System.out.println("开户成功！");
		} catch (Exception e) {
			System.out.println("你可能输入的不是数字！");
		}
		return account;
	}

	/**
	 * 密码设置模块
	 * 
	 * @return
	 */
	public static String passwd() {
		String pwd1 = "";
		String pwd2 = "";
		
		System.out.println("请输入6位密码：");
		pwd1 = sc.next();
		
		System.out.println("请再次输入6位密码：");
		pwd2 = sc.next();
		
		while (!pwd1.equals(pwd2)) {
			System.out.println("两次密码不相同，请输入6位密码：");
			pwd1 = sc.next();
			System.out.println("请再次输入6位密码：");
			pwd2 = sc.next();
		}
		
		return pwd1;
	}

	/**
	 * 取钱的业务逻辑
	 * 
	 * @param account
	 */
	public static void withdraw(Customer customer) {
		System.out.println("请输入你要取得金额：");
		double amt = sc.nextDouble();
		while (amt % 100 != 0) {
			System.out.println("取钱的数目必须是100倍数，请输入取款金额：");
			amt = sc.nextDouble();
		}
		if (!customer.getAccount().withdraw(amt)) {
			System.out.println("你的余额不足！");
		} else {
			if (!customer.isVip()) {
				customer.getAccount().withdraw(5);
				System.out.println("收取手续费5元！");
			}
			System.out.println("取款成功！余额：" + customer.getAccount().getBalance());
		}
	}

	public static void deposit(Customer customer) {
		System.out.println("请你输入存入的金额：");
		double amt = sc.nextDouble();
		while (amt % 100 != 0) {
			System.out.println("存入金额必须是100倍数，请输入存入金额：");
			amt = sc.nextDouble();
		}
		customer.getAccount().deposit(amt);
		System.out.println("你已经成功存入" + amt + "元，账户余额为："
				+ customer.getAccount().getBalance());
	}

	/**
	 * 检查密码
	 * 
	 * @param customer
	 * @return
	 */
	public static boolean checkPasswd(Customer customer) {
		
		System.out.print("请你登录,");
		
		String pwd = null;
		
		int i = 0;//密码输入次数计数
		
		do {
			System.out.println("请输入6位密码：");
			pwd = sc.next();
			if (pwd.equals(customer.getAccount().getPassword())) {
				break;
			} else {
				i++;
				System.out.println("还有" + (3 - i) + "次机会");
			}
		} while (i < 3);
		
		if (i < 3) {
			return true;
		} else {
			return false;
		}
	}
}
