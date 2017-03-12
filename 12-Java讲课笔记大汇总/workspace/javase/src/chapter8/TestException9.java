package chapter8;

import java.util.Scanner;

/**
 * 计算购买金额 
 * 用户输入一个数量
 * 如果不是整数，提示-输入错误，请输入一个整数，错误码：1001
 * 如果不是1-100直接，提示-输入错误，购买数量必须是1-100之间，错误码：1002
 * 如果输入合法，输出-购买总金额：XXX
 */
public class TestException9 {
	
	private static final int PRICE = 5;//单价

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数量：");
		String qtyStr = sc.next();
		
		int totalPrice = 0;//总金额
		
		try {
			totalPrice = getTotalPrice(qtyStr);			
		} catch (MyException e) {
			System.out.println("输入错误，" + e.getMessage() + "，错误码：" + e.getErrorId());
			return;
		}

		System.out.println("购买总金额：" + totalPrice);
	}

	/**
	 *返回购买总金额	
	 */
	public static int getTotalPrice(String qtyStr) throws MyException {
		
		int qty = 0;
		
		try {
			qty = Integer.parseInt(qtyStr);			
		} catch (Exception e) {
			throw new MyException("请输入一个整数",1001);
		}
		
		if (qty < 1 || qty > 100)
			throw new MyException("购买数量必须是1-100之间",1002);
				
		
		return PRICE * qty;
	}
}