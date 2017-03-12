package chapter8;

import java.util.Scanner;

/**
 * ���㹺���� 
 * �û�����һ������
 * ���������������ʾ-�������������һ�������������룺1001
 * �������1-100ֱ�ӣ���ʾ-������󣬹�������������1-100֮�䣬�����룺1002
 * �������Ϸ������-�����ܽ�XXX
 */
public class TestException9 {
	
	private static final int PRICE = 5;//����

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ��������");
		String qtyStr = sc.next();
		
		int totalPrice = 0;//�ܽ��
		
		try {
			totalPrice = getTotalPrice(qtyStr);			
		} catch (MyException e) {
			System.out.println("�������" + e.getMessage() + "�������룺" + e.getErrorId());
			return;
		}

		System.out.println("�����ܽ�" + totalPrice);
	}

	/**
	 *���ع����ܽ��	
	 */
	public static int getTotalPrice(String qtyStr) throws MyException {
		
		int qty = 0;
		
		try {
			qty = Integer.parseInt(qtyStr);			
		} catch (Exception e) {
			throw new MyException("������һ������",1001);
		}
		
		if (qty < 1 || qty > 100)
			throw new MyException("��������������1-100֮��",1002);
				
		
		return PRICE * qty;
	}
}