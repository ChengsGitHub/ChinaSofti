package com.icss.product;

/**
 * ������
 * @author Administrator
 *
 */
public class Order {
	
	public Customer c = new Customer();
	
	public Product p1 = new Product();
	public Product p2 = new Product();
	public Product p3 = new Product();
	
	double sumPrice;

	/**
	 * ������Ϣ
	 */
	public void getInformation() {
		sumPrice=0;
		System.out.println("�ͻ���\t��Ʒ��\t\t����\t����\t�۸�");
		if (p1.getCount() != 0)
			System.out.println(c.getName() + "\t" + p1.getName() + "\t"
					+ p1.getPrice() + "\t" + p1.getCount() + "\t"
					+ this.getPrice(p1));
		
		if (p2.getCount() != 0)
			System.out.println(c.getName() + "\t" + p2.getName() + "\t"
					+ p2.getPrice() + "\t" + p2.getCount() + "\t"
					+ this.getPrice(p2));
		
		if (p3.getCount() != 0)
			System.out.println(c.getName() + "\t" + p3.getName() + "\t\t"
					+ p3.getPrice() + "\t" + p3.getCount() + "\t"
					+ this.getPrice(p3));
		
		System.out.println("�ܼ۸�:" + this.sumPrice);
		System.out.println("�ͻ���ַ:" + c.getAddress());
		System.out.println("�绰��" + c.getTel());
		System.out.println();
		
	}

	/**
	 * �����ܼ۸�
	 * @param p
	 * @return
	 */
	public double getPrice(Product p) {
		sumPrice += p.getPrice() * p.getCount();
		return p.getPrice() * p.getCount();
	}
	
}