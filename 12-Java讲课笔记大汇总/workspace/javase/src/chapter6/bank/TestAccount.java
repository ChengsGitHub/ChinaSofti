package chapter6.bank;

import java.util.Scanner;

/**
 * 提款机系统
 * 
 * @author Administrator
 * 
 */
public class TestAccount {

	public static void main(String[] args) {

		TestAccount t = new TestAccount();

		Account account1 = new Account(1000, "123456");// 普通账户
		CheckingAccount account2 = new CheckingAccount(1000, "123456", 500);// 信用卡账户

		Customer customer1 = new Customer("张三", false, account1);// 客户1
		Customer customer2 = new Customer("李四", true, account2);// 客户2

		atm(customer2);
	}

	/**
	 * 存取款系统
	 * 
	 * 进入系统，要求立即输入密码，密码输入3次错误，程序提示且自动终止 密码正确，出现友好提示： 欢迎您：xxx，您的当前身份是：XXX 出现功能菜单
	 * 1-存款 2-取款（是会员，取款不收取费用，非会员，每次取款都额外收取5元手续费） 3-查看余额 4-退出
	 */
	public static void atm(Customer customer) {

		Account account = customer.getAccount();
		
		Scanner sc = new Scanner(System.in);

		//密码验证
		for (int i = 1; i <= 3; i++) {
			System.out.println("请输入密码：");
			String password = sc.next();

			if (!password.equals(account.getPassword())) {
								
				if (i >= 3) {
					System.out.println("连续3次输入错误，程序终止！！");
					return;
				}
				
				System.out.println("密码不正确，请重新输入");
				
			} else {
				break;
			}
		}

		System.out.println("出现友好提示： 欢迎您：" + customer.getName() + "，您的当前身份是："
				+ (customer.isVip() ? "会员" : "非会员"));

		//功能菜单
		while (true) {
			System.out.println("1-存款");
			System.out.println("2-取款");
			System.out.println("3-查看余额");
			System.out.println("4-退出");
			
			int cmd = sc.nextInt();
			
			if (cmd == 1) {
				System.out.println("请输入存款的金额：");
				int amt = sc.nextInt();
				account.deposit(amt);
				System.out.println("存款成功！当前的余额是：" + account.getBalance());
			} else if (cmd == 2) {
				System.out.println("请输入取款的金额：");
				int amt = sc.nextInt();
				
				if (!customer.isVip())
					amt = amt + 5;
				
				if (account.withdraw(amt)){
					System.out.println("取款成功！当前的余额是：" + account.getBalance());
				}else{
					System.out.println("您的余额不足");
				}
			} else if (cmd == 3) {
				System.out.println("您当前的余额是：" + account.getBalance());
			} else if (cmd == 4) {
				System.out.println("谢谢使用，系统退出");
 				System.exit(0);
			} else {
				System.out.println("输入错误，请重新输入");
			}
		}
	}
	
}